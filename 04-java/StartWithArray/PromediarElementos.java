import java.util.Arrays;
import java.util.Scanner;

public class PromediarElementos {
    public static void main(String[] args) {
        Scanner userElement = new Scanner(System.in);

        int[] numeros = new int[4];

        System.out.println("Ingrese el primer número:");
        numeros[0] = userElement.nextInt();
        System.out.println("Ingrese el segundo número:");
        numeros[1] = userElement.nextInt();
        System.out.println("Ingrese el tercero número:");
        numeros[2] = userElement.nextInt();
        System.out.println("Ingrese el cuarto número:");
        numeros[3] = userElement.nextInt();

        int sun = Arrays.stream(numeros).sum();

        double promedio = (double) sun/4;

        System.out.println("La suma de los elementos es: " +sun);
        System.out.println("El promedio de los elementos es: " +promedio);

        userElement.close();
    }
}
