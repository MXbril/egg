package com.egg.libreriaapi.entidades;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Libro {
    @Id
    private Long isbn;

    private Integer ejemplares;

    @Column(name = "libro_activo", nullable = false)
    private boolean libroActivo;

    private String titulo;

    @ManyToOne // Relación con Autor
    @JoinColumn(name = "autor_id") // Clave foránea
    private Autor autor;

    @ManyToOne // Relación con Editorial
    @JoinColumn(name = "editorial_id") // Clave foránea
    private Editorial editorial;
}
