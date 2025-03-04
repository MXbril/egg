package App.modelos;

import java.util.ArrayList;
import java.util.List;

public class Persona implements IMostrable {
    private String nombre;
    private String apellido;
    private List<Libro> librosPrestados;

    // Constructor
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.librosPrestados = new ArrayList<>();
    }

    public Persona() {

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setLibrosPrestados(List<Libro> librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    // Métodos para gestionar los libros prestados
    public void prestarLibro(Libro libro) {
        librosPrestados.add(libro);
        System.out.println(nombre + " ha tomado prestado el libro: " + libro.getTitulo());
    }

    public void devolverLibro(Libro libro) {
        librosPrestados.remove(libro);
        System.out.println(nombre + " ha devuelto el libro: " + libro.getTitulo());
    }

    // Método para mostrar la información de la persona y sus libros prestados
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Libros prestados:");
        for (Libro libro : librosPrestados) {
            System.out.println("- " + libro.getTitulo());
        }
    }
}
