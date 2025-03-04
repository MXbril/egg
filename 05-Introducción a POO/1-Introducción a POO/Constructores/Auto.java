public class Auto {

    private String marca;
    private String modelo;
    private Integer anao;

    public Auto(String marca, String modelo, int anao) {
        this.marca = marca;
        this.modelo = modelo;
        this.anao = anao;
    }

    public Auto(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Auto(String marca) {
        this.marca = marca;
    }

    public Auto() {

    }

    public void imprimirDatos() {
        if (marca != null) {
            System.out.println("Marca: " +marca);
        } else {
            System.out.println("Marca: no especificada");
        }
        if (modelo != null) {
            System.out.println("Modelo: " +modelo);
        } else {
            System.out.println("Modelo: no especificado");
        }
        if (anao != null) {
            System.out.println("Año: " +anao);
        } else {
            System.out.println("Año: no especificado");
        }
        System.out.println();
    }
}