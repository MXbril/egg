import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangulo rectangulo = null;
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear un rectángulo");
            System.out.println("2. Calcular y mostrar el área");
            System.out.println("3. Calcular y mostrar el perímetro");
            System.out.println("4. Mostrar el número total de rectángulos creados");
            System.out.println("5. Salir");
            System.out.println("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el ancho del rectángulo: ");
                    double ancho = sc.nextDouble();
                    System.out.print("Ingresa el alto del rectángulo: ");
                    double alto = sc.nextDouble();
                    rectangulo = new Rectangulo(ancho, alto);
                    System.out.println("¡Rectángulo creado con exito!");
                    break;
                case 2:
                    if (rectangulo != null) {
                        rectangulo.imprimirArea();
                    } else {
                        System.out.println("Primero debes crear un rectángulo.");
                    }
                    break;
                case 3:
                    if (rectangulo != null) {
                        rectangulo.imprimirPerimetro();
                    } else {
                        System.out.println("Primero debes crear un rectángulo.");
                    }
                    break;
                case 4:
                    System.out.println("Número total de rectángulos creados: " + Rectangulo.obtenerContador());
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta nuevamente.");
                    break;
            }
        } while (opcion != 5);

        sc.close();
    }
}
