package com.egg.persistencia;

import java.util.List;
import com.egg.JPAUtil;
import com.egg.entidades.GamaProducto;
import com.egg.entidades.Producto;

import jakarta.persistence.EntityManager;

public class GamaProductoDAO {
    public void guardarGamaProducto(GamaProducto gamaProducto) throws Exception {
        EntityManager em = JPAUtil.getEntityManager();
       
        try {
            em.getTransaction().begin();
            em.persist(gamaProducto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public GamaProducto buscarGamaProducto(int idGama) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(GamaProducto.class, idGama);
        } finally {
            em.close();
        }
    }

    public void actualizarGamaProducto(GamaProducto gamaProducto) throws Exception {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            // Utilizando merge para actualizar la entidad
            em.merge(gamaProducto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Producto> listarProductosPorGama(String nombreGama) {
        EntityManager em = JPAUtil.getEntityManager(); // Conexión al EntityManager
        String jpql = "SELECT p FROM Producto p JOIN p.gamaProducto g WHERE g.gama = :nombreGama";
        
        List<Producto> productos = null;
        try {
            productos = em.createQuery(jpql, Producto.class)
                        .setParameter("nombreGama", nombreGama)
                        .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close(); // cerrar el EntityManager
        }
        return productos;
    }
}
