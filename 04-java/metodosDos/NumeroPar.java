import java.util.Scanner;

public class NumeroPar {
    public static void main(String[] args) {
        int numero = solicitarNumero();
        if (esPar(numero)) {
            System.out.println("El " +numero+ " es par");
        } else {
            System.out.println("El " +numero+ " es impar");
        }
    }

    public static int solicitarNumero() {
        Scanner sc = new Scanner(System.in);
        Integer numero = null;
        System.out.println("Por favor ingresa un número: ");
        do {
            try {
                numero = sc.nextInt();
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("No ingresó un número, intente nuevamente:");
            }
        } while (numero == null);
        sc.close();
        return numero;
    }

    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }
}