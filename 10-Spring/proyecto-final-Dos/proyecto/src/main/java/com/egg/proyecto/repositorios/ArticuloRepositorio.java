package com.egg.proyecto.repositorios;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.egg.proyecto.entidades.Articulo;

@Repository
public interface ArticuloRepositorio extends JpaRepository<Articulo, UUID> {
    @Query("SELECT a FROM Articulo a WHERE a.nro = :nro")
    Articulo buscarPorNro(@Param("nro") Integer nro);

    @Query("SELECT a FROM Articulo a WHERE a.nombre = :nombre")
    List<Articulo> buscarPorNombre(@Param("nombre") String nombre);

    @Query("SELECT a FROM Articulo a WHERE a.descripcion = :descripcion")
    List<Articulo> buscarPorDescripcion(@Param("descripcion") String descripcion);

    @Query("SELECT COALESCE(MAX(a.nro), 0) FROM Articulo a")
    Integer obtenerUltimoNroArticulo();
}
