package DAO;

import model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; // Importação do ResultSet
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class BancoDAO {

    private Connection conn;

    public BancoDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO public.\"Investidor\" (nome, senha, cpf, bitcoin, ethereum, ripple, flash) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getNome());
        statement.setString(2, pessoa.getSenha());
        statement.setString(3, pessoa.getCpf());
        statement.setDouble(4, 0); // Inicializa o valor do Bitcoin
        statement.setDouble(5, 0); // Inicializa o valor do Ethereum
        statement.setDouble(6, 0); // Inicializa o valor do Ripple
        statement.setDouble(7, 0); // Inicializa o valor do Flash
        statement.executeUpdate();
        statement.close();
    }

    public Pessoa consultarPorCPF(String cpf) throws SQLException {
        String sql = "SELECT nome, senha, cpf, reais FROM public.\"Investidor\" WHERE cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, cpf);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String nome = resultSet.getString("nome");
            String senha = resultSet.getString("senha");
            double saldo = resultSet.getDouble("reais");  // Pega o saldo da coluna "reais"
            Pessoa pessoa = new Pessoa(nome, cpf, senha);
            pessoa.setSaldo(saldo);  // Define o saldo na instância de Pessoa
            return pessoa;
        } else {
            return null; // Retorna null se não encontrar a pessoa
        }
    }

    public void atualizarSaldo(String cpf, double novoSaldo) throws SQLException {
        String sql = "UPDATE \"Investidor\" SET reais = ? WHERE cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, novoSaldo); // Atualiza o saldo
        statement.setString(2, cpf); // Usa o CPF para identificar o usuário
        statement.executeUpdate(); // Executa a atualização no banco de dados
        statement.close();
    }

    public void atualizarMoeda(String cpf, String nomeMoeda, double quantidade) throws SQLException {
        String colunaMoeda = nomeMoeda.toLowerCase();

        // Cria um objeto do tipo Pessoa com o CPF informado
        Pessoa usuario = consultarPorCPF(cpf); // Aqui você deve obter o usuário corretamente

        // Verifica se a quantidade a ser comprada é válida
        if (quantidade <= 0) {
            JOptionPane.showMessageDialog(null, "Quantidade inválida para adição.");
            throw new IllegalArgumentException("Quantidade inválida para adição.");
        }

        // Obtém a cotação da moeda do banco de dados
        double cotacao = obterCotacaoMoeda(nomeMoeda);
        System.out.println("Cotação obtida para a moeda " + nomeMoeda + ": " + cotacao);

        // Calcula o valor da compra com a cotação da moeda
        double valorCompra = quantidade * cotacao;
        double novoSaldoReais = usuario.getSaldo() - valorCompra;

        // Verifica se o saldo do usuário é suficiente
        if (novoSaldoReais < 0) {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente para comprar " + quantidade + " moedas de " + nomeMoeda);
            return;
        }

        // Atualiza o saldo do usuário no banco de dados
        atualizarSaldo(cpf, novoSaldoReais);

        // Atualiza a quantidade de moeda no banco de dados
        double quantidadeAtual = consultarQuantidadeMoeda(cpf, nomeMoeda);
        double novaQuantidade = quantidadeAtual + quantidade;

        // Atualiza o banco de dados
        String sqlUpdate = "UPDATE \"Investidor\" SET " + colunaMoeda + " = ? WHERE cpf = ?";
        PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate);
        stmtUpdate.setDouble(1, novaQuantidade); // Usa o tipo correto para atualizar a quantidade
        stmtUpdate.setString(2, cpf);
        int rowsUpdated = stmtUpdate.executeUpdate();
        System.out.println("Número de linhas atualizadas: " + rowsUpdated);
    }

    public double consultarQuantidadeMoeda(String cpf, String nomeMoeda) throws SQLException {
        String colunaMoeda = nomeMoeda.toLowerCase();  // Convertendo o nome da moeda para minúsculas
        String sql = "SELECT " + colunaMoeda + " FROM \"Investidor\" WHERE cpf = ?";  // Consulta a quantidade da moeda no banco
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cpf);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String valorString = rs.getString(colunaMoeda);  // Retorna o valor da coluna da moeda

            if (valorString != null && !valorString.trim().isEmpty()) {
                try {
                    return Double.parseDouble(valorString);  // Converte para double e retorna
                } catch (NumberFormatException e) {
                    System.out.println("Erro de conversão para a moeda " + nomeMoeda + ": " + valorString);
                    return 0;
                }
            }
        }
        return 0;  // Se não encontrar, retorna 0
    }

    // Método para registrar a transação no banco de dados
    public void registrarTransacao(String nome, String cpf, String senha, String transacao) throws SQLException {
        String sqlInsert = "INSERT INTO public.extrato (nome, cpf, senha, extrato) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {
            stmtInsert.setString(1, nome);
            stmtInsert.setString(2, cpf);
            stmtInsert.setString(3, senha);
            stmtInsert.setString(4, transacao);

            int rowsInserted = stmtInsert.executeUpdate();
            System.out.println("Número de linhas inseridas: " + rowsInserted); // Verifica se a transação foi salva
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Lança a exceção para tratá-la em outra parte do código
        }
    }

    public List<String> obterTransacoesPorCPF(String cpf) throws SQLException {
        List<String> transacoes = new ArrayList<>();
        String sqlSelect = "SELECT extrato FROM public.extrato WHERE cpf = ?";

        try (PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect)) {
            stmtSelect.setString(1, cpf);
            ResultSet rs = stmtSelect.executeQuery();

            while (rs.next()) {
                transacoes.add(rs.getString("extrato"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Lança a exceção para tratá-la em outra parte do código
        }

        return transacoes;
    }

    public List<String> obterMoedasDisponiveis() throws SQLException {
        List<String> moedas = new ArrayList<>();
        // Consulta para buscar as colunas que representam moedas na tabela Investidor
        String sqlSelect = "SELECT column_name FROM information_schema.columns WHERE table_name = 'Investidor' AND column_name NOT IN ('nome', 'senha', 'cpf', 'reais')";

        try (PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect)) {
            ResultSet rs = stmtSelect.executeQuery();

            while (rs.next()) {
                moedas.add(rs.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return moedas;
    }

    public boolean moedaExiste(String nomeMoeda) throws SQLException {
        String colunaMoeda = nomeMoeda.toLowerCase();

        // Consulta se a coluna da moeda existe na tabela
        String sql = "SELECT column_name FROM information_schema.columns WHERE table_name = 'Investidor' AND column_name = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, colunaMoeda);
        ResultSet rs = ps.executeQuery();

        return rs.next(); // Se encontrar a coluna, a moeda existe
    }

    public double obterCotacaoMoeda(String nomeMoeda) throws SQLException {
        String sql = "SELECT cotacao FROM cotacao WHERE LOWER(moedas) = LOWER(?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nomeMoeda.trim().toLowerCase()); // Converte para minúsculas para a comparação
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            double cotacao = rs.getDouble("cotacao");
            return cotacao;
        }

        throw new SQLException("Cotação não encontrada para " + nomeMoeda);
    }

    public void atualizarCotacao(String nomeMoeda, double novaCotacao) throws SQLException {
        String sql = "UPDATE \"Investidor\" SET cotacao = ? WHERE nome = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setDouble(1, novaCotacao);
        stmt.setString(2, nomeMoeda);
        stmt.executeUpdate();
    }

    public ResultSet consultarSaldoCompleto(String cpf) throws SQLException {
        String sql = "SELECT nome, cpf, senha, reais, bitcoin, ethereum, ripple FROM \"Investidor\" WHERE cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, cpf);
        return statement.executeQuery();
    }

    public void venderMoeda(String cpf, String nomeMoeda, double quantidade) throws SQLException {
        String colunaMoeda = nomeMoeda.toLowerCase();  // Converte o nome da moeda para minúsculas

        // Cria um objeto do tipo Pessoa com o CPF informado
        Pessoa usuario = consultarPorCPF(cpf); // Aqui você deve obter o usuário corretamente

        // Verifica se a quantidade a ser vendida é válida
        if (quantidade <= 0) {
            JOptionPane.showMessageDialog(null, "Quantidade inválida para venda.");
            throw new IllegalArgumentException("Quantidade inválida para venda.");
        }

        // Obtém a quantidade atual da moeda no banco de dados
        double quantidadeAtual = consultarQuantidadeMoeda(cpf, nomeMoeda);
        System.out.println("Quantidade atual de " + nomeMoeda + ": " + quantidadeAtual);

        // Verifica se o usuário possui a quantidade de moeda para vender
        if (quantidadeAtual < quantidade) {
            JOptionPane.showMessageDialog(null, "Quantidade insuficiente de " + nomeMoeda + " para venda.");
            return;
        }

        // Subtrai a quantidade de moeda que o usuário quer vender
        double novaQuantidade = quantidadeAtual - quantidade;

        // Atualiza a quantidade no banco de dados
        String sqlUpdate = "UPDATE \"Investidor\" SET " + colunaMoeda + " = ? WHERE cpf = ?";
        PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate);
        stmtUpdate.setDouble(1, novaQuantidade); // Subtrai a quantidade de moedas
        stmtUpdate.setString(2, cpf);
        int rowsUpdated = stmtUpdate.executeUpdate();
        System.out.println("Número de linhas atualizadas: " + rowsUpdated);

        // Atualiza o saldo de reais do usuário com o valor da venda
        double valorVenda = quantidade * obterCotacaoMoeda(nomeMoeda);  // Calcula o valor da venda
        double novoSaldoReais = usuario.getSaldo() + valorVenda;
        atualizarSaldo(cpf, novoSaldoReais); // Atualiza o saldo de reais do usuário

        System.out.println("Valor da venda: " + valorVenda);
        System.out.println("Novo saldo de reais: " + novoSaldoReais);
    }

    public void atualizarCotacaoRandomica(String nomeMoeda) throws SQLException {
        // Obter a cotação atual
        double cotacaoAtual = obterCotacaoMoeda(nomeMoeda);
        System.out.println("Cotação atual para " + nomeMoeda + ": " + cotacaoAtual);

        // Gerar variação aleatória entre -5% e +5%
        Random rand = new Random();
        double variacaoPercentual = (rand.nextDouble() * 0.1) - 0.05; // Gera um valor entre -0.05 e 0.05
        double novaCotacao = cotacaoAtual * (1 + variacaoPercentual);  // Aplica a variação

        // Atualiza a cotação no banco de dados
        String sqlUpdate = "UPDATE cotacao SET cotacao = ? WHERE LOWER(moedas) = LOWER(?)";
        PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate);
        stmtUpdate.setDouble(1, novaCotacao);
        stmtUpdate.setString(2, nomeMoeda.trim().toLowerCase());  // Converte o nome da moeda para minúsculas
        int rowsUpdated = stmtUpdate.executeUpdate();
        System.out.println("Cotação atualizada para " + nomeMoeda + ": " + novaCotacao);
    }

}
