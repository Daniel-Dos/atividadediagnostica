package br.com.mastertech.danieldias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mastertech.danieldias.model.Mensagem;
import br.com.mastertech.danieldias.model.Ponto;
import br.com.mastertech.danieldias.service.PontoService;

@RestController
@RequestMapping("api/")
public class PontoController {

    @Autowired
    private PontoService pontoService;

    @PostMapping("ponto")
    public ResponseEntity<Mensagem> resgistrarPonto(@RequestBody Ponto ponto) {
        this.pontoService.cadastraPonto(ponto);
        return new ResponseEntity<Mensagem>(new Mensagem(ponto.getUsuario().getNomeCompleto() + " Registrado com Sucesso"), HttpStatus.CREATED);
    }
    
    @GetMapping("ponto")
    public ResponseEntity<List<Ponto>> obtemPonto() {
        return new ResponseEntity<List<Ponto>>(pontoService.obtemPonto(), HttpStatus.CREATED);
    }
}
