import App.modelos.Circulo;
import App.modelos.Dibujable;
import App.modelos.Figura;
import App.modelos.Rectangulo;
import App.modelos.Triangulo;

public class App {
    public static void main(String[] args) {
        Figura circulo = new Circulo(10);
        Figura rectangulo = new Rectangulo(6, 8);
        Figura triangulo = new Triangulo(3, 5, 3, 3, 4);

        Dibujable[] figuras = { (Dibujable) circulo, (Dibujable) rectangulo, (Dibujable) triangulo };
        for (Dibujable figura : figuras) {
            figura.dibujar();
            System.out.println("Área: " + ((Figura) figura).calcularArea());
            System.out.println("Perímetro: " + ((Figura) figura).calcularPerimetro());
            System.out.println();
        }
    }
}