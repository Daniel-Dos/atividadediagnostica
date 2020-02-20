package br.com.mastertech.danieldias.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mastertech.danieldias.model.Mensagem;
import br.com.mastertech.danieldias.model.Usuario;
import br.com.mastertech.danieldias.service.UsuarioService;

@RestController
@RequestMapping("api/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("usuarios")
    public ResponseEntity<List<Usuario>> obtemTodosUsuarios() {
        return new ResponseEntity<List<Usuario>>(usuarioService.obtemTodosUsuarios(), HttpStatus.OK);
    }

    @PostMapping("usuarios")
    public ResponseEntity<Mensagem> cadastraUsuarios(@RequestBody @Valid Usuario usuario) {
        this.usuarioService.cadastraUsuario(usuario);
        return new ResponseEntity<Mensagem>(new Mensagem(usuario.getNomeCompleto() + " Cadastrado com Sucesso"),
                HttpStatus.CREATED);
    }
    
    @PutMapping("usuarios")
    public ResponseEntity<Mensagem> atualizaUsuarios(@RequestBody @Valid Usuario usuario) {
        this.usuarioService.atualizaUsuario(usuario);
        return new ResponseEntity<Mensagem>(new Mensagem(usuario.getNomeCompleto() + " Atualizado com Sucesso"), HttpStatus.OK);
    }

    @GetMapping("usuarios/{id}")
    public ResponseEntity<?> cadastraOUsuarios(@PathVariable("id") int id) {
        return new ResponseEntity<Usuario>(this.usuarioService.obtemUsuario(id).get(), HttpStatus.OK);
    }
}