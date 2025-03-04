package com.egg.libreriaapi.excepciones;

public class CustomException extends RuntimeException {
    // Constructor para aceptar un mensaje de error
    public CustomException(String message) {
        super(message);  // Llamada al constructor de RuntimeException
    }
}
