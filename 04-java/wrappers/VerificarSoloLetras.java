import java.util.Scanner;

public class VerificarSoloLetras {
    public static void main(String[] args) {
        Scanner userLetras = new Scanner(System.in);
        System.out.println("Por favor, introducir una cadena:");
        String cadena = userLetras.nextLine();
        boolean letters = true;

        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (!Character.isLetter(c)) {
                letters = false;
                break;
            }
        }

        if (letters) {
            System.out.println("La cadena contiene solo letras.");
        } else {
            System.out.println("La cadena no contiene solo letras.");
        }

        userLetras.close();
    }
}
