package App.modelos;

public class Rectangulo extends Figura implements Dibujable {
    private double ancho;
    private double alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public Rectangulo() {

    }

    public double getAncho() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }


    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    @Override
    public double calcularArea() {
        return ancho * alto;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (ancho + alto);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un rectángulo");
    }
}
