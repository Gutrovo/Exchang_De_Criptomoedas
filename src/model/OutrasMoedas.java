/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Vinicius
 */
public class OutrasMoedas extends Moeda implements Tarifa {
    private float taxaCompra;
    private float taxaVenda;

    public OutrasMoedas(String nome, double cotacao, float taxaCompra, float taxaVenda) {
        super(nome, cotacao);  // Apenas dois parâmetros: nome e cotacao
        this.taxaCompra = taxaCompra;
        this.taxaVenda = taxaVenda;
    }

    @Override
    public double TaxaCompra() {
        return taxaCompra;
    }

    @Override
    public double TaxaVenda() {
        return taxaVenda;
    }

    public float getTaxaCompra() {
        return taxaCompra;
    }

    public void setTaxaCompra(float taxaCompra) {
        this.taxaCompra = taxaCompra;
    }

    public float getTaxaVenda() {
        return taxaVenda;
    }

    public void setTaxaVenda(float taxaVenda) {
        this.taxaVenda = taxaVenda;
    }
}