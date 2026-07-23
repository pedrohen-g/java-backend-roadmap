-- =========================================================
-- WEEK 2 - DAY 3
-- Primary Key, Foreign Key e relacionamentos 1:N
-- =========================================================


-- =========================================================
-- 1. TABELA CLIENTES
-- Cada cliente possui um identificador único.
-- =========================================================

CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL
);


-- =========================================================
-- 2. CADASTRO DE CLIENTES
-- =========================================================

INSERT INTO clientes (nome, email)
VALUES ('Pedro Henrique', 'pedro@email.com');

INSERT INTO clientes (nome, email)
VALUES ('Ana Souza', 'ana@email.com');


-- Consulta todos os clientes cadastrados.
SELECT *
FROM clientes
ORDER BY id;


-- =========================================================
-- 3. TABELA PEDIDOS
--
-- Cada pedido pertence a um cliente.
--
-- Relacionamento:
-- clientes 1 ---- N pedidos
-- =========================================================

CREATE TABLE pedidos (
    id SERIAL PRIMARY KEY,
    cliente_id INTEGER NOT NULL,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(30) NOT NULL,

    FOREIGN KEY (cliente_id)
        REFERENCES clientes(id)
);


-- =========================================================
-- 4. CADASTRO DE PEDIDOS
-- O cliente de ID 1 possui dois pedidos.
-- O cliente de ID 2 possui um pedido.
-- =========================================================

INSERT INTO pedidos (cliente_id, status)
VALUES (1, 'CRIADO');

INSERT INTO pedidos (cliente_id, status)
VALUES (1, 'PAGO');

INSERT INTO pedidos (cliente_id, status)
VALUES (2, 'CRIADO');


-- Consulta os pedidos cadastrados.
SELECT *
FROM pedidos
ORDER BY id;


-- =========================================================
-- 5. TESTE DA FOREIGN KEY DE PEDIDOS
--
-- Este comando gera erro porque não existe cliente com ID 999.
-- Execute separadamente para testar a integridade referencial.
-- =========================================================

INSERT INTO pedidos (cliente_id, status)
VALUES (999, 'CRIADO');


-- =========================================================
-- 6. TESTE DE EXCLUSÃO DE CLIENTE
--
-- Este comando gera erro porque o cliente de ID 1 possui
-- pedidos relacionados a ele.
--
-- Para apagar esse cliente, seria necessário apagar primeiro
-- seus pedidos ou configurar uma ação de exclusão específica.
-- =========================================================

DELETE FROM clientes
WHERE id = 1;


-- =========================================================
-- 7. TABELA ITENS_PEDIDO
--
-- Cada item pertence a um pedido e representa um produto.
--
-- Relacionamentos:
-- pedidos  1 ---- N itens_pedido
-- produtos 1 ---- N itens_pedido
-- =========================================================

CREATE TABLE itens_pedido (
    id SERIAL PRIMARY KEY,
    pedido_id INTEGER NOT NULL,
    produto_id INTEGER NOT NULL,
    quantidade INTEGER NOT NULL,
    preco_unitario NUMERIC(10, 2) NOT NULL,

    FOREIGN KEY (pedido_id)
        REFERENCES pedidos(id),

    FOREIGN KEY (produto_id)
        REFERENCES produtos(id)
);


-- =========================================================
-- 8. CONSULTAS AUXILIARES
-- Verifica os IDs disponíveis antes de cadastrar os itens.
-- =========================================================

SELECT id, nome, preco
FROM produtos
ORDER BY id;

SELECT id, cliente_id, status
FROM pedidos
ORDER BY id;


-- =========================================================
-- 9. CADASTRO DOS ITENS DOS PEDIDOS
--
-- Pedido 1:
-- 2 Camisas Brasil Azul
-- 1 Boné Brasil
--
-- Pedido 2:
-- 1 Jaqueta Brasil
--
-- Pedido 3:
-- 2 Shorts Brasil
-- 3 Chaveiros Brasil
-- =========================================================

INSERT INTO itens_pedido (
    pedido_id,
    produto_id,
    quantidade,
    preco_unitario
)
VALUES (1, 1, 2, 189.99);

INSERT INTO itens_pedido (
    pedido_id,
    produto_id,
    quantidade,
    preco_unitario
)
VALUES (1, 5, 1, 79.90);

INSERT INTO itens_pedido (
    pedido_id,
    produto_id,
    quantidade,
    preco_unitario
)
VALUES (2, 7, 1, 299.90);

INSERT INTO itens_pedido (
    pedido_id,
    produto_id,
    quantidade,
    preco_unitario
)
VALUES (3, 6, 2, 129.90);

INSERT INTO itens_pedido (
    pedido_id,
    produto_id,
    quantidade,
    preco_unitario
)
VALUES (3, 8, 3, 29.90);


-- =========================================================
-- 10. CONSULTA DOS ITENS E CÁLCULO DO SUBTOTAL
--
-- O subtotal é calculado apenas no resultado da consulta.
-- Ele não é uma coluna permanente da tabela.
-- =========================================================

SELECT
    id,
    pedido_id,
    produto_id,
    quantidade,
    preco_unitario,
    quantidade * preco_unitario AS subtotal
FROM itens_pedido
ORDER BY pedido_id, id;


-- =========================================================
-- 11. TESTES DAS FOREIGN KEYS DE ITENS_PEDIDO
--
-- Execute separadamente.
-- Os comandos abaixo devem gerar erro.
-- =========================================================


-- Pedido inexistente:
INSERT INTO itens_pedido (
    pedido_id,
    produto_id,
    quantidade,
    preco_unitario
	)
VALUES (999, 1, 1, 189.99);


-- Produto inexistente:
INSERT INTO itens_pedido (
    pedido_id,
    produto_id,
    quantidade,
    preco_unitario
)
VALUES (1, 999, 1, 100.00);