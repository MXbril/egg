import java.util.Scanner;

public class ArrayAleatorio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicita el tamaño del array al usuario
        System.out.print("Ingrese el tamaño del array: ");
        int tamaño = sc.nextInt();

        // Solicita el rango de números posibles
        System.out.print("Ingrese el valor mínimo del rango: ");
        int minimo = sc.nextInt();
        System.out.print("Ingrese el valor máximo del rango: ");
        int maximo = sc.nextInt();
        sc.close();
        // Valida el rango de números
        if (minimo > maximo) {
            System.out.println("El valor mínimo debe ser menor o igual al valor máximo.");
            return;
        }

        // Genera el array aleatorio
        int[] array = generarArrayAleatorio(tamaño, minimo, maximo);

        // Imprime el array
        System.out.println("Array generado:");
        imprimirArray(array);
    }

    // Método para generar un array de números aleatorios
    public static int[] generarArrayAleatorio(int tamaño, int minimo, int maximo) {
        int[] array = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            array[i] = numeroAleatorio(minimo, maximo);
        }
        return array;
    }

    // Método para generar un número aleatorio dentro de un rango especificado
    public static int numeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo + 1)) + minimo;
    }

    // Método para imprimir un array de tipo int
    public static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
