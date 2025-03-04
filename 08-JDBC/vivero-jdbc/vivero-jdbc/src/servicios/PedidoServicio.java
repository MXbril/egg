package servicios;

import java.util.List;
import entidades.DetallePedido;
import entidades.Pedido;
import persistencia.DetallePedidoDAO;
import persistencia.PedidoDAO;

public class PedidoServicio {
    private PedidoDAO pedidoDAO;
    private DetallePedidoDAO detallePedidoDAO;

    public PedidoServicio() {
        this.pedidoDAO = new PedidoDAO();
        this.detallePedidoDAO = new DetallePedidoDAO();
    }

    public void guardarPedido(Pedido pedido, List<DetallePedido> detalles) throws Exception {
        try {
            // Primero guardamos el pedido en la base de datos y obtenemos el ID generado
            int idPedidoGenerado = pedidoDAO.guardarPedido(pedido);

            // Ahora asignamos ese ID a cada uno de los detalles del pedido y los guardamos
            for (DetallePedido detalle : detalles) {
                detalle.setIdPedido(idPedidoGenerado);
                detallePedidoDAO.guardarDetallePedido(detalle);
            }

            System.out.println("Pedido y sus detalles guardados exitosamente.");
        } catch (Exception e) {
            throw new Exception("Error al guardar el pedido y sus detalles: " + e.getMessage());
        }
    }
}
