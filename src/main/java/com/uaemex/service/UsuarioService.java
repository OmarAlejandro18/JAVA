package com.uaemex.service;

import com.uaemex.model.Usuario;
import java.util.ArrayList;
import java.util.Optional;

public interface UsuarioService {
    ArrayList <Usuario> obtenerUsuarios();
    Optional <Usuario> buscarUsuario(long id);
    Usuario insertarUsuario(Usuario u);
    boolean eliminarUsuario(long id);
}
