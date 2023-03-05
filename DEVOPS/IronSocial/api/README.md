Endpoints da API de Rede Social
===============================

A seguir, estão listados os endpoints disponíveis na API de Rede Social:

### Criação de usuário

* Método: POST
* Endpoint: [http://localhost:8080/usuarios](http://localhost:8080/usuarios)

### Login do usuário

* Método: POST
* Endpoint: [http://localhost:8080/login](http://localhost:8080/login)

### Solicitações de amizade

* Método: POST
* Endpoint: [http://localhost:8080/social/amizade/solicitacoes](http://localhost:8080/social/amizade/solicitacoes)
* Descrição: cria uma solicitação de amizade entre dois usuários

### Aceitar solicitação de amizade

* Método: POST
* Endpoint: [http://localhost:8080/social/amizade/solicitacoes/{{id}}](http://localhost:8080/social/amizade/solicitacoes/%7B%7Bid%7D%7D)
* Descrição: aceita uma solicitação de amizade

### Recusar solicitação de amizade

* Método: DELETE
* Endpoint: [http://localhost:8080/social/amizade/solicitacoes/{{id}}](http://localhost:8080/social/amizade/solicitacoes/%7B%7Bid%7D%7D)
* Descrição: recusa uma solicitação de amizade

### Remover amizade

* Método: DELETE
* Endpoint: [http://localhost:8080/social/amizade/{{id}}](http://localhost:8080/social/amizade/%7B%7Bid%7D%7D)
* Descrição: remove uma amizade existente

### Pesquisar usuários

* Método: GET
* Endpoint: [http://localhost:8080/social/pesquisar](http://localhost:8080/social/pesquisar)
* Descrição: retorna uma lista de usuários de acordo com os parâmetros informados

### Informações do usuário

* Método: GET
* Endpoint: [http://localhost:8080/social/{{id}}](http://localhost:8080/social/%7B%7Bid%7D%7D)
* Descrição: retorna informações do usuário especificado

### Atualizar informações do usuário

* Método: PUT
* Endpoint: [http://localhost:8080/social/{{id}}](http://localhost:8080/social/%7B%7Bid%7D%7D)
* Descrição: atualiza as informações do usuário especificado

### Lista de amizades do usuário

* Método: GET
* Endpoint: [http://localhost:8080/social/{{id}}/amizades](http://localhost:8080/social/%7B%7Bid%7D%7D/amizades)
* Descrição: retorna uma lista de amizades do usuário especificado

### Feed do usuário

* Método: GET
* Endpoint: [http://localhost:8080/social/{{id}}/feed](http://localhost:8080/social/%7B%7Bid%7D%7D/feed)
* Descrição: retorna o feed de publicações do usuário especificado

### Lista de publicações do usuário

* Método: GET
* Endpoint: [http://localhost:8080/social/{{id}}/publicacoes](http://localhost:8080/social/%7B%7Bid%7D%7D/publicacoes)
* Descrição: retorna uma lista de publicações do usuário especificado

### Criar publicação

* Método: POST
* Endpoint: [http://localhost:8080/publicacoes](http://localhost:8080/publicacoes)
* Descrição: cria uma nova publicação

### Comentar publicação

* Método: POST
* Endpoint: [http://localhost:8080/publicacoes/comentar](http://localhost:8080/publicacoes/comentar)
* Descrição: adiciona um comentário à publicação especificada

### Curtir publicação

* Método: POST
* Endpoint: [http://localhost:8080/publicacoes/curtir](http://localhost:8080/publicacoes/curtir)
* Descrição: adiciona uma curtida à publicação especificada

### Descurtir publicação

* Método: DELETE
* Endpoint: [http://localhost:8080/publicacoes/descurtir](http://localhost:8080/publicacoes/descurtir)
* Descrição: remove a curtida da publicação especificada

### Lista de comentários da publicação

* Método: GET
* Endpoint: [http://localhost:8080/publicacoes/{{id}}/comentarios](http://localhost:8080/publicacoes/%7B%7Bid%7D%7D/comentarios)
* Descrição: retorna uma lista de comentários da publicação especificada

### Lista de curtidas da publicação

* Método: GET
* Endpoint: [http://localhost:8080/publicacoes/{{id}}/curtidas](http://localhost:8080/publicacoes/%7B%7Bid%7D%7D/curtidas)