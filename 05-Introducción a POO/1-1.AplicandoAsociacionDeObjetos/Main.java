import java.util.ArrayList;
import java.util.Scanner;
import modelos.Equipo;
import modelos.Jugador;

public class Main {
    private static ArrayList<Equipo> equipos = new ArrayList<>();
    private static ArrayList<Jugador> jugadores = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    crearJugador();
                    break;
                case 2:
                    crearEquipo();
                    break;
                case 3:
                    asignarJugadorAEquipo();
                    break;
                case 4:
                    mostrarListaJugadores();
                    break;
                case 5:
                    mostrarSubMenuEquipo();
                    break;
                case 6:
                    eliminarJugador();
                    break;
                case 7:
                    eliminarEquipo();
                    break;
                case 8:
                    seleccionarJugador();
                    break;
                case 9:
                    seleccionarEquipo();
                    break;
                case 10:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 10);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú Liga de Fútbol ---");
        System.out.println("1. Crear jugador");
        System.out.println("2. Crear equipo");
        System.out.println("3. Asignar jugador a equipo");
        System.out.println("4. Mostrar lista de jugadores");
        System.out.println("5. Mostrar lista de equipos");
        System.out.println("6. Eliminar jugador");
        System.out.println("7. Eliminar equipo");
        System.out.println("8. Seleccionar jugador");
        System.out.println("9. Seleccionar equipo");
        System.out.println("10. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void eliminarJugador() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para eliminar.");
            return;
        }

        mostrarListaJugadores();
        System.out.print("Seleccione el número de juagdores a eliminar: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index > 0 && index <= jugadores.size()) {
            Jugador eliminado = jugadores.remove(index - 1);
            System.out.println("Jugador eliminado: " + eliminado.getNombre());  
        } else {
            System.out.println("Selección inválida.");
        }
    }

    private static void eliminarEquipo() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos para eliminar.");
            return;
        }

        mostrarListaEquipos();
        System.out.println("Seleccione el número del aquipo a eliminar: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index > 0 && index <= equipos.size()) {
            Equipo eliminado = equipos.remove(index - 1);
            for (Jugador jugador : jugadores) {
                if (jugador.getEquipo() == eliminado) {
                    jugador.setEquipo(null);
                }
            }
            System.out.println("Equipo eliminado: " + eliminado.getNombre());
        } else {
            System.out.println("Selección inválida.");
        }
    }

    private static void seleccionarJugador() {
        if(jugadores.isEmpty()) {
            System.out.println("No hay jugadores para seleccionar.");
            return;
        }

        mostrarListaJugadores();
        System.out.print("Seleccione el número de jugador: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index > 0 && index <= jugadores.size()) {
            Jugador jugador = jugadores.get(index - 1);
            int opcion;

            do {
                mostrarSubMenuJugador();
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Detalles del jugador:");
                        System.out.println("Nombre: " + jugador.getNombre());
                        String equipoNombre = (jugador.getEquipo() != null) ? jugador.getEquipo().getNombre() : "Sin equipo";
                        System.out.println("Equipo: " + equipoNombre); 
                        break;
                    case 2:
                        System.out.print("Ingrese el nuevo nombre del jugador: ");
                        String nuevoNombre = sc.nextLine();
                        jugador.setNombre(nuevoNombre);
                        System.out.println("Nombre cambiado exitosamente");
                        break;
                    case 3:
                        cambiarEquipoJugador(jugador);
                        break;
                    case 4:
                        System.out.println("Regrasando al menú principal...");
                        break;
                    default:
                        System.err.println("Opción no válida.");
                        break;
                }
            } while (opcion != 4);
        } else {
            System.out.println("Selección inválida.");
        }
    }

    private static void mostrarSubMenuJugador() {
        System.out.println("\n--- Submenú Jugador ---");
        System.out.println("1. Ver detalles");
        System.out.println("2. Cambiar nombre");
        System.out.println("3. Cambiar equipo");
        System.out.println("4. Regresar al menú principal");
        System.out.print("Seleccione una opción: ");
    }

    private static void cambiarEquipoJugador(Jugador jugador) {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos disponibles.");
            return;
        } 
        mostrarListaEquipos();
        System.out.print("Seleccione el número del nuevo equipo: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index > 0 && index <= equipos.size()) {
            Equipo equipo = equipos.get(index - 1);
            jugador.setEquipo(equipo);
            System.out.println("Equipo cambiado exitosamente.");
        } else {
            System.out.println("Selección inválida.");
        }
    }

    private static void seleccionarEquipo() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos para seleccionar.");
            return;
        }

        mostrarListaEquipos();
        System.out.print("Seleccione el número del equipo: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index > 0 && index <= equipos.size()) {
            Equipo equipo = equipos.get(index - 1);
            int opcion;

            do {
                mostrarSubMenuEquipo();
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Detalles del equipo:");
                        System.out.println("Nombre: " + equipo.getNombre());
                        break;
                    case 2:
                        System.out.println("Ingrese el nuevo nombre del equipo: ");
                        String nuevoNombre = sc.nextLine();
                        cambiarNombreEquipo(equipo, nuevoNombre);
                        System.out.println("Nombre del equipo cambiado exitosamente.");
                        break;
                    case 3:
                        agregarJugadorAEquipo(equipo);
                        break;
                    case 4:
                        mostrarJugadoresDeEquipo(equipo);
                        break;
                    case 5:
                        System.out.println("Regresando al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } while (opcion != 5);
        } else {
            System.out.println("Selección inválida");
        }
    }

    private static void mostrarSubMenuEquipo() {
        System.out.println("\n--- Submenú Equipo ---");
        System.out.println("1. Ver detalles");
        System.out.println("2. Cambiar nombre");
        System.out.println("3. Agregar jugador al equipo");
        System.out.println("4. Mostrar jugadores del equipo");
        System.out.println("5. Regresar al menú principal");
        System.out.print("Seleccione una opción: ");
    }

    private static void cambiarNombreEquipo(Equipo equipo, String nuevoNombre) {
        equipo.setNombre(nuevoNombre);
        for (Jugador jugador : jugadores) {
            if (jugador.getEquipo() == equipo) {
                jugador.getEquipo().setNombre(nuevoNombre);
            }
        }
    }

    private static void agregarJugadorAEquipo(Equipo equipo) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores disponibles.");
            return;
        }

        mostrarListaJugadores();
        System.out.println("Seleccione el número del juagador para agregar al equipo: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index > 0 && index <= jugadores.size()) {
            Jugador jugador = jugadores.get(index -1);
            jugador.setEquipo(equipo);
            System.out.println("Jugador " + jugador.getNombre() + " agregado al equipo " + equipo.getNombre());
        } else {
            System.out.println("Selección inválida.");
        }
    }

    private static void mostrarJugadoresDeEquipo(Equipo equipo) {
        System.out.println("\n--- Jugadores del equipo " + equipo.getNombre() + " ---");
        boolean tieneJugadores = false;
        for (Jugador jugador : jugadores) {
            if (jugador.getEquipo() == equipo) {
                System.out.println("- " + jugador.getNombre());
                tieneJugadores = true;
            }
        }
        if (!tieneJugadores) {
            System.out.println("No hay jugadores asignados a este equipo.");
        }
    }

    private static void crearJugador() {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = sc.nextLine();
        Jugador jugador = new Jugador(nombre);
        
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos disponibles, el jugador se creó sin equipo asignado.");
        } else {
            mostrarListaEquipos();
            System.out.print("Seleccione el número del equipo para asignar al jugador, o 0 para dejarlo sin equipo: ");
            int seleccion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
            if (seleccion > 0 && seleccion <= equipos.size()) {
                jugador.setEquipo(equipos.get(seleccion - 1));
            } else {
                System.out.println("El jugador se creó sin equipo asignado.");
            }
        }
        jugadores.add(jugador);
        System.out.println("Jugador creado: " + jugador);
    }
    
    private static void crearEquipo() {
        System.out.print("Ingrese el nombre del equipo: ");
        String nombre = sc.nextLine();
        Equipo equipo = new Equipo(nombre);
        equipos.add(equipo);
        System.out.println("Equipo creado: " + equipo);
    }

    private static void asignarJugadorAEquipo() {
        if (jugadores.isEmpty() || equipos.isEmpty()) {
            System.out.println("Debe haber al menos un jugador y un equipo creados para realizar esta acción.");
            return;
        }

        mostrarListaJugadores();
        System.out.print("Seleccione el número del jugador a asignar: ");
        int jugadorIndex = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        mostrarListaEquipos();
        System.out.print("Seleccione el número del equipo: ");
        int equipoIndex = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        if (jugadorIndex > 0 && jugadorIndex <= jugadores.size() && equipoIndex > 0 && equipoIndex <= equipos.size()) {
            Jugador jugador = jugadores.get(jugadorIndex - 1);
            Equipo equipo = equipos.get(equipoIndex - 1);
            jugador.setEquipo(equipo);
            System.out.println("Jugador " + jugador.getNombre() + " asignado al equipo " + equipo.getNombre());
        } else {
            System.out.println("Selección inválida.");
        }
    }

    private static void mostrarListaJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores creados.");
        } else {
            System.out.println("\n--- Lista de Jugadores ---");
            for (int i = 0; i < jugadores.size(); i++) {
                System.out.println((i + 1) + ". " + jugadores.get(i));
            }
        }
    }

    private static void mostrarListaEquipos() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos creados.");
        } else {
            System.out.println("\n--- Lista de Equipos ---");
            for (int i = 0; i < equipos.size(); i++) {
                System.out.println((i + 1) + ". " + equipos.get(i));
            }
        }
    }


}