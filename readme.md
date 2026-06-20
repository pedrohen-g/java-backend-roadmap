# Java Backend Roadmap

Este repositório acompanha minha jornada de estudos em Java com foco em desenvolvimento backend.

O objetivo é construir uma base sólida em Java, Programação Orientada a Objetos, Collections, Streams, Exceptions, organização de projeto, banco de dados, Spring Boot e APIs REST.

## Objetivo do repositório

Este projeto foi criado como parte de um plano de estudos prático para evoluir como desenvolvedor backend Java.

A ideia principal é aprender construindo, com commits organizados por dia e evolução gradual dos conceitos.

## Semana 1 — Fundamentos de Java e POO

Na primeira semana, foi desenvolvido um sistema simples de controle de estoque de produtos, evoluindo o projeto dia após dia.

### Conteúdos praticados

* Classes e objetos
* Atributos e métodos
* Construtores
* Encapsulamento
* Getters e setters
* Validações
* `ArrayList`
* Classe de serviço
* Interfaces
* Polimorfismo
* Exceptions personalizadas
* `try/catch`
* `throw`
* Organização em pacotes
* Stream API
* `filter`
* `findFirst`
* `toList`
* `mapToDouble`
* `sum`

## Estrutura do projeto

```text
Semana 1
└── src
    ├── application
    │   └── Main.java
    │
    ├── contract
    │   ├── Calculavel.java
    │   └── GerenciadorEstoque.java
    │
    ├── exception
    │   ├── ProdutoInvalidoException.java
    │   └── ProdutoNaoEncontradoException.java
    │
    ├── model
    │   └── Produto.java
    │
    └── service
        └── EstoqueService.java
```

## Sobre o projeto

O sistema simula um controle de estoque simples, permitindo:

* Cadastrar produtos
* Listar produtos
* Buscar produto por nome
* Buscar produto por ID
* Remover produto
* Listar produtos por categoria
* Listar produtos por preço
* Calcular o valor total do estoque
* Tratar erros com exceptions personalizadas

## Principais classes

### Produto

Representa um produto do estoque.

Possui atributos como:

* ID
* Nome
* Categoria
* Preço
* Quantidade

Também possui métodos para:

* Calcular valor total em estoque
* Verificar disponibilidade
* Adicionar estoque
* Remover estoque
* Exibir informações

### EstoqueService

Responsável pelas operações do estoque.

Principais métodos:

* `adicionarProduto`
* `listarProdutos`
* `buscarProdutoPorNome`
* `buscarProdutoPorId`
* `removerProdutoPorNome`
* `listarProdutosPorCategoria`
* `listarProdutosComPrecoMaiorQue`
* `calcularValorTotalDoEstoque`

### Exceptions personalizadas

Foram criadas exceptions para deixar os erros mais claros e organizados:

* `ProdutoInvalidoException`
* `ProdutoNaoEncontradoException`

## Tecnologias utilizadas

* Java
* IntelliJ IDEA
* Git
* GitHub

## Como executar

1. Clone o repositório:

```bash
git clone https://github.com/pedrohen-g/java-backend-roadmap.git
```

2. Abra o projeto no IntelliJ IDEA.

3. Acesse a pasta:

```text
Semana 1/src/application/Main.java
```

4. Execute a classe `Main`.

## Evolução dos commits

A evolução da Semana 1 foi registrada com commits diários:

```text
feat: week 1 day 1 - product stock system
feat: week 1 day 2 - encapsulation and validation
feat: week 1 day 3 - stock service with arraylist
feat: week 1 day 4 - interfaces and polymorphism
feat: week 1 day 5 - custom exceptions
feat: week 1 day 6 - packages and streams
```

## Próximos passos

Os próximos estudos do roadmap incluem:

* SQL e PostgreSQL
* Spring Boot
* API REST
* JPA/Hibernate
* Spring Security
* JWT
* Testes
* Docker
* Deploy
* Projeto final de portfólio

## Autor

Pedro Henrique Gomes Silva

Estudante de Engenharia de Computação, em evolução para desenvolvimento backend Java.
