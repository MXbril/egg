import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArrayList<Integer> turnos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int opcion;
        int numeroTurno = 1;
        do {
            System.out.println("\nSistemas de turnos:");
            System.out.println("1. Asignar nuevo turno.");
            System.out.println("2. Atender próximo turno.");
            System.out.println("3. Realizar sorteo para atender un turno.");
            System.out.println("4. Mostrar turnos pendientes.");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    turnos.add(numeroTurno);
                    System.out.println("Turno asignado: " +numeroTurno);
                    numeroTurno++;
                    break;
                case 2:
                    if (!turnos.isEmpty()) {
                        int turnoAtendido = turnos.remove(0);
                        System.out.println("Atendiendo al turno: " +turnoAtendido);
                    } else {
                        System.out.println("No hay turnos pendientes.");
                    }
                    break;
                case 3:
                    if (!turnos.isEmpty()) {
                        int indexAleatorio = random.nextInt(turnos.size());
                        int turnoSorteado = turnos.remove(indexAleatorio);
                        System.out.println("Turno sorteado: " +turnoSorteado+ " (Atendido inmediatamente)");
                    } else {
                        System.out.println("No hay turnos para realizar el sorteo.");
                    }
                    break;
                case 4:
                    if (!turnos.isEmpty()) {
                        System.out.println("Turnos pendientes: " +turnos);
                    } else {
                        System.out.println("No hay turnos pendientes.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    sc.close();
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
            
        } while (opcion != 5);
    }
}