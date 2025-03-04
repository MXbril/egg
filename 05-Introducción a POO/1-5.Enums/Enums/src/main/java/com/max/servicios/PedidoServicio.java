package main.java.com.max.servicios;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import main.java.com.max.enumeraciones.EstadoPedido;
import main.java.com.max.modelos.Pedido;

public class PedidoServicio {
    private List<Pedido> pedidos;
    
    public PedidoServicio() {
        this.pedidos = new ArrayList<>();
    }

    public void crearPedido(int numeroDePedido, String cliente, String[] listaDeProductos) {
        Pedido nuevoPedido = new Pedido(numeroDePedido, cliente, listaDeProductos);
        pedidos.add(nuevoPedido);
        System.out.println("Pedido creado exitosamente: " +nuevoPedido);
    }

    public void actualizarEstadoPedido(int numeroDePedido, EstadoPedido nuevoEstado) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNumeroDePedido() == numeroDePedido) {
                pedido.setEstadoDelPedido(nuevoEstado);
                System.out.println("Estado del pedido actualizado a " + nuevoEstado + " para el pedido número " + numeroDePedido);
                return;
            }
        }
        System.out.println("Pedido no encontrado con el número: " +numeroDePedido);
    }

    public List<Pedido> buscarPedidosPorEstado(EstadoPedido estado) {
        return pedidos.stream()
                .filter(pedido -> pedido.getEstadoDelPedido() == estado)
                .collect(Collectors.toList());
    }

    public List<Pedido> obtenerTodosLosPedidos() {
        return new ArrayList<>(pedidos);
    }
}
