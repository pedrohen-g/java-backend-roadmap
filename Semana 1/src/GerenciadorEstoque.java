public interface GerenciadorEstoque {
    void adicionarProduto(Produto produto);

    void listarProdutos();

    Produto buscarProdutoPorNome(String nome);

    void removerProdutoPorNome(String nome);
}
