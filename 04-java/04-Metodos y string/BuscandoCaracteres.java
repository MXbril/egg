import java.util.Scanner;

public class BuscandoCaracteres {
    
    public static void main(String[] args) {
        Scanner userCharacter = new Scanner(System.in);

        System.out.println("Ingrese una palabra:");
        String palabra = userCharacter.nextLine();

        System.out.println("Ingresar un carácter:");
        char caracter = userCharacter.next().charAt(0);

        int position = palabra.indexOf(caracter);

        if (position != -1) {
            System.out.println("El carácter '" + caracter + "' se encuentra en la palabra, en la posición " + position +".");
        } else {
            System.out.println("El caracter '" + caracter + "' no se encuentra en la palabra.");
        }

        userCharacter.close();
    }
}
