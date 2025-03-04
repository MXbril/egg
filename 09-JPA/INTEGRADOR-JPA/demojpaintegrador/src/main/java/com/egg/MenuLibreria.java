package com.egg;

import java.util.Scanner;
import java.util.List;
import java.util.InputMismatchException;

import com.egg.entidades.Autor;
import com.egg.entidades.Editorial;
import com.egg.entidades.Libro;
import com.egg.servicios.AutorServicio;
import com.egg.servicios.EditorialServicio;
import com.egg.servicios.LibroServicio;

public class MenuLibreria {
    private LibroServicio libroServicio;
    private AutorServicio autorServicio;
    private EditorialServicio editorialServicio;
    private Scanner scanner;

    public MenuLibreria() {
        this.libroServicio = new LibroServicio();
        this.autorServicio = new AutorServicio();
        this.editorialServicio = new EditorialServicio();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("---------- Menú Principal ----------");
            System.out.println("1. Gestionar libros");
            System.out.println("2. Gestionar autores");
            System.out.println("3. Gestionar editoriales");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuLibros();
                    break;
                case 2:
                    menuAutores();
                    break;
                case 3:
                    menuEditoriales();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida, intente nuevamente.");
            }
        }
    }

    private void menuLibros() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("----- Menú de Libros -----");
            System.out.println("1. Crear libro");
            System.out.println("2. Modificar libro");
            System.out.println("3. Dar de baja libro");
            System.out.println("4. Listar libros");
            System.out.println("0. Volver al menú principal");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearLibro();
                    break;
                case 2:
                    modificarLibro();
                    break;
                case 3:
                    darBajaLibro();
                    break;
                case 4:
                    listarLibros();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private void menuAutores() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("----- Menú de Autores -----");
            System.out.println("1. Crear autor");
            System.out.println("2. Modificar autor");
            System.out.println("3. Dar de baja autor");
            System.out.println("4. Eliminar autor");
            System.out.println("5. Listar autores");
            System.out.println("0. Volver al menú principal");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearAutor();
                    break;
                case 2:
                    modificarAutor();
                    break;
                case 3:
                    darBajaAutor();
                    break;
                case 4:
                    eliminarAutor();
                    break;
                case 5:
                    listarAutores();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private void menuEditoriales() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("----- Menú de Editoriales -----");
            System.out.println("1. Crear editorial");
            System.out.println("2. Modificar editorial");
            System.out.println("3. Dar de baja editorial");
            System.out.println("4. Listar editoriales");
            System.out.println("0. Volver al menú principal");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearEditorial();
                    break;
                case 2:
                    modificarEditorial();
                    break;
                case 3:
                    darBajaEditorial();
                    break;
                case 4:
                    listarEditoriales();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // Métodos para gestionar los libros
    private void crearLibro() {
        try {
            System.out.println("Ingrese el isbn:");
            long isbn = scanner.nextInt();

            System.out.println("Ingrese el título del libro:");
            scanner.nextLine();
            String titulo = scanner.nextLine();

            System.out.println("Ingrese el año de publicación:");
            int anio = scanner.nextInt();

            System.out.println("Ingrese la cantidad de ejemplares:");
            int ejemplares = scanner.nextInt();

            System.out.println("Ingrese el ID del autor:");
            Integer autorId = scanner.nextInt();
            Autor autor = autorServicio.buscarAutorPorId(autorId); // Buscar autor por ID

            System.out.println("Ingrese el ID de la editorial:");
            Integer editorialId = scanner.nextInt();
            Editorial editorial = editorialServicio.buscarEditorialPorId(editorialId); // Buscar editorial por ID

            // Creación del libro
            libroServicio.crearLibro(isbn, titulo, anio, ejemplares, autor, editorial);
            System.out.println("Libro creado correctamente.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Por favor, asegúrese de ingresar los datos correctamente.");
            scanner.nextLine(); // Limpiar el buffer del scanner
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado al crear el libro: " + e.getMessage());
            e.printStackTrace(); // Opcional: para depuración
        }
    }

    private void modificarLibro() {
        try {
            System.out.println("Ingrese el ISBN del libro a modificar:");
            Long isbn = scanner.nextLong();
            scanner.nextLine(); // Consumir el salto de línea

            String nuevoTitulo = null;
            Integer nuevoAnio = null;
            Integer nuevosEjemplares = null;
            Autor nuevoAutor = null;
            Editorial nuevaEditorial = null;

            // Preguntar y obtener nuevos valores
            if (preguntarUsuario("¿Desea modificar el título?")) {
                System.out.println("Ingrese el nuevo título:");
                nuevoTitulo = scanner.nextLine();
            }

            if (preguntarUsuario("¿Desea modificar el autor?")) {
                System.out.println("Ingrese el ID del nuevo autor:");
                Integer autorId = leerEntero();
                nuevoAutor = autorServicio.buscarAutorPorId(autorId);
                if (nuevoAutor == null) {
                    System.out.println("No se encontró el autor con ese ID.");
                }
            }

            if (preguntarUsuario("¿Desea modificar la editorial?")) {
                System.out.println("Ingrese el ID de la nueva editorial:");
                Integer editorialId = leerEntero();
                nuevaEditorial = editorialServicio.buscarEditorialPorId(editorialId);
                if (nuevaEditorial == null) {
                    System.out.println("No se encontró la editorial con ese ID.");
                }
            }

            if (preguntarUsuario("¿Desea modificar el año de publicación?")) {
                System.out.println("Ingrese el nuevo año de publicación:");
                nuevoAnio = leerEntero();
            }

            if (preguntarUsuario("¿Desea modificar la cantidad de ejemplares?")) {
                System.out.println("Ingrese la nueva cantidad de ejemplares:");
                nuevosEjemplares = leerEntero();
            }

            // Llamar al servicio para modificar el libro
            libroServicio.modificarLibro(isbn, nuevoTitulo, nuevoAnio, nuevosEjemplares, nuevoAutor, nuevaEditorial);
            System.out.println("Libro modificado correctamente.");

        } catch (Exception e) {
            System.out.println("Ocurrió un error al modificar el libro: " + e.getMessage());
        }
    }

    /**
     * Pregunta al usuario si quiere modificar un campo.
     */
    private boolean preguntarUsuario(String pregunta) {
        System.out.println(pregunta + " (si/no)");
        String respuesta = scanner.nextLine();
        return respuesta.equalsIgnoreCase("si");
    }

    /**
     * Lee un número entero del usuario con manejo de errores.
     */
    private Integer leerEntero() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Debe ingresar un número.");
            return null;
        }
    }

    private void darBajaLibro() {
        System.out.println("Ingrese el ISBN del libro a dar de baja:");
        Long isbn = scanner.nextLong();
        libroServicio.darBajaLibro(isbn);
    }

    private void listarLibros() {
        try {
            System.out.println("Listado de libros:");
            List<Libro> libros = libroServicio.listarLibros(); // Llama al servicio para listar libros

            // Verifica si la lista está vacía
            if (libros.isEmpty()) {
                System.out.println("No se encontraron libros en la base de datos.");
            } else {
                // Imprime la lista de libros
                libros.forEach(libro -> {
                    System.out.println(libro.getTitulo() + " - " + libro.getAnio());
                });
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado al listar los libros: " + e.getMessage());
        }
    }

    // autor funciones
    private void crearAutor() {
        try {
            System.out.println("Ingrese el nombre del autor:");
            String nombre = scanner.next();
            // Crear autor
            autorServicio.crearAutor(nombre);
            System.out.println("Autor creado correctamente.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error al crear el autor: " + e.getMessage());
        }
    }

    private void modificarAutor() {
        try {
            Integer autorId = null;

            // Validar que el usuario ingrese un número válido para el ID
            while (autorId == null) {
                System.out.println("Ingrese el ID del autor a modificar:");

                if (scanner.hasNextInt()) {
                    autorId = scanner.nextInt();
                } else {
                    System.out.println("Error: Debe ingresar un número válido.");
                    scanner.next(); // Limpiar entrada incorrecta
                }
            }

            scanner.nextLine(); // Limpiar buffer después de nextInt()

            String nuevoNombre;
            // Validar que el nombre no esté vacío
            do {
                System.out.println("Ingrese el nuevo nombre:");
                nuevoNombre = scanner.nextLine().trim();
                if (nuevoNombre.isEmpty()) {
                    System.out.println("Error: El nombre no puede estar vacío.");
                }
            } while (nuevoNombre.isEmpty());

            // Llamar al servicio para modificar el autor
            autorServicio.modificarAutor(autorId, nuevoNombre);

        } catch (Exception e) {
            System.out.println("Ocurrió un error al modificar el autor: " + e.getMessage());
        }
    }

    private void darBajaAutor() {
        try {
            System.out.println("Ingrese el ID del autor a dar de baja:");
            Integer autorId = scanner.nextInt();

            // Dar de baja autor
            autorServicio.darBajaAutor(autorId);
            System.out.println("Autor dado de baja correctamente.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error al dar de baja el autor: " + e.getMessage());
        }
    }

    private void eliminarAutor() {
        try {
            Integer autorId = leerEntero("Ingrese el ID del autor a eliminar:");

            if (autorId != null) {
                // Llamar al servicio para eliminar el autor
                autorServicio.eliminarAutor(autorId);
            } else {
                System.out.println("No se pudo eliminar el autor. Ingrese un número válido.");
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error al eliminar el autor: " + e.getMessage());
        }
    }

    /**
     * Método auxiliar para leer un número entero con validación.
     */
    private Integer leerEntero(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.next(); // Descarta la entrada incorrecta
            }
        }
    }

    private void listarAutores() {
        try {
            System.out.println("Listado de autores:");
            autorServicio.listarAutores();

        } catch (Exception e) {
            System.out.println("Ocurrió un error al listar los autores: " + e.getMessage());
        }
    }

    // editorial funciones
    private void crearEditorial() {
        try {
            System.out.println("Ingrese el nombre de la editorial:");
            String nombre = scanner.next();

            // Crear editorial
            editorialServicio.crearEditorial(nombre);
            System.out.println("Editorial creada correctamente.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error al crear la editorial: " + e.getMessage());
        }
    }

    private void modificarEditorial() {
        try {
            System.out.println("Ingrese el ID de la editorial a modificar:");
            Integer editorialId = scanner.nextInt();

            System.out.println("Ingrese el nuevo nombre:");
            String nuevoNombre = scanner.next();

            // Modificar editorial
            editorialServicio.modificarEditorial(editorialId, nuevoNombre);
            System.out.println("Editorial modificada correctamente.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error al modificar la editorial: " + e.getMessage());
        }
    }

    private void darBajaEditorial() {
        try {
            System.out.println("Ingrese el ID de la editorial a dar de baja:");
            Integer editorialId = scanner.nextInt();

            // Dar de baja editorial
            editorialServicio.darBajaEditorial(editorialId);
            System.out.println("Editorial dada de baja correctamente.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error al dar de baja la editorial: " + e.getMessage());
        }
    }

    private void listarEditoriales() {
        try {
            System.out.println("Listado de editoriales:");
            editorialServicio.listarEditoriales();

        } catch (Exception e) {
            System.out.println("Ocurrió un error al listar las editoriales: " + e.getMessage());
        }
    }
}
