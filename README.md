# Projeto E-diaristas Administrativo

Projeto desenvolvido no curso Multi Stack da [Treinaweb](https://www.treinaweb.com.br/) utilizando Java e Spring Boot.

## Dependências do projeto

- Spring Boot
- Spring Web MVC
- Thymeleaf
- Spring Data JPA
- Bean Validation

## Dependências do projeto

- Spring Boot Devtools

## Requisitos

- Java 11
- Maven

## Como testar esse projeto na minha máquina?

Clone este repositório e entre na pasta do projeto.

```sh
git clone https://github.com/PauloMtz/multistack-treinaweb-administrativo-java
cd e-diaristas
```

Atualize as configurações de acesso ao banco de dados no arquivo [application.properties](src/main/resources/application.properties).

```properties
spring.datasource.url=jdbc:mysql://host:porta/database
spring.datasource.username=username
spring.datasource.password=password
```

Execute o projeto utilizando o Maven (pelo terminal):

```sh
mvn spring-boot:run
```

Acesse a aplicação em [http://localhost:8080/admin/servicos](http://localhost:8080/admin/servicos)
