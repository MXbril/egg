package datos.max.modelos;

class Polideportivo extends Edificio {
    private String nombre;
    private String tipoInstalacion;

    public Polideportivo(double ancho, double alto, double largo, String nombre, String tipoInstalacion) {
        super(ancho, alto, largo);
        this.nombre = nombre;
        this.tipoInstalacion = tipoInstalacion;
    }

    public Polideportivo() {

    }

    @Override
    public double calcularSuperficie() {
        return ancho * largo;
    }

    @Override
    public double calcularVolumen() {
        return ancho * largo * alto;
    }

    public String getTipoInstalacion() {
        return tipoInstalacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoInstalacion(String tipoInstalacion) {
        this.tipoInstalacion = tipoInstalacion;
    }

    public String getNombre() {
        return nombre;
    }
}
