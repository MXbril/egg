package com.egg.biblioteca.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import com.egg.biblioteca.excepciones.MiException;

import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Service
public class AutorServicio {
    
    @Autowired
    private AutorRepositorio autorRepositorio;

    @Transactional
    public void crearAutor(String nombre) throws MiException {
        validarAutor(nombre);
        Autor autor = new Autor();
        autor.setNombre(nombre);

        autorRepositorio.save(autor); // persisto el dato en la base de datos.
    }

    @Transactional(readOnly = true)
    public List<Autor> listarAutor() {
        return autorRepositorio.findAll();
    }

    @Transactional
    public void modificarAutor(String nombre, UUID id) throws MiException {
        validarAutor(nombre);

        Optional<Autor> respuesta = autorRepositorio.findById(id);

        if(respuesta.isPresent()) {
            Autor autor = respuesta.get();
            autor.setNombre(nombre);

            autorRepositorio.save(autor);
        }
    }

    @Transactional(readOnly = true)
    public Autor getOne(UUID id){
        return autorRepositorio.getReferenceById(id);
    }

    private void validarAutor(String nombre) throws MiException {
        if (nombre == null || nombre.isEmpty()) {
            throw new MiException("el nombre no puede ser nulo o estar vacio");
        }
    }
}
