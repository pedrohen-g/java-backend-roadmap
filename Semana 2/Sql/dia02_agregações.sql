-- =========================================================
-- WEEK 2 - DAY 2
-- Consultas, filtros, ordenação e funções de agregação
-- =========================================================


-- =========================================================
-- 1. INSERÇÃO DE DADOS PARA TESTES
-- Execute estes INSERTs apenas uma vez para não duplicar dados.
-- =========================================================

INSERT INTO produtos (nome, categoria, preco, quantidade)
VALUES ('Camisa Brasil Branca', 'Camisa', 189.99, 8);

INSERT INTO produtos (nome, categoria, preco, quantidade)
VALUES ('Boné Brasil', 'Acessório', 79.90, 10);

INSERT INTO produtos (nome, categoria, preco, quantidade)
VALUES ('Shorts Brasil', 'Roupa', 129.90, 4);

INSERT INTO produtos (nome, categoria, preco, quantidade)
VALUES ('Jaqueta Brasil', 'Roupa', 299.90, 2);

INSERT INTO produtos (nome, categoria, preco, quantidade)
VALUES ('Chaveiro Brasil', 'Acessório', 29.90, 20);


-- =========================================================
-- 2. CONSULTA BÁSICA
-- Retorna todas as colunas e todos os produtos.
-- =========================================================

SELECT *
FROM produtos;


-- =========================================================
-- 3. ORDER BY
-- Organiza os resultados por uma determinada coluna.
-- =========================================================

-- Ordena os produtos do maior preço para o menor.
SELECT *
FROM produtos
ORDER BY preco DESC;

-- Ordena os produtos do menor preço para o maior.
SELECT *
FROM produtos
ORDER BY preco ASC;


-- =========================================================
-- 4. LIMIT
-- Limita a quantidade de linhas retornadas.
-- =========================================================

-- Retorna apenas três produtos.
-- Sem ORDER BY, não há garantia de quais serão os três.
SELECT *
FROM produtos
LIMIT 3;

-- Retorna os três produtos mais caros.
SELECT nome, preco
FROM produtos
ORDER BY preco DESC
LIMIT 3;

-- Retorna os dois produtos com maior quantidade em estoque.
SELECT nome, quantidade
FROM produtos
ORDER BY quantidade DESC
LIMIT 2;


-- =========================================================
-- 5. DISTINCT
-- Remove valores repetidos do resultado.
-- =========================================================

-- Mostra a categoria de cada produto, incluindo repetições.
SELECT categoria
FROM produtos;

-- Mostra somente as categorias diferentes.
SELECT DISTINCT categoria
FROM produtos;


-- =========================================================
-- 6. WHERE COM AND E OR
-- WHERE filtra as linhas de acordo com condições.
-- =========================================================

-- Retorna produtos da categoria Roupa
-- que também custem mais de R$ 150.
SELECT nome, categoria, preco
FROM produtos
WHERE categoria = 'Roupa'
  AND preco > 150;

-- Retorna acessórios que também possuam
-- pelo menos 15 unidades em estoque.
SELECT nome, categoria, preco
FROM produtos
WHERE categoria = 'Acessório'
  AND quantidade >= 15;

-- Retorna produtos que sejam da categoria Camisa
-- ou que custem menos de R$ 50.
SELECT nome, categoria, preco
FROM produtos
WHERE categoria = 'Camisa'
   OR preco < 50;


-- =========================================================
-- 7. LIKE E ILIKE
-- Fazem buscas utilizando partes de um texto.
--
-- % representa qualquer quantidade de caracteres.
-- LIKE diferencia letras maiúsculas e minúsculas.
-- ILIKE ignora letras maiúsculas e minúsculas.
-- =========================================================

-- Nomes que começam com "Camisa".
SELECT nome
FROM produtos
WHERE nome LIKE 'Camisa%';

-- Nomes que terminam com "Brasil".
SELECT nome
FROM produtos
WHERE nome LIKE '%Brasil';

-- Nomes que contêm "Brasil" em qualquer posição.
SELECT nome
FROM produtos
WHERE nome LIKE '%Brasil%';

-- Busca "brasil" ignorando maiúsculas e minúsculas.
SELECT nome
FROM produtos
WHERE nome ILIKE '%brasil%';


-- =========================================================
-- 8. BETWEEN
-- Busca valores dentro de um intervalo.
-- Os valores inicial e final também são incluídos.
-- =========================================================

-- Produtos com preço entre R$ 50 e R$ 200.
SELECT nome, preco
FROM produtos
WHERE preco BETWEEN 50 AND 200
ORDER BY preco ASC;

-- Produtos com quantidade entre 4 e 10 unidades.
SELECT nome, quantidade
FROM produtos
WHERE quantidade BETWEEN 4 AND 10
ORDER BY quantidade ASC;


-- =========================================================
-- 9. IN
-- Compara uma coluna com uma lista de valores exatos.
-- =========================================================

-- Produtos pertencentes às categorias Camisa ou Roupa.
SELECT nome, categoria, preco
FROM produtos
WHERE categoria IN ('Camisa', 'Roupa')
ORDER BY categoria, nome;

-- Produtos que possuem exatamente 2, 5 ou 10 unidades.
SELECT nome, quantidade
FROM produtos
WHERE quantidade IN (2, 5, 10);


-- =========================================================
-- 10. FUNÇÕES DE AGREGAÇÃO
-- Resumem informações de várias linhas.
-- =========================================================

-- Conta o total de produtos cadastrados.
SELECT COUNT(*) AS total_produtos
FROM produtos;

-- Conta somente os produtos da categoria Camisa.
SELECT COUNT(*) AS total_camisas
FROM produtos
WHERE categoria = 'Camisa';

-- Conta quantas categorias diferentes existem.
SELECT COUNT(DISTINCT categoria) AS total_categorias
FROM produtos;