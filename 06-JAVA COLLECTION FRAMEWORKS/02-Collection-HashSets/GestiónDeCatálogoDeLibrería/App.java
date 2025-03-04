import java.util.Scanner;

import com.max.modelos.Libreria;
import com.max.modelos.Libro;

public class App {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Libreria libreria = new Libreria();
        int opcion;

        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Mostrar catálogo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el título del libro: ");
                    String titulo = sc.nextLine();
                    System.out.println("Ingrese el autor del libro: ");
                    String autor = sc.nextLine();
                    System.out.println("Ingrese el número de ISBN: ");
                    String isbn = sc.nextLine();
                    Libro libro = new Libro(titulo, autor, isbn);
                    libreria.agregarLibro(libro);
                    break;
                case 2:
                    System.out.print("Ingrese el número de ISBN del libro a eliminar: ");
                    String isbnEliminar = sc.nextLine();
                    libreria.eliminarLibro(isbnEliminar);
                    break;
                case 3:
                    libreria.mostrarCatalogo();
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