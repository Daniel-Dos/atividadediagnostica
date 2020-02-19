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

import br.com.mastertech.danieldias.model.Usuario;
import br.com.mastertech.danieldias.service.UsuarioService;

@RestController
@RequestMapping("api/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
 
    @GetMapping("usuarios")
    public ResponseEntity<List<Usuario>> obtemTodosUsuarios() {
        return new ResponseEntity<List<Usuario>>(usuarioService.obtemTodosUsuarios(),HttpStatus.OK);
    }
    
    @PostMapping("usuarios")
    public ResponseEntity<String> cadastraOUsuarios(@RequestBody Usuario usuario) {
        this.usuarioService.cadastraUsuario(usuario);
        return new ResponseEntity<String>("Usuario Cadastrado com Sucesso",HttpStatus.CREATED);
    }
}