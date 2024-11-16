/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.BancoDAO;
import DAO.Conexao;
import controller.CadastroController;
import controller.ExtratoController;
import javax.swing.JOptionPane;
import model.Pessoa;
import java.sql.Connection;
import java.sql.SQLException;


public class Sacar extends javax.swing.JFrame {
     private CadastroController cadastroController;
    private ExtratoController extratoController; // Adiciona ExtratoController como variável de instância
   
    public Sacar(CadastroController cadastroController, ExtratoController extratoController) {
        this.cadastroController = cadastroController;
         this.extratoController = extratoController; // Inicializa extratoController
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDisplay1 = new javax.swing.JTextField();
        txtDisplay2 = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        txtDisplay3 = new javax.swing.JTextField();
        btSacar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Senha:");

        jLabel2.setText("CPF:");

        lblValor.setText("Valor que deseja sacar:");

        btSacar.setText("Sacar");
        btSacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSacarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDisplay2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(txtDisplay3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(btSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDisplay2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDisplay3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSacarActionPerformed
        // Obtém as entradas do usuário
    String cpf = txtDisplay2.getText(); // CPF do usuário
    String senha = txtDisplay1.getText(); // Senha do usuário
    String valorStr = txtDisplay3.getText(); // Valor a sacar

    // Verifica se os campos estão vazios
    if (cpf.isEmpty() || senha.isEmpty() || valorStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.");
        return;
    }

    double valor;
    try {
        valor = Double.parseDouble(valorStr); // Tenta converter o valor para double
        if (valor <= 0) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor positivo.");
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Valor inválido. Por favor, insira um número.");
        return;
    }

    try {
        // Conecta ao banco de dados
        Connection conn = new Conexao().getConnection();
        BancoDAO dao = new BancoDAO(conn);

        // Busca a pessoa pelo CPF
        Pessoa usuario = dao.consultarPorCPF(cpf);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            // Verifica se o saldo é suficiente
            if (usuario.getSaldo() >= valor) {
                // Subtrai o valor do saldo e atualiza no banco
                double novoSaldo = usuario.getSaldo() - valor;
                dao.atualizarSaldo(cpf, novoSaldo); // Atualiza o saldo no banco

                // Fecha a conexão
                conn.close();

                // Registra o saque no ExtratoController
               extratoController.registrarTransacao("Saque", "Reais", valor, 0.0, usuario);

                // Exibe a mensagem de sucesso com o saldo atualizado
                JOptionPane.showMessageDialog(this, "Saque realizado com sucesso! Saldo atual: " + novoSaldo);
                dispose(); // Fecha a janela após o saque
            } else {
                JOptionPane.showMessageDialog(this, "Saldo insuficiente para saque.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "CPF ou senha incorretos.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao realizar saque: " + e.getMessage());
    }


    }//GEN-LAST:event_btSacarActionPerformed

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
//            java.util.logging.Logger.getLogger(Sacar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Sacar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Sacar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Sacar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Sacar().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSacar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTextField txtDisplay1;
    private javax.swing.JTextField txtDisplay2;
    private javax.swing.JTextField txtDisplay3;
    // End of variables declaration//GEN-END:variables
}
