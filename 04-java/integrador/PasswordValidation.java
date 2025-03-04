import java.util.Scanner;

public class PasswordValidation {
    public static void main(String[] args) {
        Scanner userValidation = new Scanner(System.in);

        System.out.print("Ingrese una contraseña: ");
        String password = userValidation.nextLine();

        if (password.length() < 8) {
            System.out.println("La contraseña no es segura. Debe tener al menos 8 caracteres.");
        } else {
            boolean tieneMayuscula = false;
            boolean tieneMinuscula = false;
            boolean tieneNumero = false;
            boolean tieneCaracterEspecial = false;

            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    tieneMayuscula = true;
                } else if (Character.isLowerCase(c)) {
                    tieneMinuscula = true;
                } else if (Character.isDigit(c)) {
                    tieneNumero = true;
                } else if ("!@#$%^&*()_+-=[]{}|;':,.<>?/".indexOf(c) != -1) {
                    tieneCaracterEspecial = true;
                }
            }

            if (tieneMayuscula && tieneMinuscula && tieneNumero && tieneCaracterEspecial) {
                System.out.println("¡Contraseña segura! Cumple con todos los criterios.");
            } else {
                System.out.println("La contraseña no es segura. Debe cumplir con los siguientes criterios:");
                if (!tieneMayuscula) System.out.println("- Al menos una letra mayúscula.");
                if (!tieneMinuscula) System.out.println("- Al menos una letra minúscula.");
                if (!tieneNumero) System.out.println("- Al menos un número.");
                if (!tieneCaracterEspecial) System.out.println("- Al menos un carácter especial (!, @, #, $, etc.).");
            }
        }

        userValidation.close();
    }
}
