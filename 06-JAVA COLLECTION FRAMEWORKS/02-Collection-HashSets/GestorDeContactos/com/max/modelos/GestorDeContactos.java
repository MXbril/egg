package com.max.modelos;

import java.util.ArrayList;
import java.util.HashSet;

public class GestorDeContactos {
    private ArrayList<Contacto> listaContactos;
    private HashSet<Contacto> conjuntoContactos;
    
    public GestorDeContactos() {
        listaContactos = new ArrayList<>();
        conjuntoContactos = new HashSet<>();
    }

    // Método para agregar contacto al ArrayList, asegurando que no haya duplicados
    public void agregarContactoArrayList(Contacto contacto) {
        if (!listaContactos.contains(contacto)) {
            listaContactos.add(contacto);
            System.out.println("Contacto agregado al ArrayList.");
        } else {
            System.out.println("El contacto ya existe en el ArrayList.");
        }
        mostrarContactosArrayList();
    }

    // Método para eliminar contacto del ArrayList
    public void eliminarContactoArrayList(String nombre) {
        Contacto contactoAEliminar = buscarContactoEnArrayList(nombre);
        if (contactoAEliminar != null) {
            listaContactos.remove(contactoAEliminar);
            System.out.println("Contacto eliminado del ArrayList.");
        } else {
            System.out.println("Contacto no encontrado en el ArrayList.");
        }
        mostrarContactosArrayList();
    }

    // Método para buscar contacto por nombre en ArrayList
    private Contacto buscarContactoEnArrayList(String nombre) {
        for (Contacto contacto : listaContactos) {
            if (contacto.getNombre().equals(nombre.toLowerCase())) {
                return contacto;
            }
        }
        return null;
    }

    // Método para agregar contacto al HashSet, sin duplicados por defecto
    public void agregarContactoHashSet(Contacto contacto) {
        if (conjuntoContactos.add(contacto)) {
            System.out.println("Contacto agregado al HashSet.");
        } else {
            System.out.println("El contacto ya existe en el HashSet.");
        }
        mostrarContactosHashSet();
    }

    // Método para eliminar contacto del HashSet
    public void eliminarContactoHashSet(String nombre) {
        Contacto contactoAEliminar = buscarContactoEnHashSet(nombre);
        if (contactoAEliminar != null) {
            conjuntoContactos.remove(contactoAEliminar);
            System.out.println("Contacto eliminado del HashSet.");
        } else {
            System.out.println("Contacto no encontrado en el HashSet.");
        }
        mostrarContactosHashSet();
    }

    // Método para buscar contacto por nombre en HashSet
    private Contacto buscarContactoEnHashSet(String nombre) {
        for (Contacto contacto : conjuntoContactos) {
            if (contacto.getNombre().equals(nombre.toLowerCase())) {
                return contacto;
            }
        }
        return null;
    }

    // Método para mostrar contactos en ArrayList
    public void mostrarContactosArrayList() {
        System.out.println("Contactos en ArrayList:");
        if (listaContactos.isEmpty()) {
            System.out.println("No hay contactos en la lista.");
        } else {
            for (Contacto contacto : listaContactos) {
                System.out.println(contacto);
            }
        }
    }

    // Método para mostrar contactos en HashSet
    public void mostrarContactosHashSet() {
        System.out.println("Contactos en HashSet:");
        if (conjuntoContactos.isEmpty()) {
            System.out.println("No hay contactos en el conjunto.");
        } else {
            for (Contacto contacto : conjuntoContactos) {
                System.out.println(contacto);
            }
        }
    }
}
