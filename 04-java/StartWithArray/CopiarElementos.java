import java.util.Scanner;

public class CopiarElementos {
    public static void main(String[] args) {
        Scanner usercopy = new Scanner(System.in);

        int[] num0 = {1,2,3};
        int[] newArray = new int[num0.length + 2];

        for (int i = 0; i < num0.length; i++) {
            newArray[i] = num0[i];
        }

        System.out.println("Ingrese el primer número:");
        int newNum1 = usercopy.nextInt();
        System.out.println("Ingrese el segundo número:");
        int newNum2 = usercopy.nextInt();

        newArray[num0.length] = newNum1;
        newArray[num0.length + 1] = newNum2;
        
        System.out.println("Contenido del nuevo array:");
        for (int numero : newArray) {
            System.out.print(numero + " ");
        }
        System.out.println();

        usercopy.close();
    }
}
