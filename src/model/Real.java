
package model;


public class Real extends Moeda {

    public Real(double valorAtual) {
        super("Real", valorAtual);
    }

    

   
    public double calcularValor(double valor) {
        // Para o Real, o valor não sofre alteração, mas mantemos o método para uniformidade
        return valor;
    }
}
