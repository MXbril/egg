package main.java.com.max.modelos;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidadEnStock;
    private String descripcion;

    public Producto(String nombre, double precio, int cantidadEnStock, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
