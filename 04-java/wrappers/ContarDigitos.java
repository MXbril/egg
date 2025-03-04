import java.util.Scanner;

public class ContarDigitos {
    public static void main(String[] args) {
        Scanner userCount = new Scanner(System.in);
        System.out.println("Por favor, introduce un número:");
        String count = userCount.nextLine();
        int countDigito = 0;

        for (int i = 0; i < count.length(); i++) {
            if (Character.isDigit(count.charAt(i))) {
                countDigito++;
            }
        }
        System.out.println("El número de dígitos en el número introducido es: " +countDigito);

        userCount.close();
    }
}
