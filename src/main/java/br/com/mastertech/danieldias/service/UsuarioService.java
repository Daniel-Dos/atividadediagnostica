package br.com.mastertech.danieldias.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mastertech.danieldias.model.Usuario;

@Service
public interface UsuarioService {

    void cadastraUsuario(Usuario usuario);
    List<Usuario> obtemTodosUsuarios();
    Usuario obtemUsuario(int id);
    void atualizaUsuario(Usuario usuario);
}
