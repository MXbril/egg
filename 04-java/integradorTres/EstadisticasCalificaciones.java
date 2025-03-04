import java.util.Random;

public class EstadisticasCalificaciones {
    public static void main(String[] args) {
        Random randomEc = new Random();
        int numCalificaciones = 20;
        double[] calificaciones = new double[numCalificaciones];

        // Arreglos para almacenar las calificaciones en cada categoría
        double[] desaprobado = new double[numCalificaciones];
        double[] aprobado = new double[numCalificaciones];
        double[] excelente = new double[numCalificaciones];
        
        int countDesaprobado = 0;
        int countAprobado = 0;
        int countExcelente = 0;

        double sumaOriginal = 0;

        // Generar calificaciones aleatorias
        for (int i = 0; i < numCalificaciones; i++) {
            double valor = 1 + randomEc.nextDouble() * 10;
            calificaciones[i] = valor;
            sumaOriginal += valor;
        }

        // Clasificar las calificaciones
        for (double valor : calificaciones) {
            if (valor < 4) {
                desaprobado[countDesaprobado++] = valor;
            } else if (valor < 10) {
                aprobado[countAprobado++] = valor;
            } else {
                excelente[countExcelente++] = valor;
            }
        }

        // Calcular promedios
        double promedioOriginal = sumaOriginal / numCalificaciones;

        double sumaDesaprobado = 0;
        double sumaAprobado = 0;
        double sumaExcelente = 0;

        for (int i = 0; i < countDesaprobado; i++) {
            sumaDesaprobado += desaprobado[i];
        }
        for (int i = 0; i < countAprobado; i++) {
            sumaAprobado += aprobado[i];
        }
        for (int i = 0; i < countExcelente; i++) {
            sumaExcelente += excelente[i];
        }

        double promedioDesaprobado = countDesaprobado == 0 ? 0 : sumaDesaprobado / countDesaprobado;
        double promedioAprobado = countAprobado == 0 ? 0 : sumaAprobado / countAprobado;
        double promedioExcelente = countExcelente == 0 ? 0 : sumaExcelente / countExcelente;

        // Mostrar resultados
        System.out.println("Promedio del arreglo original: " + promedioOriginal);
        System.out.println("Promedio de desaprobado: " + promedioDesaprobado);
        System.out.println("Promedio de aprobado: " + promedioAprobado);
        System.out.println("Promedio de excelente: " + promedioExcelente);
    }
}
