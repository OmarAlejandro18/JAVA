package com.uaemex.controllers;

import com.uaemex.model.Usuario;
import com.uaemex.service.UsuarioService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiDemo {
    
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/saludo")
    public String saludar(){
        return "Hola Mundo desde spring";
    }
    
    @GetMapping("/usuarios")
    public ArrayList<Usuario> obtUsuarios(){
        return usuarioService.obtenerUsuarios();
    }
    
    @GetMapping("/buscar/{id}")
    public Optional<Usuario> bUsuarioId(@PathVariable("id") long id){
        return usuarioService.buscarUsuario(id);
    }
    
    @PostMapping("/insertar")
    public Usuario insUsuario(@RequestBody Usuario u){
        return usuarioService.insertarUsuario(u);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public String elimUsuario(@PathVariable("id") long id){
        if (usuarioService.eliminarUsuario(id)){
            return "Se ha eliminado el usuario";
        }else{
            return "No se ha eliminado el usuario";
        }
    }
}
