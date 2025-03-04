import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchExample {
    public static void main(String[] args) {
        int[] arraySearch = {2,4,5,7,9,13,16,19,25,30};
        System.out.println("Arreglo original: " +Arrays.toString(arraySearch));

        Scanner userSearch = new Scanner(System.in);
        System.out.println("Ingrese el valor a buscar: ");
        int valorBuscar = userSearch.nextInt();

        int index = Arrays.binarySearch(arraySearch, valorBuscar);
        if (index >= 0) {
            System.out.println("El valor " +valorBuscar+ " se encuentra en el índice: " +index);
        } else {
            System.out.println("El valor " +valorBuscar+ " no se encuentra en el arreglo.");
        }

        userSearch.close();
    }
}
