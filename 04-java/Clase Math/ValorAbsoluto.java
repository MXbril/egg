import java.util.Scanner;

public class ValorAbsoluto {
    public static void main(String[] args) {
        Scanner userScan = new Scanner(System.in);

        System.out.print("Introduce un número entero: ");
        int num = userScan.nextInt();

        int valorAbs = Math.abs(num);
        System.out.println("El valor absoluto " +num+ " es " + valorAbs);

        userScan.close();
    }
} 