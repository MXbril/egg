package main.java.com.max.servicios;
import java.util.List;
import java.util.Scanner;
import main.java.com.max.enumeraciones.EstadoPedido;
import main.java.com.max.modelos.Pedido;

public class MenuServicio {
    private PedidoServicio pedidoServicio;
    private Scanner sc;

    public MenuServicio() {
        this.pedidoServicio = new PedidoServicio();
        this.sc = new Scanner(System.in);
    }

    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer de entrada
            switch (opcion) {
                case 1:
                    crearNuevoPedido();
                    break;
                case 2:
                    actualizarEstadoDePedido();
                    break;
                case 3:
                    buscarPedidosPorEstado();
                    break;
                case 4:
                    mostrarListaDePedidos();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del menú.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Crear nuevo pedido");
        System.out.println("2. Actualizar estado de un pedido");
        System.out.println("3. Buscar pedidos por estado");
        System.out.println("4. Mostrar lista de pedidos");
        System.out.println("5. Salir");
    }

     private void crearNuevoPedido() {
        System.out.println("Ingrese el número de pedido:");
        int numeroDePedido = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        System.out.println("Ingrese el nombre del cliente:");
        String cliente = sc.nextLine();
        System.out.println("Ingrese la lista de productos separados por comas:");
        String productos = sc.nextLine();
        String[] listaDeProductos = productos.split(",");
        pedidoServicio.crearPedido(numeroDePedido, cliente, listaDeProductos);
    }

    private void actualizarEstadoDePedido() {
        System.out.println("Ingrese el número de pedido para actualizar el estado:");
        int numeroDePedido = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        System.out.println("Ingrese el nuevo estado del pedido (PENDIENTE, ENVIADO, ENTREGADO):");
        String estado = sc.nextLine().toUpperCase();
        try {
            EstadoPedido nuevoEstado = EstadoPedido.valueOf(estado);
            pedidoServicio.actualizarEstadoPedido(numeroDePedido, nuevoEstado);
        } catch (IllegalArgumentException e) {
            System.out.println("Estado no válido. Por favor ingrese un estado válido.");
        }
    }

    private void buscarPedidosPorEstado() {
        System.out.println("Ingrese el estado del pedido para buscar (PENDIENTE, ENVIADO, ENTREGADO):");
        String estado = sc.nextLine().toUpperCase();
        try {
            EstadoPedido estadoPedido = EstadoPedido.valueOf(estado);
            List<Pedido> pedidosPorEstado = pedidoServicio.buscarPedidosPorEstado(estadoPedido);
            pedidosPorEstado.forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.println("Estado no válido. Por favor ingrese un estado válido.");
        }
    }

    private void mostrarListaDePedidos() {
        List<Pedido> todosLosPedidos = pedidoServicio.obtenerTodosLosPedidos();
        todosLosPedidos.forEach(System.out::println);
    }
}
