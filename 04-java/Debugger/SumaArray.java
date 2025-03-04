public class SumaArray {

    public static void main(String[] args) {
        int[] numeros = {5, 10, 15, 20, 25};
        int suma =0;
        for (int i = 0; i < numeros.length; i++) {
            int numero = numeros[i];
            suma += numero;
        }
        System.out.println("La suma de los números es: " +suma);
    }
}