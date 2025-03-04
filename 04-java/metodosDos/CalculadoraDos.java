import java.util.Scanner;

public class CalculadoraDos {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scUser = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nCalculadora");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scUser.nextInt();

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingrese el primer número: ");
                double numero1 = scUser.nextDouble();

                System.out.print("Ingrese el segundo número: ");
                double numero2 = scUser.nextDouble();

                double resultado = (opcion == 1) ? (numero1 + numero2) :
                                   (opcion == 2) ? (numero1 - numero2) :
                                   (opcion == 3) ? (numero1 * numero2) :
                                   (numero2 != 0) ? (numero1 / numero2) : Double.NaN;

                String mensaje = (opcion == 4 && numero2 == 0) ?
                    "Error no se puede dividir por cero." :
                    "El resultado de la operación es: " + resultado;
                   
                System.out.println(mensaje);
            } else if (opcion == 5) {
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("opción no válida. Por favor, seleccione una opción entre 1 y 5.");
            }
        } while (opcion != 5);
        
        scUser.close();
    }
}
