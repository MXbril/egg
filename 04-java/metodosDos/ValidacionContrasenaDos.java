import java.util.Scanner;

public class ValidacionContrasenaDos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una contraseña para verificar si es segura: ");
        String password = sc.nextLine();

        if (esSegura(password)) {
            System.out.println("La contraseña es segura.");
        } else {
            System.out.println("La contraseña no es segura. Debe cumplir con los siguientes criterios:");
            if (!tieneLongitudCorrecta(password)) {
                System.out.println("-Tener al menos 8 caracteres.");
            }
            if (!tieneMayuscula(password)) {
                System.out.println("- Contener al menos una letra mayúscula.");
            }
            if (!tieneMinuscula(password)) {
                System.out.println("- Contener al menos una letra minúscula.");
            }
            if (!tieneNumero(password)) {
                System.out.println("- Contener al menos un número.");
            }
            if (!tieneCaracterEspecial(password)) {
                System.out.println("- Contener al menos un carácter especial (por ejemplo, !, @, #, $).");
            }
        }

        sc.close();
    }

    public static boolean esSegura(String password) {
        return tieneLongitudCorrecta(password) &&
               tieneMayuscula(password) &&
               tieneMinuscula(password) &&
               tieneNumero(password) &&
               tieneCaracterEspecial(password);
    }

    public static boolean tieneLongitudCorrecta(String contrasena) {
        return contrasena.length() >= 8;
    }

    public static boolean tieneMayuscula(String contrasena) {
        for (char c : contrasena.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean tieneMinuscula(String contrasena) {
        for (char c : contrasena.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean tieneNumero(String contrasena) {
        for (char c : contrasena.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean tieneCaracterEspecial(String contrasena) {
        // Caracteres especiales permitidos
        String caracteresEspeciales = "!@#$%^&*()_+-=[]{}|;:',.<>?/";

        for (char c : contrasena.toCharArray()) {
            if (caracteresEspeciales.indexOf(c) >= 0) {
                return true;
            }
        }
        return false;
    }
}
