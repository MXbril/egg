package com.egg.persistencia;

import java.util.List;
import com.egg.JPAUtil;
import com.egg.entidades.Producto;

import jakarta.persistence.EntityManager;

public class ProductoDAO {
    
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
            em.close(); // Asegúrate de cerrar el EntityManager
        }
        return productos;
    }
}
