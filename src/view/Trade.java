/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.BancoDAO;
import controller.CadastroController;
import controller.ExtratoController;
import controller.SaldoController;
import controller.VenderController;
import java.util.ArrayList;
import model.Pessoa;
import java.sql.SQLException;
import DAO.Conexao;  // Importando a classe Conexao
import DAO.BancoDAO;  // Importando a classe BancoDAO
import java.sql.Connection;  // Para usar o tipo Connection
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Bitcoin;
import model.Ethereum;
import model.Moeda;
import model.Ripple;


public class Trade extends javax.swing.JFrame {

    private ExtratoController extratoController;

    private CadastroController cadastroController;

    public Trade() {
         initComponents();
        cadastroController = new CadastroController();
        
        try {
            // Criação da instância de Conexao e obtendo a conexão
            Conexao conexao = new Conexao();  
            Connection conn = conexao.getConnection();  // Obtém a conexão com o banco

            BancoDAO dao = new BancoDAO(conn);  // Passa a conexão para o BancoDAO
            extratoController = new ExtratoController(dao);  // Passa a instância de BancoDAO para o ExtratoController
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btLogin = new javax.swing.JButton();
        txtBemvindo = new javax.swing.JLabel();
        btConsultarSD = new javax.swing.JButton();
        btConsultarEX = new javax.swing.JButton();
        btDepositar = new javax.swing.JButton();
        btSacar = new javax.swing.JButton();
        btComprar = new javax.swing.JButton();
        btVender = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btLogin.setText("Nao mexer");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        txtBemvindo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txtBemvindo.setForeground(new java.awt.Color(0, 255, 204));
        txtBemvindo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBemvindo.setText("Bem-Vindo");

        btConsultarSD.setText("Consultar saldo");
        btConsultarSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarSDActionPerformed(evt);
            }
        });

        btConsultarEX.setText("Consultar extrato");
        btConsultarEX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarEXActionPerformed(evt);
            }
        });

        btDepositar.setText("Depositar");
        btDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDepositarActionPerformed(evt);
            }
        });

        btSacar.setText("Sacar");
        btSacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSacarActionPerformed(evt);
            }
        });

        btComprar.setText("Comprar Criptomoedas");
        btComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprarActionPerformed(evt);
            }
        });

        btVender.setText("Vender Criptomoedas");
        btVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVenderActionPerformed(evt);
            }
        });

        btAtualizar.setText("Atualizar cotação");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(txtBemvindo, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(222, 222, 222)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btConsultarSD, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btConsultarEX, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btVender, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 107, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBemvindo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btConsultarSD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btConsultarEX, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btVender, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        Cadastro cadastroFrame = new Cadastro(cadastroController);
        cadastroFrame.setVisible(true);
    }//GEN-LAST:event_btLoginActionPerformed

    private void btConsultarSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarSDActionPerformed
        Saldo extratoFrame = new Saldo(cadastroController);
        extratoFrame.setVisible(true);
    }//GEN-LAST:event_btConsultarSDActionPerformed

    private void btConsultarEXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarEXActionPerformed
        Extrato extratoFrame = new Extrato(cadastroController, extratoController);
        extratoFrame.setVisible(true);
    }//GEN-LAST:event_btConsultarEXActionPerformed

    private void btDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDepositarActionPerformed
        Depositar depositarFrame = new Depositar(cadastroController, extratoController);
        depositarFrame.setVisible(true);
    }//GEN-LAST:event_btDepositarActionPerformed

    private void btSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSacarActionPerformed
        Sacar sacarFrame = new Sacar(cadastroController, extratoController);
        sacarFrame.setVisible(true);
    }//GEN-LAST:event_btSacarActionPerformed

    private void btComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComprarActionPerformed
        Comprar compra = new Comprar(cadastroController, extratoController);
        compra.setVisible(true);
    }//GEN-LAST:event_btComprarActionPerformed

    private void btVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVenderActionPerformed
        VenderController venderController = new VenderController();
        Vender venderFrame = new Vender(cadastroController, venderController, extratoController);
        venderFrame.setVisible(true);
    }//GEN-LAST:event_btVenderActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btSairActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
try {
        // Conectar ao banco de dados
        Connection conn = new Conexao().getConnection();
        BancoDAO dao = new BancoDAO(conn);

        // Atualiza a cotação do Bitcoin
        dao.atualizarCotacaoRandomica("Bitcoin");

        // Atualiza a cotação do Ethereum
        dao.atualizarCotacaoRandomica("Ethereum");

        // Atualiza a cotação do Ripple
        dao.atualizarCotacaoRandomica("Ripple");
        
        conn.close(); // Fecha a conexão com o banco
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao acessar o banco de dados: " + e.getMessage());
    }



    }//GEN-LAST:event_btAtualizarActionPerformed

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
//            java.util.logging.Logger.getLogger(Trade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Trade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Trade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Trade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Trade().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btComprar;
    private javax.swing.JButton btConsultarEX;
    private javax.swing.JButton btConsultarSD;
    private javax.swing.JButton btDepositar;
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btSacar;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btVender;
    private javax.swing.JLabel txtBemvindo;
    // End of variables declaration//GEN-END:variables
}
