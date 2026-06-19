public class Main {
    public static void main(String[] args) {
        EstoqueService estoque = new EstoqueService();

        System.out.println("===== TESTE DE PRODUTO INVÁLIDO =====");

        try {
            Produto produtoInvalido = new Produto("cam", 10, -50);
        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro de produto inválido: " + erro.getMessage());
        }

        Produto camisaBrasilAzul = new Produto("Camisa Brasil Azul", 189.99, 2);
        Produto camisaBrasilAmarela = new Produto("Camisa Brasil Amarela", 189.99, 5);
        Produto camisaBrasilBranca = new Produto("Camisa Brasil Branca", 189.99, 8);

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

        System.out.println("\n===== BUSCANDO PRODUTO EXISTENTE =====");

        try {
            Produto produtoEncontrado = estoque.buscarProdutoPorNome("camisa brasil amarela");
            System.out.println("Produto encontrado:");
            produtoEncontrado.exibirInformacoes();

        } catch (ProdutoInvalidoException erro) {
            System.out.println("Erro de produto inválido: " + erro.getMessage());

        } catch (ProdutoNaoEncontradoException erro) {
            System.out.println("Erro de produto não encontrado: " + erro.getMessage());
        }

        System.out.println("===== BUSCANDO PRODUTO INEXISTENTE =====");

        try {
            Produto produtoNaoEncontrado = estoque.buscarProdutoPorNome("camisa brasil rosa");
            produtoNaoEncontrado.exibirInformacoes();

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
    }
}