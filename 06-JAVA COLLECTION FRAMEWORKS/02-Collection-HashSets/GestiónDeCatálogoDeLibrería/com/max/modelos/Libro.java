package com.max.modelos;

import java.util.Objects;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = formatearTexto(titulo) ;
        this.autor = formatearTexto(autor) ;
        this.isbn = isbn;
    }
    
    // Método para formatear el texto (quita espacios y pone en minúsculas)
    private String formatearTexto(String texto) {
        return texto.trim().toLowerCase();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    // Sobrescribimos equals para comparar libros por ISBN
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Libro libro = (Libro) obj;
        return Objects.equals(isbn, libro.isbn); // Compara solo por ISBN
    }

    // Sobrescribimos hashCode para que coincida con equals
    @Override
    public int hashCode() {
        return Objects.hash(isbn); // Basamos el hash solo en el ISBN
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn;
    }
}
