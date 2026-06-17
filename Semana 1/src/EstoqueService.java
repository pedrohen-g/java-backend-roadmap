import java.util.ArrayList;

public class EstoqueService {

    private ArrayList<Produto> produtos;

    public EstoqueService() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto){
        if(produto == null ){
            System.out.println("Produto Inválido!\n");
            return;
        }

        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!\n");
    }

    public void listarProdutos(){
        if(produtos.isEmpty()){
            System.out.println("Estoque está vazio!\n");
            return;
        }
        for(Produto produto : produtos){
            produto.exibirInformacoes();
        }

    }

    public Produto buscarProdutoPorNome(String nome){
        if(nome == null || nome.trim().isEmpty()){
            System.out.println("Nome inválido!\n");
            return null;
        }

        for (Produto produto : produtos){
            if(produto.getNome().equalsIgnoreCase(nome.trim())){
                return produto;
            }
        }

        return null;
    }

    public void removerProdutoPorNome(String nome){

        Produto produtoEncontrado = buscarProdutoPorNome(nome);

        if(produtoEncontrado == null){
            System.out.println("Produto não encontrado para remoção!\n");
            return;
        }

        produtos.remove(produtoEncontrado);
        System.out.println("Produto removido com sucesso!\n");
    }
}
