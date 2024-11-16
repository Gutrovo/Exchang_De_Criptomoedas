/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.BancoDAO;
import DAO.Conexao;
import controller.CadastroController;
import javax.swing.JOptionPane;
import model.Pessoa;
import model.Moeda;
import controller.ComprarController;
import controller.ExtratoController;
import java.util.HashSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Comprar extends javax.swing.JFrame {

    private ExtratoController extratoController;
    private ComprarController comprarController;
    private CadastroController cadastroController;

    public Comprar(CadastroController cadastroController, ExtratoController extratoController) {
        this.cadastroController = cadastroController;
         this.extratoController = extratoController; // Recebe o controlador de extrato
        this.comprarController = new ComprarController();
        initComponents();
    }
private void mostrarMoedasDisponiveis() {
    try {
        // Conecta ao banco de dados
        Connection conn = new Conexao().getConnection();
        BancoDAO dao = new BancoDAO(conn);

        // Obtém a lista de moedas disponíveis
        List<String> moedas = dao.obterMoedasDisponiveis();

        if (moedas.isEmpty()) {
            lblTabela.setText("Nenhuma moeda disponível.");
        } else {
            StringBuilder sb = new StringBuilder("<html>");
            for (String moeda : moedas) {
                sb.append(moeda).append("<br>");
            }
            sb.append("</html>");
            lblTabela.setText(sb.toString());
        }

        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao acessar o banco de dados: " + e.getMessage());
    }
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl4 = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        txtDisplay1 = new javax.swing.JTextField();
        txtDisplay2 = new javax.swing.JTextField();
        btComprar = new javax.swing.JButton();
        TxtMoeda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtValor = new javax.swing.JTextField();
        BtVerMoedas = new javax.swing.JButton();
        lblTabela = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl4.setText("Comprar Criptomoedas");

        lblSenha.setText("Senha:");

        lblCPF.setText("CPF:");

        btComprar.setText("Comprar");
        btComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome da Moeda:");

        jLabel2.setText("Valor:");

        BtVerMoedas.setText("VerMoedas");
        BtVerMoedas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVerMoedasActionPerformed(evt);
            }
        });

        lblTabela.setText("tabela:");
        lblTabela.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(TxtMoeda, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDisplay2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(124, 124, 124)
                                        .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                                .addComponent(lblTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtVerMoedas, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(txtDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF)
                    .addComponent(txtDisplay2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(lbl4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtMoeda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(BtVerMoedas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComprarActionPerformed
     // Obtém as entradas do usuário
    String cpf = txtDisplay2.getText(); // CPF do usuário
    String senha = txtDisplay1.getText(); // Senha do usuário

    // Verifica se os campos estão vazios
    if (cpf.isEmpty() || senha.isEmpty() || TxtMoeda.getText().isEmpty() || TxtValor.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "CPF, senha, nome da moeda e valor devem ser preenchidos.");
        return;
    }

    try {
        // Conecta ao banco de dados
        Connection conn = new Conexao().getConnection();
        BancoDAO dao = new BancoDAO(conn);

        // Busca a pessoa pelo CPF
        Pessoa usuario = dao.consultarPorCPF(cpf);
        if (usuario != null) {
            // Verifica se a senha está correta
            if (usuario.getSenha().equals(senha)) {
                StringBuilder resultadoCompra = new StringBuilder();
                boolean compraRealizada = false;

                // Obtém os dados da moeda e valor
                String nomeMoeda = TxtMoeda.getText().trim();
                double valorCompra = Double.parseDouble(TxtValor.getText().trim());

                // Verifica se a moeda está disponível
                if (nomeMoeda.isEmpty() || valorCompra <= 0) {
                    JOptionPane.showMessageDialog(this, "Moeda ou valor inválidos.");
                    return;
                }

                // Cria um objeto de Moeda com o nome e valor
                Moeda moeda = new Moeda(nomeMoeda, valorCompra);

                // Processa a compra da moeda
                processarCompra(dao, usuario, moeda, valorCompra, resultadoCompra);
                compraRealizada = true;

                // Se a compra foi realizada
                if (compraRealizada) {
                    JOptionPane.showMessageDialog(this, "Compra realizada com sucesso!\n" + resultadoCompra.toString());
                    dispose(); // Fecha a janela após a compra
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhuma compra foi realizada.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Senha incorreta.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "CPF não cadastrado.");
        }

        // Fecha a conexão com o banco de dados
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao acessar o banco de dados: " + e.getMessage());
    }
}

// Método para processar a compra de uma moeda
private void processarCompra(BancoDAO dao, Pessoa usuario, Moeda moeda, double valorCompra, StringBuilder resultadoCompra) throws SQLException {
    // Obtém a cotação da moeda do banco de dados
    double cotacaoMoeda = dao.obterCotacaoMoeda(moeda.getNome());
    moeda.setCotacao(cotacaoMoeda);  // Atribui a cotação à moeda

    // Calcula a quantidade de moedas que podem ser compradas
    double quantidadeDesejada = valorCompra / moeda.getCotacao();  // Divide o valor total pela cotação da moeda

    // Verifica se o saldo do usuário é suficiente para cobrir o valor total da compra
    if (usuario.getSaldo() >= valorCompra) {
        // Subtrai o valor da compra do saldo de reais do usuário
        usuario.removerSaldo(valorCompra);

        // Atualiza a quantidade de moedas no banco de dados
        dao.atualizarMoeda(usuario.getCpf(), moeda.getNome(), quantidadeDesejada);

        // Atualiza o saldo de reais no banco
        dao.atualizarSaldo(usuario.getCpf(), usuario.getSaldo()); 

        // Exibe o resultado da compra
        resultadoCompra.append("Moeda: ").append(moeda.getNome())
            .append(" | Valor total da compra: ").append(valorCompra)
            .append(" | Quantidade comprada: ").append(quantidadeDesejada).append("\n");

        // Registra a transação no extrato
        extratoController.registrarTransacao("Compra", moeda.getNome(), valorCompra, quantidadeDesejada, usuario);

        JOptionPane.showMessageDialog(this, "Compra realizada com sucesso!\n" + resultadoCompra.toString());
    } else {
        JOptionPane.showMessageDialog(this, "Saldo insuficiente para comprar moedas de " + moeda.getNome());
    }




















    }//GEN-LAST:event_btComprarActionPerformed

    private void BtVerMoedasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtVerMoedasActionPerformed
        mostrarMoedasDisponiveis();
    }//GEN-LAST:event_BtVerMoedasActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Comprar().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtVerMoedas;
    private javax.swing.JTextField TxtMoeda;
    private javax.swing.JTextField TxtValor;
    private javax.swing.JButton btComprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTabela;
    private javax.swing.JTextField txtDisplay1;
    private javax.swing.JTextField txtDisplay2;
    // End of variables declaration//GEN-END:variables
}
