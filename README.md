# Spring Boot 3

# Sobre o projeto

Este projeto faz parte do curso de Java de Nélio Alves pela Udemy. Contempla uma introdução ao Spring Boot 3 com JPA Hibernate.

## Objetivos

- Criar projeto Spring Boot Java
- Implementar modelo de domínio
- Estruturar camadas lógicas: resource, service, repository
- Configurar banco de dados de teste (H2)
- Povoar o banco de dados
- CRUD - Create, Retrieve, Update, Delete
- Tratamento de exceções

## H2-Console
<div align="center">
<img src="/../readme/Captura de Tela (43).png" alt="image 1" width=500 height=400>
<img src="/../readme/Captura de Tela (44).png" alt="image 2" width=765 height=650>
</div>

## Modelo conceitual
<img src="/../readme/Captura de Tela (45).png" alt="image 2" width=700 height=380>
<img src="/../readme/Captura de Tela (46).png" alt="image 2" width=880 height=500>

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven

## Implantação em produção
- Banco de dados: H2

## Teste API REST
- Postman

# Como executar o projeto

## Back end
Pré-requisitos: Java 18

```bash
# clonar repositório
git clone https://github.com/MarcosAndreBueno/springboot3.git

# entrar na pasta do projeto back end
cd backend

# executar o projeto
./mvnw spring-boot:run
```

## executar localmente
http://localhost:8080/h2-console/

    - Driver Class:	org.h2.Driver 
    - JDBC URL: jdbc:h2:mem:testdb
    - username: sa
    - password:

# Observação:
Por conta da não gratuidade do Heroku, este projeto não contempla o front.
Um projeto com implementação Front end usando Heroku pode ser encontrado aqui https://github.com/MarcosAndreBueno/dsmeta
