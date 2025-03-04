import java.util.Scanner;

public class ConversorTemperatura {
    public static void main(String[] args) {
        Scanner userConversor = new Scanner(System.in);

        try {
            System.out.print("Ingrese la temperatura: ");
            double temperatura = userConversor.nextDouble();
    
            System.out.print("Ingrese la unidad de medida (C o F): ");
            String unidad = userConversor.next().toUpperCase();

            switch (unidad) {
                case "C":
                    double fahrenheit = (temperatura * 9 / 5) + 32;
                    System.out.println(temperatura + " grados Celsius son " + (int)fahrenheit + " grados Fahrenheit.");
                    break;
                case "F":
                    double celsius = (temperatura - 32) * 5 / 9;
                    System.out.println(temperatura + " grados Fahrenheit son " + (int)celsius + " grados Celsius.");
                    break;
                default:
                    System.out.println("Unidad de medida inválida. Use 'C' para Celsius o 'F' para Fahrenheit.");
            }
        } catch (Exception e) {
            System.out.println("Temperatura no válida. Asegúrese de ingresar un número válido.");
        } finally {
            userConversor.close();
        }
    }
}
