import java.util.Scanner;

public class complementariosCuatro {
    public static void main(String[] args) {
        RellenarArreglo();
    }
    public static void RellenarArreglo() {
        Scanner userArreglo = new Scanner(System.in);

        System.out.println("Ingrese el tamaño del arreglo: ");
        int semejante = userArreglo.nextInt();

        int[] arreglo0 = new int[semejante];
        int ultimoIndex = -1;

        while (ultimoIndex < semejante -1) {
            System.out.print("ingrese el número con el que desea rellenar el arreglo: ");
            int numero = userArreglo.nextInt();
            System.out.print("Ingrese el índice hasta el cual desea rellenar (debe ser mayor que " + ultimoIndex + " y menor que " + semejante + "): ");
            int indice = userArreglo.nextInt();

            // Validar el índice ingresado
            if (indice <= ultimoIndex || indice >= semejante) {
                System.out.println("Índice inválido. Intente de nuevo.");
                continue;
            }

            // Rellenar el arreglo con el número proporcionado hasta el índice ingresado
            for (int i = ultimoIndex + 1; i <= indice; i++) {
                arreglo0[i] = numero;
            }

            // Actualizar el último índice ingresado
            ultimoIndex = indice;
        }

        // Imprimir el arreglo completo
        System.out.print("Arreglo completo: ");
        for (int num : arreglo0) {
            System.out.print(num + " ");
        }
        System.out.println();

        userArreglo.close();
    }
}
