package App.modelos;

public class Libro extends ItemBiblioteca {
    private String autor;
    private int numeroDePaginas;

    // Constructor
    public Libro(String titulo, String autor, int numeroDePaginas) {
        super(titulo);
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public void prestar() {
        this.prestado = true;
    }

    public void devolver() {
        this.prestado = false;
    }

    // Método para mostrar la información del libro
    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Número de Páginas: " + numeroDePaginas);
        System.out.println("Estado: " +(prestado ? "Prestado" : "Disponible"));
    }
}
