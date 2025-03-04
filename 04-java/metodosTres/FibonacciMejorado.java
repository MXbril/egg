import java.util.Scanner;

public class FibonacciMejorado {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int posicion = obtenerPosicion(sc);
        long resultado = calcularFibonacci(posicion);
        mostrarResultado(posicion, resultado);

        sc.close();
    }

    private static int obtenerPosicion(Scanner sc) {
        System.out.println("Ingrese la posición en la serie de fibonacci: ");
        return sc.nextInt();
    }

    private static long calcularFibonacci(int posicion) {
        if (posicion < 0) {
            throw new IllegalArgumentException("La posicion no puede ser negativa.");
        } else if (posicion == 0) {
            return 0;
        } else if (posicion == 1) {
            return 1;
        }

        return calcularFibonacci(posicion -1) + calcularFibonacci(posicion -2);
    }

    private static void mostrarResultado(int posicion, long resultado) {
        System.out.println("El valor en la posición " +posicion+ " de la serie de fibonacci es: " +resultado);
    }
}