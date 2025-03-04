import java.util.Scanner;

public class ConversionMayMin {
    
    public static void main(String[] args) {
        Scanner userMayMin = new Scanner(System.in);

        System.out.println("Ingrese una cadena de texto:");
        String cadena = userMayMin.nextLine();
        
        String mayusculas = cadena.toUpperCase();
        String minusculas = cadena.toLowerCase();

        System.out.println("La cadena de mayuscula es: " + mayusculas);
        System.out.println("La cadena de minusculas es: " + minusculas);

        userMayMin.close();
    }
}
