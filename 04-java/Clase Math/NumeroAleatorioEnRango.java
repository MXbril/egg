import java.util.Scanner;

public class NumeroAleatorioEnRango {
    public static void main(String[] args) {
        Scanner userRandom = new Scanner(System.in);

        System.out.println("Ingresa el límite inferior: ");
        int limiteInferior = userRandom.nextInt();

        System.out.println("Ingresa el límite superior: ");
        int limiteSuperior = userRandom.nextInt();

        if (limiteInferior > limiteSuperior) {
            System.out.println("El límite inferior debe ser menor o igual que el límite superior.");
        } else {
            int numRandom = (int) (Math.random() * (limiteSuperior - limiteInferior + 1)) + limiteInferior;
            System.out.println("El número aleatorio generado entre " + limiteInferior + " y " +limiteSuperior+ " es: " +numRandom);
        }

        userRandom.close();
    }
}
