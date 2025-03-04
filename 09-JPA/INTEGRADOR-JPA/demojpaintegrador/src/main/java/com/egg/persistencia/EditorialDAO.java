package com.egg.persistencia;

import java.util.List;
import com.egg.EntityManagerUtil;
import com.egg.entidades.Editorial;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class EditorialDAO {
     private EntityManager em = EntityManagerUtil.getEntityManager();

    // Guardar una editorial
    public void guardar(Editorial editorial) {
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
    }

    // Buscar una editorial por su ID
    public Editorial buscarPorId(Integer id) {
        return em.find(Editorial.class, id);
    }

    // Actualizar una editorial
    public void actualizar(Editorial editorial) {
        em.getTransaction().begin();
        em.merge(editorial);
        em.getTransaction().commit();
    }

    // Eliminar una editorial (cambiar estado de activo)
    public void darBaja(Editorial editorial) {
        em.getTransaction().begin();
        editorial.setActivo(false);
        em.merge(editorial);
        em.getTransaction().commit();
    }

    // Listar todas las editoriales
    public List<Editorial> listarTodos() {
        TypedQuery<Editorial> query = em.createQuery("SELECT e FROM Editorial e", Editorial.class);
        return query.getResultList();
    }

    // Cerrar el EntityManager si es necesario
    public void cerrar() {
        if (em.isOpen()) {
            em.close();
        }
    }
}
