import java.util.ArrayList;
import java.util.Scanner;

public class RegistroAlumnos {
    private static ArrayList<String> nombres = new ArrayList<>();
    private static ArrayList<Double> notas = new ArrayList<>();
    private static Scanner userSc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: ");
            switch (opcion) {
                case 1:
                    registrarAlumno();
                    break;
                case 2:
                    mostrarAlumnos();
                    break;
                case 3:
                    mostrarPromedioNotas();
                    break;
                case 4:
                    buscarAlumnoPorNombre();
                    break;
                case 5:
                    modificarNotaPorNombre();
                    break;
                case 6:
                    eliminarAlumnoPorNombre();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 7);
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú de opciones:");
        System.out.println("1. Registrar alumno");
        System.out.println("2. Mostrar todos los alumnos");
        System.out.println("3. Mostrar promedio de notas");
        System.out.println("4. Buscar alumno por nombre");
        System.out.println("5. Modificar nota por nombre");
        System.out.println("6. Eliminar alumno por nombre");
        System.out.println("7. Salir");
    }

    private static void registrarAlumno() {
        String nombre = leerCadena("Introduce el nombre del alumno: ");
        while (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío. Inténtalo de nuevo.");
            nombre = leerCadena("Introduce el nombre del alumno: ");
        }

        double nota = leerDouble("Introduce la nota del alumno (0.00 - 10.00): ");
        while (nota < 0.00 || nota > 10.00) {
            System.out.println("Nota no válida. Debe estar entre 0.00 y 10.00. Inténtalo de nuevo.");
            nota = leerDouble("Introduce la nota del alumno (0.00 - 10.00): ");
        }

        nombres.add(nombre);
        notas.add(nota);
        System.out.println("Alumno registrado exitosamente.");
    }

    private static void mostrarAlumnos() {
        if (nombres.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            System.out.println("\nLista de alumnos:");
            for (int i = 0; i < nombres.size(); i++) {
                System.out.printf("%s: %.2f%n", nombres.get(i), notas.get(i));
            }
        }
    }

    private static void mostrarPromedioNotas() {
        if (notas.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            double suma = 0.0;
            for (double nota : notas) {
                suma += nota;
            }
            double promedio = suma / notas.size();
            System.out.printf("Promedio de notas: %.2f%n", promedio);
        }
    }

    private static void buscarAlumnoPorNombre() {
        String nombre = leerCadena("Introduce el nombre del alumno a buscar: ");
        int indice = nombres.indexOf(nombre);
        if (indice != -1) {
            System.out.printf("Nota de %s: %.2f%n", nombre, notas.get(indice));
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    private static void modificarNotaPorNombre() {
        String nombre = leerCadena("Introduce el nombre del alumno para modificar la nota: ");
        int indice = nombres.indexOf(nombre);
        if (indice != -1) {
            double nuevaNota = leerDouble("Introduce la nueva nota (0.00 - 10.00): ");
            while (nuevaNota < 0.00 || nuevaNota > 10.00) {
                System.out.println("Nota no válida. Debe estar entre 0.00 y 10.00. Inténtalo de nuevo.");
                nuevaNota = leerDouble("Introduce la nueva nota (0.00 - 10.00): ");
            }
            notas.set(indice, nuevaNota);
            System.out.println("Nota modificada exitosamente.");
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    private static void eliminarAlumnoPorNombre() {
        String nombre = leerCadena("Introduce el nombre del alumno para eliminar: ");
        int indice = nombres.indexOf(nombre);
        if (indice != -1) {
            nombres.remove(indice);
            notas.remove(indice);
            System.out.println("Alumno eliminado exitosamente.");
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    private static String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return userSc.nextLine().trim();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(userSc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, introduce un número entero.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(userSc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, introduce un número decimal.");
            }
        }
    }
}