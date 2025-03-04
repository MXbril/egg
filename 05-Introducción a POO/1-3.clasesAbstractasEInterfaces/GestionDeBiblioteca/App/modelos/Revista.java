package App.modelos;

public class Revista extends ItemBiblioteca implements Catalogable {
    private int nroEdicion;
    private int cantidadEjemplares;
    private String nombreRevista;

    public Revista(int nroEdicion, int cantidadEjemplares, String nombreRevista) {
        this.nroEdicion = nroEdicion;
        this.cantidadEjemplares = cantidadEjemplares;
        this.nombreRevista = nombreRevista;
    }

    public Revista() {

    }

    public int getNroEdicion() {
        return nroEdicion;
    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNroEdicion(int nroEdicion) {
        this.nroEdicion = nroEdicion;
    }

    public void setCantidadEjemplares(int cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    @Override
    public void prestar() {
        if (cantidadEjemplares > 0) {
            cantidadEjemplares--;
            System.out.println("Revista " +nombreRevista+ " prestada. Ejemplares restantes: " + cantidadEjemplares);
        } else {
            System.out.println("No hay ejemplares disponibles de la revista " +nombreRevista+ " para prestar.");
        }
    }

    @Override
    public void devolver() {
        cantidadEjemplares++;
        System.out.println("Revista " +nombreRevista+ " devuelta. Ejemplares disponibles: " +cantidadEjemplares);
    }

    @Override
    public double calcularMultas(int diasAtraso) {
        double multa = diasAtraso * 0.50;
        System.out.println("Multa por " +diasAtraso+ " días de atraso: $" +multa);
        return multa;
    }

    @Override
    public void obtenerInformacion() {
        System.out.println("Información de la Revista:");
        System.out.println("Nombre: " + nombreRevista);
        System.out.println("Número de Edición: " + nroEdicion);
        System.out.println("Cantidad de Ejemplares: " + cantidadEjemplares);
    }
}
