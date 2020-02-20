# atividade diagnostica

EndPoint para Usuario :


GET - Lista Usuarios = `http://localhost:8080/api/usuarios`

GET - Buscar usuario por id = `http://localhost:8080/api/usuarios/{id}`

PUT - Editar um usuario = `http://localhost:8080/api/usuarios`

POST - Criar um usuario = `http://localhost:8080/api/usuarios`


### Exemplo de Post


----
	   {
        "nomeCompleto": "Daniel Dias",
        "cpf": "10",
        "email": "daniel@gmail.com",
        "dataCadastro": "2020-02-19"
       }
----

EndPoint para Ponto :


GET - Lista Pontos = `http://localhost:8080/api/ponto`

POST - Criar um ponto = `http://localhost:8080/api/ponto`

### Exemplo de Post


----
	  {
        "usuario":{
        	"id":1
        },
        "tipoBatida": "ENTRADA",
        "dataHoraBatida": "2020-02-19 21:46:04"
      }
----
