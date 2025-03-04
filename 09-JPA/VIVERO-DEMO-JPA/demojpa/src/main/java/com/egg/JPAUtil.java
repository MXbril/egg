package com.egg;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "ViveroPU";
    private static EntityManagerFactory emf;

    // Método para obtener la instancia de EntityManagerFactory
    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return emf;
    }

    // Método para cerrar el EntityManagerFactory
    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    // Método para obtener un nuevo EntityManager
    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
