package main.java.com.max.modelos;

public class ProductoRopa extends Producto {
    private String talla;

    public ProductoRopa(String nombre, double precio, int cantidadEnStock, String descripcion, String talla) {
        super(nombre, precio, cantidadEnStock, descripcion);
        this.talla = talla;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }
}
