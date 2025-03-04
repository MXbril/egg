package modelos;

public class Punto {
    private double x;
    private double y;

    public Punto() {
        this.x = 0;
        this.y = 0;
    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distanciaDesdeOrigen() {
        return Math.sqrt(x * x + y * y);
    }

    public static double calcularDistancia(Punto p1, Punto p2) {
        double dX = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        return Math.sqrt(dX * dX + dy * dy);
    }

    public static boolean estanAlineados(Punto p1, Punto p2, Punto p3) {
        return (p3.getY() - p1.getY()) * (p2.getX() - p1.getX()) ==
               (p2.getY() - p1.getY()) * (p3.getX() - p1.getX());
    }
}
