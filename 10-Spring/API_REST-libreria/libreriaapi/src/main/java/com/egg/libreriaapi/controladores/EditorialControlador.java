package com.egg.libreriaapi.controladores;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egg.libreriaapi.entidades.Editorial;
import com.egg.libreriaapi.modelos.EditorialCreateDTO;
import com.egg.libreriaapi.servicios.EditorialServicio;

@RestController
@RequestMapping("/editorial")
public class EditorialControlador {
    @Autowired
    private EditorialServicio editorialServicio;

    @PostMapping("crear")
    public ResponseEntity<Object> crearEditorial(String nombre) {
        try {
            editorialServicio.crearEditorial(nombre);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("crearDTO")
    public ResponseEntity<Object> crearEditorial(@RequestBody EditorialCreateDTO editorialCreateDTO) {
        try {
            editorialServicio.crearEditorial(editorialCreateDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<Object> listar() {
        try {
            List<Editorial> editoriales = editorialServicio.listarEditorial();
            return new ResponseEntity<>(editoriales, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al listar editoriales",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listarEditorial/{id}")
    public ResponseEntity<Editorial> listarEditorial(@PathVariable UUID id) {
        try {
            Editorial editorial = editorialServicio.getOne(id);
            return ResponseEntity.ok(editorial);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/modificar")
    public ResponseEntity<Void> modificarEditorial(@RequestParam String nombre, @RequestParam UUID id) {
        try {
            editorialServicio.modificarEditorial(nombre, id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
