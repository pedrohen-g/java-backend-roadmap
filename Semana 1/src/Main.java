public class Main {
    public static void main(String[] args){
        Produto produtoValido = new Produto("Camisa Brasil Azul", 189.99, 2);
        produtoValido.exibirInformacoes();

        produtoValido.removerEstoque(2);
        produtoValido.exibirInformacoes();

        produtoValido.adicionarEstoque(5);
        produtoValido.exibirInformacoes();

        Produto produtoInvalido = new Produto("", -10, -3);
        produtoInvalido.exibirInformacoes();

        produtoValido.setPreco(0);
        produtoValido.setNome("   ");
        produtoValido.setQuantidade(-5);
        produtoValido.adicionarEstoque(-2);
        produtoValido.removerEstoque(999);
        produtoValido.exibirInformacoes();
    }
}
