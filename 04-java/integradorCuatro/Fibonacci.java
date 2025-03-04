import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner ScUser = new Scanner(System.in);

        System.out.print("Ingrese la posición en la serie de fibonacci: ");
        int posicion = ScUser.nextInt();

        int fibonacci;
        if (posicion == 0) {
            fibonacci = 0;
        } else if (posicion == 1) {
            fibonacci = 1;
        } else {
            int fibo1 = 0, fibo2 = 1;
            fibonacci = 1;
            for (int i = 2; i <= posicion; i++) {
                fibonacci = fibo1 + fibo2;
                fibo1 = fibo2;
                fibo2 = fibonacci;
            }
        }
        System.out.println("El valor en la posición " +posicion+ " de la serie de fibonacci es " +fibonacci);

        ScUser.close();
    }
}
