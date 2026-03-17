# 💧 API de Tabela Tarifária de Água - Desafio Técnico

Esta é uma API REST desenvolvida em Spring Boot para gerenciar tabelas tarifárias de água e calcular progressivamente o valor da conta com base no consumo e na categoria do cliente.

## 🛠️ Pré-requisitos
Certifique-se de ter instalado em sua máquina:
* **Java 17** (ou superior)
* **Maven**
* **PostgreSQL**

## 🗄️ Configuração do Banco de Dados
1. Abra sua ferramenta de preferência para o PostgreSQL.
2. Crie um banco de dados vazio com o nome: `gsan_tarifas`.
3. No projeto, abra o arquivo `src/main/resources/application.properties` e ajuste o usuário e a senha do banco de acordo com a sua máquina local:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/gsan_tarifas
spring.datasource.username=postgres
spring.datasource.password=senha
```

*(O Spring Boot com Hibernate JPA está configurado com `update`, então as tabelas serão criadas automaticamente ao rodar o projeto pela primeira vez).*

## 🚀 Como Executar e Testar a Aplicação
1. Clone o repositório em sua máquina.
2. Abra a pasta raiz do projeto na sua IDE.
3. Execute a classe principal `TarifasApplication.java` ou rode o comando maven: `./mvnw spring-boot:run`.
4. A API estará disponível no endereço: `http://localhost:8080`.

---

## 📚 Documentação Interativa (Swagger)
Após iniciar a aplicação, você pode visualizar e testar todos os endpoints diretamente pelo navegador,acessando o link abaixo:

👉 **[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)**

---

