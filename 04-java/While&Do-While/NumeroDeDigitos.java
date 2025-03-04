import java.util.Scanner;

public class NumeroDeDigitos {
    public static void main(String[] args) {
        Scanner userNum = new Scanner(System.in);
        System.out.print("Ingresa un número entero: ");
        int numero = userNum.nextInt();
        
        int contadorDeDigitos = 0;
        int numeroAbsoluto = Math.abs(numero);

        if (numero == 0) {
            contadorDeDigitos = 1;
        } else {
            while (numeroAbsoluto > 0) {
                numeroAbsoluto /= 10;
                contadorDeDigitos++;
            }
        }

        System.out.println("El número " + numero + " tiene " + contadorDeDigitos + " dígitos.");

        userNum.close();
    }
}
