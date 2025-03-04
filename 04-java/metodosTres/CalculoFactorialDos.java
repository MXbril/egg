import java.util.Scanner;

public class CalculoFactorialDos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un número para calcular factorial: ");
        int numero = sc.nextInt();

        int resultado = calcularFactorial(numero);

        System.out.println("El factorial de " + numero + " es: " + resultado);
        
        sc.close();
    }

    private static int calcularFactorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("El número no debe ser negativo.");
        } else if (numero == 0 || numero == 1) {
            return 1;
        }

        return numero * calcularFactorial( numero -1);
    }
}

// IllegalArgumentException. Esta excepción se utiliza para indicar 
// que un método ha recibido un argumento que no es válido o no cumple 
// con los requisitos esperados.