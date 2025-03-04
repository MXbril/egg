import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero {

    public static void main(String[] args) {
        Random random = new Random();
        int numeroSecreto = random.nextInt(50) + 1;
        int intentos = 0;
        boolean adivinado = false;

        Scanner sc = new Scanner(System.in);
        System.out.println("¡Bienvenido al juego de adivinar el número!");
        System.out.println("He elegido un número entre el 1 y 50. ¿Puedes adivinarlo?");

        while (!adivinado) {
            System.out.println("Introduce tu intento: ");
            try {
                int intento = sc.nextInt();
                intentos++;

                if (intento < 1 || intento > 50) {
                    System.out.println("Por favor, introduce un número entre 1 y 50.");
                } else if (intento < numeroSecreto) {
                    System.out.println("El número a adivinar es mayor.");
                } else if (intento > numeroSecreto) {
                    System.out.println("El número a adivinar es menor.");
                } else {
                    System.out.println("¡Felicidades! Has adivinado el número " +numeroSecreto+ " en " +intentos+ " intentos.");
                    adivinado = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, introduce un número.");
                intentos++;
                sc.next();
            }
        }
        sc.close();
        System.out.println("Gracias por jugar. ¡Hasta la próxima!");
    }
}