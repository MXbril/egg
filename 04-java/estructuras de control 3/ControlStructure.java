import java.util.Scanner;

public class ControlStructure {

    public static void main(String[] args) {
        DivisionSegura();
    }

    public static void DivisionSegura() {
        Scanner numUser = new Scanner(System.in);

        try{
            System.out.print("Ingrese el primer número entero: ");
            int num1 = numUser.nextInt();

            System.out.print("Ingresa el segundo número entero: ");
            int num2 = numUser.nextInt();

            int resulado = num1 / num2;
            System.out.println("El resultado de la división es:" + resulado);
        } catch (ArithmeticException e) {
            System.out.println("Error no se puede dividir por cero.");
        } finally {
            numUser.close();
        }
    }
}