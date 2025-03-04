import java.util.Scanner;

public class ImprimeNombre {
    public static void ImprimirNombre(String nombre) {
        System.out.println("Mi nombre es " +nombre);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa tu nombre: ");
        String nombre = sc.nextLine();

        ImprimirNombre(nombre);
        sc.close();
    }
}