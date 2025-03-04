package com.max.modelos;

public class Tarea {
    
    private static int contadorTareas = 0;
    private int idTarea;
    private String descripcion;
    private boolean completada;

    public Tarea(String descripcion) {
        this.idTarea = ++contadorTareas;
        this.descripcion = descripcion;
        this.completada = false; // Por defecto, la tarea está pendiente
    }

    public int getIdTarea() {
        return idTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void completar() {
        this.completada = true;
    }

    @Override
    public String toString() {
        return "ID: " + idTarea + ", Descripción: " + descripcion + ", Estado: " + (completada ? "Completada" : "Pendiente");
    }
}
