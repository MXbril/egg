import java.util.Random;

public class GeneradorDeContraseñas {
    public static void main(String[] args) {
        int longitud = 10;
        Random random = new Random();

        char[] password = new char[longitud];
        boolean mayuscula = false;
        boolean minuscula = false;
        boolean digito = false;

        do {
            for (int i = 0; i < longitud; i++) {
                int tipo = random.nextInt(3);
                switch (tipo) {
                    case 0:
                        password[i] = (char) ('A' + random.nextInt(26));
                        break;
                    case 1:
                        password[i] = (char) ('a' + random.nextInt(26));
                        break;
                    case 2:
                        password[i] = (char) ('0' + random.nextInt(10));
                        break;
                    default:
                        break;
                }
            }

            mayuscula = false;
            minuscula = false;
            digito = false;

            for (char c : password) {
                if (Character.isUpperCase(c)) mayuscula = true;
                if (Character.isLowerCase(c)) minuscula = true;
                if (Character.isDigit(c)) digito = true;
            }
        } while (!mayuscula || !minuscula || !digito);

        String passwordStr = new String(password);
        System.out.println("Contraseña generada: " +passwordStr);
    }
}
