import java.util.Scanner;

public class RedondeoNumero {
    public static void main(String[] args) {
        Scanner userRound = new Scanner(System.in);

        System.out.print("Ingrese un número decimal: ");
        double num1 = userRound.nextDouble();

        long valorRound = Math.round(num1);
        System.out.println("El valor redondeado de " +num1+ " es " + valorRound);

        userRound.close();
    }
}
