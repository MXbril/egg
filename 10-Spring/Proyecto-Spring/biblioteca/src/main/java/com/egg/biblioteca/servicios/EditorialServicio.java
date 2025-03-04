package com.egg.biblioteca.servicios;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import com.egg.biblioteca.excepciones.MiException;

import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.util.List;

@Service
public class EditorialServicio {
    
    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearEditorial(String nombre) throws MiException {
        validarEditorial(nombre);
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);

        editorialRepositorio.save(editorial);
    }

    @Transactional(readOnly = true)
    public List<Editorial> listarEditorial() {
        return editorialRepositorio.findAll();
    }

    @Transactional
    public void modificarEditorial(String nombre, UUID id) throws MiException {
        validarEditorial(nombre);
        Optional<Editorial> respuesta = editorialRepositorio.findById(id);

        if(respuesta.isPresent()) {
            Editorial editorial = respuesta.get();
            editorial.setNombre(nombre);

            editorialRepositorio.save(editorial);
        }
    }

    @Transactional(readOnly = true)
    public Editorial getOne(UUID id){
        return editorialRepositorio.getReferenceById(id);
    }

    private void validarEditorial(String nombre) throws MiException {
        if (nombre == null || nombre.isEmpty()) {
            throw new MiException("el nombre no puede ser nulo o estar vacio");
        }
    }
}
