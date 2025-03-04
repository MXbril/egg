import java.util.Scanner;

public class MetodosNombreEdad {
    public static void main(String[] args) {
        Scanner scUser = new Scanner(System.in);
        String nombre = obtenerNombre(scUser);
        int edad = obtenerEdad(scUser);

        imprimeNombreYEdad(nombre, edad);
        scUser.close();

    }

    public static String obtenerNombre(Scanner sc) {
        System.out.print("Ingresa tu nombre: ");
        return sc.nextLine();
    }

    public static int obtenerEdad(Scanner sc) {
        System.out.print("Ingresa tu edad: ");
        return sc.nextInt();
    }

    public static void imprimeNombreYEdad(String nombre, int edad) {
        System.out.println("Me llamo " + nombre + " y tengo " + edad + " años.");
    }
}
