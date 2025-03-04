import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArrayList<Integer> valores = leerValores();// Leer valores ingresados por el usuario
        int suma = calcularSuma(valores);// Calcular la suma de los valores
        double promedio = calcularPromedio(valores);// Calcular el promedio de los valores
        mostrarResultados(valores, suma, promedio);// Mostrar resultados finales
    }

    public static ArrayList<Integer> leerValores() {
        ArrayList<Integer> valores = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int numero;

        System.out.println("Ingerse valores numéricos (Ingrese -99 para finalizar):");
        while (true) {
            numero = sc.nextInt();
            if (numero == -99) {
                break;
            }
            valores.add(numero);
        }
        sc.close();
        return valores;
    }

    public static int calcularSuma(ArrayList<Integer> valores) {
        int suma = 0;
        Iterator<Integer> iterador = valores.iterator();

        while (iterador.hasNext()) {
            suma += iterador.next();
        }
        return suma;
    }

    public static double calcularPromedio(ArrayList<Integer> valores) {
        int suma = calcularSuma(valores);
        return (double) suma / valores.size();
    }

    public static void mostrarResultados(ArrayList<Integer> valores, int suma, double promedio) {
        System.out.println("\nValores Ingresados:");
        for (int valor : valores) {
            System.out.println(valor);
        }

        System.out.println("\nTotal de valores ingresados: " +valores.size());
        System.out.println("Suma de los valores: " +suma);
        System.out.println("Promedio de los valores: " +promedio);

        int countMayorQuePromedio = 0;
        for (int valor : valores) {
            if (valor > promedio) {
                countMayorQuePromedio++;
            }
        }
        System.out.println("Cantidad de valores mayores que el promedio: " +countMayorQuePromedio);
    }
}