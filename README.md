#Sistema de contas
##Sistema que compreende:

- Armazenar os dados dos clientes (Pessoas)
- Armazenar os dados das contas
- Realizar transações entre as contas
##Tecnologias utilizadas:

- Spring Boot
- Spring-data
- Hibernate
- Jackson 2
- Embedded Jetty
###Para os testes Unitarios
- Junit
- Spring-test
###Para os testes Integrados
- Junit
- Spring-test
### Banco de dados
- MySql

##Serviços
- Os serviços estão documentados com o swagger: http://localhost:8080/sistema-contas/swagger-ui.html#
- Na aplicação, os servicos estão documentados atraves dos testes integrados


###Passo a passo:

* Criar banco de dados:
```
create database odara7;

```

* Atualizar os dados do datasource (url, username, password) nos arquivos ./sistema-contas/src/main/resources/application.properties
```
server.port=8080
server.servlet.context-path=/sistema-contas
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3307/odara7
spring.datasource.username = root
spring.datasource.password =
spring.jpa.show-sql = true
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto = update
```

* Compilar o projeto
Entre na pasta ./sistem-contas
Execute:
```
mvn package
```
* Execute o projeto:
```
mvn spring-boot:run
```