import java.util.Scanner;

import App.modelos.Biblioteca;
import App.modelos.Libro;
import App.modelos.Persona;

public class App {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("------ Menú de Biblioteca ------");
            System.out.println("1. Agregar un libro");
            System.out.println("2. Mostrar catálogo de libros");
            System.out.println("3. Registrar persona");
            System.out.println("4. Mostrar personas registradas");
            System.out.println("5. Prestar un libro");
            System.out.println("6. Devolver un libro");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Solicitar datos del libro
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = sc.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = sc.nextLine();
                    System.out.print("Ingrese el número de páginas del libro: ");
                    int numeroDePaginas = sc.nextInt();
                    sc.nextLine();  // Limpiar el buffer

                    // Crear y agregar el libro
                    Libro libro = new Libro(titulo, autor, numeroDePaginas);
                    biblioteca.agregarLibro(libro);
                    break;
                case 2:
                    // Mostrar el catálogo de libros
                    biblioteca.mostrarCatalogo();
                    break;
                case 3:
                    // Registrar una persona
                    System.out.print("Ingrese el nombre de la persona: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese el apellido de la persona: ");
                    String apellido = sc.nextLine();
                    Persona persona = new Persona(nombre, apellido);
                    biblioteca.agregarPersona(persona);
                    System.out.println("Persona registrada: " + nombre + " " + apellido);
                    break;
                case 4:
                    biblioteca.mostrarPersonas();
                    break;
                case 5:
                    // Prestar un libro
                    System.out.print("Ingrese el nombre completo de la persona: ");
                    String nombrePersonaPrestar = sc.nextLine();
                    Persona personaPrestar = biblioteca.buscarPersona(nombrePersonaPrestar);
                    if (personaPrestar != null) {
                        System.out.print("Ingrese el título del libro a prestar: ");
                        String tituloLibroPrestar = sc.nextLine();
                        biblioteca.prestarLibro(personaPrestar, tituloLibroPrestar);
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;
                case 6:
                    // Devolver un libro
                    System.out.print("Ingrese el nombre completo de la persona: ");
                    String nombrePersonaDevolver = sc.nextLine();
                    Persona personaDevolver = biblioteca.buscarPersona(nombrePersonaDevolver);
                    if (personaDevolver != null) {
                        System.out.print("Ingrese el título del libro a devolver: ");
                        String tituloLibroDevolver = sc.nextLine();
                        biblioteca.devolverLibro(personaDevolver, tituloLibroDevolver);
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;
                case 7:
                    // Salir del programa
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        } while (opcion != 7);

        sc.close();
    }
}