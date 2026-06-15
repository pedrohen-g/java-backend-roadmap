public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public double calcularValorTotal(){
        return getPreco() * getQuantidade();
    }

    public void exibirInformacoes(){
        System.out.println("Nome do produto: " + getNome());
        System.out.println("Preço: " + getPreco());
        System.out.println("Quantidade: " + getQuantidade());
        System.out.println("Valor Total em Estoque: " + calcularValorTotal());
        System.out.println("\n");
    }

    public void adicionarEstoque(int quantidadeAdicionada){
        int quantidade = getQuantidade();
        quantidade += quantidadeAdicionada;
        setQuantidade(quantidade);
    }

    public void removerEstoque(int quantidadeRemovida){
        int quantidade = getQuantidade();
        quantidade -= quantidadeRemovida;
        setQuantidade(quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
