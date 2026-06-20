package contract;

import model.Produto;

import java.util.List;

public interface GerenciadorEstoque {
    void adicionarProduto(Produto produto);

    void listarProdutos();

    Produto buscarProdutoPorNome(String nome);

    void removerProdutoPorNome(String nome);

    Produto buscarProdutoPorId(int id);

    List<Produto> listarProdutosPorCategoria(String categoria);

    List<Produto> listarProdutosComPrecoMaiorQue(double precoMinimo);

    double calcularValorTotalDoEstoque();
}
