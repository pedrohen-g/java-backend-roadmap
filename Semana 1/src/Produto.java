public class Produto {
    private String nome = "Produto sem nome";
    private double preco = 1.0;
    private int quantidade = 0;

    public Produto(String nome, double preco, int quantidade) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public double calcularValorTotal(){
        return getPreco() * getQuantidade();
    }

    public boolean estaDisponivel(){
        return getQuantidade() > 0;
    }

    public void exibirInformacoes(){
        System.out.println("Nome do produto: " + getNome());
        System.out.println("Preço: " + getPreco());
        System.out.println("Quantidade: " + getQuantidade());
        System.out.println("Valor Total em Estoque: " + calcularValorTotal());
        if(estaDisponivel()){
            System.out.println("Disponível: Sim");
        }else{
            System.out.println("Disponível: Não");
        }
        System.out.println("\n");
    }

    public void adicionarEstoque(int quantidadeAdicionada){
        if(quantidadeAdicionada > 0){
            int quantidade = getQuantidade();
            quantidade += quantidadeAdicionada;
            setQuantidade(quantidade);
        }else{
            System.out.println("Quantidade invalida!\n");
            return;
        }

    }

    public void removerEstoque(int quantidadeRemovida){
        if(quantidadeRemovida <= getQuantidade() && quantidadeRemovida > 0){
            int quantidade = getQuantidade();
            quantidade -= quantidadeRemovida;
            setQuantidade(quantidade);
        }else{
            System.out.println("Quantidade invalida!\n");
            return;
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || nome.trim().isEmpty()){
            System.out.println("Nome inválido!\n");
            return;
        }else{
            this.nome = nome.trim();
        }
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if(preco <= 0){
            System.out.println("Preço inválido!\n");
            return;
        }else{
            this.preco = preco;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade < 0){
            System.out.println("Quantidade inválida!\n");
            return;
        }else{
            this.quantidade = quantidade;
        }
    }
}
