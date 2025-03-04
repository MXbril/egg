import java.util.Scanner;

public class AdivinaNumero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define el rango de números (mínimo y máximo)
        int minimo = 1;
        int maximo = 20;

        // Genera un número aleatorio dentro del rango especificado
        int numeroAleatorio = numeroAleatorio(minimo, maximo);
        int numeroIngresado = 0;

        // Mensaje inicial para el usuario
        System.out.println("He generado un número entre " + minimo + " y " + maximo + ". ¡Intenta adivinarlo!");

        // Bucle do-while para solicitar adivinanzas hasta que se acierte el número
        do {
            System.out.print("Ingrese su adivinanza: ");
            numeroIngresado = sc.nextInt();

            if (numeroIngresado < numeroAleatorio) {
                System.out.println("El número que ingresaste es menor que el número aleatorio.");
            } else if (numeroIngresado > numeroAleatorio) {
                System.out.println("El número que ingresaste es mayor que el número aleatorio.");
            } else {
                System.out.println("¡Felicidades! Adivinaste el número.");
            }

        } while (numeroIngresado != numeroAleatorio);

        sc.close();
    }

    // Método para generar un número aleatorio dentro de un rango especificado
    public static int numeroAleatorio(int minimo, int maximo) {
        // Verifica que el mínimo sea menor o igual al máximo
        if (minimo > maximo) {
            throw new IllegalArgumentException("El mínimo debe ser menor o igual al máximo.");
        }
        // Genera y devuelve el número aleatorio en el rango
        return (int) (Math.random() * (maximo - minimo + 1)) + minimo;
    }
}
