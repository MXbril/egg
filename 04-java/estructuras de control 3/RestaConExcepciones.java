import java.util.InputMismatchException;
import java.util.Scanner;

public class RestaConExcepciones {
    public static void main(String[] args) {
        Scanner userExeption = new Scanner(System.in);

        try {
            System.out.print("Ingrese el primer número: ");
            int numero1 = userExeption.nextInt();

            System.out.print("Ingrese el segundo número: ");
            int numero2 = userExeption.nextInt();

            int result = numero1 - numero2;
            System.out.println("El resultado de la resta es: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor ingrese un número válido.");
        } finally {
            userExeption.close();
        }
    }
}
