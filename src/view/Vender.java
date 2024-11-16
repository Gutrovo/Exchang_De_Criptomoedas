
package view;

import DAO.BancoDAO;
import DAO.Conexao;
import controller.CadastroController;
import controller.ExtratoController;
import controller.VenderController;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import model.Bitcoin;
import model.Ethereum;
import model.Pessoa;
import model.Ripple;
import model.Moeda;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class Vender extends javax.swing.JFrame {

   private ExtratoController extratoController;
    private VenderController venderController;
    private CadastroController cadastroController;
    private Connection conn;

     public Vender(CadastroController cadastroController, VenderController venderController, ExtratoController extratoController) {
        this.cadastroController = cadastroController;
        this.venderController = venderController;
        this.extratoController = extratoController;
        initComponents();
        
        try {
            // Estabelece a conexão com o banco
            conn = new Conexao().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

private void mostrarMoedasDisponiveis() {
        try {
            BancoDAO dao = new BancoDAO(conn);
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

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao acessar o banco de dados: " + e.getMessage());
        }
    }

private void processarVenda(BancoDAO dao, Pessoa usuario, Moeda moeda, double quantidadeVenda, StringBuilder resultadoVenda) throws SQLException {
    if (quantidadeVenda > 0) {
        // Chama o método venderMoeda para subtrair a quantidade e atualizar o saldo
        dao.venderMoeda(usuario.getCpf(), moeda.getNome(), quantidadeVenda);

        // Exibe o resultado da venda
        resultadoVenda.append("Moeda: ").append(moeda.getNome())
            .append(" | Valor total da venda: ").append(moeda.getCotacao() * quantidadeVenda)
            .append(" | Quantidade Vendida: ").append(quantidadeVenda).append("\n");

        // Registra a transação no extrato
        extratoController.registrarTransacao("Venda", moeda.getNome(), moeda.getCotacao() * quantidadeVenda, quantidadeVenda, usuario);
    } else {
        JOptionPane.showMessageDialog(this, "Quantidade inválida para venda.");
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSenha = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        txtDisplay1 = new javax.swing.JTextField();
        txtDisplay2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btVender = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtMoeda = new javax.swing.JTextField();
        TxtValor = new javax.swing.JTextField();
        lblTabela = new javax.swing.JLabel();
        BtVerMoedas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSenha.setText("Senha:");

        lblCPF.setText("CPF:");

        jLabel2.setText("Vender Criptomoedas");

        btVender.setText("Vender");
        btVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVenderActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome da Moeda:");

        jLabel3.setText("Valor:");

        lblTabela.setText("tabela:");
        lblTabela.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        BtVerMoedas.setText("VerMoedas");
        BtVerMoedas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVerMoedasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDisplay2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(btVender, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtVerMoedas, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(TxtMoeda, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(lblTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(txtDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF)
                    .addComponent(txtDisplay2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TxtMoeda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btVender, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtVerMoedas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVenderActionPerformed
       String cpf = txtDisplay2.getText(); // CPF do usuário
    String senha = txtDisplay1.getText(); // Senha do usuário

    // Verifica se os campos estão vazios
    if (cpf.isEmpty() || senha.isEmpty() || TxtMoeda.getText().isEmpty() || TxtValor.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "CPF, senha, nome da moeda e valor devem ser preenchidos.");
        return;
    }

    // Busca a pessoa pelo CPF
    Pessoa usuario = cadastroController.buscarPessoaPorCPF(cpf);
    if (usuario != null) {
        // Verifica se a senha está correta
        if (usuario.getSenha().equals(senha)) {
            StringBuilder resultadoVenda = new StringBuilder();
            boolean vendaRealizada = false;

            // Obtém os dados da moeda e valor
            String nomeMoeda = TxtMoeda.getText().trim();
            double quantidadeVenda = Double.parseDouble(TxtValor.getText().trim());

            // Verifica se a moeda está disponível
            if (nomeMoeda.isEmpty() || quantidadeVenda <= 0) {
                JOptionPane.showMessageDialog(this, "Moeda ou valor inválidos.");
                return;
            }

            // Cria um objeto de Moeda com o nome e valor
            Moeda moeda = new Moeda(nomeMoeda, quantidadeVenda);

            // Instancia o BancoDAO
            BancoDAO dao = new BancoDAO(conn);

            try {
                // Processa a venda da moeda
                processarVenda(dao, usuario, moeda, quantidadeVenda, resultadoVenda);
                vendaRealizada = true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Erro ao processar a venda: " + e.getMessage());
                e.printStackTrace(); // Para fins de depuração
                return;
            }

            // Se a venda foi realizada
            if (vendaRealizada) {
                JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!\n" + resultadoVenda.toString());
                dispose(); // Fecha a janela após a venda
            } else {
                JOptionPane.showMessageDialog(this, "Nenhuma venda foi realizada.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Senha incorreta.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "CPF não cadastrado.");
    }


    


    }//GEN-LAST:event_btVenderActionPerformed

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
//            java.util.logging.Logger.getLogger(Vender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Vender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Vender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Vender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Vender().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtVerMoedas;
    private javax.swing.JTextField TxtMoeda;
    private javax.swing.JTextField TxtValor;
    private javax.swing.JButton btVender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTabela;
    private javax.swing.JTextField txtDisplay1;
    private javax.swing.JTextField txtDisplay2;
    // End of variables declaration//GEN-END:variables
}
