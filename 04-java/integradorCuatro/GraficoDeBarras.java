import java.util.Scanner;

public class GraficoDeBarras {
    public static void main(String[] args) {
        Scanner userBs = new Scanner(System.in);
        int[] numeros = new int[4];

        for (int i = 0; i < 4; i++) {
            while (true) {
                System.out.print("Ingrese un número entre 1 y 20: ");
                int num = userBs.nextInt();
                if (num >= 1 && num <= 20) {
                    numeros[i] = num;
                    break;
                } else {
                    System.out.println("Número inválido. Por favor, ingrese un número entre 1 y 20.");
                }
            }
        }

        // Imprimir el gráfico de barras
        System.out.println("Gráfico de barras:");
        for (int num : numeros) {
            System.out.print(num + " ");
            for (int j = 0; j < num; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        userBs.close();
    }
}
