package datos.max.modelos;

class EdificioDeOficinas extends Edificio {
    private int numOficinas;
    private int personasPorOficina;
    private int numPisos;

    public EdificioDeOficinas(double ancho, double alto, double largo, int numOficinas, int personasPorOficina, int numPisos) {
        super(ancho, alto, largo);
        this.numOficinas = numOficinas;
        this.personasPorOficina = personasPorOficina;
        this.numPisos = numPisos;
    }

    public EdificioDeOficinas() {
        
    }

    @Override
    public double calcularSuperficie() {
        return ancho * largo * numPisos; // Superficie de todos los pisos
    }

    @Override
    public double calcularVolumen() {
        return ancho * largo * alto; // Volumen del edificio
    }

    public int cantPersonas() {
        return numOficinas * personasPorOficina * numPisos; // Cantidad total de personas en el edificio
    }

    public void setNumOficinas(int numOficinas) {
        this.numOficinas = numOficinas;
    }

    public void setPersonasPorOficina(int personasPorOficina) {
        this.personasPorOficina = personasPorOficina;
    }

    public void setNumPisos(int numPisos) {
        this.numPisos = numPisos;
    }

    public int getNumOficinas() {
        return numOficinas;
    }

    public int getNumPisos() {
        return numPisos;
    }

    public int getPersonasPorOficina() {
        return personasPorOficina;
    }
}
