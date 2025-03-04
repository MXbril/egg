package com.egg.biblioteca.servicios;

import java.util.Date;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import com.egg.biblioteca.repositorios.LibroRepositorio;

import java.util.UUID;
import java.util.List;


@Service
public class LibroServicio {
    

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Autowired
    private AutorRepositorio autorRepositorio;

    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial) throws MiException {

        validar(isbn, titulo, ejemplares, idAutor, idEditorial);

        Autor autor = autorRepositorio.findById(idAutor).get();
        Editorial editorial = editorialRepositorio.findById(idEditorial).get();
        Libro libro = new Libro();

        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setAlta(new Date());
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepositorio.save(libro);
    }

    @Transactional(readOnly = true)
    public List<Libro> listarLibros() {
        return libroRepositorio.findAll();
    }

    // @Transactional
    // public void modificarLibro(Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial) throws MiException {

    //     validar(isbn, titulo, ejemplares, idAutor, idEditorial);

    //     Optional<Libro> respuestaLibro = libroRepositorio.findById(isbn);
    //     Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
    //     Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idEditorial);

    //     Autor autor = new Autor();
    //     Editorial editorial = new Editorial();

    //     if (respuestaAutor.isPresent()) {
    //         autor = respuestaAutor.get();
    //     }

    //     if (respuestaEditorial.isPresent()) {
    //         editorial = respuestaEditorial.get();
    //     }

    //     if (respuestaLibro.isPresent()) {
    //         Libro libro = new Libro();

    //         libro.setTitulo(titulo);
    //         libro.setEjemplares(ejemplares);
    //         libro.setAutor(autor);
    //         libro.setEditorial(editorial);

    //         libroRepositorio.save(libro);
    //     }
    // }


    @Transactional
    public void modificarLibro(Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial) throws MiException {

        validar(isbn, titulo, ejemplares, idAutor, idEditorial);

        Optional<Libro> respuestaLibro = libroRepositorio.findById(isbn);
        // Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
        // Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idEditorial);

        if (respuestaLibro.isPresent()) {
            Libro libro = respuestaLibro.get();

            Autor autor = autorRepositorio.findById(idAutor).orElseThrow(() -> new RuntimeException("Autor no encontrado"));
            Editorial editorial = editorialRepositorio.findById(idEditorial).orElseThrow(() -> new RuntimeException("Editorial no encontrado"));

            libro.setTitulo(titulo);
            libro.setEjemplares(ejemplares);
            libro.setAutor(autor);
            libro.setEditorial(editorial);

            libroRepositorio.save(libro);
        } else {
            throw new RuntimeException("Libro no encontrado con ISBN: " +isbn);
        }
    }

    @Transactional(readOnly = true)
    public Libro getOne(Long isbn){
        return libroRepositorio.getReferenceById(isbn);
    }

    private void validar(Long isbn, String titulo, Integer ejemplares, UUID idAutor, UUID idEditorial) throws MiException {
        if (isbn == null) {
            throw new MiException("El isbn no puede ser nulo");
        }
        if (titulo == null || titulo.isEmpty()) {
            throw new MiException("El titulo no puede ser nulo o estar vacio");
        }
        if (ejemplares == null) {
            throw new MiException("Ejemplares no puede ser nulo");
        }
        if (idAutor == null) {
            throw new MiException("El autor no puede ser nulo");
        }
        if (idEditorial == null) {
            throw new MiException("La editorial no puede ser nulo");
        }
    }
}
