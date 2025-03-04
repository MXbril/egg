package com.egg.servicios;

import java.util.List;
import com.egg.entidades.Autor;
import com.egg.persistencia.AutorDAO;

public class AutorServicio {

    private AutorDAO autorDAO;
    public AutorServicio() {
        this.autorDAO = new AutorDAO();
    }

    // Crear un autor
    public void crearAutor(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }
        
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setActivo(true); // Se asigna como activo al crearlo
        
        autorDAO.guardar(autor);
    }

    // Buscar un autor por ID
    public Autor buscarAutorPorId(Integer id) {
        Autor autor = autorDAO.buscarPorId(id);
        if (autor == null) {
            System.out.println("No se encontró un autor con el ID proporcionado.");
        }
        return autor;
    }

    // Modificar un autor
    public void modificarAutor(Integer id, String nuevoNombre) {
        Autor autor = autorDAO.buscarPorId(id);
        if (autor == null) {
            System.out.println("No se encontró un autor con el ID proporcionado.");
            return;
        }

        if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }

        autor.setNombre(nuevoNombre);
        autorDAO.actualizar(autor);
        System.out.println("Autor actualizado correctamente.");
    }

    // Método para dar de baja a un autor (setea el atributo alta en false)
    public void darBajaAutor(Integer id) {
        Autor autor = autorDAO.buscarPorId(id);
        if (autor != null) {
            autor.setActivo(false); // Si decides manejar el estado activo aquí
            autorDAO.actualizar(autor);
            System.out.println("Autor dado de baja exitosamente.");
        } else {
            System.out.println("El autor no existe.");
        }
    }

    // Eliminar un autor completamente (no recomendado)
    public void eliminarAutor(Integer id) {
        Autor autor = autorDAO.buscarPorId(id);
        if (autor == null) {
            System.out.println("No se encontró un autor con el ID proporcionado.");
            return;
        }

        autorDAO.eliminar(autor);
        System.out.println("Autor eliminado del sistema.");
    }

    // Listar todos los autores
    public List<Autor> listarAutores() {
        List<Autor> autores = autorDAO.listarTodos();
        if (autores.isEmpty()) {
            System.out.println("No hay autores disponibles.");
        } else {
            System.out.println("Lista de autores:");
            for (Autor autor : autores) {
                System.out.println("ID: " + autor.getId() + " - Nombre: " + autor.getNombre());
            }
        }
        return autores;
    }
}
