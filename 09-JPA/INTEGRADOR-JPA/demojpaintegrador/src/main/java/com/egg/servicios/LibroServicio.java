package com.egg.servicios;

import java.util.List;
import com.egg.entidades.Autor;
import com.egg.entidades.Editorial;
import com.egg.entidades.Libro;
import com.egg.persistencia.LibroDAO;

public class LibroServicio {
    private LibroDAO libroDAO;
    public LibroServicio() {
        this.libroDAO = new LibroDAO();
    }

    // Crear un libro
    public void crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Autor autor, Editorial editorial) throws Exception {
        try {
            if (isbn == null || isbn < 0) {
                throw new Exception("El isbn no puede ser nulo o ser negativa.");
            }
            if (titulo == null || titulo.isEmpty()) {
                throw new Exception("El título no puede estar vacío.");
            }
            
            if (anio == null || anio <= 0) {
                throw new Exception("El año de publicación debe ser un número positivo.");
            }
            
            if (ejemplares == null || ejemplares < 0) {
                throw new Exception("La cantidad de ejemplares no puede ser negativa.");
            }
    
            if (autor == null) {
                throw new Exception("El autor no puede ser nulo.");
            }
    
            if (editorial == null) {
                throw new Exception("La editorial no puede ser nula.");
            }
    
            // Creación del libro
            Libro libro = new Libro();
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setActivo(true);
    
            libroDAO.guardar(libro);
        } catch (Exception e) {
            throw new Exception("Error al crear el libro: " + e.getMessage());
        }
    }

    // Modificar un libro
    public void modificarLibro(Long isbn, String nuevoTitulo, Integer nuevoAnio, Integer nuevosEjemplares, Autor nuevoAutor, Editorial nuevaEditorial) {
        Libro libro = libroDAO.buscarPorId(isbn);
        if (libro != null && libro.getActivo()) {
            libro.setTitulo(nuevoTitulo);
            libro.setAnio(nuevoAnio);
            libro.setEjemplares(nuevosEjemplares);
            libro.setAutor(nuevoAutor);
            libro.setEditorial(nuevaEditorial);

            libroDAO.actualizar(libro);
        } else {
            System.out.println("El libro no existe o no está activo.");
        }
    }

    // Dar de baja (eliminación lógica) un libro
    public void darBajaLibro(Long isbn) {
        Libro libro = libroDAO.buscarPorId(isbn);
        if (libro != null && libro.getActivo()) {
            libroDAO.darBaja(libro);
            System.out.println("Libro dado de baja correctamente.");
        } else {
            System.out.println("El libro no existe o ya está inactivo.");
        }
    }

    // Buscar un libro por ISBN
    public Libro buscarLibroPorId(Long isbn) throws Exception {
        try {
            Libro libro = libroDAO.buscarPorId(isbn);

            if (libro == null) {
                throw new Exception("No se encontró un libro con el ISBN " + isbn);
            }

            return libro;
        } catch (Exception e) {
            throw new Exception("Error al buscar el libro: " + e.getMessage());
        }
    }

    // Listar todos los libros
    public List<Libro> listarLibros() throws Exception {
        try {
            List<Libro> libros = libroDAO.listarTodos();

            if (libros == null || libros.isEmpty()) {
                throw new Exception("No se encontraron libros en la base de datos.");
            }

            return libros;
        } catch (Exception e) {
            throw new Exception("Error al listar los libros: " + e.getMessage());
        }
    }
}
