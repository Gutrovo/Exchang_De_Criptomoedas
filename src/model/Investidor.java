/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Vinicius
 */
public class Investidor extends Pessoa {
    private Carteira carteira;

    public Investidor(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        this.carteira = new Carteira();
    }

    public Carteira getCarteira() {
        return carteira;
    }

    // Método para adicionar saldo à carteira
    public void adicionarMoeda(String nomeMoeda, double quantidade) {
        carteira.adicionarMoeda(nomeMoeda, quantidade);
    }

    public void removerMoeda(String nomeMoeda, double quantidade) {
        carteira.removerMoeda(nomeMoeda, quantidade);
    }

    public double getQuantidadeMoeda(String nomeMoeda) {
        return carteira.getQuantidadeMoeda(nomeMoeda);
    }
}
