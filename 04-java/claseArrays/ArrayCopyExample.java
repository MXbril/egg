import java.util.Arrays;
import java.util.Scanner;

public class ArrayCopyExample {
    public static void main(String[] args) {
        int[] arrayCopy = {10,20,30,40,50,60,70,80,90,100};
        System.out.println("Arreglo original: " +Arrays.toString(arrayCopy));
        System.out.println("Índice:");
        for (int i = 0; i < arrayCopy.length; i++) {
            System.out.println("Índice " +i+ ": " +arrayCopy[i]);
        }

        Scanner userCopy = new Scanner(System.in);

        System.out.print("Ingrese el índice inicial: ");
        int startIndex = userCopy.nextInt();
        System.out.print("Ingrese el índice final: ");
        int endIndex = userCopy.nextInt();

        if (startIndex < 0 || endIndex >= arrayCopy.length || startIndex > endIndex) {
            System.out.println("Índices inválidos. Asegúrese de que el índice inicial sea menor que el índice final.");
        } else {
            int[] newArray = Arrays.copyOfRange(arrayCopy, startIndex, endIndex +1);
            System.out.println("Nuevo arreglo copiado: " +Arrays.toString(newArray));
        }

        userCopy.close();
    }
}
