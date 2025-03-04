import java.util.Scanner;

public class MenuInteractivo {
    public static void main(String[] args) {
        Scanner userMenu = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 5) {
            System.out.println("Menú interactivo:");
            System.out.println("1. Comprar producto");
            System.out.println("2. Realizar devolución");
            System.out.println("3. Ver mis pedidos");
            System.out.println("4. Preguntas frecuentes");
            System.out.println("5. Salir");
            System.out.println("Elige una opción: ");

            opcion = userMenu.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has elegido 'Comprar producto'.");
                    break;
                case 2:
                    System.out.println("Has elegido 'Realizar devolución'.");
                    break;
                case 3:
                    System.out.println("Has elegido 'Ver mis pedidos'.");
                    break;
                case 4:
                    System.out.println("Has elegido 'Preguntas frecuentes'.");
                    break;
                case 5:
                    System.out.println("Has elegido 'Salir'.");
                    break;
                default:
                System.out.println("Opción no válida. Por favor elija una opción del 1 al 5.");
                    break;
            }
        }

        userMenu.close();
    }
}