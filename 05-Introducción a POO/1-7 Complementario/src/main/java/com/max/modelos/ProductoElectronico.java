package main.java.com.max.modelos;

public class ProductoElectronico extends Producto {
    private int garantia;

    public ProductoElectronico(String nombre, double precio, int cantidadEnStock, String descripcion, int garantia) {
        super(nombre, precio, cantidadEnStock, descripcion);
        this.garantia = garantia;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }
}
