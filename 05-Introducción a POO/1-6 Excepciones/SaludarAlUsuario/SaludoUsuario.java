import java.util.Scanner;

public class SaludoUsuario {
    public static void main(String[] args) {
        saludar();
    }

    public static void saludar() {
        Scanner sc = new Scanner(System.in);
        
        try {
            String nombre = solicitarNombre(sc);
            System.out.println("¡Hola, " + nombre + "! Bienvenido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Scanner cerrado.");
        }
    }

    public static String solicitarNombre(Scanner sc) throws IllegalArgumentException {
        System.out.print("Por favor, ingresa tu nombre: ");
        String nombre = sc.nextLine();

        if (nombre.length() < 2) {
            throw new IllegalArgumentException("El nombre debe tener al menos 2 caracteres.");
        }
        return nombre;
    }
}