package App.modelos;

public class Libro extends ItemBiblioteca implements Catalogable {
    private String titulo;
    private String autor;
    private int cantidadCopias;

    public Libro(String titulo, String autor, int cantidadCopias) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadCopias = cantidadCopias;
    }

    public Libro() {

    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getCantidadCopias() {
        return cantidadCopias;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCantidadCopias(int cantidadCopias) {
        this.cantidadCopias = cantidadCopias;
    }

    @Override
    public void prestar() {
        if (cantidadCopias > 0) {
            cantidadCopias--;
            System.out.println("Libro " +titulo+ " prestado. Copias restantes: " +cantidadCopias);
        } else {
            System.out.println("No hay copias disponibles del libro " +titulo+ " para pretar.");
        }
    }
    @Override
    public void devolver() {
        cantidadCopias++;
        System.out.println("Libro " +titulo+ " devuelto. Copias disponibles: " +cantidadCopias);
    }

    @Override
    public double calcularMultas(int diasAtraso) {
        double multa = diasAtraso * 1.00;
        System.out.println("Multa por " +diasAtraso+ " días de atraso: $" +multa);
        return multa;
    }

    @Override
    public void obtenerInformacion() {
        System.out.println("Información del Libro:");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Cantidad de Copias: " + cantidadCopias);
    }

}
