package com.egg.servicios;

import java.util.List;
import com.egg.entidades.Editorial;
import com.egg.persistencia.EditorialDAO;

public class EditorialServicio {
    
    private EditorialDAO editorialDAO;
    public EditorialServicio() {
        this.editorialDAO = new EditorialDAO();
    }

    // Crear una nueva editorial
    public void crearEditorial(String nombre) throws Exception {
        if (nombre == null || nombre.isEmpty()) {
            throw new Exception("El nombre de la editorial no puede estar vacío.");
        }
        
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorial.setActivo(true); // Estado "activo" activo por defecto
        
        editorialDAO.guardar(editorial);
    }

    // Modificar una editorial existente
    public void modificarEditorial(Integer id, String nuevoNombre) {
        Editorial editorial = editorialDAO.buscarPorId(id);
        if (editorial != null && editorial.getActivo()) {
            editorial.setNombre(nuevoNombre);
            editorialDAO.actualizar(editorial);
        } else {
            System.out.println("La editorial no existe o no está activa.");
        }
    }

    // Dar de baja (eliminación lógica) una editorial
    public void darBajaEditorial(Integer id) {
        Editorial editorial = editorialDAO.buscarPorId(id);
        if (editorial != null && editorial.getActivo()) {
            editorialDAO.darBaja(editorial);
            System.out.println("Editorial dada de baja correctamente.");
        } else {
            System.out.println("La editorial no existe o ya está inactiva.");
        }
    }

    // Buscar una editorial por ID
    public Editorial buscarEditorialPorId(Integer id) throws Exception {
        if (id == null) {
            throw new Exception("El ID de la editorial no puede ser nulo.");
        }

        Editorial editorial = editorialDAO.buscarPorId(id);
        if (editorial == null) {
            throw new Exception("No se encontró una editorial con el ID proporcionado.");
        }

        return editorial;
    }

    public List<Editorial> listarEditoriales() {
        List<Editorial> editoriales = editorialDAO.listarTodos();
    
        if (editoriales.isEmpty()) {
            System.out.println("No hay editoriales disponibles.");
        } else {
            System.out.println("Lista de editoriales:");
            for (Editorial editorial : editoriales) {
                System.out.println("ID: " + editorial.getId() + " - Nombre: " + editorial.getNombre());
            }
        }
    
        return editoriales;
    }
}
