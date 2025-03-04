package com.egg.persistencia;

import java.util.List;

import com.egg.JPAUtil;
import com.egg.entidades.Cliente;
import jakarta.persistence.EntityManager;

public class ClienteDAO {
    public void guardarCliente(Cliente cliente) throws Exception {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Cliente buscarCliente(int idCliente) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Cliente.class, idCliente);
        } finally {
            em.close();
        }
    }

    // Método para listar clientes cuyo nombre de contacto coincida con el parámetro
    public List<Cliente> listarClientesPorNombre(String nombreABuscar) throws Exception {
        EntityManager em = JPAUtil.getEntityManager(); // Obtén el EntityManager
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE c.nombreContacto LIKE :nombre", Cliente.class)
                     .setParameter("nombre", "%" + nombreABuscar + "%")
                     .getResultList();
        } finally {
            if (em != null) {
                em.close(); // Asegúrate de cerrar el EntityManager
            }
        }
    }

    public List<Cliente> listarClientesPorCiudad(String ciudadABuscar) throws Exception {
        EntityManager em = JPAUtil.getEntityManager(); // Obtén el EntityManager
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE c.ciudad LIKE :ciudad", Cliente.class)
                    .setParameter("ciudad", "%" + ciudadABuscar + "%")
                    .getResultList();
        } finally {
            em.close(); // Asegúrate de cerrar el EntityManager
        }
    }
}
