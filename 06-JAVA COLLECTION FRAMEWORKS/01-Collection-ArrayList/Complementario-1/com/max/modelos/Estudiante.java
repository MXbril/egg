package com.max.modelos;

public class Estudiante {
    private String documento;
    private String nombre;
    private int edad;

    public Estudiante(String documento, String nombre, int edad) {
        this.documento = documento;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Documento: " + documento + ", Nombre: " + nombre + ", Edad: " + edad;
    }
}
