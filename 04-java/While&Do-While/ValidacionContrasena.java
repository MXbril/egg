import java.util.Scanner;

public class ValidacionContrasena {
    public static void main(String[] args) {
        Scanner userContra = new Scanner(System.in);

        String password = "secreto";
        String passwordEntered;

        do {
            System.out.print("Por favor, ingresa la contraseña: ");
            passwordEntered = userContra.nextLine();

            if (!passwordEntered.equals(password)) {
                System.out.println("Contraseña incorrecta. Intenta nuevamente.");
            }
        } while (!passwordEntered.equals(password));

        System.out.println("¡Contraseña correcta!");

        userContra.close();
    }
}
