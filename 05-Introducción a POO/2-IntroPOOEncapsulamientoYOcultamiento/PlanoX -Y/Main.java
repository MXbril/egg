import java.util.Scanner;

import modelos.Punto;

public class Main {
    private static Punto[] puntos = new Punto[10];  // Arreglo global para almacenar puntos
    private static int contador = 0;  // Contador para el número de puntos creados
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear un nuevo punto");
            System.out.println("2. Calcular distancia desde el origen");
            System.out.println("3. Calcular distancia entre dos puntos");
            System.out.println("4. Verificar si tres puntos están alineados");
            System.out.println("5. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    crearPunto(sc);
                    break;
                case 2:
                    calcularDistanciaDesdeOrigen(sc);
                    break;
                case 3:
                    calcularDistanciaEntrePuntos(sc);
                    break;
                case 4:
                    verificarAlineacion(sc);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }

    private static void crearPunto(Scanner sc) {
        if (contador < puntos.length) {
            System.out.print("Ingrese la coordenada X del punto: ");
            double x = sc.nextDouble();
            System.out.print("Ingrese la coordenada Y del punto: ");
            double y = sc.nextDouble();
            Punto punto = new Punto();
            punto.setX(x);  // Usar el setter para asignar 'x'
            punto.setY(y);  // Usar el setter para asignar 'y'
            puntos[contador] = punto;
            System.out.println("Punto creado en (" + punto.getX() + ", " + punto.getY() + ")");  // Usar el getter para mostrar 'x' y 'y'
            contador++;
        } else {
            System.out.println("No se pueden crear más puntos. El arreglo está lleno.");
        }
    }

    private static void calcularDistanciaDesdeOrigen(Scanner sc) {
        System.out.print("Ingrese el índice del punto (0 a " + (contador - 1) + "): ");
        int index = sc.nextInt();
        if (index >= 0 && index < contador) {
            double distancia = puntos[index].distanciaDesdeOrigen();
            System.out.println("La distancia desde el origen es: " + distancia);
        } else {
            System.out.println("Índice no válido.");
        }
    }

    private static void calcularDistanciaEntrePuntos(Scanner sc) {
        System.out.print("Ingrese el índice del primer punto (0 a " + (contador - 1) + "): ");
        int index1 = sc.nextInt();
        System.out.print("Ingrese el índice del segundo punto (0 a " + (contador - 1) + "): ");
        int index2 = sc.nextInt();

        if (index1 >= 0 && index1 < contador && index2 >= 0 && index2 < contador) {
            double distancia = Punto.calcularDistancia(puntos[index1], puntos[index2]);
            System.out.println("La distancia entre los puntos es: " + distancia);
        } else {
            System.out.println("Índice(s) no válido(s).");
        }
    }

    private static void verificarAlineacion(Scanner sc) {
        System.out.print("Ingrese el índice del primer punto (0 a " + (contador - 1) + "): ");
        int index1 = sc.nextInt();
        System.out.print("Ingrese el índice del segundo punto (0 a " + (contador - 1) + "): ");
        int index2 = sc.nextInt();
        System.out.print("Ingrese el índice del tercer punto (0 a " + (contador - 1) + "): ");
        int index3 = sc.nextInt();

        if (index1 >= 0 && index1 < contador && index2 >= 0 && index2 < contador && index3 >= 0 && index3 < contador) {
            boolean alineados = Punto.estanAlineados(puntos[index1], puntos[index2], puntos[index3]);
            if (alineados) {
                System.out.println("Los puntos están alineados.");
            } else {
                System.out.println("Los puntos no están alineados.");
            }
        } else {
            System.out.println("Índice(s) no válido(s).");
        }
    }
}