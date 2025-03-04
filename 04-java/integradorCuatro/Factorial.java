import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner userSc = new Scanner(System.in);

        int num;
        System.out.print("Ingrese un número: ");
        num = userSc.nextInt();

        long factorial = 1;
        int i = 1;

        do {
            factorial *= i;
            i++;
        } while (i <= num);
        System.out.println("El factorial de " +num+ " es " +factorial);

        userSc.close();
    }
}