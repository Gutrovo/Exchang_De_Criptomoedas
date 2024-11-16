/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.BancoDAO;
import DAO.Conexao;
import model.Pessoa;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CadastroController {

    // Construtor
    public CadastroController() {}

    // Adiciona uma nova pessoa ao banco de dados
    public void adicionarPessoa(String nome, String senha, String cpf) {
        Pessoa pessoa = new Pessoa(nome, senha, cpf);
        try {
            Connection conn = new Conexao().getConnection(); // Cria a conexão com o banco
            BancoDAO dao = new BancoDAO(conn); // Cria uma instância de BancoDAO usando a conexão
            dao.inserir(pessoa); // Insere a nova pessoa no banco
            conn.close(); // Fecha a conexão após inserir
            JOptionPane.showMessageDialog(null, "Cadastro criado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar pessoa: " + e.getMessage());
        }
    }
    
    public Pessoa buscarPessoaPorCPF(String cpf) {
    try {
        Connection conn = new Conexao().getConnection(); // Cria a conexão com o banco
        BancoDAO dao = new BancoDAO(conn);
        Pessoa pessoa = dao.consultarPorCPF(cpf); // Implementaremos esse método em BancoDAO
        conn.close();
        return pessoa;
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao buscar pessoa: " + e.getMessage());
        return null;
    }
}
}
