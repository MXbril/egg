package com.max;
import java.util.Random;
import com.max.modelos.DiaSemana;

public class App {

    public static void main(String[] args) {
        DiaSemana[] dias = new DiaSemana[10];
        Random random = new Random();

        for (int i = 0; i < dias.length; i++) {
            int randomIndex = random.nextInt(DiaSemana.values().length);
            dias[i] = DiaSemana.values()[randomIndex];
        }

        for (DiaSemana dia : dias) {
            System.out.println(ImprimirDiaLaboral(dia));
        }
    }
    
    public static String ImprimirDiaLaboral(DiaSemana dia) {
        return dia+ ": " +(dia.esDiaLaboral() ? "Día laboral" : "No es día laboral"); 
    }
}