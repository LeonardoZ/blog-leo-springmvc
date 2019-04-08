# Blog-Leo - Escrevendo um blog simples com Spring MVC

Esse projeto é um pequeno blog, usado para demonstrar o funcionamento do Spring 4 e do Spring MVC.

## Requisitos

- OpenJDK 8
- MySQL 5.7+
- Maven 3.x+
- Docker 18.xx+
- Docker Compose 1.22+

## Executando

A execução desse projeto é feita utilizando as ferramentas **docker** e **docker-compose**, que fornecem todas as dependendências (java 8, MySQL e Maven) para que o projeto rode.

### Preparando os containers (Configuração de desenvolvimento)

Construa os containers para poder executá-los posteriormente

Linux

`./build-container.sh`

Outros SOs

`docker-compose -f "docker-compose.yml" build`

O MySQL usa um volume que mapeia a pasta ./docker/mysql-data, e, devido um problema de permissões, pode ser necessário, ao executar o comando de build outras vezes, executar o comando com níveis de permissão mais elevados, ou, como alternativa, deletar a pasta para que seja recriada (ocasiona perda dos sesus dados).


### Executando aplicação (Configuração de desenvolvimento)

Linux

`./run-container.sh`

Outros SOs:

`docker-compose -f "docker-compose.yml" up -d`

### Desligando a aplicação (Configuração de desenvolvimento)

Linux 

`./shutdown-container.sh`

Outro SOs:

`docker-compose down -v`

## Usando a aplicação

No seu localhost, estarão disponíveis duas URLs principais:
- http://localhost:8080/blogleo/blog (endereço do blog principal)
- http://localhost:8080/blogleo/cp (endereço do control panel cp)
- http://localhost:8080/blogleo/login (login para o control panel cp)

Um usuário padrão é criado na primeira execução da aplicação, contendo as credenciais:
- e-mail: admin@admin.com
- senha: 123456

É possível alterar essas informações e adicionar novos usuários pela aplicação.