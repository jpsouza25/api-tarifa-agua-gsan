# 💧 API de Tabela Tarifária de Água - Desafio Técnico

Esta é uma API REST desenvolvida em Spring Boot para gerenciar tabelas tarifárias de água e calcular progressivamente o valor da conta com base no consumo e na categoria do cliente. O motor de cálculo garante que o cliente não seja cobrado por volume não consumido na faixa inicial.

## 🛠️ Pré-requisitos
Certifique-se de ter instalado em sua máquina:
* **Java 17** (ou superior)
* **Maven**
* **PostgreSQL** (versão 15 ou compatível)

## 🗄️ Configuração do Banco de Dados
1. Abra sua ferramenta de preferência para o PostgreSQL (ex: pgAdmin).
2. Crie um banco de dados vazio com o nome: `gsan_tarifas`.
3. No projeto, abra o arquivo `src/main/resources/application.properties` e ajuste o usuário e a senha do banco de acordo com a sua máquina local:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/gsan_tarifas
spring.datasource.username=postgres
spring.datasource.password=sua_senha_aqui
```

*(O Spring Boot com Hibernate JPA está configurado com `update`, então as tabelas serão criadas automaticamente ao rodar o projeto pela primeira vez).*

## 🚀 Como Executar e Testar a Aplicação
1. Clone o repositório em sua máquina.
2. Abra a pasta raiz do projeto na sua IDE (VS Code, IntelliJ, etc.).
3. Execute a classe principal `TarifasApplication.java` ou rode o comando maven: `./mvnw spring-boot:run`.
4. A API estará disponível no endereço: `http://localhost:8080`.

---

## 📚 Documentação Interativa (Swagger)
A API possui documentação automática e interativa gerada pelo Swagger (OpenAPI). 
Após iniciar a aplicação, você pode visualizar e testar todos os endpoints diretamente pelo navegador, sem necessidade de ferramentas externas, acessando o link abaixo:

👉 **[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)**

---

## 📡 Endpoints (Exemplos de Request e Response)

### 1. Criar Tabela Tarifária Completa
**`POST /api/tabelas-tarifarias`**
Cria uma tabela com suas categorias e faixas de uma só vez.

**Request Body (JSON):**
```json
{
  "nome": "Tabela Padrão 2026",
  "faixas": [
    { "categoria": "INDUSTRIAL", "inicio": 0, "fim": 10, "valorUnitario": 1.00 },
    { "categoria": "INDUSTRIAL", "inicio": 11, "fim": 20, "valorUnitario": 2.00 },
    { "categoria": "PARTICULAR", "inicio": 0, "fim": 18, "valorUnitario": 5.00 },
    { "categoria": "PARTICULAR", "inicio": 19, "fim": 30, "valorUnitario": 10.00 }
  ]
}
```

### 2. Listar Tabelas Tarifárias
**`GET /api/tabelas-tarifarias`**
Retorna todas as tabelas cadastradas no sistema com suas respectivas configurações. Nenhuma entrada é necessária.

### 3. Excluir Tabela Tarifária
**`DELETE /api/tabelas-tarifarias/{id}`**
Remove a tabela e, por efeito cascata, todas as faixas atreladas a ela.
Exemplo de URL: `http://localhost:8080/api/tabelas-tarifarias/1`

### 4. Cálculo do Valor a Pagar
**`POST /api/calculos`**
Realiza o cálculo progressivo baseado no consumo. O sistema busca automaticamente a tabela mais recente cadastrada.

**Request Body (JSON):**
```json
{
  "categoria": "INDUSTRIAL",
  "consumo": 18
}
```

**Response Body (JSON):**
```json
{
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
```
