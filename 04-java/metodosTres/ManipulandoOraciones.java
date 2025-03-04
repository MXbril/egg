import java.util.Arrays;
import java.util.Scanner;

public class ManipulandoOraciones {
    private static String oracion = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();
            manejarOpcion(opcion, sc);
        } while (opcion != 9);

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("\nMenú de opciones:");
        System.out.println("1. " +(oracion.isEmpty() ? "Crear oración" : "Borrar oración"));
        System.out.println("2. Cantidad de caracteres de la oración");
        System.out.println("3. Cantidad de palabras de la oración");
        System.out.println("4. Mostrar palabras ordenadas alfabéticamente");
        System.out.println("5. Ingresar un número y devolver la palabra correspondiente");
        System.out.println("6. Buscar palabra dentro de la oración");
        System.out.println("7. Modificar palabra dentro de la oración");
        System.out.println("8. Agregar contenido a la oración");
        System.out.println("9. Salir");
        System.out.print("Elija una opción: ");
    }

    public static void manejarOpcion(int opcion, Scanner sc) {
        switch (opcion) {
            case 1:
                if (oracion.isEmpty()) {
                    crearOracion(sc);
                } else {
                    borrarOracion();
                }
                break;
            case 2:
                mostrarCantidadCaracteres();
                break;
            case 3:
                mostrarCantidadPalabras();
                break;
            case 4:
                mostrarPalabrasOrdenadas();
                break;
            case 5:
                devolverPalabraPorNumero(sc);
                break;
            case 6:
                buscarPalabra(sc);
                break;
            case 7:
                modificarPalabra(sc);
                break;
            case 8:
                agregarContenido(sc);
                break;
            case 9:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción inválida. Intente nuevamente.");
        }
    }

    public static void crearOracion(Scanner sc) {
        System.out.print("Ingrese una nueva oración: ");
        oracion = sc.nextLine().trim();
    }

    public static void borrarOracion() {
        oracion = "";
        System.out.println("Oración borrada.");
    }

    public static void mostrarCantidadCaracteres() {
        System.out.println("Cantidad de caracteres en la oración: " +oracion.length());
    }

    public static void mostrarCantidadPalabras() {
        String[] palabras = oracion.split("\\s+");
        System.out.println("Cantidad de palabras en la oración: " +palabras.length);
    }

    public static void mostrarPalabrasOrdenadas() {
        String[] palabras = oracion.split("\\s+");
        Arrays.sort(palabras);
        System.out.println("Palabras ordenadas alfabéticamente: " +String.join(",", palabras));
    }

    public static void devolverPalabraPorNumero(Scanner sc) {
        String[] palabras = oracion.split("\\s+");
        System.out.print("Ingrese un número: ");
        int numero = sc.nextInt();
        if (numero > 0 && numero <= palabras.length) {
            System.out.println("La palabra en la posición " +numero+ " es: " +palabras[numero -1]);
        } else {
            System.out.println("Número inválido. Intente nuevamente.");
        }
    }

    public static void buscarPalabra(Scanner sc) {
        System.out.print("Ingrese la palabra a buscar: ");
        String palabra = sc.nextLine().trim();
        String[] palabras = oracion.split("\\s+");
        boolean encontrada = false;

        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].equalsIgnoreCase(palabra)) {
                System.out.println("Palabra encontrada en la posición: " +(i+1));
                encontrada = true;
                break;
            }
        }
        
        if (!encontrada) {
            System.out.println("Palabra no encontrada.");
        }
    }

    public static void modificarPalabra(Scanner sc) {
        System.out.println("Ingrese la palabra a modificar: ");
        String palabraOriginal = sc.nextLine().trim();
        String[] palabras = oracion.split("\\s+");
        boolean encontrada = false;

        for (int i = 0; i < palabras.length; i++) {
            if(palabras[i].equalsIgnoreCase(palabraOriginal)) {
                System.out.print("Ingrese la nueva palabra: ");
                String nuevaPalabra = sc.nextLine().trim();
                palabras[i] = nuevaPalabra;
                encontrada = true;
                break;
            }
        }
        
        if (encontrada) {
            oracion = String.join(" ", palabras);
            System.out.println("Oración modificada: " +oracion);
        } else {
            System.out.println("Palabra no encontrada. Intente nuevamente.");
        }
    }

    public static void agregarContenido(Scanner sc) {
        System.out.print("Ingrese el contenido a agregar: ");
        String nuevoContenido = sc.nextLine().trim();
        oracion = oracion.isEmpty() ? nuevoContenido : oracion + " " + nuevoContenido;
        System.out.println("Oración actualizada: "  +oracion);
    }
}
