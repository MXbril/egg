package com.egg.libreriaapi.servicios;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.libreriaapi.entidades.Autor;
import com.egg.libreriaapi.modelos.AutorModificarDTO;
import com.egg.libreriaapi.repositorios.AutorRepositorio;

@Service
public class AutorServicio {
    @Autowired
    private AutorRepositorio autorRepositorio;

    @Transactional
    public void crearAutor(String nombre) {
    Autor autor = new Autor();
    autor.setNombre(nombre);
    autor.setAutorActivo(true);  // Puede ser un valor por defecto

    autorRepositorio.save(autor);
    }

    @Transactional
    public void modificarAutor(String nombre, UUID id) {
        
        Optional<Autor> respuesta = autorRepositorio.findById(id);

        if(respuesta.isPresent()) {
            Autor autor = respuesta.get();
            System.out.println(autor);
            autor.setNombre(nombre);

            autorRepositorio.save(autor);
        } else {
            throw new NoSuchElementException("No se encontró el autor con ID: " +id);
        }
    }

    @Transactional
    public void modificarAutor(UUID id, AutorModificarDTO autorModificarDTO) {
        
        Optional<Autor> respuesta = autorRepositorio.findById(id);

        if(respuesta.isPresent()) {
            Autor autorDTO = respuesta.get();
            System.out.println(autorDTO);
            autorDTO.setNombre(autorModificarDTO.getNombre());
            autorDTO.setAutorActivo(autorModificarDTO.isAutorActivo());

            autorRepositorio.save(autorDTO);
        } else {
            throw new NoSuchElementException("No se encontró el autor con ID: " +id);
        }
    }

    @Transactional
    public void bajarAutor(UUID id) {
        Optional<Autor> respuesta = autorRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
            autor.setAutorActivo(false);
            autorRepositorio.save(autor);
        }
    }

    @Transactional(readOnly = true)
    public Autor getOne(UUID id){
        return autorRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Autor no encontrado"));
    }

    @Transactional(readOnly = true)
    public List<Autor> listarAutor() {
        return autorRepositorio.findAll();
    }
}
