# Apresentação do Projeto: Sistema de Livraria

O **Sistema de Livraria** é um projeto Java desenvolvido com o objetivo de gerenciar livros, autores e clientes de uma livraria, oferecendo funcionalidades como cadastro, empréstimo e consulta. A aplicação é estruturada seguindo boas práticas de programação, utilizando Maven para gerenciamento de dependências e oferecendo uma interface simples para o terminal.

## Funcionalidades Principais

### Gerenciamento de Livros:
- Cadastro de livros com título, autor e ano de publicação.
- Consulta de livros cadastrados.
- Identificação de livros emprestados e disponíveis.

### Gerenciamento de Autores:
- Cadastro de autores com nome e lista de obras publicadas.
- Consulta de autores e seus respectivos livros.

### Gerenciamento de Clientes:
- Cadastro de clientes com nome e informações de contato.
- Controle de empréstimos associados a cada cliente.

### Sistema de Empréstimos:
- Registro de empréstimos de livros a clientes.
- Verificação da disponibilidade de livros antes de emprestar.

### Barra de Progresso e Animações:
- Feedback visual no terminal ao iniciar o sistema.
- Animação interativa para carregamento e inicialização do programa.

## Estrutura do Projeto

```
project-root/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/
│   │   │       └── livraria/
│   │   │           ├── ProgramaPrincipal.java  # Ponto de entrada do programa
│   │   │           ├── service/
│   │   │           │   └── BibliotecaService.java
│   │   │           ├── model/
│   │   │           │   ├── Livro.java
│   │   │           │   ├── Autor.java
│   │   │           │   └── Cliente.java
│   │   │           └── util/
│   │   │               └── ConsoleUtils.java
│   │   └── resources/
├── target/                                  # Pasta de build (gerada automaticamente pelo Maven)
├── pom.xml                                  # Configurações do Maven
└── README.md                                # Documentação do projeto
```

## Principais Classes

### `ProgramaPrincipal.java`
Classe principal que inicializa o programa e gerencia a interação com o usuário. Exibe animações e barra de progresso durante a inicialização.

### Pacote `model`
- **Livro**: Representa as propriedades e métodos associados a um livro.
- **Autor**: Gerencia as informações de um autor e seus livros.
- **Cliente**: Armazena dados sobre os clientes da livraria.
- **Biblioteca**: Gerencia os livros disponíveis para empréstimo e o controle de empréstimos.
- **Emprestimo**: Representa um empréstimo de livro, incluindo informações sobre o cliente e o livro emprestado.


### Pacote `service`
- **BibliotecaService**: Contém a lógica de negócios, como cadastro e empréstimo de livros.

### Pacote `util`
- **ConsoleUtils**: Oferece utilitários para manipulação do terminal, como limpeza de tela e formatação de texto.

## Requisitos do Sistema

### Software Necessário:
- JDK 21 ou superior.
- Maven 3.6 ou superior.
- IDE recomendada: IntelliJ IDEA.

### Bibliotecas Utilizadas:
- **Lombok**: Para geração automática de getters, setters e outros utilitários.
- **Jansi**: Para manipulação de cores no terminal.

## Configuração e Execução

### Clonando o Projeto:

```bash
git clone <URL-DO-REPOSITÓRIO>
cd Sistema-de-Livraria
```

### Compilando com Maven:

```bash
mvn clean compile
```

### Gerando o Arquivo JAR:

```bash
mvn package
```

### Executando o Programa:

```bash
java -jar target/Sistema-de-Livraria-1.0-SNAPSHOT.jar
```

## Exemplo de Execução

### Tela Inicial
```plaintext
[                    ] 0% █
[████████████████████] 100%
Carregamento concluído!
Inicializando o programa...
```

### Menu Principal
```plaintext
|||||||||| MENU PRINCIPAL ||||||||||

[1] Gerenciar Livros
[2] Gerenciar Clientes
[3] Gerenciar Empréstimos
[0] Sair
```

## Extensões Futuras
- Implementação de persistência de dados com banco de dados relacional.
- Suporte para multilinguagem.
- Relatórios detalhados sobre empréstimos e estatísticas da livraria.

## Conclusão

O **Sistema de Livraria** é um projeto modular e escalável, projetado para oferecer uma base sólida para aprendizado e práticas em Java. Sua arquitetura permite fácil manutenção e expansão, atendendo tanto a propósitos educacionais quanto operacionais.

Acesse, modifique e contribua!
