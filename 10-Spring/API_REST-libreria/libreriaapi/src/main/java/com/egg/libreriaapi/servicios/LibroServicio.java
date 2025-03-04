package com.egg.libreriaapi.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.libreriaapi.entidades.Autor;
import com.egg.libreriaapi.entidades.Editorial;
import com.egg.libreriaapi.entidades.Libro;
import com.egg.libreriaapi.modelos.LibroCreateDTO;
import com.egg.libreriaapi.modelos.LibroListarActivosDTO;
import com.egg.libreriaapi.modelos.LibroModificarDTO;
import com.egg.libreriaapi.repositorios.LibroRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LibroServicio {
    @Autowired
    private LibroRepositorio libroRepositorio;

    @Autowired
    private AutorServicio autorServicio;

    @Autowired
    private EditorialServicio editorialServicio;

    @Transactional
    public void crearLibro(LibroCreateDTO libroCreateDTO) {
        Libro libro = new Libro();
        libro.setIsbn(libroCreateDTO.getIsbn());
        libro.setEjemplares(libroCreateDTO.getEjemplares());
        libro.setTitulo(libroCreateDTO.getTitulo());
        libro.setLibroActivo(libroCreateDTO.isLibroActivo());

        Autor autor = autorServicio.getOne(libroCreateDTO.getIdAutor());
        if (autor != null) {
            libro.setAutor(autor);
        }
        Editorial editorial = editorialServicio.getOne(libroCreateDTO.getIdEditorial());
        if (editorial != null) {
            libro.setEditorial(editorial);
        }
        libroRepositorio.save(libro);
    }

    @Transactional
    public void modificarLibro(LibroModificarDTO libroModificarDTO) {
        Optional<Libro> respuesta = libroRepositorio.findById(libroModificarDTO.getIsbn());
        if (respuesta.isEmpty()) {
            throw new EntityNotFoundException("El libro con ISBN " + libroModificarDTO.getIsbn() + "no existe.");
        }
        // obtener el libro existente
        Libro libro = respuesta.get();
        libro.setEjemplares(libroModificarDTO.getEjemplares());
        libro.setTitulo(libroModificarDTO.getTitulo());
        libro.setLibroActivo(libroModificarDTO.isLibroActivo());

        if(libroModificarDTO.getIdAutor() != null) {
            Autor autor = autorServicio.getOne(libroModificarDTO.getIdAutor());
            if (autor != null) {
                libro.setAutor(autor);
            } else {
                throw new EntityNotFoundException("El autor con ID " + libroModificarDTO.getIdAutor() + "no existe.");
            }
        }
        if(libroModificarDTO.getIdEditorial() != null) {
            Editorial editorial = editorialServicio.getOne(libroModificarDTO.getIdEditorial());
            if (editorial != null) {
                libro.setEditorial(editorial);
            } else {
                throw new EntityNotFoundException("El autor con ID " + libroModificarDTO.getIdEditorial() + "no existe.");
            }
        }
        libroRepositorio.save(libro);
    }

    @Transactional(readOnly = true)
    public List<LibroListarActivosDTO> listarLibrosActivos(){
        return libroRepositorio.encontrarActivos();
    }
}
