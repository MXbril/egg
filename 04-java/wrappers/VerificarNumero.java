import java.util.Scanner;

public class VerificarNumero {
    public static void main(String[] args) {
        Scanner userNun = new Scanner(System.in);
        System.out.println("Por favor, introduce una cadena:");
        String input = userNun.nextLine();

        try {
            double num = Double.valueOf(input);
            System.out.println("La cadena introducida representa el número: " +num);
        } catch (NumberFormatException e) {
            System.out.println("La entrada no es un número válido.");
        }

        userNun.close();
    }
}