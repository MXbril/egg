import java.util.Scanner;

public class NumerosPrimosPlus {
    public static void main(String[] args) {
        Scanner userPlus = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de números primos que desea obtener:");
        int cantidadDeseada = userPlus.nextInt();

        int contador = 0;
        int numero = 2;

        while (contador < cantidadDeseada) {
            boolean esPrimo = true;
            if (numero < 2) {
                esPrimo = false;
            } else if (numero == 2) {
                esPrimo = true;
            } else if (numero % 2 == 0) {
                esPrimo = false;
            } else {
                for (int i = 3; i <= Math.sqrt(numero); i += 2) {
                    if (numero % i == 0) {
                        esPrimo = false;
                        break;
                    }
                }
            }

            if (esPrimo) {
                System.out.print(numero + " ");
                contador++;
            }
            numero++;
        }

       userPlus.close(); 
    }
}
