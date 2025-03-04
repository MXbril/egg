import java.util.Scanner;

public class NumeroPrimoDos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        do {
            System.out.println("Ingrese un número (0 para salir): ");
            numero = sc.nextInt();

            if (numero == 0) {
                System.out.println("Programa terminado.");
                break;
            }

            if (esPrimo(numero, 2)) {
                System.out.println(numero+ " es un número primo.");
            } else {
                System.out.println(numero+ " no es un número primo. Intente nuevamente.");
            }

        } while (!esPrimo(numero, 2));

        sc.close();
    }

    public static boolean esPrimo(int numero, int divisor) {
        if (numero <= 1) {
            return false;
        }
        if (divisor > Math.sqrt(numero)) {
            return true;
        }
        if (numero % divisor == 0) {
            return false;
        }
        return esPrimo(numero, divisor +1);
    }
}
