
import java.util.Scanner;
import modelo.Circulo;
import modelo.Rectangulo;
import modelo.Triangulo;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("seleccione la figura geométrica:");
            System.out.println("1. Rectángulo");
            System.out.println("2. Triángulo");
            System.out.println("3. Círculo");
            System.out.println("4. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Rectangulo rectangulo = crearRectangulo(sc);
                    rectangulo.imprimirDatos();
                    break;
                case 2:
                    Triangulo triangulo = crearTriangulo(sc);
                    triangulo.imprimirDatos();
                    break;
                case 3:
                    Circulo circulo = crearCirculo(sc);
                    circulo.imprimirDatos();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 4);

        sc.close();
    }

    public static Rectangulo crearRectangulo(Scanner sc) {
        Rectangulo rectangulo = new Rectangulo();

        System.out.print("Ingrese el ancho del rectángulo: ");
        double ancho = sc.nextDouble();
        rectangulo.setAncho(ancho);
        System.out.print("Ingrese el alto del rectángulo: ");
        double alto = sc.nextDouble();
        rectangulo.setAlto(alto);
        return rectangulo;
        // return new Rectangulo(ancho, alto);
    }

    public static Triangulo crearTriangulo(Scanner sc) {
        Triangulo triangulo = new Triangulo();
        System.out.print("Ingrese la base del triángulo: ");
        double base = sc.nextDouble();
        triangulo.setBase(base);
        System.out.print("Ingrese la altura del triángulo: ");
        double altura = sc.nextDouble();
        triangulo.setAltura(altura);
        return triangulo;
        // return new Triangulo(base, altura);
    }

    public static Circulo crearCirculo(Scanner sc) {
        Circulo circulo = new Circulo();
        System.out.print("Ingrese el radio del círculo: ");
        double radio = sc.nextDouble();
        circulo.setRadio(radio);
        return circulo;
        // return new Circulo(radio);
    }
}