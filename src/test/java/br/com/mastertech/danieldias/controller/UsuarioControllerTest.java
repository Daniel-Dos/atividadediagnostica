package br.com.mastertech.danieldias.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mvc;

    
    private String json = "  {\n" + 
            "        \n" + 
            "        \"nomeCompleto\": \"daniel\",\n" + 
            "        \"cpf\": \"10\",\n" + 
            "        \"email\": \"daniel@gmail.com\",\n" + 
            "        \"dataCadastro\": \"2020-02-19\"\n" + 
            "    }";
    

    private String jsonNovo = "  {\n" + 
            "        \n" + 
            "        \"nomeCompleto\": \"danielSantos\",\n" + 
            "        \"cpf\": \"10\",\n" + 
            "        \"email\": \"daniel@gmail.com\",\n" + 
            "        \"dataCadastro\": \"2020-02-19\"\n" + 
            "    }";
    
    private String jsonUpdate = "{\n" + 
            "    \"id\": 1,\n" + 
            "    \"nomeCompleto\": \"danielDias\",\n" + 
            "    \"cpf\": \"11\",\n" + 
            "    \"email\": \"daniel@gmail.com\",\n" + 
            "    \"dataCadastro\": \"2020-02-19\"\n" + 
            "}";
    @Test
    public void deveRetornarUmaListVazia() throws Exception {

        MvcResult result = 
                  mvc.perform(MockMvcRequestBuilders.get("/api/usuarios")
                                                    .accept(MediaType.APPLICATION_JSON))
                                                    .andDo(print())
                                                    .andExpect(status().isOk())
                                                    .andReturn();
        
        assertEquals(result.getResponse().getContentLength(), 0);

    }
    
    @Test
    public void adicionaUsuario() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/api/usuarios")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nomeCompleto",is("daniel")))
                .andExpect(jsonPath("$.cpf",is("10")))
                .andExpect(jsonPath("$.email",is("daniel@gmail.com")))
                .andExpect(jsonPath("$.dataCadastro",is("2020-02-19")));
                
    }
    
    @Test
    public void deveRetornarConteudoNaLista() throws Exception {
        
       mvc.perform(MockMvcRequestBuilders.get("/api/usuarios")
                                         .accept(MediaType.APPLICATION_JSON))
                                         .andDo(print())
                                         .andExpect(status().isOk())
                                         .andExpect(jsonPath("$.*",hasSize(1)));
                
    }
   
    @Test
    public void atualizaUsuario() throws Exception {
        
        mvc.perform(MockMvcRequestBuilders.post("/api/usuarios")
                .content(jsonNovo)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
        
        mvc.perform(MockMvcRequestBuilders.put("/api/usuarios")
                .content(jsonUpdate)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nomeCompleto",is("danielDias")))
                .andExpect(jsonPath("$.cpf",is("11")))
                .andExpect(jsonPath("$.email",is("daniel@gmail.com")))
                .andExpect(jsonPath("$.dataCadastro",is("2020-02-19")));
    }
    
    @Test
    public void deveRetornarUmUsuarioPorId() throws Exception {
        
        mvc.perform(MockMvcRequestBuilders.get("/api/usuarios/{id}",1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nomeCompleto",is("danielDias")))
                .andExpect(jsonPath("$.cpf",is("11")))
                .andExpect(jsonPath("$.email",is("daniel@gmail.com")))
                .andExpect(jsonPath("$.dataCadastro",is("2020-02-19")));
    }
    
}