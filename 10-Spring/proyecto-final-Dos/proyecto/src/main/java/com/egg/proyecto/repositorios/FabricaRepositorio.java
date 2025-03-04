package com.egg.proyecto.repositorios;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egg.proyecto.entidades.Fabrica;


@Repository
public interface FabricaRepositorio extends JpaRepository<Fabrica, UUID> {
    
}
