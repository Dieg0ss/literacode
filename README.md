# Literacode📚

**Literacode** é um projeto de gerenciamento e pesquisa de livros baseado na API Gutendex, permitindo buscar livros, autores e registrar informações em um banco de dados PostgreSQL. Utiliza Java com Spring Boot para backend e o PostgreSQL como banco de dados para persistência.

## Funcionalidades 🚀 

- **Busca de livros**: Permite buscar livros por título na API Gutendex.
- **Listagem de livros e autores**: Exibe livros e autores registrados no banco de dados.
- **Filtragem de autores por ano**: Lista autores vivos em um determinado ano.
- **Filtragem de livros por idioma**: Permite listar livros filtrados por idioma (português, inglês, espanhol, francês).
- **Top 10 livros mais baixados**: Exibe os 10 livros mais baixados pela API Gutendex.

## Tecnologias 🛠️ 

- **Java**: Linguagem de programação utilizada no backend.
- **Spring Boot**: Framework para criação da aplicação e APIs REST.
- **PostgreSQL**: Banco de dados relacional para persistência de dados.
- **Gutendex API**: API externa para pesquisa de livros e autores.

## Como executar ⚙️

### Pré-requisitos ✅

- Java 17 ou superior
- Maven
- PostgreSQL configurado com um banco de dados para persistência

### Passos para rodar o projeto 🔃

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/Dieg0ss/literacode.git
2. **Configure o banco de dados**:
   Certifique-se de que o PostgreSQL está rodando e crie um banco de dados. Após isso, edite o arquivo src/main/resources/application.properties com as credenciais de acesso ao banco de dados.

3. **Compile o projeto:** Na raiz do projeto, execute:
   ```bash
   ./mvnw clean install
4. **Execute a aplicação:** Para rodar a aplicação, utilize o seguinte comando:
   ```bash
   ./mvnw spring-boot:run
5. **Acesse a aplicação:** O servidor estará rodando na porta padrão 8080. Acesse a aplicação via console para interagir com as opções disponíveis.

### Observações 📌 

Este projeto é um challenge proposto pelo programa Oracle Next Generation (ONE), que tem como objetivo avaliar conhecimentos em Java, orientação a objetos, consumo de API, uso do SpringBoot e banco de dados relacional.
