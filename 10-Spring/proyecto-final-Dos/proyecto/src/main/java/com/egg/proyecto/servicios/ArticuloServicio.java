package com.egg.proyecto.servicios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.proyecto.entidades.Articulo;
import com.egg.proyecto.entidades.Fabrica;
import com.egg.proyecto.excepciones.MiException;
import com.egg.proyecto.repositorios.ArticuloRepositorio;
import com.egg.proyecto.repositorios.FabricaRepositorio;

@Service
public class ArticuloServicio {
    
    @Autowired
    private ArticuloRepositorio articuloRepositorio;

    @Autowired
    private FabricaRepositorio fabricaRepositorio;

    @Transactional
    public void crearArticulo(Integer nro, String nombre, String descripcion, UUID idFabrica) throws MiException{
        validar(nombre, descripcion, idFabrica);
        Fabrica fabrica = fabricaRepositorio.findById(idFabrica).get();
        Articulo articulo = new Articulo();


        articulo.setNombre(nombre);
        articulo.setDescripcion(descripcion);
        articulo.setFabrica(fabrica);
        Integer ultimoNroArticulo = articuloRepositorio.obtenerUltimoNroArticulo();
        articulo.setNro(ultimoNroArticulo + 1);

        articuloRepositorio.save(articulo);
    }

    @Transactional
    public void modificarArticulo(UUID id, String nombre, String descripcion, UUID idFabrica) throws MiException{
        validar(nombre, descripcion, idFabrica);
        //busca por id y verifica.
        Optional<Articulo> opcionalArticulo = articuloRepositorio.findById(id);
        if (!opcionalArticulo.isPresent()) {
            throw new MiException("No se encontró un artículo con el ID: " +id);
        }
        Articulo articulo = opcionalArticulo.get();
        //busca por id y verifica.
        Optional<Fabrica> opcionalFabrica = fabricaRepositorio.findById(idFabrica);
        if (!opcionalFabrica.isPresent()) {
            throw new MiException("No se encontró una fábrica con el ID: "  +idFabrica);
        }
        Fabrica fabrica = opcionalFabrica.get();
        //Modifica atributos.
        articulo.setNombre(nombre);
        articulo.setDescripcion(descripcion);
        articulo.setFabrica(fabrica);

        articuloRepositorio.save(articulo);

    }

    @Transactional(readOnly = true)
    public List<Articulo> listarArticulos() {
        return articuloRepositorio.findAll();
    }

    @Transactional(readOnly = true)
    public Articulo getOne(UUID id){
        return articuloRepositorio.getReferenceById(id);
    }

    private void validar(String nombre, String descripcion, UUID idFabrica) throws MiException {

        if (nombre == null || nombre.isEmpty()) {
            throw new MiException("El nombre no puede ser nulo o estar vacio");
        }
        if (descripcion == null || descripcion.isEmpty()) {
            throw new MiException("La descripción del articulo no puede ser nulo o estar vacio");
        }
        if (idFabrica == null) {
            throw new MiException("La fabrica no puede ser nulo");
        }
    }
}
