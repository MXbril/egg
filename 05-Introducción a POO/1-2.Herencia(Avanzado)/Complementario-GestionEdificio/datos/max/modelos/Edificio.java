package datos.max.modelos;

abstract class Edificio {
    
    protected double ancho;
    protected double alto;
    protected double largo;

    public Edificio(double ancho, double alto, double largo) {
        this.ancho = ancho;
        this.alto = alto;
        this.largo = largo;
    }

    public Edificio() {

    }

    public abstract double calcularSuperficie();
    public abstract double calcularVolumen();

}
