import java.util.Scanner;

public class NombreEdad {
    public static void imprimeNombreYEdad(String nombre, int edad) {
        System.out.println("Me llamo " +nombre+ " y tengo " +edad+ " años.");
    }

    public static void main(String[] args) {
        Scanner userSc = new Scanner(System.in);
        System.out.print("Ingresa tu numbre: ");
        String nombre = userSc.nextLine();

        System.out.print("Ingresa tu edad: ");
        int edad = userSc.nextInt();

        imprimeNombreYEdad(nombre, edad);
        userSc.close();
    }
}
