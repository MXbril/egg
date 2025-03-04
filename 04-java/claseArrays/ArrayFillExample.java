import java.util.Arrays;
import java.util.Scanner;

public class ArrayFillExample {
    public static void main(String[] args) {
        Scanner userFill = new Scanner(System.in);

        System.out.println("Ingrese el tamaño del array: ");
        int size = userFill.nextInt();
        if (size <= 0) {
            System.out.println("El tamaño del arreglo debe ser un número positivo.");
            return;
        }

        System.out.println("Ingrese el número entero para rellenar el arreglo.");
        int fillValue = userFill.nextInt();

        int[] arrayFill = new int[size];
        Arrays.fill(arrayFill, fillValue);
        System.out.println("Arreglo rellenado: " +Arrays.toString(arrayFill));

        userFill.close();
    }
}
