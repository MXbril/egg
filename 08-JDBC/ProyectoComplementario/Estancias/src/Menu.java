import java.util.List;
import java.util.Scanner;

import entidades.Casa;
import entidades.Familia;
import servicios.CasaServicio;
import servicios.FamiliaServicio;

public class Menu {

  
    private FamiliaServicio familiaServicio;
    private CasaServicio casaServicio;
    private Scanner scanner = new Scanner(System.in);

    public Menu() {
        
        familiaServicio = new FamiliaServicio();
        casaServicio = new CasaServicio();
        scanner = new Scanner(System.in);
        
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("\n--- Menú de Consultas ---");
            System.out.println("1. Familias con al menos 3 hijos y edad máxima menor a 10 años");
            System.out.println("2. Casas disponibles en Reino Unido (Agosto 2020)");
            // System.out.println("3. Familias con email Hotmail");
            // System.out.println("4. Casas disponibles desde una fecha dada y por un número específico de días");
            // System.out.println("5. Clientes con estancias y descripción de casas");
            // System.out.println("6. Estancias reservadas por cliente (nombre, país, ciudad, casa reservada)");
            // System.out.println("7. Incrementar precio por día de casas del Reino Unido (5%)");
            // System.out.println("8. Número de casas por país");
            // System.out.println("9. Casas del Reino Unido con comentarios de que están limpias");
            // System.out.println("10. Insertar nueva estancia verificando disponibilidad");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción: ");

            String entrada = scanner.nextLine();

            // Verificar si la entrada es un número
            if (entrada.matches("\\d+")) { 
                opcion = Integer.parseInt(entrada);

                switch (opcion) {
                    case 1:
                        listarFamiliasConHijosYEdad();
                        break;
                    case 2:
                        casasDisponiblesEnReinoUnido();
                        break;
                    case 3:
                        // familiasConEmailHotmail();
                        break;
                    case 4:
                        // casasDisponiblesPorFechaYDias();
                        break;
                    case 5:
                        // clientesConEstancias();
                        break;
                    case 6:
                        // estanciasReservadasPorCliente();
                        break;
                    case 7:
                        // incrementarPrecioCasasUK();
                        break;
                    case 8:
                        // numeroCasasPorPais();
                        break;
                    case 9:
                        // casasLimpiasReinoUnido();
                        break;
                    case 10:
                        // insertarNuevaEstancia();
                        break;
                    case 11:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } else {
                System.out.println("Error: No se permiten letras, solo números.");
            }
        } while (opcion != 11);
        scanner.close();
    }

    // Métodos correspondientes a las consultas

