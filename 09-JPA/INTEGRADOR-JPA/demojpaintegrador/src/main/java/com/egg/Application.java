package com.egg;

public class Application {

    public static void main(String[] args) {

        MenuLibreria menu = new MenuLibreria();
        menu.mostrarMenu();

        // Cerrar el EntityManagerFactory
        EntityManagerUtil.closeEntityManagerFactory();
    }
}
