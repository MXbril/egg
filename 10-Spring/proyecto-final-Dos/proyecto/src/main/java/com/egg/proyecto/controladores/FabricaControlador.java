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

import com.egg.proyecto.entidades.Fabrica;
import com.egg.proyecto.excepciones.MiException;
import com.egg.proyecto.servicios.FabricaServicio;

@Controller
@RequestMapping("/fabrica")
public class FabricaControlador {
    
    @Autowired
    private FabricaServicio fabricaServicio;

    @GetMapping("/registrar")
    public String registrar() {
        return "fabrica_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap modelo) {
        try {
            fabricaServicio.crearFabrica(nombre);
            modelo.put("exito", "La fabrica se creo con exito!");
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return "fabrica_form.html";
        }
        return "index.html";
    }

    @GetMapping("/lista")
    public String listar(ModelMap modelo) {
        List<Fabrica> fabricas = fabricaServicio.listarFabrica();

        modelo.addAttribute("fabricas", fabricas);
        return "fabrica_list.html";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable UUID id, ModelMap modelo) {

        modelo.put("fabrica", fabricaServicio.getOne(id));

        return "fabrica_modificar.html";

    }

    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable UUID id, String nombre, ModelMap modelo) {
        try {
            fabricaServicio.modificarFabrica(nombre, id);

            return "redirect:../lista";
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return "fabrica_modificar.html";
        }
    }

}
