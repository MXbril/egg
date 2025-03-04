package main.java.com.max.excepciones;

public class ProductoAgotadoException extends Exception {
    public ProductoAgotadoException(String mensaje) {
        super(mensaje);
    }
}
