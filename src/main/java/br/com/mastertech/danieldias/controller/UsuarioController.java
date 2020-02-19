package br.com.mastertech.danieldias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mastertech.danieldias.mastertech.repositorio.UsuarioRepositorio;
import br.com.mastertech.danieldias.model.Usuario;

@RestController
@RequestMapping("api/")
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
 
    @GetMapping("usuarios")
    public ResponseEntity<List<Usuario>> obtemTodosUsuarios() {
        return new ResponseEntity<List<Usuario>>(usuarioRepositorio.findAll(),HttpStatus.OK);
    }
}