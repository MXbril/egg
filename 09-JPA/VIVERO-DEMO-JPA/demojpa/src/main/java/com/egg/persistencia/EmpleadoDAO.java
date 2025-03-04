package com.egg.persistencia;
import java.util.ArrayList;
import java.util.List;
import com.egg.JPAUtil;
import com.egg.entidades.Empleado;

import jakarta.persistence.EntityManager;

public class EmpleadoDAO {

    public void guardarEmpleado(Empleado empleado) throws Exception {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(empleado);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Empleado buscarEmpleado(int idEmpleado) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Empleado.class, idEmpleado);
        } finally {
            em.close();
        }
    }

    public void remove(int idEmpleado) throws Exception {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Empleado empleado = em.find(Empleado.class, idEmpleado);
            if (empleado != null) {
                em.remove(empleado);
            } else {
                throw new Exception("Empleado no encontrado con ID: " + idEmpleado);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    // Método para listar empleados por ID de oficina
    public List<Empleado> listarEmpleadosPorIdOficina(int idOficina) throws Exception {
        EntityManager em = JPAUtil.getEntityManager();
        List<Empleado> empleados = new ArrayList<>();
        try {
            empleados = em.createQuery("SELECT e FROM Empleado e WHERE e.Oficina.idOficina = :idOficina", Empleado.class)
                    .setParameter("idOficina", idOficina)
                    .getResultList();
        } catch (Exception e) {
            System.err.println("Error al listar empleados por id de oficina: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return empleados;
    }

}
