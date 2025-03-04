public class ImprimirArray {
    public static void main(String[] args) {
        // Ejemplos de arreglos
        int[] numeros = {1, 2, 3, 4, 5};
        String[] palabras = {"Hola", "Mundo", "Java"};
        int[][] matrizNumeros = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        String[][] matrizPalabras = {
            {"Uno", "Dos", "Tres"},
            {"Cuatro", "Cinco", "Seis"}
        };

        // Llamadas a los métodos sobrecargados
        imprimirArray(numeros);
        imprimirArray(palabras);
        imprimirArray(matrizNumeros);
        imprimirArray(matrizPalabras);
    }

    // Método para imprimir un array unidimensional de enteros
    public static void imprimirArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Sobrecarga del método para imprimir un array unidimensional de Strings
    public static void imprimirArray(String[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Sobrecarga del método para imprimir un array bidimensional de enteros
    public static void imprimirArray(int[][] array) {
        System.out.println("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print("  [");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j < array[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        System.out.println("]");
    }

    // Sobrecarga del método para imprimir un array bidimensional de Strings
    public static void imprimirArray(String[][] array) {
        System.out.println("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print("  [");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j < array[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
