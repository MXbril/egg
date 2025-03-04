import java.util.Arrays;
import java.util.Collections;

public class OrdenDescendente {
    public static void main(String[] args) {
        Integer[] num = new Integer[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = (int) (Math.random() * 100) +1;
        }

        System.out.println("Arreglo inicial:");
        System.out.println(Arrays.toString(num));

        Arrays.sort(num, Collections.reverseOrder());

        System.out.println("Arreglo ordenado en forma descendente:");
        System.out.println(Arrays.toString(num));
    }
}