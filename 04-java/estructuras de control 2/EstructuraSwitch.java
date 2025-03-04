import java.util.Scanner;

public class EstructuraSwitch {

    public static void main(String[] args) {
        FiguraGeometrica();
    }

    public static void ConversionCalificacion() {
        Scanner conversion = new Scanner(System.in);

        System.out.println("Ingrese una calificación numérica del 1 al 5:");
        int calificación = conversion.nextInt();

        String calificacionEnLetras;
        switch (calificación) {
            case 1:
                calificacionEnLetras = "Muy deficiente";
                break;
            case 2:
                calificacionEnLetras = "Deficiente";
                break;
            case 3:
                calificacionEnLetras = "Suficiente";
                break;
            case 4:
                calificacionEnLetras = "Notable";
                break;
            case 5:
                calificacionEnLetras = "Sobresaliente";
                break;
            default:
                calificacionEnLetras = "Calificación inválida. Por favor ingrese un número del 1 al 5.";
                break;
        }

        System.out.println("La calificación en letras es: " + calificacionEnLetras);

        conversion.close();
    }

    public static void DiaDeLaSemana() {
        Scanner semana = new Scanner(System.in);

        System.out.println("Ingrese un número del 1 al 7 que represente un día de la semana:");
        int numeroDia = semana.nextInt();

        String diaSemana;
        switch (numeroDia ) {
            case 1:
                diaSemana = "Lunes";
                break;
            case 2:
                diaSemana = "Martes";
                break;
            case 3:
                diaSemana = "Miercoles";
                break;
            case 4:
                diaSemana = "Jueves";
                break;
            case 5:
                diaSemana = "Viernes";
                break;
            case 6:
                diaSemana = "Sabado";
                break;
            case 7:
                diaSemana = "Domingo";
                break;
            default:
                diaSemana = "Número inválido. Por favor ingrese un número del 1 al 7.Número inválido. Por favor ingrese un número del 1 al 7.";
                break;
        }

        System.out.println("El día de la semana es: " + diaSemana);

        semana.close();
    }

    public static void SelectOption() {
        Scanner select = new Scanner(System.in);

        System.out.println("Seleccione una opción:");
        System.out.println("1: Guardar");
        System.out.println("2: Cargar");
        System.out.println("3: Salir");

        int option = select.nextInt();
        switch (option) {
            case 1:
                System.out.println("Has seleccionado: Guardar");
                break;
            case 2:
                System.out.println("Has seleccionado: Cargar");
                break;
            case 3:
                System.out.println("Has seleccionado: Salir");
                break;
            default:
                System.out.println("Opcion invalida. Por favor ingrese un número del 1 al 3.");
                break;
        }

        select.close();
    }

    public static void FiguraGeometrica() {
        Scanner userFigura = new Scanner(System.in);
        
        System.out.println("Seleccione una figura geométrica:");
        System.out.println("1: Círculo");
        System.out.println("2: Cuadrado");
        System.out.println("3: Triángulo");

        int figuraSelect = userFigura.nextInt();

        switch (figuraSelect) {
            case 1:
                System.out.println("Ingrese el radio del círculo:");
                double radio = userFigura.nextDouble();
                double areaCirculo = Math.PI * radio * radio;
                System.out.println("El área del círculo es: " + areaCirculo);
                break;
            case 2:
                System.out.println("Ingrese el lado del cuadrado:");
                double lado = userFigura.nextDouble();
                double areaCuadrado = lado * lado;
                System.out.println("El área del cuadrado es: " + areaCuadrado);
                break;
            case 3:
                System.out.println("Ingrese la base del tríangulo:");
                double base = userFigura.nextDouble();
                System.out.println("Ingrese la altura del tríangulo:");
                double altura = userFigura.nextDouble();
                double areaDelTriangulo = (base * altura) / 2;
                System.out.println("El área del triángulo es: " + areaDelTriangulo);
                break;
            default:
                System.out.println("Opción inválida. Por favor ingrese un número del 1 al 3.");
                break;
        }

        userFigura.close();
    }
}