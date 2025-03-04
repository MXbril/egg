package com.egg.persistencia;
import java.util.List;
import com.egg.EntityManagerUtil;
import com.egg.entidades.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class LibroDAO {
    private EntityManager em = EntityManagerUtil.getEntityManager();

     // Guardar un libro
    public void guardar(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }

    // Buscar un libro por su ISBN
    public Libro buscarPorId(Long isbn) {
        return em.find(Libro.class, isbn);
    }

    // Actualizar un libro
    public void actualizar(Libro libro) {
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
    }

    // Eliminar un libro (solo cambiar estado de activo)
    public void darBaja(Libro libro) {
        em.getTransaction().begin();
        libro.setActivo(false);
        em.merge(libro);
        em.getTransaction().commit();
    }

    // Listar todos los libros
    public List<Libro> listarTodos() {
        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l", Libro.class);
        return query.getResultList();
    }

    // Cerrar el EntityManager si es necesario
    public void cerrar() {
        if (em.isOpen()) {
            em.close();
        }
    }
}
