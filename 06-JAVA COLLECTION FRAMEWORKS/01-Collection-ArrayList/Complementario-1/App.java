import java.util.ArrayList;
import java.util.Scanner;

import com.max.modelos.Estudiante;

public class App {

    public static void main(String[] args) {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nRegistro de Estudiantes:");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Eliminar estudiante");
            System.out.println("3. Mostrar lista de estudiantes");
            System.out.println("4. Buscar estudiante por documento");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    // Agregar estudiante
                    System.out.print("Ingrese el documento del estudiante: ");
                    String documento = sc.nextLine();
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese la edad del estudiante: ");
                    int edad = sc.nextInt();
                    estudiantes.add(new Estudiante(documento, nombre, edad));
                    System.out.println("Estudiante agregado correctamente.");
                    break;

                case 2:
                    // Eliminar estudiante
                    System.out.print("Ingrese el documento del estudiante a eliminar: ");
                    String documentoEliminar = sc.nextLine();
                    boolean eliminado = eliminarEstudiante(estudiantes, documentoEliminar);
                    if (eliminado) {
                        System.out.println("Estudiante eliminado correctamente.");
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 3:
                    // Mostrar lista de estudiantes
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        System.out.println("Lista de estudiantes registrados:");
                        for (Estudiante estudiante : estudiantes) {
                            System.out.println(estudiante);
                        }
                    }
                    break;

                case 4:
                    // Buscar estudiante por documento
                    System.out.print("Ingrese el documento del estudiante a buscar: ");
                    String documentoBuscar = sc.nextLine();
                    Estudiante estudiante = buscarEstudiante(estudiantes, documentoBuscar);
                    if (estudiante != null) {
                        System.out.println("Estudiante encontrado: " + estudiante);
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 5:
                    // Salir
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 5);
    }

    public static boolean eliminarEstudiante(ArrayList<Estudiante> estudiantes, String documento) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getDocumento().equals(documento)) {
                estudiantes.remove(estudiante);
                return true;
            }
        }
        return false;
    }

    public static Estudiante buscarEstudiante(ArrayList<Estudiante> estudiantes, String documento) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getDocumento().equals(documento)) {
                return estudiante;
            }
        }
        return null;
    }
}