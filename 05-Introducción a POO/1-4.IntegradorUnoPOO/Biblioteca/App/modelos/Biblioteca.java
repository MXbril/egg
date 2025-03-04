package App.modelos;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<ItemBiblioteca> catalogo;
    private List<Persona> personas;

    public Biblioteca() {
        this.catalogo = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    // Método para agregar un libro al catálogo
    public void agregarLibro(ItemBiblioteca item) {
        catalogo.add(item);
        System.out.println("Libro agregado al catálogo: " + item.getTitulo());
    }

    // Método para mostrar la información de todos los libros en el catálogo
    public void mostrarCatalogo() {
        if (catalogo.isEmpty()) {
            System.out.println("El catálogo está vacío.");
        } else {
            System.out.println("Catálogo de libros:");
            for (ItemBiblioteca item : catalogo) {
                item.mostrarInformacion();
                System.out.println("------------------------");
            }
        }
    }

    // Método para prestar un libro
    public void prestarLibro(Persona persona, String tituloLibro) {
        for (ItemBiblioteca item : catalogo) {
            if (item.getTitulo().equalsIgnoreCase(tituloLibro) && !item.isPrestado() && item instanceof Libro) {
                item.prestar();
                persona.prestarLibro((Libro) item);
                return;
            }
        }
        System.out.println("El libro no está disponible o ya está prestado.");
    }

    public void devolverLibro(Persona persona, String tituloLibro) {
        for (Libro libro : persona.getLibrosPrestados()) {
            if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                libro.devolver();
                persona.devolverLibro(libro);
                return;
            }
        }
        System.out.println("El libro no se encontró en la lista de libros prestados por la persona.");
    }

    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    // Método para mostrar la lista de personas registradas en la biblioteca
    public void mostrarPersonas() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas en la biblioteca.");
        } else {
            System.out.println("Personas registradas en la biblioteca:");
            for (Persona persona : personas) {
                persona.mostrarInformacion();
                System.out.println("------------------------");
            }
        }
    }

    // Método para buscar una persona por nombre completo
    public Persona buscarPersona(String nombreCompleto) {
        for (Persona persona : personas) {
            String nombreCompletoPersona = persona.getNombre() + " " + persona.getApellido();
            if (nombreCompletoPersona.equalsIgnoreCase(nombreCompleto)) {
                return persona;
            }
        }
        return null;
    }
}
