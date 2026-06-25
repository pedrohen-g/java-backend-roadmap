-- Semana 2 - Dia 1
-- SQL/PostgreSQL básico
-- Tabela de produtos

-- Criar banco de dados
CREATE DATABASE java_backend_roadmap;

-- Criar tabela produtos
CREATE TABLE produtos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    preco NUMERIC(10, 2) NOT NULL,
    quantidade INTEGER NOT NULL
);

-- Inserir produtos
INSERT INTO produtos (nome, categoria, preco, quantidade)
VALUES ('Camisa Brasil Azul', 'Camisa', 189.99, 2);

INSERT INTO produtos (nome, categoria, preco, quantidade)
VALUES ('Camisa Brasil Amarela', 'Camisa', 189.99, 5);

INSERT INTO produtos (nome, categoria, preco, quantidade)
VALUES ('Camisa Brasil Branca', 'Camisa', 189.99, 8);

-- Listar todos os produtos
SELECT * FROM produtos;

-- Buscar produto por ID
SELECT * FROM produtos
WHERE id = 2;

-- Buscar produtos por categoria
SELECT * FROM produtos
WHERE categoria = 'Camisa';

-- Buscar produtos com preço maior que 100
SELECT * FROM produtos
WHERE preco > 100;

-- Calcular valor total por produto
SELECT 
    id,
    nome,
    categoria,
    preco,
    quantidade,
    preco * quantidade AS valor_total
FROM produtos;

-- Calcular valor total do estoque
SELECT SUM(preco * quantidade) AS valor_total_estoque
FROM produtos;

-- Atualizar quantidade de um produto
UPDATE produtos
SET quantidade = 4
WHERE id = 1;

-- Conferir produto atualizado
SELECT * FROM produtos
WHERE id = 1;

-- Remover produto
DELETE FROM produtos
WHERE id = 3;

-- Conferir lista final
SELECT * FROM produtos;

-- Calcular valor total do estoque após alterações
SELECT SUM(preco * quantidade) AS valor_total_estoque
FROM produtos;