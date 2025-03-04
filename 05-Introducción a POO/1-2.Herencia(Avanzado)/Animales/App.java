import java.util.ArrayList;
import java.util.List;

import dato.modelos.Animal;
import dato.modelos.Gato;
import dato.modelos.Perro;

public class App {

    public static void main(String[] args) {

        List<Animal> animales = new ArrayList<>();

        animales.add(new Perro("Scooby", 3, "Gran danés"));
        animales.add(new Perro("Bobby", 5, "Pastor Alemán"));
        animales.add(new Perro("Charlie", 4, "Bulldog"));
        animales.add(new Perro("toby", 9, "Beagle"));
        animales.add(new Perro("Rocky", 4, "Poodle"));

        animales.add(new Gato("Ton", 2, "Gris"));
        animales.add(new Gato("Simba", 3, "Blanco"));
        animales.add(new Gato("Leo", 2, "Negro"));
        animales.add(new Gato("Michi", 4, "Atigrado"));
        animales.add(new Gato("Mimi", 2, "Naranja"));

        for (Animal animal : animales) {
            if (animal instanceof Perro) {
                Perro perro = (Perro) animal;
                System.out.println("Es un perro:");
                perro.comer();
                perro.dormir();
                perro.ladrar();
                perro.mostrarDetalles();
            } else if (animal instanceof Gato) {
                Gato gato = (Gato) animal;
                System.out.println("Es un gato:");
                gato.comer();
                gato.dormir();
                gato.maullar();
                gato.mostrarDetalles();
            }
            System.out.println();
        }

        // Perro perro = new Perro("Scooby", 3, "Gran danés");
        // Perro perro2 = new Perro("Scooby", 3, "Gran danés");

        // perro.comer();
        // perro.dormir();
        // perro.ladrar();
        // perro.mostrarDetalles();

        // System.out.println("¿perro es igual a perro2? " +perro.equals(perro2));
        // System.out.println("HashCode de perro: " + perro.hashCode());
        // System.out.println("HashCode de perro2 " +perro2.hashCode());


        // Gato gato = new Gato("Ton", 2, "Gris");
        // gato.comer();
        // gato.dormir();
        // gato.maullar();
        // gato.mostrarDetalles();
    }
}