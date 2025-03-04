import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Edificio> edificios = new ArrayList<>();

        // Creación de instancias de Polideportivo
        Polideportivo poli1 = new Polideportivo(50, 10, 30, "Polideportivo Central", "Techado");
        Polideportivo poli2 = new Polideportivo(60, 12, 40, "Polideportivo Norte", "Abierto");

        // Creación de instancias de EdificioDeOficinas
        EdificioDeOficinas oficinas1 = new EdificioDeOficinas(20, 30, 15, 10, 5, 5);
        EdificioDeOficinas oficinas2 = new EdificioDeOficinas(25, 35, 20, 15, 4, 8);

        // Añadir instancias al ArrayList
        edificios.add(poli1);
        edificios.add(poli2);
        edificios.add(oficinas1);
        edificios.add(oficinas2);

        // Contadores para polideportivos techados y abiertos
        int contadorTechados = 0;
        int contadorAbiertos = 0;

        // Recorrer el ArrayList y ejecutar los métodos correspondientes
        for (Edificio edificio : edificios) {
            System.out.println("Superficie del edificio: " + edificio.calcularSuperficie() + " m²");
            System.out.println("Volumen del edificio: " + edificio.calcularVolumen() + " m³");

            if (edificio instanceof Polideportivo) {
                Polideportivo poli = (Polideportivo) edificio;
                System.out.println("Nombre del polideportivo: " + poli.getNombre());
                System.out.println("Tipo de instalación: " + poli.getTipoInstalacion());

                if (poli.getTipoInstalacion().equalsIgnoreCase("Techado")) {
                    contadorTechados++;
                } else if (poli.getTipoInstalacion().equalsIgnoreCase("Abierto")) {
                    contadorAbiertos++;
                }
            } else if (edificio instanceof EdificioDeOficinas) {
                EdificioDeOficinas oficinas = (EdificioDeOficinas) edificio;
                System.out.println("Número de oficinas: " + oficinas.getNumOficinas());
                System.out.println("Número de pisos: " + oficinas.getNumPisos());
                System.out.println("Capacidad total de personas: " + oficinas.cantPersonas());
            }
            System.out.println(); // Separación entre edificios
        }

        // Mostrar la cantidad de polideportivos techados y abiertos
        System.out.println("Cantidad de polideportivos techados: " + contadorTechados);
        System.out.println("Cantidad de polideportivos abiertos: " + contadorAbiertos);
    }
}