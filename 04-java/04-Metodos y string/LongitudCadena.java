import java.util.Scanner;

public class LongitudCadena {

    public static void main(String[] args) {
        Scanner userlength = new Scanner(System.in);

        System.out.println("ingrese una cadena de texto: ");
        String cadena = userlength.nextLine();
        int longitud = cadena.length();

        System.out.println("La longitud de la cadena ingresada es: " + longitud);

        userlength.close();
    }
}