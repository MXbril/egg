package com.egg.servicios;
import java.util.Date;
import java.util.List;
import com.egg.entidades.Pedido;
import com.egg.persistencia.PedidoDAO;

public class PedidoServicio {
    private final PedidoDAO pedidoDAO;

    public PedidoServicio() {
        this.pedidoDAO = new PedidoDAO();
    }

    public void listarPedidosPorFechaEntrega(Date fechaEsperada) throws Exception {
        List<Pedido> pedidos = pedidoDAO.listarPedidosPorFechaEntrega(fechaEsperada);
        imprimirLista(pedidos); // Imprimir los resultados
    }

    // Método para imprimir la lista de pedidos
    public void imprimirLista(List<Pedido> listaRecibida) {
        for (Pedido pedido : listaRecibida) {
            System.out.println("ID Pedido: " + pedido.getIdPedido() +
                               " - Código: " + pedido.getCodigoPedido() +
                               " - Estado: " + pedido.getEstado() +
                               " - Fecha de Entrega: " + pedido.getFechaEntrega());
        }
    }

    public void listarPedidosPorClienteYFechas(String nombreCliente, Date fechaInicio, Date fechaFin) {
        List<Pedido> pedidos = pedidoDAO.listarPedidosPorClienteYFechas(nombreCliente, fechaInicio, fechaFin);
        if (pedidos == null || pedidos.isEmpty()) {
            System.out.println("No se encontraron pedidos para el cliente: " + nombreCliente + " entre las fechas especificadas.");
        } else {
            imprimirListaPedidos(pedidos); // Método para imprimir la lista de pedidos
        }
    }

    private void imprimirListaPedidos(List<Pedido> pedidos) {
        for (Pedido pedido : pedidos) {
            System.out.println("ID Pedido: " + pedido.getIdPedido() +
                               ", Fecha Pedido: " + pedido.getFechaPedido() +
                               ", Estado: " + pedido.getEstado() +
                               ", Comentarios: " + pedido.getComentarios() +
                               ", Fecha Entrega: " + pedido.getFechaEntrega());
        }
    }
}
