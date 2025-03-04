import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero {
    public static void main(String[] args) {
        Scanner userRandome = new Scanner(System.in);
        Random aleatorio = new Random();

        int numRandome = aleatorio.nextInt(20)+1;
        int intento;

        System.out.println("Has generado un número aleatorio del 1 al 20.");

        do {
            System.out.print("Intenta adivinar el número: ");
            intento = userRandome.nextInt();

            if (intento > numRandome) {
                System.out.println("El número es mayor.");
            } else if (intento < numRandome) {
                System.out.println("El número es mayor.");
            } else {
                System.out.println("Felicidades has adivinado el número.");
            }
        } while (intento != numRandome);

        userRandome.close();
    }
}
