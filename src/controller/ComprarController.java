package controller;

import DAO.BancoDAO;
import model.Moeda;
import model.Pessoa;
import java.sql.SQLException;

public class ComprarController {

    public void comprar(Moeda moeda, double valorCompra, BancoDAO dao, Pessoa usuario) throws SQLException {
        // Obtém a cotação da moeda
        double cotacao = dao.obterCotacaoMoeda(moeda.getNome());

        // Calcula a quantidade de moedas que o usuário pode comprar
        double quantidadeMoedas = valorCompra / cotacao;

        // Verifica se a quantidade a ser comprada é válida (não pode ser zero ou negativa)
        if (quantidadeMoedas <= 0) {
            throw new IllegalArgumentException("Quantidade inválida de moeda.");
        }

        // Verifica se o usuário tem saldo suficiente para realizar a compra
        if (usuario.getSaldo() < valorCompra) {
            throw new SQLException("Saldo insuficiente para realizar a compra.");
        }

        // Atualiza o saldo do usuário
        usuario.removerSaldo(valorCompra);

        // Atualiza a quantidade de moedas do usuário no banco
        dao.atualizarMoeda(usuario.getCpf(), moeda.getNome(), quantidadeMoedas);

        // Atualiza o saldo no banco de dados
        dao.atualizarSaldo(usuario.getCpf(), usuario.getSaldo());
    }
}
