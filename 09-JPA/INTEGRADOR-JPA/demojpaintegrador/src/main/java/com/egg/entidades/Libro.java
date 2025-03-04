package com.egg.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {
    
    @Id
    private Long isbn;

    @Column(nullable = false, length = 255)
    private String titulo; // Título del libro

    @Column(nullable = false)
    private Integer anio; // Año de publicación

    @Column(nullable = false)
    private Integer ejemplares; // Cantidad total de ejemplares

    @Column(nullable = false)
    private Boolean activo = true; // Estado activo, por defecto true

    @ManyToOne // Relación con Autor
    @JoinColumn(name = "autor_id") // Clave foránea
    private Autor autor;

    @ManyToOne // Relación con Editorial
    @JoinColumn(name = "editorial_id") // Clave foránea
    private Editorial editorial;

    public Libro() {
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }



}
