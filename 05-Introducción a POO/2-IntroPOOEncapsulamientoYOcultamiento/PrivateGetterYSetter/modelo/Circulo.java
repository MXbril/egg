package modelo;

public class Circulo {
    private double radio;

    public Circulo() {
        this.radio = 0;
    }

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double area() {
        return Math.PI * Math.pow(radio, 2);
    }

    public double perimetro() {
        return 2 * Math.PI * radio;
    }

    public void imprimirDatos() {
        System.out.println("Círculo:");
        System.out.println("Radio: " +radio);
        System.out.println("Área: " +area());
        System.out.println("Perímetro: " +perimetro());
    }
}
