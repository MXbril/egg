import java.util.Scanner;

public class RaizCuadrada {
    public static void main(String[] args) {
        Scanner userRaiz = new Scanner(System.in);

        System.out.println("Introduce un número entero: ");
        double numero = userRaiz.nextDouble();

        if (numero < 0) {
            System.out.println("El número ingresado es negativo. Por favor, introduce un número positivo.");
        } else {
            double raizQrt = Math.sqrt(numero);

            System.out.println("La raíz cuadrada de " +numero+ " es " +raizQrt);
        }

        userRaiz.close();
    }
}
