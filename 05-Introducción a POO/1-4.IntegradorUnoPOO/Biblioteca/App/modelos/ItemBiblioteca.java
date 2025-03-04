package App.modelos;

public abstract class ItemBiblioteca implements IMostrable {
    protected String titulo;
    protected boolean prestado;

    public ItemBiblioteca(String titulo) {
        this.titulo = titulo;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void prestar() {
        this.prestado = true;
    }

    public void devolver() {
        this.prestado = false;
    }

    // Método abstracto para que cada subclase lo implemente
    public abstract void mostrarInformacion();
}
