/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;




import model.Moeda;
import model.Bitcoin;
import model.Ethereum;
import model.Ripple;

public class VenderController {
    // Modificação aqui: Venda sem aplicar a taxa
    public double vender(Moeda moeda, double valorVenda) {
        return valorVenda; // Retorna o valor total da venda, sem a taxa
    }
}
