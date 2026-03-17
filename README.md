# 💧 API de Tabela Tarifária de Água - Desafio Técnico

Esta é uma API REST desenvolvida em Spring Boot para gerenciar tabelas tarifárias de água e calcular progressivamente o valor da conta com base no consumo e na categoria do cliente.

## 🛠️ Pré-requisitos
Certifique-se de ter instalado em sua máquina:
* **Java 17** (ou superior)
* **Maven**
* **PostgreSQL** (versão 15 ou compatível)

## 🗄️ Configuração do Banco de Dados
1. Abra o pgAdmin (ou sua ferramenta de preferência para o PostgreSQL).
2. Crie um banco de dados vazio com o nome: `gsan_tarifas`.
3. No projeto, abra o arquivo `src/main/resources/application.properties` e ajuste o usuário e a senha do banco de acordo com a sua máquina local:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/gsan_tarifas
   spring.datasource.username=postgres
   spring.datasource.password=sua_senha_aqui
