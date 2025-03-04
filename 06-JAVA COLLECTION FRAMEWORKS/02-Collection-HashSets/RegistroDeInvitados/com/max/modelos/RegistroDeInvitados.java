package com.max.modelos;

import java.util.HashSet;

public class RegistroDeInvitados {
    private HashSet<String> invitados;

    // Constructor que inicializa el HashSet
    public RegistroDeInvitados() {
        invitados = new HashSet<>();
    }

    public void agregarInvitado(String nombre) {
        nombre = formatearNombre(nombre);
        if (invitados.add(nombre)) {
            System.out.println(nombre+ " ha sido agregado a la lista de invitados.");
        } else {
            System.out.println(nombre+ " ya está en la lista.");
        }
    }

    public void eliminarInvitado(String nombre) {
        nombre = formatearNombre(nombre);
        if (invitados.remove(nombre)) {
            System.out.println(nombre+ " ha sido eliminado de la lista.");
        } else {
            System.out.println(nombre+ " no está en la lista.");
        }
    }

    public void mostrarInvitados() {
        if (invitados.isEmpty()) {
            System.out.println("La lista de invitados esta vacía.");
        } else {
            System.out.println("Lista de invitados:");
            for (String invitado : invitados) {
                System.out.println("- " +invitado);
            }
        }
    }

    private String formatearNombre(String nombre) {
        return nombre.trim().toLowerCase();
    }

}
