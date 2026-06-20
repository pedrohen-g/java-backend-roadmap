package service;

import contract.GerenciadorEstoque;
import exception.ProdutoInvalidoException;
import exception.ProdutoNaoEncontradoException;
import model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EstoqueService implements GerenciadorEstoque {

    private ArrayList<Produto> produtos;

    public EstoqueService() {
        this.produtos = new ArrayList<>();
    }

    @Override
    public double calcularValorTotalDoEstoque(){
        if(produtos.isEmpty()){
            throw new ProdutoNaoEncontradoException("Estoque está vazio!");
        }

        return produtos.stream()
                .mapToDouble(produto -> produto.calcularValorTotal())
                .sum();
    }

    @Override
    public List<Produto> listarProdutosComPrecoMaiorQue(double precoMinimo){
        if (precoMinimo <= 0) {
            throw new ProdutoInvalidoException("Preço minimo deve ser maior que zero!");
        }
        List<Produto> listaFiltrada = produtos.stream()
                .filter(produto -> produto.getPreco() > precoMinimo)
                .toList();
        if(listaFiltrada.isEmpty()){
            throw new ProdutoNaoEncontradoException("Não há produtos com preço maior!");
        }
        return listaFiltrada;
    }

    @Override
    public List<Produto> listarProdutosPorCategoria(String categoria){
        if(categoria == null || categoria.trim().isEmpty()){
            throw new ProdutoInvalidoException("Categoria inválida!");
        }

        List<Produto> produtosFiltrados = produtos.stream()
                .filter(produto -> produto.getCategoria().equalsIgnoreCase(categoria.trim()))
                .toList();

        if(produtosFiltrados.isEmpty()){
            throw new ProdutoNaoEncontradoException("Nenhum produto encontrado nessa categoria!");
        }
        return produtosFiltrados;
    }


    @Override
    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            throw new ProdutoInvalidoException("Produto não pode ser nulo!");
        }

        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!\n");
    }

    @Override
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque está vazio!\n");
            return;
        }

        for (Produto produto : produtos) {
            produto.exibirInformacoes();
        }
    }

    @Override
    public Produto buscarProdutoPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ProdutoInvalidoException("Nome do produto inválido!");
        }

        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome.trim())) {
                return produto;
            }
        }

        throw new ProdutoNaoEncontradoException("Produto não encontrado no estoque!");
    }

    @Override
    public Produto buscarProdutoPorId(int id) {
        if (id <= 0) {
            throw new ProdutoInvalidoException("ID deve ser maior que zero!");
        }

        return produtos.stream()
                .filter(produto -> produto.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado no estoque!"));
    }

    @Override
    public void removerProdutoPorNome(String nome) {
        Produto produtoEncontrado = buscarProdutoPorNome(nome);

        produtos.remove(produtoEncontrado);
        System.out.println("Produto removido com sucesso!\n");
    }
}