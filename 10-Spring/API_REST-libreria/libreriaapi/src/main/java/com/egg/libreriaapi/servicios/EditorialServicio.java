package com.egg.libreriaapi.servicios;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.libreriaapi.entidades.Editorial;
import com.egg.libreriaapi.modelos.EditorialCreateDTO;
import com.egg.libreriaapi.repositorios.EditorialRepositorio;

@Service
public class EditorialServicio {
    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearEditorial(String nombre) {
    Editorial editorial = new Editorial();
    editorial.setNombre(nombre);
    editorial.setEditorialActiva(true);  // Puede ser un valor por defecto

    editorialRepositorio.save(editorial);
    }

    @Transactional
    public void crearEditorial(EditorialCreateDTO editorialCreateDTO) {
    Editorial editorialDto = new Editorial();
    editorialDto.setNombre(editorialCreateDTO.getNombre());
    editorialDto.setEditorialActiva(editorialCreateDTO.isEditorialActiva());
    editorialRepositorio.save(editorialDto);
    }

    @Transactional
    public void modificarEditorial(String nombre, UUID id) {
        
        Optional<Editorial> respuesta = editorialRepositorio.findById(id);

        if(respuesta.isPresent()) {
            Editorial editorial = respuesta.get();
            System.out.println(editorial);
            editorial.setNombre(nombre);

            editorialRepositorio.save(editorial);
        } else {
            throw new NoSuchElementException("No se encontró la editorial con el ID: " +id);
        }
    }

    @Transactional
    public void bajarEditorial(UUID id) {
        Optional<Editorial> respuesta = editorialRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Editorial editorial = respuesta.get();
            editorial.setEditorialActiva(false);
            editorialRepositorio.save(editorial);
        }
    }

    @Transactional(readOnly = true)
    public Editorial getOne(UUID id){
        return editorialRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Editorial no encontrada"));
    }

    @Transactional(readOnly = true)
    public List<Editorial> listarEditorial() {
        return editorialRepositorio.findAll();
    }
}
