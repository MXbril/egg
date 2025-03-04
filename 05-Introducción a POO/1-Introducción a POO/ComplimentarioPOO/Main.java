import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AutoDos auto = null;
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear un auto con marca, modelo y año");
            System.out.println("2. Crear un auto con marca y modelo");
            System.out.println("3. Crear un auto solo con la marca");
            System.out.println("4. Crear un auto sin especificar atributos");
            System.out.println("5. Imprimir datos del auto");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la marca del auto: ");
                    String marca1 = sc.nextLine();
                    System.out.print("Ingresa el modelo del auto: ");
                    String modelo1 = sc.nextLine();
                    System.out.print("Ingresa el año del auto: ");
                    int year1 = sc.nextInt();
                    auto = new AutoDos(marca1, modelo1, year1);
                    System.out.println("¡Auto creado con éxito!");
                    break;

                case 2:
                    System.out.print("Ingresa la marca del auto: ");
                    String marca2 = sc.nextLine();
                    System.out.print("Ingresa el modelo del auto: ");
                    String modelo2 = sc.nextLine();
                    auto = new AutoDos(marca2, modelo2);
                    System.out.println("¡Auto creado con éxito!");
                    break;

                case 3:
                    System.out.print("Ingresa la marca del auto: ");
                    String marca3 = sc.nextLine();
                    auto = new AutoDos(marca3);
                    System.out.println("¡Auto creado con éxito!");
                    break;

                case 4:
                    auto = new AutoDos();
                    System.out.println("¡Auto creado con éxito!");
                    break;

                case 5:
                    if (auto != null) {
                        auto.imprimirDatos();
                    } else {
                        System.out.println("Primero debes crear un auto.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break;
            }
        } while (opcion != 6);

        sc.close();
    }
}
