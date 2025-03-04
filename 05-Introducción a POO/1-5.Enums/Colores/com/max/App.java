package com.max;
import com.max.modelos.Color;
import com.max.modelos.ConvertidorColor;

public class App {

    public static void main(String[] args) {
        String[] valoresHexadecimales = {
            "#FF0000",  // ROJO
            "#00FF00",  // No es un color primario
            "#0000FF",  // AZUL
            "#FFFF00",  // AMARILLO
            "#123456"   // No es un color primario
        };

        for (String valorHex : valoresHexadecimales) {
            Color color = ConvertidorColor.convertirHexadecimal(valorHex);
            String mensaje = (color != null) ? color.name() : "No es un color primario";
            System.out.println(valorHex+ ": " +mensaje);
        }
    }    
}