package modelo;

public class Triangulo {
    private double base;
    private double altura;

    public Triangulo() {
        this.base = 0;
        this.altura = 0;
    }

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double area() {
        return (base * altura) / 2;
    }

    public void imprimirDatos() {
        System.out.println("Triángulo:");
        System.out.println("Base: " +base);
        System.out.println("Altura: " +altura);
        System.out.println("Área: " +area());
    }
}
