package br.com.mastertech.danieldias.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.mastertech.danieldias.model.Usuario;
import br.com.mastertech.danieldias.service.UsuarioService;

@SpringBootTest
public class UsuarioServiceTest {

    @Autowired
    private UsuarioService usuarioServico;
    
    @Test
    public void deveSalvarUsuario() {
        
       Usuario usuario = new Usuario();
       usuario.setCpf("109");
       usuario.setData(LocalDate.now());
       usuario.setEmail("daniel@gmail.com");
       usuario.setNomeCompleto("Daniel");
       
       this.usuarioServico.cadastraUsuario(usuario);
       assertEquals(1, usuarioServico.obtemTodosUsuarios().size());
    }
    
    @Test
    public void deveRetornaUmUsuario() {
        
        Usuario usuario = new Usuario();
        usuario.setCpf("109");
        usuario.setData(LocalDate.now());
        usuario.setEmail("daniel@gmail.com");
        usuario.setNomeCompleto("Daniel");
        
        this.usuarioServico.cadastraUsuario(usuario);
        
        Optional<Usuario> novo = usuarioServico.obtemUsuario(1);
        assertEquals(usuario.getNomeCompleto(),novo.get().getNomeCompleto());
    }
}