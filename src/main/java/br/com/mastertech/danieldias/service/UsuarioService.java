package br.com.mastertech.danieldias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.mastertech.danieldias.model.Usuario;

@Service
public interface UsuarioService {

    Usuario cadastraUsuario(Usuario usuario);
    List<Usuario> obtemTodosUsuarios();
    Optional<Usuario> obtemUsuario(int id);
    void atualizaUsuario(Usuario usuario);
}
