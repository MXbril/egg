package com.egg.persistencia;

import java.util.List;
import java.util.Date;
import com.egg.JPAUtil;
import com.egg.entidades.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class PedidoDAO {
    public List<Pedido> listarPedidosPorFechaEntrega(Date fechaEsperada) throws Exception {
        EntityManager em = JPAUtil.getEntityManager(); // Obtener el EntityManager
        try {
            // Consulta para obtener pedidos cuya fecha de entrega sea posterior a la fecha esperada
            TypedQuery<Pedido> query = em.createQuery(
                "SELECT p FROM Pedido p WHERE p.fechaEntrega > :fechaEsperada", Pedido.class);
            query.setParameter("fechaEsperada", fechaEsperada); // Establecer el parámetro de la consulta
            return query.getResultList(); // Retornar la lista de pedidos
        } finally {
            em.close(); // Asegurarse de cerrar el EntityManager
        }
    }

    public List<Pedido> listarPedidosPorClienteYFechas(String nombreCliente, Date fechaInicio, Date fechaFin) {
        EntityManager em = JPAUtil.getEntityManager(); // Conexión al EntityManager
        String jpql = "SELECT p FROM Pedido p JOIN p.cliente c WHERE c.nombreCliente = :nombreCliente " +
                      "AND p.fechaPedido BETWEEN :fechaInicio AND :fechaFin";
    
        List<Pedido> pedidos = null;
        try {
            pedidos = em.createQuery(jpql, Pedido.class)
                        .setParameter("nombreCliente", nombreCliente)
                        .setParameter("fechaInicio", fechaInicio)
                        .setParameter("fechaFin", fechaFin)
                        .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close(); //cerrar el EntityManager
        }
        return pedidos;
    }
}