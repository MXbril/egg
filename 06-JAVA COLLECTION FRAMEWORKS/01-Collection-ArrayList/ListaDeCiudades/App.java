import java.util.ArrayList;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        ArrayList<String> ciudades = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String ciudad;
        String respuesta;

        do {
            System.out.print("Ingrese el nombre de una ciudad: ");
            ciudad = sc.nextLine();
            ciudades.add(ciudad);

            System.out.println("¿Desea agregar otra ciudad? (si/no): ");
            respuesta = sc.nextLine();
        } while (respuesta.equalsIgnoreCase("si"));

        System.out.println("\nLista de ciudades ingresadas:");
        for (String c : ciudades) {
            System.out.println(c);
        }
        sc.close();
    }
}