package br.com.mastertech.danieldias;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.mastertech.danieldias.service.PontoService;
import br.com.mastertech.danieldias.service.UsuarioService;
import br.com.mastertech.danieldias.service.impl.PontoServiceImpl;
import br.com.mastertech.danieldias.service.impl.UsuarioServiceImpl;

@Configuration
public class ConfigurarionApplication {

    @Bean
    public PontoService pontoServiceBean() {
        return new PontoServiceImpl();
    }
    
    @Bean
    public UsuarioService usuarioServiceBean() {
        return new UsuarioServiceImpl();
    }
}
