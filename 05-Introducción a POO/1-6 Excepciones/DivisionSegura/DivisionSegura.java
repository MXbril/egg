import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionSegura {

    public static void main(String[] args) {
        obtenerNumerador();
    }

    public static void obtenerNumerador() {
        Scanner sc = new Scanner(System.in);
        int numerador;
        int denominador;

        try {
            System.out.println("Ingresa el numerador: ");
            numerador = sc.nextInt();
            System.out.println("Ingresa el denominador: ");
            denominador = sc.nextInt();

            if (denominador == 0) {
                throw new ArithmeticException("El denominador no puede ser 0.");
            }

            double resultado = (double) numerador / denominador;
            System.out.println("El resultado de la división es: " +resultado);
            
        } catch (InputMismatchException e) {
            System.out.println("Error: debes ingresar un número entero.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " +e.getMessage());
        } finally {
            sc.close();
        }
    }
}