package br.com.mastertech.danieldias.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PontoControllerTest {

    @Autowired
    private MockMvc mvc;
    
    private String jsonPonto = "{\n" + 
            "        \"usuario\":{\n" + 
            "            \"id\":1\n" + 
            "        },\n" + 
            "        \"tipoBatida\": \"ENTRADA\",\n" + 
            "        \"dataHoraBatida\": \"2020-02-19 21:46:04\"\n" + 
            "    }";
    
    @Test
    public void registraPonto() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/api/ponto")
                .content(jsonPonto)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$['usuario'].['id']",is(1)))
                .andExpect(jsonPath("$['usuario'].['nomeCompleto']",is("danielDias")))
                .andExpect(jsonPath("$['usuario'].['cpf']",is("11")))
                .andExpect(jsonPath("$['usuario'].['email']",is("daniel@gmail.com")))
                .andExpect(jsonPath("$['usuario'].['dataCadastro']",is("2020-02-19")))
                .andExpect(jsonPath("tipoBatida",is("ENTRADA")))
                .andExpect(jsonPath("dataHoraBatida",is("2020-02-19 21:46:04")));
    }
    
    @Test
    public void deveRetornarConteudoNaLista() throws Exception {
        
        mvc.perform(MockMvcRequestBuilders.post("/api/ponto")
                .content(jsonPonto)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                
                .andExpect(jsonPath("$['usuario'].['id']",is(1)))
                .andExpect(jsonPath("$['usuario'].['nomeCompleto']",is("danielDias")))
                .andExpect(jsonPath("$['usuario'].['cpf']",is("11")))
                .andExpect(jsonPath("$['usuario'].['email']",is("daniel@gmail.com")))
                .andExpect(jsonPath("$['usuario'].['dataCadastro']",is("2020-02-19")))
                .andExpect(jsonPath("tipoBatida",is("ENTRADA")))
                .andExpect(jsonPath("dataHoraBatida",is("2020-02-19 21:46:04")));

       mvc.perform(MockMvcRequestBuilders.get("/api/ponto")
                                         .accept(MediaType.APPLICATION_JSON))
                                         .andDo(print())
                                         .andExpect(status().isOk())
                                         .andExpect(jsonPath("$.*",hasSize(1)));               
    }
}