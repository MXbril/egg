package main.java.com.max.clientes;
import java.util.HashMap;
import java.util.Map;

import main.java.com.max.excepciones.ProductoAgotadoException;
import main.java.com.max.modelos.Producto;

public class Cliente {
    private Map<Producto, Integer> carrito = new HashMap<>();

    public void agregarAlCarrito(Producto producto, int cantidad) throws ProductoAgotadoException {
        if (producto.getCantidadEnStock() < cantidad) {
            throw new ProductoAgotadoException("No hay suficiente stock para el producto: " +producto.getNombre());
        }
        producto.setCantidadEnStock(producto.getCantidadEnStock() - cantidad);
        // Si el producto ya está en el carrito, actualiza la cantidad
        carrito.put(producto, carrito.getOrDefault(producto, 0) + cantidad);
    }

    public Map<Producto, Integer> getCarrito() { return carrito; }
}
