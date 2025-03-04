package App.modelos;

public class Pelicula extends ItemBiblioteca implements Catalogable {
    private String titulo;
    private String director;
    private int cantidadCopias;

    public Pelicula(String titulo, String director, int cantidadCopias) {
        this.titulo = titulo;
        this.director = director;
        this.cantidadCopias = cantidadCopias;
    }
    public Pelicula() {

    }
    public String getTitulo() {
        return titulo;
    }
    public String getDirector() {
        return director;
    }
    public int getCantidadCopias() {
        return cantidadCopias;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setCantidadCopias(int cantidadCopias) {
        this.cantidadCopias = cantidadCopias;
    }

    @Override
    public void prestar() {
        if (cantidadCopias > 0) {
            cantidadCopias--;
            System.out.println("Película " + titulo + " prestada. Copias restantes: " + cantidadCopias);
        } else {
            System.out.println("No hay copias disponibles de la película " + titulo + " para prestar.");
        }
    }

    @Override
    public void devolver() {
        cantidadCopias++;
        System.out.println("Película " + titulo + " devuelta. Copias disponibles: " + cantidadCopias);
    }

    @Override
    public double calcularMultas(int diasAtraso) {
        double multa = diasAtraso * 2.00; // Suponiendo que la multa es de 2.00 por día de atraso
        System.out.println("Multa por " + diasAtraso + " días de atraso: $" + multa);
        return multa;
    }

    @Override
    public void obtenerInformacion() {
        System.out.println("Información de la Película:");
        System.out.println("Título: " + titulo);
        System.out.println("Director: " + director);
        System.out.println("Cantidad de Copias: " + cantidadCopias);
    }
}
