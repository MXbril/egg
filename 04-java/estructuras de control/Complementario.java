import java.util.Scanner;

public class Complementario {
    public static void main(String[] args) {
        DeterminarEdades();
    }

    public static void VerificacionContrasena () {
        String contraCorerecta = "miContraUnica";

        Scanner contra = new Scanner(System.in);
        
        System.out.print("Por favor, ingrese la contraseña: ");
        String contraIngresada = contra.nextLine();

        if (contraIngresada.equals(contraCorerecta)) {
            System.out.println("Acceso concedido.");
        } else {
            System.out.println("Acceso denegado.");
        }

        contra.close();
    }

    public static void CalculoDescuento() {
        Scanner calculo = new Scanner(System.in);

        System.out.print("Por favor, ingresa el precio del producto: ");
        double precio = calculo.nextDouble();

        double descuento = 0.10;
        double precioConDescuento;

        if (precio >= 100) {
            precioConDescuento = precio - (precio * descuento);
            System.out.printf("Tienes derecho a un descuento del 10%%. El nuevo precio con descuento es: $%.2f\n", precioConDescuento);
        } else {
            System.out.printf("El precio del producto es: $%.2f. No tienes derecho a un descuento.\n", precio);
        }

        calculo.close();
    }

    public static void DeterminarEdades() {
        Scanner edadUser = new Scanner(System.in);

        System.out.print("Por favor, ingresa tu edad: ");
        int edad = edadUser.nextInt();

        // Determinar la categoría según la edad ingresada
        if (edad < 18 && edad > 0) {
            System.out.println("Eres menor de edad.");
        } else if (edad >= 18 && edad <= 64) {
            System.out.println("Eres adulto.");
        } else if (edad >= 65 && edad <= 100) {
            System.out.println("Eres un adulto mayor.");
        } else {
            System.out.println("Edad no válida.");
        }

        edadUser.close();
    }
}