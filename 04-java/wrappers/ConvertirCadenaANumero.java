import java.util.Scanner;

public class ConvertirCadenaANumero {
    public static void main(String[] args) {
        Scanner userConvert = new Scanner(System.in);
        System.out.println("Por favor, ingrese una cadena que represente un número entero:");
        String entrada = userConvert.nextLine();

        try {
            int numero = Integer.parseInt(entrada);
            System.out.println("La cadena introducida representa el número entero: " +numero);
        } catch (NumberFormatException e) {
            System.out.println("La entrada no es un número entero válido.");
        }

        userConvert.close();
    }
}
