package dato.modelos;

public class Perro extends Animal {
    private String raza;

    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad);
        this.raza = raza;
    }

    public Perro() {

    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public void comer() {
        System.out.println("El perro " +nombre+ " está comiendo croquetas.");
    }

    @Override
    public void dormir() {
        System.out.println("El perro " +nombre+ " está durmiendo en su cama.");
    }

    public void ladrar() {
        System.out.println(nombre+ " está ladrando.");
    }

    public void mostrarDetalles() {
        System.out.println("Nombre: " +nombre+ ", Edad: " +edad+ " años, raza: " +raza);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((raza == null) ? 0 : raza.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Perro other = (Perro) obj;
        if (raza == null) {
            if (other.raza != null)
                return false;
        } else if (!raza.equals(other.raza))
            return false;
        return true;
    }

    
}
