package br.com.mastertech.danieldias.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.mastertech.danieldias.model.Ponto;
import br.com.mastertech.danieldias.repositorio.PontoRepositorio;
import br.com.mastertech.danieldias.service.PontoService;

public class PontoServiceImpl implements PontoService {

    @Autowired
    private PontoRepositorio pontoRepositorio;
 
    @Override
    public void cadastraPonto(Ponto ponto) {
        this.pontoRepositorio.save(ponto);
    }

    @Override
    public List<Ponto> obtemPonto() {
        return pontoRepositorio.findAll();
    }
}