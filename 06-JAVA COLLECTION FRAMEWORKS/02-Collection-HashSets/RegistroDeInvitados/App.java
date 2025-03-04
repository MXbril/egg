import java.util.Scanner;

import com.max.modelos.RegistroDeInvitados;

public class App {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegistroDeInvitados registro = new RegistroDeInvitados();
        int opcion;

        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Agregar invitado");
            System.out.println("2. Eliminar invitado");
            System.out.println("3. Mostrar lista de invitados");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.err.println("Ingrese el nombre del invitado: ");
                    String nombreAgregar = sc.nextLine();
                    registro.agregarInvitado(nombreAgregar);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del invitado a eliminar: ");
                    String nombreEliminar = sc.nextLine();
                    registro.eliminarInvitado(nombreEliminar);
                    break;
                case 3:
                    registro.mostrarInvitados();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (opcion != 4);
        sc.close();
    }
}