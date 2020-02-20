package br.com.mastertech.danieldias.service.impl;

import java.util.List;
import java.util.Optional;

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
    public Optional<Usuario> obtemUsuario(int id) {
        return this.usuarioRepositorio.findById(id) ;
    }

    @Override
    public void atualizaUsuario(Usuario usuario) {
        Optional<Usuario> oldUsuario= obtemUsuario(usuario.getId());
        Usuario usuarioNovo = new Usuario();
        usuarioNovo.setNomeCompleto(usuario.getNomeCompleto());
        usuarioNovo.setEmail(usuario.getEmail());
        usuarioNovo.setData(oldUsuario.get().getDataCadastro());
        usuarioNovo.setCpf(usuario.getCpf());
        usuarioNovo.setId(oldUsuario.get().getId());
        this.usuarioRepositorio.save(usuarioNovo);
        
    }
}