package App.modelos;

public abstract class ItemBiblioteca {
    public abstract void prestar();
    public abstract void devolver();
    public abstract double calcularMultas(int diasAtraso);
}
