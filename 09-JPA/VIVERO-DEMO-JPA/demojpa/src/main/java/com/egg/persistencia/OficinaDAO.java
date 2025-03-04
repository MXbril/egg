package com.egg.persistencia;

import java.util.List;

import com.egg.JPAUtil;
import com.egg.entidades.Oficina;
import jakarta.persistence.EntityManager;

public class OficinaDAO {

    public void guardaOficina(Oficina oficina) throws Exception {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            em.getTransaction().begin();
            em.persist(oficina);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Hacer rollback si la transacción está activa
            }
            throw e;
        } finally {
            if (em.isOpen()) {
                em.close(); // Asegurar que el EntityManager se cierre al final
            }
        }
    }

    public List<Oficina> listarTodas() throws Exception {
        EntityManager em = JPAUtil.getEntityManager(); // Obtén el EntityManager
        try {
            return em.createQuery("SELECT o FROM Oficina o", Oficina.class)
                     .getResultList(); // Ejecuta la consulta JPQL para obtener todas las oficinas
        } finally {
            em.close(); // Cierra el EntityManager para liberar los recursos
        }
    }

}
