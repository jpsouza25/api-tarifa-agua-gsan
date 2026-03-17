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
(O Spring Boot com Hibernate JPA está configurado com update, então as tabelas serão criadas automaticamente ao rodar o projeto pela primeira vez).🚀 Como Executar e Testar a AplicaçãoClone o repositório em sua máquina.Abra a pasta raiz do projeto na sua IDE.Execute a classe principal TarifasApplication.java ou rode o comando maven: ./mvnw spring-boot:run.A API estará disponível no endereço: http://localhost:8080.Utilize o Swagger, Postman ou Insomnia para testar os endpoints abaixo.📚 Documentação Interativa (Swagger)A API possui documentação automática e interativa gerada pelo Swagger (OpenAPI).Após iniciar a aplicação, você pode visualizar e testar todos os endpoints diretamente pelo navegador, sem necessidade de ferramentas externas, acessando o link abaixo:👉 http://localhost:8080/swagger-ui/index.html📡 Endpoints (Exemplos de Request e Response)1. Criar Tabela Tarifária CompletaPOST /api/tabelas-tarifarias Cria uma tabela com suas categorias e faixas de uma só vez .Request Body (JSON): JSON{
  "nome": "Tabela Padrão 2026",
  "faixas": [
    { "categoria": "INDUSTRIAL", "inicio": 0, "fim": 10, "valorUnitario": 1.00 },
    { "categoria": "INDUSTRIAL", "inicio": 11, "fim": 20, "valorUnitario": 2.00 },
    { "categoria": "PARTICULAR", "inicio": 0, "fim": 18, "valorUnitario": 5.00 },
    { "categoria": "PARTICULAR", "inicio": 19, "fim": 30, "valorUnitario": 10.00 }
  ]
}
2. Listar Tabelas TarifáriasGET /api/tabelas-tarifarias Retorna todas as tabelas cadastradas no sistema com suas respectivas configurações . Nenhuma entrada é necessária.3. Excluir Tabela TarifáriaDELETE /api/tabelas-tarifarias/{id} Remove a tabela e, por efeito cascata, todas as faixas atreladas a ela.
Exemplo de URL: http://localhost:8080/api/tabelas-tarifarias/14. Cálculo do Valor a PagarPOST /api/calculos Realiza o cálculo progressivo baseado no consumo. O sistema busca automaticamente a tabela mais recente cadastrada.Request Body (JSON): JSON{
  "categoria": "INDUSTRIAL",
  "consumo": 18
}
Response Body (JSON): JSON{
    "categoria": "INDUSTRIAL",
    "consumoTotal": 18,
    "valorTotal": 26.00,
    "detalhamento": [
        {
            "faixa": { "inicio": 0, "fim": 10 },
            "m3Cobrados": 10,
            "valorUnitario": 1.00,
            "subtotal": 10.00
        },
        {
            "faixa": { "inicio": 11, "fim": 20 },
            "m3Cobrados": 8,
            "valorUnitario": 2.00,
            "subtotal": 16.00
        }
    ]
}
