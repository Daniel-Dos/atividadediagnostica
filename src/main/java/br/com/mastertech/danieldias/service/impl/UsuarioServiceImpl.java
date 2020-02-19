package br.com.mastertech.danieldias.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.mastertech.danieldias.model.Usuario;
import br.com.mastertech.danieldias.repositorio.UsuarioRepositorio;
import br.com.mastertech.danieldias.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public void cadastraUsuario(Usuario usuario) {
       this.usuarioRepositorio.save(usuario);
    }

    @Override
    public List<Usuario> obtemTodosUsuarios() {
        return this.usuarioRepositorio.findAll();
    }

    @Override
    public Usuario obtemUsuario(int id) {
        return null;
    }

    @Override
    public void atualizaUsuario(Usuario usuario) {
    
    }
}