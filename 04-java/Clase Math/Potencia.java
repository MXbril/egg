import java.util.Scanner;

public class Potencia {
    public static void main(String[] args) {
        Scanner userPow = new Scanner(System.in);

        System.out.println("Introduce la base: ");
        int base = userPow.nextInt();

        System.out.println("Itroduce el exponente: ");
        int exponente = userPow.nextInt();

        double resultado = Math.pow(base, exponente);
        System.out.println("El resultado de " +base+ " elevado a " +exponente+ " es " +(int)resultado);

        userPow.close();
    }
}
