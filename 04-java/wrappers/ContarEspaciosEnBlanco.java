import java.util.Scanner;

public class ContarEspaciosEnBlanco {
    public static void main(String[] args) {
        Scanner userSpace = new Scanner(System.in);
        System.out.println("Por favor, ingrese una cadena:");
        String chain = userSpace.nextLine();
        int contador = 0;

        for(int i = 0; i < chain.length(); i++) {
            if (Character.isWhitespace(chain.charAt(i))) {
                contador++;
            }
        }

        System.out.println("El número de espacios en blanco en la cadena: " +contador);

        userSpace.close();
    }
}
