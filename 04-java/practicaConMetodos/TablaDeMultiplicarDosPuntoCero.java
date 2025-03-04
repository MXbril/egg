import java.util.Scanner;

public class TablaDeMultiplicarDosPuntoCero {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numeros = pedirNumeros();
        imprimirTablaMultiplicar(numeros);

        sc.close();
    }

    public static int[] pedirNumeros() {
        int[] numeros = new int[3];
        String[] orden = {"primer", "segundo", "tercer"};
        
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Ingresa el " +orden[i]+ "número: ");
            numeros[i] = sc.nextInt();
        }
        return numeros; 
    }

    public static void imprimirTablaMultiplicar(int[] numeros) {
        
        for (int numero : numeros) {
            System.out.println("tabla de multiplicar del " +numero+ ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(numero+ " x " +i+ " = " +(numero * i));
            }
            System.out.println();
        }
    }
}
