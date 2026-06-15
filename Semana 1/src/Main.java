public class Main {
    public static void main(String[] args){
        Produto camisaBrasilAzul = new Produto("Camisa Brasil Azul", 189.99, 1);
        Produto camisaBrasilAmarela = new Produto("Camisa Brasil Amarela", 189.99, 2);
        Produto camisaArgentina = new Produto("Camisa Argentina", 189.99, 1);

        camisaArgentina.exibirInformacoes();
        camisaBrasilAmarela.exibirInformacoes();
        camisaBrasilAzul.exibirInformacoes();

        camisaBrasilAzul.adicionarEstoque(3);
        camisaBrasilAmarela.removerEstoque(2);
        camisaArgentina.adicionarEstoque(25);

        camisaArgentina.exibirInformacoes();
        camisaBrasilAmarela.exibirInformacoes();
        camisaBrasilAzul.exibirInformacoes();

    }
}
