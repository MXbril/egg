package com.max.modelos;
import java.util.Scanner;

public class PalabraClave {
    private String clave;

    public void ingresarPalabraClave() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una palabra clave: ");
        clave = sc.nextLine();

        try {
            validarPalabraClave(clave);
            System.out.println("La palabra clave es válida para ser utilizada.");
        } catch (LongitudInvalidaException | FormatoInvalidoException e) {
            System.out.println("Error: " +e.getMessage());
        } finally {
            sc.close();
        }
    }

    private void validarPalabraClave(String clave) throws LongitudInvalidaException, FormatoInvalidoException {
        if (clave.length() < 8) {
            throw new LongitudInvalidaException("La palabra clave debe tener al menos 8 caracteres.");
        }
        int contadorNumeros = 0;
        boolean contieneZ = false;

        for (char c : clave.toCharArray()) {
            if (Character.isDigit(c)) {
                contadorNumeros++;
            } else if (c == 'z' || c == 'Z') {
                contieneZ = true;
            }
        }

        if (contadorNumeros != 4) {
            throw new FormatoInvalidoException("La palabra clave debe contener exactamente 4 números.");
        }

        if (!contieneZ) {
            throw new FormatoInvalidoException("La palabra clave debe contener la letra 'z'.");
        }
    }


}
