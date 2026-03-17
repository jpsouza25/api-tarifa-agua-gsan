# 💧 API de Tabela Tarifária de Água - Desafio Técnico

[cite_start]Esta é uma API REST desenvolvida em Spring Boot para gerenciar tabelas tarifárias de água e calcular progressivamente o valor da conta com base no consumo e na categoria do cliente [cite: 3-4, 63]. O motor de cálculo garante que o cliente não seja cobrado por volume não consumido na faixa inicial.

## 🛠️ Pré-requisitos
[cite_start]Certifique-se de ter instalado em sua máquina[cite: 147]:
* [cite_start]**Java 17** (ou superior) [cite: 6]
* **Maven**
* [cite_start]**PostgreSQL** (versão 15 ou compatível) [cite: 8]

## 🗄️ Configuração do Banco de Dados
1. Abra sua ferramenta de preferência para o PostgreSQL (ex: pgAdmin).
2. Crie um banco de dados vazio com o nome: `gsan_tarifas`.
3. [cite_start]No projeto, abra o arquivo `src/main/resources/application.properties` e ajuste o usuário e a senha do banco de acordo com a sua máquina local[cite: 148]:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/gsan_tarifas
   spring.datasource.username=postgres
   spring.datasource.password=sua_senha_aqui

