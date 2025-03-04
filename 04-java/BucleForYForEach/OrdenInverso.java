public class OrdenInverso {
    public static void main(String[] args) {
        int[] numeros = {5,10,6,7,3,8,4,2};

        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.println(numeros[i]);
        }
    }
}
