# CRUD de Produtos - API REST

Este projeto é uma API REST desenvolvida com **Spring Boot** para gerenciar produtos. Ele implementa um CRUD completo (Create, Read, Update, Delete) utilizando **Spring Data JPA** e **Flyway** para migração do banco de dados.

## 🚀 Tecnologias Utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- Flyway
- PostgreSQL
- Lombok

## 📌 Funcionalidades
- Criar um produto
- Listar todos os produtos
- Atualizar um produto
- Deletar um produto

## 🔧 Configuração do Ambiente

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/whsmumu/crud-product.git
   ```

2. **Configure o banco de dados PostgreSQL:**
   
   Crie um banco de dados chamado `crudone` no PostgreSQL.

3. **Configure o arquivo `application.properties`:**
   ```properties
   spring.application.name=crudone
   spring.datasource.url=jdbc:postgresql://localhost:5432/crudone
   spring.datasource.username=postgres
   spring.datasource.password=postgres
   ```

4. **Execute a aplicação:**
   ```bash
   mvn spring-boot:run
   ```

## 🔥 Endpoints da API

### 1️⃣ Criar um Produto
- **POST /product**
- **Body:**
  ```json
  {
    "name": "Notebook Dell",
    "price": 5000
  }
  ```
- **Resposta:** `200 OK`

---
### 2️⃣ Listar Produtos
- **GET /product**
- **Resposta:**
  ```json
  [
    {
      "id": "882c804a-5450-481e-9f12-8481ce9d3c7f",
      "name": "Notebook Dell",
      "price": 5000
    }
  ]
  ```

---
### 3️⃣ Atualizar um Produto
- **PUT /product**
- **Body:**
  ```json
  {
    "id": "882c804a-5450-481e-9f12-8481ce9d3c7f",
    "name": "Notebook Lenovo",
    "price": 4500
  }
  ```
- **Resposta:** `200 OK`

---
### 4️⃣ Deletar um Produto
- **DELETE /product/{id}**
- **Resposta:** `204 No Content`

## 🛠️ Migração do Banco de Dados
O Flyway é utilizado para gerenciar as migrações do banco de dados.

1. Arquivo de migração `V1__create_product_table.sql`:
   ```sql
   CREATE TABLE product(
       id TEXT PRIMARY KEY UNIQUE NOT NULL,
       name TEXT NOT NULL,
       price INT NOT NULL
   );
   ```
2. O Flyway aplica automaticamente a migração ao iniciar a aplicação.

## 📝 Autor
Desenvolvido por [Seu Nome](https://github.com/seu-usuario).

