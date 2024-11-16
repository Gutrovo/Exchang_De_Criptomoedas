/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Vinicius
 */
import java.util.ArrayList;
import java.util.List;

public class Carteira {
    private List<Moeda> moedas;

    public Carteira() {
        this.moedas = new ArrayList<>();
    }

    public List<Moeda> getMoedas() {
        return moedas;
    }

    // Método para adicionar moeda
    public void adicionarMoeda(String nomeMoeda, double quantidade) {
        for (Moeda moeda : moedas) {
            if (moeda.getNome().equals(nomeMoeda)) {
                moeda.adicionarQuantidade(quantidade);
                return;
            }
        }
        Moeda novaMoeda = new Moeda(nomeMoeda, 0);
        novaMoeda.adicionarQuantidade(quantidade);
        moedas.add(novaMoeda);
    }

    // Método para remover moeda
    public void removerMoeda(String nomeMoeda, double quantidade) {
        for (Moeda moeda : moedas) {
            if (moeda.getNome().equals(nomeMoeda)) {
                moeda.removerQuantidade(quantidade);
                return;
            }
        }
        throw new IllegalArgumentException("Moeda não encontrada.");
    }

    // Método para obter a quantidade de uma moeda específica
    public double getQuantidadeMoeda(String nomeMoeda) {
        for (Moeda moeda : moedas) {
            if (moeda.getNome().equals(nomeMoeda)) {
                return moeda.getQuantidade();
            }
        }
        return 0.0;
    }
}
