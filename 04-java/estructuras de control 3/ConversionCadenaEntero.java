import java.util.Scanner;

public class ConversionCadenaEntero {
    public static void main(String[] args) {
        Scanner userCadena = new Scanner(System.in);

        try {
            System.out.println("Ingresar una cadena de caracteres que represente un número entero: ");
        String cadena = userCadena.nextLine();

        int num = Integer.parseInt(cadena);
        System.out.println("El número entero es: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Error: La cadena ingresada no es un número entero válido.");
        } finally {
            userCadena.close();
        }

    }
}
