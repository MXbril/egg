import App.modelos.Libro;
import App.modelos.Pelicula;
import App.modelos.Revista;

public class App {
    public static void main(String[] args) {
        Revista revista1 = new Revista(1, 5, "National Geographic");
        Revista revista2 = new Revista(2, 2, "Science Today");
        Revista revista3 = new Revista(3, 0, "Time Magazine");

        // Arreglo de revistas
        Revista[] revistas = { revista1, revista2, revista3 };

        // Invocación de métodos para probar el funcionamiento de las revistas
        for (Revista revista : revistas) {
            revista.obtenerInformacion();
            revista.prestar();
            revista.devolver();
            revista.calcularMultas(3); // Ejemplo de cálculo de multa por 3 días de atraso
            System.out.println();
        }

        // Creación de objetos Libro
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", 3);
        Libro libro2 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 2);

        // Invocación de métodos para probar el funcionamiento de los libros
        libro1.obtenerInformacion();
        libro1.prestar();
        libro1.devolver();
        libro1.calcularMultas(5); // Ejemplo de cálculo de multa por 5 días de atraso
        System.out.println();

        libro2.obtenerInformacion();
        libro2.prestar();
        libro2.devolver();
        libro2.calcularMultas(7); // Ejemplo de cálculo de multa por 7 días de atraso
        System.out.println();

        // Creación de objetos Pelicula
        Pelicula pelicula1 = new Pelicula("Inception", "Christopher Nolan", 4);
        Pelicula pelicula2 = new Pelicula("The Matrix", "The Wachowskis", 1);

        // Invocación de métodos para probar el funcionamiento de las películas
        pelicula1.obtenerInformacion();
        pelicula1.prestar();
        pelicula1.devolver();
        pelicula1.calcularMultas(2); // Ejemplo de cálculo de multa por 2 días de atraso
        System.out.println();

        pelicula2.obtenerInformacion();
        pelicula2.prestar();
        pelicula2.devolver();
        pelicula2.calcularMultas(1);
    }
}