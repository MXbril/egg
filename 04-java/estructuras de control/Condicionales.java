import java.util.Scanner;

public class Condicionales {
    public static void main(String[] args) {
        Divisibilidad();
    }

    public static void ClasificandoNumeros() {
        Scanner user = new Scanner(System.in);

        System.out.print("Por favor, ingresa un número: ");
        double numero = user.nextDouble();

        if (numero > 0) {
            System.out.println("El número es positivo.");
        } else if (numero < 0) {
            System.out.println("El número es negativo.");
        } else {
            System.out.println("El número es cero.");
        }

        user.close();
    }

    public static void Calificacion() {
        Scanner punto = new Scanner(System.in);

        System.out.print("Por favor,ingresa una puntuación entre 0 y 100: ");
        int puntuacion = punto.nextInt();

        if (puntuacion < 0 || puntuacion > 100) {
            System.out.println("El número ingresado esta fuera del rango válido.");
        } else if (puntuacion >= 90) {
            System.out.println("Calificación: A");
        } else if (puntuacion >= 80) {
            System.out.println("Calificación: B");
        } else if (puntuacion >= 70) {
            System.out.println("Calificación: C");
        } else if (puntuacion >= 60) {
            System.out.println("Calificación: D");
        } else {
            System.out.println("Calificación: F");
        }

        punto.close();
    }

    public static void Divisibilidad() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Por favor, ingresa un número: ");
        int num = entrada.nextInt();

        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("El número es divisible por 3 y por 5.");
        } else if (num % 3 == 0) {
            System.out.println("El número es divisible por 3.");
        } else if (num % 5 == 0) {
            System.out.println("El número es divisible por 5.");
        } else {
            System.out.println("El número no es divisible por 3 ni por 5.");
        }    
        
        entrada.close();
    }

}