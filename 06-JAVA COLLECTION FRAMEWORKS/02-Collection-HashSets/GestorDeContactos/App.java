import java.util.Scanner;
import com.max.modelos.Contacto;
import com.max.modelos.GestorDeContactos;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorDeContactos gestor = new GestorDeContactos();
        int opcion;

        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Agregar contacto en ArrayList");
            System.out.println("2. Eliminar contacto en ArrayList");
            System.out.println("3. Agregar contacto en HashSet");
            System.out.println("4. Eliminar contacto en HashSet");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombreArray = sc.nextLine();
                    System.out.print("Ingrese el número de teléfono: ");
                    String telefonoArray = sc.nextLine();
                    System.out.print("Ingrese el correo electrónico: ");
                    String emailArray = sc.nextLine();
                    Contacto contactoArray = new Contacto(nombreArray, telefonoArray, emailArray);
                    gestor.agregarContactoArrayList(contactoArray);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del contacto a eliminar en ArrayList: ");
                    String nombreEliminarArray = sc.nextLine();
                    gestor.eliminarContactoArrayList(nombreEliminarArray);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombreSet = sc.nextLine();
                    System.out.print("Ingrese el número de teléfono: ");
                    String telefonoSet = sc.nextLine();
                    System.out.print("Ingrese el correo electrónico: ");
                    String emailSet = sc.nextLine();
                    Contacto contactoSet = new Contacto(nombreSet, telefonoSet, emailSet);
                    gestor.agregarContactoHashSet(contactoSet);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del contacto a eliminar en HashSet: ");
                    String nombreEliminarSet = sc.nextLine();
                    gestor.eliminarContactoHashSet(nombreEliminarSet);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (opcion != 5);

        sc.close();
    }
}