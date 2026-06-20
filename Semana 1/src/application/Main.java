package application;

import contract.Calculavel;
import contract.GerenciadorEstoque;
import exception.ProdutoInvalidoException;
import exception.ProdutoNaoEncontradoException;
import model.Produto;
import service.EstoqueService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EstoqueService estoque = new EstoqueService();

        System.out.println("===== TESTE DE PRODUTO INVÁLIDO =====");

        try {
            Produto produtoInvalido = new Produto(0, "", "", -189.99, -212);
        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro de produto inválido: " + erro.getMessage());
        }

        System.out.println("\n===== TESTE DE ADICIONAR PRODUTO NULO =====");

        try {
            estoque.adicionarProduto(null);
        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro ao adicionar produto: " + erro.getMessage());
        }

        Produto camisaBrasilAzul = new Produto(1, "Camisa Brasil Azul", "Camisa", 189.99, 2);
        Produto camisaBrasilAmarela = new Produto(2, "Camisa Brasil Amarela", "Camisa", 189.99, 5);
        Produto camisaBrasilBranca = new Produto(3, "Camisa Brasil Branca", "Camisa", 189.99, 8);

        System.out.println("\n===== ADICIONANDO PRODUTOS AO ESTOQUE =====");

        estoque.adicionarProduto(camisaBrasilAmarela);
        estoque.adicionarProduto(camisaBrasilAzul);
        estoque.adicionarProduto(camisaBrasilBranca);

        System.out.println("===== LISTA INICIAL DO ESTOQUE =====");
        estoque.listarProdutos();

        System.out.println("===== TESTE DE ADIÇÃO INVÁLIDA NO ESTOQUE =====");

        try {
            camisaBrasilAmarela.adicionarEstoque(-5);
        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro ao adicionar estoque: " + erro.getMessage());
        }

        System.out.println("\n===== TESTE DE REMOÇÃO INVÁLIDA NO ESTOQUE =====");

        try {
            camisaBrasilAmarela.removerEstoque(-895);
        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro ao remover estoque: " + erro.getMessage());
        }

        System.out.println("\n===== TESTE DE ESTOQUE INSUFICIENTE =====");

        try {
            camisaBrasilAmarela.removerEstoque(999);
        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro ao remover estoque: " + erro.getMessage());
        }

        System.out.println("\n===== BUSCANDO PRODUTO POR NOME EXISTENTE =====");

        try {
            Produto produtoEncontrado = estoque.buscarProdutoPorNome("camisa brasil amarela");
            System.out.println("Produto encontrado:");
            produtoEncontrado.exibirInformacoes();

        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro de produto inválido: " + erro.getMessage());

        } catch (ProdutoNaoEncontradoException erro) {
            System.out.println("Erro de produto não encontrado: " + erro.getMessage());
        }

        System.out.println("===== BUSCANDO PRODUTO POR NOME INEXISTENTE =====");

        try {
            Produto produtoNaoEncontrado = estoque.buscarProdutoPorNome("camisa brasil rosa");
            produtoNaoEncontrado.exibirInformacoes();

        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro de produto inválido: " + erro.getMessage());

        } catch (ProdutoNaoEncontradoException erro) {
            System.out.println("Erro de produto não encontrado: " + erro.getMessage());
        }

        System.out.println("\n===== BUSCANDO PRODUTO POR ID EXISTENTE =====");

        try {
            Produto produtoEncontradoPorId = estoque.buscarProdutoPorId(2);
            System.out.println("Produto encontrado por ID:");
            produtoEncontradoPorId.exibirInformacoes();

        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro de produto inválido: " + erro.getMessage());

        } catch (ProdutoNaoEncontradoException erro) {
            System.out.println("Erro de produto não encontrado: " + erro.getMessage());
        }

        System.out.println("===== BUSCANDO PRODUTO POR ID INEXISTENTE =====");

        try {
            Produto produtoEncontradoPorId = estoque.buscarProdutoPorId(99);
            produtoEncontradoPorId.exibirInformacoes();

        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro de produto inválido: " + erro.getMessage());

        } catch (ProdutoNaoEncontradoException erro) {
            System.out.println("Erro de produto não encontrado: " + erro.getMessage());
        }

        System.out.println("===== BUSCANDO PRODUTO POR ID INVÁLIDO =====");

        try {
            Produto produtoEncontradoPorId = estoque.buscarProdutoPorId(0);
            produtoEncontradoPorId.exibirInformacoes();

        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro de produto inválido: " + erro.getMessage());

        } catch (ProdutoNaoEncontradoException erro) {
            System.out.println("Erro de produto não encontrado: " + erro.getMessage());
        }

        System.out.println("\n===== REMOVENDO PRODUTO EXISTENTE =====");

        try {
            estoque.removerProdutoPorNome("camisa brasil branca");

        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro de produto inválido: " + erro.getMessage());

        } catch (ProdutoNaoEncontradoException erro) {
            System.out.println("Erro de produto não encontrado: " + erro.getMessage());
        }

        System.out.println("===== TENTANDO REMOVER PRODUTO INEXISTENTE =====");

        try {
            estoque.removerProdutoPorNome("camisa brasil roxa");

        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro de produto inválido: " + erro.getMessage());

        } catch (ProdutoNaoEncontradoException erro) {
            System.out.println("Erro de produto não encontrado: " + erro.getMessage());
        }

        System.out.println("===== LISTA FINAL DO ESTOQUE =====");
        estoque.listarProdutos();

        System.out.println("===== TESTE COM INTERFACE CALCULAVEL =====");

        Calculavel itemCalculavel = camisaBrasilAzul;

        System.out.println("Valor calculado pela interface: R$ " + itemCalculavel.calcularValorTotal());

        System.out.println("\n===== TESTE COM INTERFACE GERENCIADOR ESTOQUE =====");

        GerenciadorEstoque gerenciador = estoque;

        gerenciador.listarProdutos();

        System.out.println("\n===== LISTANDO PRODUTOS POR CATEGORIA EXISTENTE =====");

        try {
            List<Produto> produtosPorCategoria = estoque.listarProdutosPorCategoria("Camisa");

            for (Produto produto : produtosPorCategoria) {
                produto.exibirInformacoes();
            }

        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro de produto inválido: " + erro.getMessage());

        } catch (ProdutoNaoEncontradoException erro) {
            System.out.println("Erro de produto não encontrado: " + erro.getMessage());
        }

        System.out.println("===== LISTANDO PRODUTOS POR CATEGORIA INEXISTENTE =====");

        try {
            List<Produto> produtosPorCategoria = estoque.listarProdutosPorCategoria("Tênis");

            for (Produto produto : produtosPorCategoria) {
                produto.exibirInformacoes();
            }

        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro de produto inválido: " + erro.getMessage());

        } catch (ProdutoNaoEncontradoException erro) {
            System.out.println("Erro de produto não encontrado: " + erro.getMessage());
        }
        System.out.println("\n===== LISTANDO PRODUTOS COM PREÇO MAIOR QUE 100 =====");

        try {
            List<Produto> produtosCaros = estoque.listarProdutosComPrecoMaiorQue(100);

            for (Produto produto : produtosCaros) {
                produto.exibirInformacoes();
            }

        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro de produto inválido: " + erro.getMessage());

        } catch (ProdutoNaoEncontradoException erro) {
            System.out.println("Erro de produto não encontrado: " + erro.getMessage());
        }

        System.out.println("===== LISTANDO PRODUTOS COM PREÇO MAIOR QUE 1000 =====");

        try {
            List<Produto> produtosCaros = estoque.listarProdutosComPrecoMaiorQue(1000);

            for (Produto produto : produtosCaros) {
                produto.exibirInformacoes();
            }

        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro de produto inválido: " + erro.getMessage());

        } catch (ProdutoNaoEncontradoException erro) {
            System.out.println("Erro de produto não encontrado: " + erro.getMessage());
        }

        System.out.println("\n===== CALCULANDO VALOR TOTAL DO ESTOQUE =====");

        try {
            double valorTotalEstoque = estoque.calcularValorTotalDoEstoque();
            System.out.println("Valor total do estoque: R$ " + valorTotalEstoque);

        } catch (ProdutoNaoEncontradoException erro) {
            System.out.println("Erro de produto não encontrado: " + erro.getMessage());
        }
    }
}