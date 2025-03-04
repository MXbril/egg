package com.egg.libreriaapi.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.egg.libreriaapi.entidades.Libro;
import com.egg.libreriaapi.modelos.LibroListarActivosDTO;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {
    // @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    // Libro buscarPorTitulo(@Param("titulo") String titulo);

    // @Query("SELECT l FROM Libro l WHERE l.autor = :autor")
    // List<Libro> buscarPorAutor(@Param("autor") String autor);


    @Query("SELECT new com.egg.libreriaapi.modelos.LibroListarActivosDTO(l.titulo, l.ejemplares) " + 
            "FROM Libro l WHERE l.libroActivo = true")
    List<LibroListarActivosDTO> encontrarActivos();
}
