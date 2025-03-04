package com.egg.libreriaapi.modelos;

import java.util.UUID;

import lombok.Data;

@Data
public class LibroCreateDTO {
    private Long isbn;
    private Integer ejemplares;
    private String titulo;
    private UUID idAutor;
    private UUID idEditorial;
    private boolean libroActivo;
}
