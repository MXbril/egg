package com.egg.libreriaapi.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egg.libreriaapi.modelos.LibroCreateDTO;
import com.egg.libreriaapi.modelos.LibroListarActivosDTO;
import com.egg.libreriaapi.modelos.LibroModificarDTO;
import com.egg.libreriaapi.servicios.LibroServicio;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/libro")
public class LibroControlador {
    @Autowired
    private LibroServicio libroServicio;

    @PostMapping("/crear")
    public ResponseEntity<Object> crearLibro(@RequestBody LibroCreateDTO libroDTO) {
        try {
            libroServicio.crearLibro(libroDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"Algun dato no es correcto o es nulo, revisar.\"}");
        }
    }

    @PutMapping("/modificarDTO")
    public ResponseEntity<Object> modificarLibro(@RequestBody LibroModificarDTO libroModificarDTO) {
        try {
            libroServicio.modificarLibro(libroModificarDTO);
            return new ResponseEntity<>("El libro se modificó carrectamente.", HttpStatus.OK);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("{\"error\": \"No se encontró el libro, autor o editorial: " + ex.getMessage() + "\"}");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("{\"error\": \"Ocurrió un error al modificar un libro.\"}");
        }
    }

    @GetMapping("/listarActivos")
    public ResponseEntity<List<LibroListarActivosDTO>> listarLibrosActivos() {
        try {
            List<LibroListarActivosDTO> librosActivos = libroServicio.listarLibrosActivos();
            return new ResponseEntity<>(librosActivos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
