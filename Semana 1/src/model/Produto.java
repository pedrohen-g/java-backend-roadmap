package model;

import contract.Calculavel;
import exception.ProdutoInvalidoException;

public class Produto implements Calculavel {
    private String nome = "Produto sem nome";
    private double preco = 1.0;
    private int quantidade = 0;
    private int id;
    private String categoria;

    public Produto(int id, String nome, String categoria, double preco, int quantidade) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
        setId(id);
        setCategoria(categoria);
    }

    @Override
    public double calcularValorTotal(){
        return getPreco() * getQuantidade();
    }

    public boolean estaDisponivel(){
        return getQuantidade() > 0;
    }

    public void exibirInformacoes(){
        System.out.println("ID: " + getId());
        System.out.println("Nome do produto: " + getNome());
        System.out.println("Categoria: " + getCategoria());
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
        if(quantidadeAdicionada <= 0){
            throw new ProdutoInvalidoException("Quantidade adicionada deve ser maior que zero!");
        }
        int quantidade = getQuantidade();
        quantidade += quantidadeAdicionada;
        setQuantidade(quantidade);

    }

    public void removerEstoque(int quantidadeRemovida){
        if(quantidadeRemovida <= 0){
            throw new ProdutoInvalidoException("Quantidade removida deve ser maior que zero!");
        }
        if (quantidadeRemovida > getQuantidade()){
            throw new ProdutoInvalidoException("Estoque insuficiente para remoção!");
        }
        int quantidade = getQuantidade();
        quantidade -= quantidadeRemovida;
        setQuantidade(quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || nome.trim().isEmpty()){
            throw new ProdutoInvalidoException("Nome do produto não pode ser vazio!");
        }

        this.nome = nome.trim();
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if(preco <= 0){
            throw new ProdutoInvalidoException("Preço deve ser maior que zero!");
        }

        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if(quantidade < 0){
            throw new ProdutoInvalidoException("Quantidade não pode ser negativa!");
        }
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id <= 0){
            throw new ProdutoInvalidoException("ID deve ser maior que zero!");
        }
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if(categoria == null || categoria.trim().isEmpty()){
            throw new ProdutoInvalidoException("Categoria do produto não pode ser vazia!");
        }
        this.categoria = categoria.trim();
    }

}
