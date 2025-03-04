import java.util.Scanner;

public class TablaDeMultiplicar {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numero = pedirNumero();
        imprimirTablaMultiplicar(numero);

        sc.close();
    }

    public static int pedirNumero() {
        System.out.println("Ingresa un número: ");
        return sc.nextInt();
    }
    public static void imprimirTablaMultiplicar(int numero) {
        System.out.println("tabla de multiplicar del " +numero+ ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero+ " x " +i+ " = " +(numero * i));
        }
    }
}
