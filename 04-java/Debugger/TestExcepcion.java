import java.util.Scanner;

public class TestExcepcion {
    public static void main(String[] args) {
        Scanner scUser = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        double numero1 = scUser.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double numero2 = scUser.nextDouble();
        try {
            double resultado = numero1 / numero2;
            System.out.println("El resultado de la división es: " + resultado);
        } catch (Exception e) {
            System.out.println("Error: No se puede dividir por cero.");
        }
        
        scUser.close();
    }
}