import java.util.Arrays;

public class ComparingArrangements {
    public static void main(String[] args) {
        int[] arreglo1 = {1,2,3,4,5};
        int[] arreglo2 = {1,2,3,4,5};
        int[] arreglo3 = {3,5,7,9,10};

        boolean sonIguales1 = Arrays.equals(arreglo1, arreglo2);
        boolean sonIguales2 = Arrays.equals(arreglo1, arreglo3);

        if (sonIguales1) {
            System.out.println("El arreglo 1 y 2 son iguales.");
        } else {
            System.out.println("El arreglo 1 y 2 no son iguales.");
        }
        if (sonIguales2) {
            System.out.println("El arreglo 1 y 3 son iguales.");
        } else {
            System.out.println("El arreglo 1 y 3 no son iguales.");
        }
    }
}
