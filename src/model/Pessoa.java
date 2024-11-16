
package model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private String cpf;
    private String senha;
    private double saldo; 
    private List<Moeda> moedas;

    public Pessoa(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.saldo = 0.0;
        this.moedas = new ArrayList<>(); 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void adicionarSaldo(double valor) {
        this.saldo += valor; 
    }

    // Método para remover saldo
    public void removerSaldo(double valor) {
        this.saldo -= valor;
    }
    
    // Método que retorna a lista de moedas do usuário
    public List<Moeda> getMoedas() {
        return moedas; // Retorna a lista de moedas
    }
    
    
    // Método para adicionar moeda
  public void adicionarMoeda(String nomeMoeda, double quantidade) {
    for (Moeda moeda : moedas) {
        if (moeda.getNome().equalsIgnoreCase(nomeMoeda)) {
            moeda.adicionarQuantidade(quantidade); // Adiciona à quantidade existente
            return;
        }
    }
    // Se a moeda não existir, cria uma nova entrada
    Moeda novaMoeda = new Moeda(nomeMoeda, 0); // Inicializa o valor atual como 0 ou algum valor padrão
    novaMoeda.adicionarQuantidade(quantidade);
    moedas.add(novaMoeda);
}

    public void removerMoeda(String nomeMoeda, double quantidade) {
    for (Moeda moeda : moedas) {
        if (moeda.getNome().equals(nomeMoeda)) {
            moeda.removerQuantidade(quantidade); // Aqui você já tem a lógica para remover a quantidade de moedas
            return;
        }
    }
    throw new IllegalArgumentException("Moeda não encontrada para remoção.");
}
   
   


    // Método para obter a quantidade de uma moeda específica
    public double getQuantidadeMoeda(String nomeMoeda) {
        for (Moeda moeda : moedas) {
            if (moeda.getNome().equals(nomeMoeda)) {
                return moeda.getQuantidade();
            }
        }
        return 0.0; // Se não houver a moeda, retorna 0
    }
   
}
