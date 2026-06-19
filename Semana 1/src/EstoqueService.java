import java.util.ArrayList;

public class EstoqueService implements GerenciadorEstoque {

    private ArrayList<Produto> produtos;

    public EstoqueService() {
        this.produtos = new ArrayList<>();
    }

    @Override
    public void adicionarProduto(Produto produto){
        if(produto == null ){
            System.out.println("Produto Inválido!\n");
            return;
        }

        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!\n");
    }

    @Override
    public void listarProdutos(){
        if(produtos.isEmpty()){
            System.out.println("Estoque está vazio!\n");
            return;
        }
        for(Produto produto : produtos){
            produto.exibirInformacoes();
        }

    }

    @Override
    public Produto buscarProdutoPorNome(String nome){
        if(nome == null || nome.trim().isEmpty()){
            throw new ProdutoInvalidoException("Nome do produto invalido!");
        }

        for (Produto produto : produtos){
            if(produto.getNome().equalsIgnoreCase(nome.trim())){
                return produto;
            }
        }

        throw new ProdutoNaoEncontradoException("Produto não encontrado no estoque!");
    }

    @Override
    public void removerProdutoPorNome(String nome){

        Produto produtoEncontrado = buscarProdutoPorNome(nome);

        produtos.remove(produtoEncontrado);
        System.out.println("Produto removido com sucesso!\n");
    }
}
