import java.util.Scanner;

public class EncontrarMaximo {
    public static void main(String[] args) {
        Scanner userMax = new Scanner(System.in);

        int[] nums1 = new int[5];

        System.out.println("Ingrese el primer número:");
        nums1[0] = userMax.nextInt();
        System.out.println("Ingrese el segundo número:");
        nums1[1] = userMax.nextInt();
        System.out.println("Ingrese el tercer número:");
        nums1[2] = userMax.nextInt();
        System.out.println("Ingrese el cuarto número:");
        nums1[3] = userMax.nextInt();
        System.out.println("Ingrese el quinto número:");
        nums1[4] = userMax.nextInt();

        int maximo = nums1[0];
        maximo = Math.max(maximo, nums1[1]);
        maximo = Math.max(maximo, nums1[2]);
        maximo = Math.max(maximo, nums1[3]);
        maximo = Math.max(maximo, nums1[4]);

        System.out.println("El máximo es: " +maximo);

        userMax.close();
    }
}
