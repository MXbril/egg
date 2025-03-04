package com.egg.proyecto.controladores;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.proyecto.entidades.Articulo;
import com.egg.proyecto.entidades.Fabrica;
import com.egg.proyecto.excepciones.MiException;
import com.egg.proyecto.servicios.ArticuloServicio;
import com.egg.proyecto.servicios.FabricaServicio;

@Controller
@RequestMapping("/articulo")
public class ArticuloControlador {
    
    @Autowired
    private ArticuloServicio articuloServicio;

    @Autowired
    private FabricaServicio fabricaServicio;

    @GetMapping("/registrar")
    public String registrar(ModelMap modelo) {
        List<Fabrica> fabricas = fabricaServicio.listarFabrica();
        modelo.addAttribute("fabricas", fabricas);

        return "articulo_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) Integer nro, @RequestParam String nombre, @RequestParam String descripcion, @RequestParam(required = false) UUID idFabrica, ModelMap modelo) {
        try {
            articuloServicio.crearArticulo(nro, nombre, descripcion, idFabrica);
            modelo.put("exito", "EL articulo fue cargado exitosamente!");
        } catch (MiException ex) {
            List<Fabrica> fabricas = fabricaServicio.listarFabrica();
            modelo.addAttribute("fabricas", fabricas);
            modelo.put("error", ex.getMessage());
            return "articulo_form.html";
        }
        return "index.html";
    }

    @GetMapping("/lista")
    public String listar(ModelMap modelo) {
        List<Articulo> articulos = articuloServicio.listarArticulos();
        modelo.addAttribute("articulos", articulos);

        return "articulo_list.html";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable UUID id, ModelMap modelo) {
        modelo.put("articulo", articuloServicio.getOne(id));
        List<Fabrica> fabricas = fabricaServicio.listarFabrica();
        modelo.addAttribute("fabricas", fabricas);

        return "articulo_modificar.html";
    }

    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable UUID id, String nombre, String descripcion, UUID idFabrica, ModelMap modelo) {
        try {
            List<Fabrica> fabricas = fabricaServicio.listarFabrica();
            modelo.addAttribute("fabricas", fabricas);
            articuloServicio.modificarArticulo(id, nombre, descripcion, idFabrica);

            return "redirect:../lista";
        } catch (MiException ex) {
            List<Fabrica> fabricas = fabricaServicio.listarFabrica();

            modelo.put("error", ex.getMessage());
            modelo.addAttribute("fabricas", fabricas);
            return "articulo_modificar.html";
        }
    }
}
