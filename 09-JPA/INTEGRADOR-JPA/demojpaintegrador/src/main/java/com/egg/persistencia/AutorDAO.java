package com.egg.persistencia;

import com.egg.EntityManagerUtil;
import com.egg.entidades.Autor;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class AutorDAO {
    private EntityManager em = EntityManagerUtil.getEntityManager();

    public void guardar(Autor autor) {
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
    }

    public Autor buscarPorId(Integer id) {
        return em.find(Autor.class, id);
    }

    public void actualizar(Autor autor) {
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
    }

    public void eliminar(Autor autor) {
        em.getTransaction().begin();
        em.remove(autor);
        em.getTransaction().commit();
    }

    public List<Autor> listarTodos() {
        TypedQuery<Autor> query = em.createQuery("SELECT a FROM Autor a", Autor.class);
        return query.getResultList();
    }

    // Opción para cerrar el EntityManager si es necesario
    public void cerrar() {
        if (em.isOpen()) {
            em.close();
        }
    }
}
