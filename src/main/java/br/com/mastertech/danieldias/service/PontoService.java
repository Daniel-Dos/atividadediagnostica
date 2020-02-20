package br.com.mastertech.danieldias.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mastertech.danieldias.model.Ponto;

@Service
public interface PontoService {

    void cadastraPonto(Ponto ponto);
    List<Ponto> obtemPonto();
}
