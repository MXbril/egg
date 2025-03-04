package com.max.modelos;

import java.util.Objects;

public class Contacto {
    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = formatearTexto(nombre);
        this.telefono = telefono;
        this.email = email;
    }

    // Método para formatear el texto (quita espacios y pone en minúsculas)
    private String formatearTexto(String texto) {
        return texto.trim().toLowerCase();
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contacto contacto = (Contacto) obj;
        return Objects.equals(nombre, contacto.nombre); // Comparar solo por nombre
    }

    // Sobrescribimos hashCode para que coincida con equals
    @Override
    public int hashCode() {
        return Objects.hash(nombre); // Basamos el hash solo en el nombre
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Teléfono: " + telefono + ", Email: " + email;
    }
}