    private void listarFamiliasConHijosYEdad() {
        System.out.print("Ingrese el número mínimo de hijos: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next(); // Consumir la entrada no válida
        }
        int numHijos = scanner.nextInt();
    
        System.out.print("Ingrese la edad máxima: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next(); // Consumir la entrada no válida
        }
        int edadMaxima = scanner.nextInt();
    
        try {
            // Llama al servicio para listar las familias
            List<Familia> familias = familiaServicio.listarFamiliasConHijosYEdad(numHijos, edadMaxima);
            
            // Verifica si la lista de familias está vacía
            if (familias.isEmpty()) {
                System.out.println("No se encontraron familias con al menos " + numHijos + " hijos y edad máxima menor a " + edadMaxima + " años.");
            } else {
                familias.forEach(familia -> {
                    System.out.println("Familia: " + familia.getNombre() + ", Hijos: " + familia.getNumHijos() +
                            ", Edad Máxima: " + familia.getEdadMaxima() + ", Email: " + familia.getEmail());
                });
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta: " + e.getMessage());
        }
    }

    private void casasDisponiblesEnReinoUnido() {
    // Solicitar la fecha de inicio
    System.out.print("Ingrese la fecha de inicio (YYYY-MM-DD): ");
    String fechaInicio = scanner.nextLine();

    // Solicitar la fecha de fin
    System.out.print("Ingrese la fecha de fin (YYYY-MM-DD): ");
    String fechaFin = scanner.nextLine();

    try {
        // Llama al servicio para listar las casas disponibles
        List<Casa> casas = casaServicio.listarCasasDisponiblesReinoUnido(fechaInicio, fechaFin);

        // Verifica si la lista de casas está vacía
        if (casas.isEmpty()) {
            System.out.println("No se encontraron casas disponibles en Reino Unido entre " + fechaInicio + " y " + fechaFin + ".");
        } else {
            System.out.println("Casas disponibles en Reino Unido entre " + fechaInicio + " y " + fechaFin + ":");
            for (Casa casa : casas) {
                System.out.println("ID Casa: " + casa.getIdCasa() +
                                   ", Calle: " + casa.getCalle() +
                                   ", Número: " + casa.getNumero() +
                                   ", Ciudad: " + casa.getCiudad() +
                                   ", Código Postal: " + casa.getCodigoPostal() +
                                   ", Precio por habitación: " + casa.getPrecioHabitacion() +
                                   ", Tipo de Vivienda: " + casa.getTipoVivienda());
            }
        }
        } catch (Exception e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    // private void familiasConEmailHotmail() {
    //     try {
    //         familiaServicio.listarFamiliasConEmailHotmail();
    //     } catch (Exception e) {
    //         System.out.println("Error en la consulta: " + e.getMessage());
    //     }
    // }

    // private void casasDisponiblesPorFechaYDias() {
    //     Scanner scanner = new Scanner(System.in);
    //     try {
    //         System.out.print("Ingrese la fecha (AAAA-MM-DD): ");
    //         String fecha = scanner.nextLine();
    //         System.out.print("Ingrese el número de días: ");
    //         int dias = scanner.nextInt();
    //         casaServicio.listarCasasDisponiblesPorFechaYDias(fecha, dias);
    //     } catch (Exception e) {
    //         System.out.println("Error en la consulta: " + e.getMessage());
    //     }
    // }

    // private void clientesConEstancias() {
    //     try {
    //         estanciaServicio.listarClientesConEstancias();
    //     } catch (Exception e) {
    //         System.out.println("Error en la consulta: " + e.getMessage());
    //     }
    // }

    // private void estanciasReservadasPorCliente() {
    //     try {
    //         estanciaServicio.listarEstanciasReservadasPorCliente();
    //     } catch (Exception e) {
    //         System.out.println("Error en la consulta: " + e.getMessage());
    //     }
    // }

    // private void incrementarPrecioCasasUK() {
    //     try {
    //         casaServicio.incrementarPrecioCasasUK(5); // Aumenta un 5%
    //     } catch (Exception e) {
    //         System.out.println("Error al incrementar precios: " + e.getMessage());
    //     }
    // }

    // private void numeroCasasPorPais() {
    //     try {
    //         casaServicio.obtenerNumeroCasasPorPais();
    //     } catch (Exception e) {
    //         System.out.println("Error en la consulta: " + e.getMessage());
    //     }
    // }

    // private void casasLimpiasReinoUnido() {
    //     try {
    //         casaServicio.listarCasasLimpiasReinoUnido();
    //     } catch (Exception e) {
    //         System.out.println("Error en la consulta: " + e.getMessage());
    //     }
    // }

    // private void insertarNuevaEstancia() {
    //     Scanner scanner = new Scanner(System.in);
    //     try {
    //         System.out.print("Ingrese el ID del cliente: ");
    //         int idCliente = scanner.nextInt();
    //         System.out.print("Ingrese el ID de la casa: ");
    //         int idCasa = scanner.nextInt();
    //         scanner.nextLine(); // Limpiar buffer
    //         System.out.print("Ingrese la fecha de inicio (AAAA-MM-DD): ");
    //         String fechaDesde = scanner.nextLine();
    //         System.out.print("Ingrese la fecha de fin (AAAA-MM-DD): ");
    //         String fechaHasta = scanner.nextLine();

    //         estanciaServicio.insertarEstancia(idCliente, idCasa, fechaDesde, fechaHasta);
    //     } catch (Exception e) {
    //         System.out.println("Error al insertar la estancia: " + e.getMessage());
    //     }
    // }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
