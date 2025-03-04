package dato.modelos;

public class Gato extends Animal {

    private String colorPelaje;

    public Gato(String nombre, int edad, String colorPelaje) {
        super(nombre, edad);
        this.colorPelaje = colorPelaje;
    }

    public Gato() {

    }

    public String getColorPelaje() {
        return colorPelaje;
    }

    public void setColorPelaje(String colorPelaje) {
        this.colorPelaje = colorPelaje;
    }

    @Override
    public void comer() {
        System.out.println("El gato " +nombre+ " está comiendo pescado.");
    }

    @Override
    public void dormir() {
        System.out.println("El gato " +nombre+ " está durmiendo encima del sofá.");
    }

    public void maullar() {
        System.out.println(nombre+ " está maullando.");
    }

    public void mostrarDetalles() {
        System.out.println("Nombre: " +nombre+ ", Edad: " +edad+ " años, color de pelaje: " +colorPelaje);
    }
}
