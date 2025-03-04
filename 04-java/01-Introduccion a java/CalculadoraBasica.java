import java.util.Scanner;

public class CalculadoraBasica {
    public static void main(String[] args) {
        Scanner calculate = new Scanner(System.in);

        System.out.print("Por favor, ingresa el primer número: ");
        double num01 = calculate.nextDouble();

        System.out.print("Por favor, ingresa el segundo número: ");
        double num02 = calculate.nextDouble();

        System.out.println("Elige una operación: (+, -, *, /)");
        char operacion = calculate.next().charAt(0);
        double result;

        result = (operacion == '+') ? (num01 + num02) :
                (operacion == '-') ? (num01 - num02) :
                (operacion == '*') ? (num01 * num02) :
                (operacion == '/') ? (num01 / num02) :
                Double.NaN;

        if (!Double.isNaN(result)) {
            System.out.println("El resultado de la operación es: " +result);
        } else {
            System.out.println("operación no válida.");
        }

        calculate.close();
    }
}
