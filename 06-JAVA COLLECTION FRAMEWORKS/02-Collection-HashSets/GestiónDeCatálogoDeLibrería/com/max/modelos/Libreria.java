package com.max.modelos;
import java.util.HashSet;

public class Libreria {
    private HashSet<Libro> catalogo;

    public Libreria() {
        catalogo = new HashSet<>();
    } 

    public void agregarLibro(Libro libro) {
        if (catalogo.add(libro)) {
            System.out.println("El libro ha sido agregado al catálogo.");
        } else {
            System.out.println("El libro con ISBN " +libro.getIsbn()+ " ya está en el catálogo.");
        }
    }

    public void eliminarLibro(String isbn) {
        Libro libroEliminar = null;
        for (Libro libro : catalogo) {
            if (libro.getIsbn().equals(isbn)) {
                libroEliminar = libro;
                break;
            }
        }
        if (libroEliminar != null) {
            catalogo.remove(libroEliminar);
            System.out.println("El libro con ISBN " +isbn+ " ha sido eliminado del catálogo.");
        } else {
            System.out.println("No se encontró ningún libro con el ISBN " +isbn);
        }
    }

    public void mostrarCatalogo() {
        if (catalogo.isEmpty()) {
            System.out.println("El catálogo está vacío.");
        } else {
            System.out.println("Catalogos de libros:");
            for (Libro libro : catalogo) {
                System.out.println(libro);
            }
        }
    }
}
