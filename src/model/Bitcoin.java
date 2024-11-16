
package model;


public class Bitcoin extends Moeda implements Tarifa {

    // Definindo os atributos para as taxas de compra e venda
    private double taxCompra;
    private double taxVenda;

    public Bitcoin(double cotacao, double taxaCompra, double taxaVenda) {
        super("Bitcoin", cotacao); // Passando o nome da moeda e cotação
        this.taxCompra = taxaCompra;
        this.taxVenda = taxaVenda;
    }

    @Override
    public double TaxaCompra() {
        return taxCompra;
    }

    @Override
    public double TaxaVenda() {
        return taxVenda;
    }
}