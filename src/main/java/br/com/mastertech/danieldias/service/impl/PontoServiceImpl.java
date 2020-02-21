package br.com.mastertech.danieldias.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.mastertech.danieldias.model.Ponto;
import br.com.mastertech.danieldias.model.Usuario;
import br.com.mastertech.danieldias.repositorio.PontoRepositorio;
import br.com.mastertech.danieldias.service.PontoService;
import br.com.mastertech.danieldias.service.UsuarioService;

public class PontoServiceImpl implements PontoService {

    @Autowired
    private PontoRepositorio pontoRepositorio;
    
    @Autowired
    private UsuarioService usuarioService;
 
    @Override
    public void cadastraPonto(Ponto ponto) {
        Optional<Usuario> user = this.usuarioService.obtemUsuario(ponto.getUsuario().getId());
        
        ponto.setUsuario(user.get());
        this.pontoRepositorio.save(ponto);
    }

    @Override
    public List<Ponto> obtemPonto() {
        return pontoRepositorio.findAll();
    }
}