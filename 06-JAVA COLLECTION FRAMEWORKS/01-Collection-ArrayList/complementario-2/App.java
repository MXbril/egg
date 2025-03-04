import java.util.ArrayList;
import java.util.Scanner;

import com.max.modelos.Tarea;

public class App {

    public static void main(String[] args) {
         ArrayList<Tarea> tareas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nGestión de Tareas Pendientes:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Marcar tarea como completada");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Mostrar tareas pendientes");
            System.out.println("5. Mostrar tareas completadas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    // Agregar tarea
                    System.out.print("Ingrese la descripción de la tarea: ");
                    String descripcion = sc.nextLine();
                    tareas.add(new Tarea(descripcion));
                    System.out.println("Tarea agregada correctamente.");
                    break;

                case 2:
                    // Marcar tarea como completada
                    System.out.print("Ingrese el ID de la tarea a completar: ");
                    int idCompletar = sc.nextInt();
                    boolean encontradaCompletar = false;
                    for (Tarea tarea : tareas) {
                        if (tarea.getIdTarea() == idCompletar) {
                            tarea.completar();
                            encontradaCompletar = true;
                            System.out.println("Tarea marcada como completada.");
                            break;
                        }
                    }
                    if (!encontradaCompletar) {
                        System.out.println("No se encontró la tarea con ID " + idCompletar + ".");
                    }
                    break;

                case 3:
                    // Eliminar tarea
                    System.out.print("Ingrese el ID de la tarea a eliminar: ");
                    int idEliminar = sc.nextInt();
                    boolean encontradaEliminar = false;
                    for (Tarea tarea : tareas) {
                        if (tarea.getIdTarea() == idEliminar) {
                            tareas.remove(tarea);
                            encontradaEliminar = true;
                            System.out.println("Tarea eliminada correctamente.");
                            break;
                        }
                    }
                    if (!encontradaEliminar) {
                        System.out.println("No se encontró la tarea con ID " + idEliminar + ".");
                    }
                    break;

                case 4:
                    // Mostrar tareas pendientes
                    System.out.println("\nTareas Pendientes:");
                    for (Tarea tarea : tareas) {
                        if (!tarea.isCompletada()) {
                            System.out.println(tarea);
                        }
                    }
                    break;

                case 5:
                    // Mostrar tareas completadas
                    System.out.println("\nTareas Completadas:");
                    for (Tarea tarea : tareas) {
                        if (tarea.isCompletada()) {
                            System.out.println(tarea);
                        }
                    }
                    break;

                case 6:
                    // Salir
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 6);
    }
}