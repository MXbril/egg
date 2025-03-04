import java.util.Scanner;

public class CalificacionDos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int puntuacion;
        do {
            System.out.println("Ingrese una puntuacion entre 0 y 100: ");
            puntuacion = sc.nextInt();

            if (puntuacion < 0 || puntuacion > 100) {
                System.out.println("Puntuacion no válida. Debe estar entre 0 y 100.");
            }
        } while (puntuacion < 0 || puntuacion > 100);

        String calificacion = obtenerNota(puntuacion);
        System.out.println("La calificación obtenida es: " +calificacion);
        sc.close();
    }

    public static String obtenerNota(int puntuacion) {
        return switch (puntuacion / 10) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };
    }
}
