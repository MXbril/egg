package main.java.com.max;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import main.java.com.max.clientes.Cliente;
import main.java.com.max.excepciones.ProductoAgotadoException;
import main.java.com.max.modelos.Producto;
import main.java.com.max.modelos.ProductoElectronico;
import main.java.com.max.modelos.ProductoRopa;

public class App {
    private static Cliente cliente = new Cliente();
    private static List<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {
        productos.add(new ProductoElectronico("Laptop", 1000.00, 30, "muy buena laptop unica", 0));
        productos.add(new ProductoRopa("Camisa", 25.00, 10, "Camisa de buena calidad echa de algodón", null));

        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("1. Agregar producto al carrito");
            System.out.println("2. Ver el carrito");
            System.out.println("3. Realizar la compra");
            System.out.println("4. Salir");

            try {
                int opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        agregarProductoAlCarrito(sc);
                        break;
                    case 2:
                        verCarrito();
                        break;
                    case 3:
                        realizarCompra();
                        break;
                    case 4:
                        salir = true;
                        break;  
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error al leer la entrada: " +e.getMessage());
                sc.nextLine();
            }
        }
        sc.close();
    }
    
    private static void agregarProductoAlCarrito(Scanner sc) {
        // Mostrar la lista de productos disponibles
        System.out.println("Productos disponibles:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            System.out.printf("%d. %s - Precio: %.2f - Stock: %d\n",
                            i + 1, producto.getNombre(), producto.getPrecio(), producto.getCantidadEnStock());
        }

        // Selección del producto
        System.out.print("Selecciona el número del producto que deseas agregar al carrito: ");
        int seleccion = sc.nextInt() - 1;

        if (seleccion < 0 || seleccion >= productos.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Producto productoSeleccionado = productos.get(seleccion);

        // Cantidad a agregar
        System.out.print("Ingresa la cantidad que deseas agregar al carrito: ");
        int cantidad = sc.nextInt();

        try {
            cliente.agregarAlCarrito(productoSeleccionado, cantidad);
            System.out.println("Producto agregado al carrito.");
        } catch (ProductoAgotadoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void verCarrito() {
        Map<Producto, Integer> carrito = cliente.getCarrito();

        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }

        System.out.println("Carrito de compras:");
        double total = 0;

        for (Map.Entry<Producto, Integer> entry : carrito.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            double subtotal = producto.getPrecio() * cantidad;
            System.out.printf("Producto: %s - Cantidad: %d - Precio unitario: %.2f - Subtotal: %.2f\n",
                          producto.getNombre(), cantidad, producto.getPrecio(), subtotal);
            total += subtotal;
        }

        System.out.printf("Total a pagar: %.2f\n", total);
    }

    private static void realizarCompra() {
        Map<Producto, Integer> carrito = cliente.getCarrito();

        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío. No puedes realizar la compra.");
            return;
        }

        double total = 0;

        for (Map.Entry<Producto, Integer> entry : carrito.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            double subtotal = producto.getPrecio() * cantidad;
            total += subtotal;
        }

        // Aquí podrías aplicar descuentos o impuestos si es necesario
        // Por ejemplo, aplicar un 10% de descuento
        double descuento = total * 0.10;
        double totalConDescuento = total - descuento;

        System.out.printf("Precio total antes de descuento: %.2f\n", total);
        System.out.printf("Descuento aplicado: %.2f\n", descuento);
        System.out.printf("Total a pagar después de descuento: %.2f\n", totalConDescuento);

        // Limpiar el carrito después de la compra
        cliente.getCarrito().clear();
    }
}