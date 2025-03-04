public class Rectangulo {
    private double ancho;
    private double alto;
    static int contadorRectangulos = 0;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
        contadorRectangulos++;
    }

    public double area() {
        return ancho * alto;
    }

    public double perimetro() {
        return 2 * (ancho + alto);
    }

    public void imprimirArea() {
        System.out.println("Área del rectángulo: " + area());
    }

    public void imprimirPerimetro() {
        System.out.println("Perímetro del rectángulo: " + perimetro());
    }

    public static int obtenerContador() {
        return contadorRectangulos;
    }
}