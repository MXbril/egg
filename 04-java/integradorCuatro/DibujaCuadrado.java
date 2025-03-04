import java.util.Scanner;

public class DibujaCuadrado {
    public static void main(String[] args) {
        Scanner usercuadrado = new Scanner(System.in);
        System.out.print("Introduce el tamaño del cuadrado: ");
        int lado = usercuadrado.nextInt();
        usercuadrado.close();
        
        if (lado < 2) {
            System.out.println("El tamaño del cuadrado debe ser mayor o igual a 2.");
            return;
        }

        for (int i = 0; i < lado; i++) {
            for (int columna = 0; columna < lado; columna++) {
                if (i == 0 || i == lado - 1 || columna == 0 || columna == lado - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
