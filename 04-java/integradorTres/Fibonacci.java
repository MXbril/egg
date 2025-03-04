public class Fibonacci {
    public static void main(String[] args) {
        int a = 0, b = 1;

        // Inicializa el contador
        int count = 0;

        // Define el número de términos que deseas imprimir
        int numTerms = 8;

        // Imprime los primeros términos de la serie de Fibonacci
        while (count < numTerms) {
            System.out.println(a);
            // Actualiza los valores de a y b
            int temp = a;
            a = b;
            b = temp + b;
            // Incrementa el contador
            count++;
        }
    }
}
