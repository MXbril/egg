import java.util.Scanner;

public class ProgramIdentifier {
    public static void main(String[] args) {
        Scanner parImpar = new Scanner(System.in);

        System.out.print("Por favor ingresa un número: ");
        int numero = parImpar.nextInt();
        // Determina si los numeros son par o impar.
        String resultado = (numero % 2 == 0) ? "par" : "impar";

        System.out.println("El número " +numero+ " es " +resultado+ ".");
        //cerrar el objeto scanner
        parImpar.close();
    }
}
