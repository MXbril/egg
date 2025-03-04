package com.egg.proyecto.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.egg.proyecto.entidades.Usuario;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, UUID> {
    @Query("SELECT u FROM Usuario u WHERE u.username = :username")
    public Usuario buscarPorUsername(@Param("username") String username);

    @Query("SELECT u FROM Usuario u WHERE u.id = :id")
    Usuario buscarPorId(@Param("id") UUID id);

    @Query("SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    Usuario buscarPorNombre(@Param("nombre") String nombre);

    @Query("SELECT u FROM Usuario u WHERE u.apellido = :apellido")
    Usuario buscarPorApellido(@Param("apellido") String apellido);
}
