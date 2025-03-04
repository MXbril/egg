package com.egg.proyecto.servicios;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.proyecto.entidades.Fabrica;
import com.egg.proyecto.excepciones.MiException;
import com.egg.proyecto.repositorios.FabricaRepositorio;

@Service
public class FabricaServicio {
    @Autowired
    private FabricaRepositorio fabricaRepositorio;

    @Transactional
    public void crearFabrica(String nombre) throws MiException{
        validarFabrica(nombre);
        Fabrica fabrica = new Fabrica();

        fabrica.setNombre(nombre);

        fabricaRepositorio.save(fabrica);
    }

    @Transactional
    public void modificarFabrica(String nombre, UUID id ) throws MiException {
        validarFabrica(nombre);

        Optional<Fabrica> opcionalFabrica = fabricaRepositorio.findById(id);
        if (opcionalFabrica.isPresent()) {
            Fabrica fabrica = opcionalFabrica.get();
            fabrica.setNombre(nombre);

            fabricaRepositorio.save(fabrica);
        }
    }

    @Transactional(readOnly = true)
    public List<Fabrica> listarFabrica() {
        return fabricaRepositorio.findAll();
    }

    
    @Transactional(readOnly = true)
    public Fabrica getOne(UUID id){
        return fabricaRepositorio.getReferenceById(id);
    }

    public void validarFabrica(String nombre) throws MiException {
        if (nombre == null || nombre.isEmpty()) {
            throw new MiException("El nombre de la fabrica no puede ser nulo o estar vacio");
        }
    }
}
