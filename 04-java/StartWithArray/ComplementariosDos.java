import java.util.Random;
import java.util.Scanner;

public class ComplementariosDos {
    public static void main(String[] args) {
        SumarElementosPosicionesPares();
    }

    public static void ContarElementosPares() {
        int[] numeros = new int[6];

        // Generar números aleatorios entre 1 y 100 para llenar el array
        Random random = new Random();
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(100) + 1; // Números aleatorios entre 1 y 100
        }

        // Contar la cantidad de elementos pares en el array
        int cantidadPares = 0;
        for (int numero : numeros) {
            if (numero % 2 == 0) {
                cantidadPares++;
            }
        }

        // Mostrar el resultado por consola
        System.out.println("El array generado es:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println(); // Imprimir una línea en blanco

        System.out.println("Cantidad de números pares en el array: " + cantidadPares);
    }


    public static void SumarElementosPosicionesPares() {
         Scanner userPar = new Scanner(System.in);

        // Crear un array de tamaño 5 para almacenar números enteros
        int[] numeros = new int[5];

        // Pedir al usuario que ingrese los cinco números
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Ingrese el número en la posición " + i + ": ");
            numeros[i] = userPar.nextInt();
        }

        // Sumar los elementos ubicados en las posiciones pares (0, 2 y 4)
        int sumaPosicionesPares = numeros[0] + numeros[2] + numeros[4];

        // Mostrar el resultado de la suma por consola
        System.out.println("El resultado de la suma de los elementos en posiciones pares (0, 2 y 4) es: " + sumaPosicionesPares);

        userPar.close();
    }

    public static void OrdenarNombres() {
        Scanner userOrder = new Scanner(System.in);

        // Crear un array para almacenar los 4 nombres
        String[] nombres = new String[4];

        // Pedir al usuario que ingrese los nombres
        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Ingrese el nombre " + (i + 1) + ": ");
            nombres[i] = userOrder.nextLine();
        }

        // Ordenar los nombres alfabéticamente (método de burbuja)
        for (int i = 0; i < nombres.length - 1; i++) {
            for (int j = 0; j < nombres.length - 1 - i; j++) {
                if (nombres[j].compareToIgnoreCase(nombres[j + 1]) > 0) {
                    // Intercambiar nombres[j] y nombres[j + 1]
                    String temp = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = temp;
                }
            }
        }

        // Mostrar los nombres ordenados alfabéticamente
        System.out.println("Nombres ordenados alfabéticamente:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        userOrder.close();
    }
}
