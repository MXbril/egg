package com.egg.proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.proyecto.excepciones.MiException;
import com.egg.proyecto.servicios.UsuarioServicio;

@Controller
@RequestMapping("/")
public class NuevoControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;


    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/registrar")
    public String registrar() {
        return "registro.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, String apellido, String username, String password, String password2, ModelMap modelo) {
        try {
            usuarioServicio.registrar(nombre, apellido, username, password, password2);
            modelo.put("exito", "Usuario registrado exitosamente!");
            return "index.html";
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("apellido", apellido);
            modelo.put("username", username);
            return "registro.html";
        }
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo) {
        if (error != null) {
            modelo.put("error", "Usuario o contraseña inválidos!");
        }
        return "login.html";
    }

    @GetMapping("/inicio")
    public String inicio() {
        return "inicio.html";
    }
}
