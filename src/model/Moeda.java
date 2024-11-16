
package model;

import java.util.Random;




public class Moeda {
    private String nome;
    private double valorAtual;
    private double quantidade; 
    private double cotacao;  // Cotação da moeda

    public Moeda(String nome, double cotacao) {
        this.nome = nome;
        this.cotacao = cotacao;
        this.valorAtual = cotacao; // O valor atual pode ser igual à cotação no início
        this.quantidade = 0; 
    }

    // Getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void adicionarQuantidade(double quantidade) {
        this.quantidade += quantidade; 
    }

 public void removerQuantidade(double quantidade) {
    if (this.quantidade >= quantidade) {
        this.quantidade -= quantidade;
    } else {
        throw new IllegalArgumentException("Quantidade insuficiente para remover.");
    }
}

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }
    
     

    public double atualizar() {
    Random random = new Random();
    double variacaoPercentual = (random.nextDouble() * 0.1) - 0.05; // Random between -5% and +5%
    double novaCotacao = this.cotacao * (1 + variacaoPercentual); // Adjusting the cotacao based on the variation
    return novaCotacao;
}

    
       public double calcularQuantidadeComprada(double valorComTaxa) {
        return valorComTaxa / this.cotacao;
    }
    @Override
    public String toString() {
        return "Moeda{" + "nome=" + nome + ", cotacao=" + cotacao + '}';
    }
}
