package entidades;

public class Oficina {
    private int idOficina;
    private String codigoOficina;
    private String ciudad;
    private String pais;
    private String region;
    private String codigoPostal;
    private String telefono;
    
    public Oficina(int idOficina, String codigoOficina, String ciudad, String pais, String region, String codigoPostal,
            String telefono) {
        this.idOficina = idOficina;
        this.codigoOficina = codigoOficina;
        this.ciudad = ciudad;
        this.pais = pais;
        this.region = region;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
    }

    public Oficina(String codigoOficina, String ciudad, String pais, String region, String codigoPostal,
            String telefono) {
        this.codigoOficina = codigoOficina;
        this.ciudad = ciudad;
        this.pais = pais;
        this.region = region;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
    }

    public Oficina() {
    }

    public int getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
    }

    public String getCodigoOficina() {
        return codigoOficina;
    }

    public void setCodigoOficina(String codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método toString para imprimir detalles de la oficina
    @Override
    public String toString() {
        return "Oficina{" +
                "idOficina=" + idOficina +
                ", codigoOficina='" + codigoOficina + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", region='" + region + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    // Método personalizado para imprimir un resumen de la oficina
    public void imprimirResumenOficina() {
        System.out.println("Oficina: " + codigoOficina + " | Ciudad: " + ciudad + " | País: " + pais);
    }
}
