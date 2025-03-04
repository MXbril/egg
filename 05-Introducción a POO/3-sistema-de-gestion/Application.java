import java.util.Scanner;
import modelos.Empleado;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empleado[] empleados = new Empleado[100];
        int contadorEmpleados = 0;
        Empleado[] empleadosFiltrados = empleados;

        while (true) {
            System.out.println("\nMenú de Gestión de Empleados:");
            System.out.println("1. Mostrar todos los empleados");
            System.out.println("2. Crear empleado");
            System.out.println("3. Filtrar empleados");
            System.out.println("4. Ordenar empleados");
            System.out.println("5. Incrementar salario");
            System.out.println("6. Limpiar filtros");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion =sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    mostrarEmpleados(empleadosFiltrados, contadorEmpleados);
                    break;
                case 2:
                    contadorEmpleados = crearEmpleado(sc, empleados, contadorEmpleados);
                    empleadosFiltrados = empleados; // Actualiza la lista filtrada con la original
                    break;
                case 3:
                    empleadosFiltrados = filtrarEmpleados(sc, empleados, contadorEmpleados);
                    break;
                case 4:
                    ordenarEmpleados(sc, empleadosFiltrados);
                    break;
                case 5:
                    incrementarSalario(sc, empleados, contadorEmpleados);
                    break;
                case 6:
                    empleadosFiltrados = empleados; // Restablece la lista filtrada
                    System.out.println("Filtros limpiados. Se muestra la lista original.");
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }
    }

    private static void mostrarEmpleados(Empleado[] empleados, int contadorEmpleados) {
        System.out.println("\nLista de empleados:");
        System.out.printf("%-5s %-15s %-5s %-10s %-15s%n", "ID", "Nombre", "Edad", "Salario", "Departamento");
        for (int i = 0; i < contadorEmpleados; i++) {
            System.out.printf("%-5d %-15s %-5d %-10.2f %-15s%n", i + 1, empleados[i].getNombre(), empleados[i].getEdad(), empleados[i].getSalario(), empleados[i].getDepartamento());
        }
    }

    private static int crearEmpleado(Scanner sc, Empleado[] empleados, int contadorEmpleados) {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = sc.nextLine();
        //verificar si el empleado ya existe
        for (int i = 0; i < contadorEmpleados; i++) {
            if (empleados[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Error: Ya existe un empleado con ese nombre.");
                return contadorEmpleados;
            }
        }

        System.out.print("Ingrese la edad del empleado: ");
        int edad = sc.nextInt();
        System.out.print("Ingrese el salario del empleado: ");
        double salario = sc.nextDouble();
        sc.nextLine();
        System.out.print("Ingrese el departamento del empleado: ");
        String departamento = sc.nextLine();

        empleados[contadorEmpleados] = new Empleado(nombre, edad, salario, departamento);
        System.out.println("Empleado creado exitosamente.");
        return contadorEmpleados + 1;
    }

    private static Empleado[] filtrarEmpleados(Scanner sc, Empleado[] empleados, int contadorEmpleados) {
        System.out.println("Seleccione el atributo por el cual filtrar:");
        System.out.println("1. Nombre");
        System.out.println("2. Edad");
        System.out.println("3. Salario");
        System.out.println("4. Departamento");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nombre a filtrar: ");
                String nombreFiltro = sc.nextLine();
                return filtrarPorNombre(empleados, contadorEmpleados, nombreFiltro);
            case 2:
                System.out.print("Ingrese la edad mínima: ");
                int edadMin = sc.nextInt();
                System.out.print("Ingrese la edad máxima: ");
                int edadMax = sc.nextInt();
                return filtrarPorEdad(empleados, contadorEmpleados, edadMin, edadMax);
            case 3:
                System.out.print("Ingrese el salario mínimo: ");
                double salarioMin = sc.nextDouble();
                System.out.print("Ingrese el salario máximo: ");
                double salarioMax = sc.nextDouble();
                return filtrarPorSalario(empleados, contadorEmpleados, salarioMin, salarioMax);
            case 4:
                System.out.print("Ingrese el departamento a filtrar: ");
                String departFiltro = sc.nextLine();
                return filtrarPorDepartamento(empleados, contadorEmpleados, departFiltro);
            default:
                System.out.println("Opción no válida.");
                return empleados; //retorna la lista original
        }
    }

    private static Empleado[] filtrarPorNombre(Empleado[] empleados, int contadorEmpleados, String nombre) {
        return java.util.Arrays.stream(empleados, 0, contadorEmpleados)
        .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
        .toArray(Empleado[]::new);
    }

    private static Empleado[] filtrarPorEdad(Empleado[] empleados, int contadorEmpleados, int min, int max) {
        return java.util.Arrays.stream(empleados, 0, contadorEmpleados)
        .filter(e -> e.getEdad() >= min && e.getEdad() <= max)
        .toArray(Empleado[]::new);
    }

    private static Empleado[] filtrarPorSalario(Empleado[] empleados, int contadorEmpleados, double min, double max) {
        return java.util.Arrays.stream(empleados, 0, contadorEmpleados)
        .filter(e -> e.getSalario() >= min && e.getSalario() <= max)
        .toArray(Empleado[]::new);
    }

    private static Empleado[] filtrarPorDepartamento(Empleado[] empleados, int contadorEmpleados, String departamento) {
        return java.util.Arrays.stream(empleados, 0, contadorEmpleados)
        .filter(e -> e.getDepartamento().equalsIgnoreCase(departamento))
        .toArray(Empleado[]::new);
    }

    private static void ordenarEmpleados(Scanner sc, Empleado[] empleados) {
        System.out.println("Seleccione el atributo por el cual ordenar:");
        System.out.println("1. Nombre");
        System.out.println("2. Edad");
        System.out.println("3. Salario");
        System.out.println("4. Departamento");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < empleados.length - 1; i++) {
            for (int j = 0 ; j < empleados.length - i - 1; i++) {
                if (compararEmpleados(empleados[j], empleados[j + 1], opcion) > 0) {
                    Empleado temp = empleados[j];
                    empleados[j] = empleados[j + 1];
                    empleados[j + 1] = temp;

                }
            }
        }
        System.out.println("Empleados ordenados exitosamente.");
    }

    private static int compararEmpleados(Empleado e1, Empleado e2, int criterio) {
        switch (criterio) {
            case 1:
                return e1.getNombre().compareToIgnoreCase(e2.getNombre());
            case 2:
                return Integer.compare(e1.getEdad(), e2.getEdad());
            case 3:
                return Double.compare(e1.getSalario(), e2.getSalario());
            case 4:
                return e1.getDepartamento().compareToIgnoreCase(e2.getDepartamento());
            default:
                return 0;
        }
    }

    private static void incrementarSalario(Scanner sc, Empleado[] empleados, int contadorEmpleados) {
        System.out.print("Ingrese el nombre del empleado para incrementar salario: ");
        String nombre = sc.nextLine();

        Empleado empleado = buscarPorNombre(empleados, contadorEmpleados, nombre);
        if (empleado == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }

        System.out.print("Ingrese el porcentaje de aumento: ");
        double porcentaje = sc.nextDouble();

        double nuevoSalario = empleado.getSalario() * (1 + porcentaje / 100);
        empleado.setSalario(nuevoSalario);
        System.out.println("Salario incrementado exitosamente. Nuevo salario: " + nuevoSalario);
    }

    private static Empleado buscarPorNombre(Empleado[] empleados, int contadorEmpleados, String nombre) {
        for (int i = 0; i < contadorEmpleados; i++) {
            if (empleados[i].getNombre().equalsIgnoreCase(nombre)) {
                return empleados[i];
            }
        }
        return null;
    }
}