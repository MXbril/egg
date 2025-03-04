public class AutoDos {

    private String marca;
    private String modelo;
    private Integer year;

    public AutoDos(String marca, String modelo, Integer year) {
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
    }

    public AutoDos(String marca, String modelo) {
        this(marca, modelo, null);
    }

    public AutoDos(String marca) {
        this(marca, null, null);
    }

    public AutoDos() {
        this(null, null, null);
    }

    public void imprimirDatos() {
        if (marca != null) {
            System.out.println("Marca: " +marca);
        } else {
            System.out.println("Marca: no especificada.");
        }
        if (modelo != null) {
            System.out.println("Modelo: " +modelo);
        } else {
            System.out.println("Modelo: no especificado.");
        }
        if (year != null) {
            System.out.println("Año: " +year);
        } else {
            System.out.println("Año: no especificado.");
        }
    }

}