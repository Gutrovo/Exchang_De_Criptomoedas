/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.BancoDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaldoController {

    private CadastroController cadastroController; // Armazenar o CadastroController

    // Alterando o construtor para aceitar o CadastroController
    public SaldoController(CadastroController cadastroController) {
        this.cadastroController = cadastroController;
    }

    public String consultarExtrato(String cpf, String senha) {
        StringBuilder resultado = new StringBuilder();

        try {
            Connection conn = new Conexao().getConnection();
            BancoDAO dao = new BancoDAO(conn);
            ResultSet rs = dao.consultarSaldoCompleto(cpf);

            if (rs.next()) {
                String nome = rs.getString("nome");
                String cpfBanco = rs.getString("cpf");
                String senhaBanco = rs.getString("senha");

                if (senhaBanco.equals(senha)) {
                    resultado.append("Nome: ").append(nome).append("\n");
                    resultado.append("CPF: ").append(cpfBanco).append("\n\n");

                    // Exibe o saldo das moedas dinamicamente
                    for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                        String columnName = rs.getMetaData().getColumnName(i + 1);
                        if (!columnName.equals("nome") && !columnName.equals("cpf") && !columnName.equals("senha")) {
                            // Não exibe as colunas nome, cpf e senha
                            Double saldo = rs.getDouble(columnName);
                            if (saldo == 0) {  // Se o valor for zero ou nulo, coloque "0" ou "Não disponível"
                                resultado.append(columnName).append(": Não disponível\n");
                            } else {
                                resultado.append(columnName).append(": ").append(saldo).append("\n");
                            }
                        }
                    }
                } else {
                    resultado.append("CPF ou senha incorretos.");
                }
            } else {
                resultado.append("Investidor não encontrado.");
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            resultado.append("Erro ao consultar saldo: ").append(e.getMessage());
        }
        return resultado.toString();
    }
}
