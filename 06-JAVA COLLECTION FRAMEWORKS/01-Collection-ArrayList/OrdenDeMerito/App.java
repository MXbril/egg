import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArrayList<Integer> notas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int nota;
        String respuesta;

        do {
            System.out.println("Ingrese una nota del 1 al 10: ");
            nota = sc.nextInt();

            if (nota >= 1 && nota <= 10) {
                notas.add(nota);
            } else {
                System.out.println("Nota fuera del rango permitido. Intente de nuevo.");
            }

            System.out.println("¿Desea agregar otra nota? (si/no): ");
            respuesta = sc.next();
        } while (respuesta.equalsIgnoreCase("si"));

        Collections.sort(notas, Collections.reverseOrder());

        System.out.println("\nLista de notas en orden descendente:");
        for (int n : notas) {
            System.out.println(n);
        }

        Collections.sort(notas);

        System.out.println("\nLista de notas en orden ascendente:");
        for (int n : notas) {
            System.out.println(n);
        }
        sc.close();
    }
}