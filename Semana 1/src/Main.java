public class Main {
    public static void main(String[] args) {
        EstoqueService estoque = new EstoqueService();

        Produto camisaBrasilAzul = new Produto("Camisa Brasil Azul", 189.99, 2);
        Produto camisaBrasilAmarela = new Produto("Camisa Brasil Amarela", 189.99, 5);
        Produto camisaBrasilBranca = new Produto("Camisa Brasil Branca", 189.99, 8);

        estoque.adicionarProduto(camisaBrasilAmarela);
        estoque.adicionarProduto(camisaBrasilAzul);
        estoque.adicionarProduto(camisaBrasilBranca);

        System.out.println("===== LISTA INICIAL DO ESTOQUE =====");
        estoque.listarProdutos();

        System.out.println("===== BUSCANDO PRODUTO EXISTENTE =====");
        Produto produtoEncontrado = estoque.buscarProdutoPorNome("camisa brasil amarela");

        if (produtoEncontrado != null) {
            System.out.println("Produto encontrado na busca:");
            produtoEncontrado.exibirInformacoes();
        } else {
            System.out.println("Produto não encontrado na busca!\n");
        }

        System.out.println("===== BUSCANDO PRODUTO INEXISTENTE =====");
        Produto produtoNaoEncontrado = estoque.buscarProdutoPorNome("camisa brasil rosa");

        if (produtoNaoEncontrado != null) {
            System.out.println("Produto encontrado na busca:");
            produtoNaoEncontrado.exibirInformacoes();
        } else {
            System.out.println("Produto não encontrado na busca!\n");
        }

        System.out.println("===== REMOVENDO PRODUTO EXISTENTE =====");
        estoque.removerProdutoPorNome("camisa brasil branca");

        System.out.println("===== TENTANDO REMOVER PRODUTO INEXISTENTE =====");
        estoque.removerProdutoPorNome("camisa brasil roxa");

        System.out.println("===== LISTA FINAL DO ESTOQUE =====");
        estoque.listarProdutos();

        Calculavel itemCalculavel = camisaBrasilAzul;

        System.out.println("===== TESTE COM INTERFACE CALCULAVEL =====");
        System.out.println("Valor Calculado pela Interface: R$ " + itemCalculavel.calcularValorTotal());

        GerenciadorEstoque gerenciador = estoque;

        System.out.println("===== TESTE COM INTERFACE GERENCIADOR ESTOQUE =====");
        gerenciador.listarProdutos();

    }
}