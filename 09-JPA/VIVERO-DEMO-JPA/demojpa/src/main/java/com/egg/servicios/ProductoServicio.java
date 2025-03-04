package com.egg.servicios;

import java.util.List;
import com.egg.entidades.Producto;
import com.egg.persistencia.ProductoDAO;

public class ProductoServicio {

    private final ProductoDAO productoDAO;
    public ProductoServicio() {
        this.productoDAO = new ProductoDAO();
    }

    public void listarProductosPorGama(String nombreGama) {
        List<Producto> productos = productoDAO.listarProductosPorGama(nombreGama);
        if (productos == null || productos.isEmpty()) {
            System.out.println("No se encontraron productos para la gama: " + nombreGama);
        } else {
            imprimirListaProductos(productos); // Método para imprimir la lista de productos
        }
    }

    private void imprimirListaProductos(List<Producto> productos) {
        for (Producto producto : productos) {
            System.out.println("ID: " + producto.getIdProducto() +
                               ", Nombre: " + producto.getNombre() +
                               ", Precio: " + producto.getPrecioVenta() +
                               ", Proveedor: " + producto.getProveedor() +
                               ", Cantidad en stock: " + producto.getCantidadEnStock());
        }
    }
}
