import java.util.Scanner;

public class SumaNumeros {
    public static void main(String[] args) {
        Scanner userSuma = new Scanner(System.in);

        System.out.println("Por favor, introduce una cadena que represente un número entero:");
        String entero = userSuma.nextLine();
        System.out.println("Por favor, introduce una cadena que represente un número decimal:");
        String decimal = userSuma.nextLine();

        try {
            int numEntero = Integer.valueOf(entero);
            double numDecimal = Double.valueOf(decimal);

            double suma = numEntero + numDecimal;
            System.out.println("La suma del número entero y el decimal es: " +suma);
        } catch (NumberFormatException e) {
            System.out.println("Una o ambas entradas no son válidas. Por favor, introduce números válidos.");
        }

        userSuma.close();
    }
}
