package com.uaemex.service;

import com.uaemex.model.Usuario;
import com.uaemex.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        return (ArrayList<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> buscarUsuario(long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario insertarUsuario(Usuario u) {
        return usuarioRepository.save(u);
    }

    @Override
    public boolean eliminarUsuario(long id) {
        try {
            Optional<Usuario> u = buscarUsuario(id);
            usuarioRepository.delete(u.get());
            return true;
        } catch (Exception e) {
            return false;
        }
    }   
}
