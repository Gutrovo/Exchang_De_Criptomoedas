/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.CadastroController;
import controller.ExtratoController;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Pessoa;

public class Extrato extends javax.swing.JFrame {

    private ExtratoController extratoController;
    private CadastroController cadastroController;

    public Extrato(CadastroController cadastroController, ExtratoController extratoController) {
        initComponents();
        this.cadastroController = cadastroController;
        this.extratoController = extratoController;
    }

    // Método para exibir o extrato no lblTabela
    private void mostrarExtrato(String cpf) {
    lblTabela.setText(""); // Limpa o texto do lblTabela antes de exibir
    StringBuilder extrato = new StringBuilder("<html>");

    // Busca as transações do banco de dados para o CPF específico
    for (String transacao : extratoController.getTransacoes(cpf)) {
        extrato.append(transacao).append("<br>");
    }

    extrato.append("</html>");
    lblTabela.setText(extrato.toString());
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        lblTabela = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Senha:");

        jLabel2.setText("CPF:");

        lblTabela.setText("tabela:");
        lblTabela.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jButton1.setText("Ver Extrato");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2)
                        .addGap(181, 181, 181))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(63, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(lblTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cpf = jTextField2.getText();
        String senha = jTextField1.getText();

        // Verifica se os campos estão vazios
        if (cpf.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "CPF e senha devem ser preenchidos.");
            return;
        }

        // Busca a pessoa pelo CPF
        Pessoa usuario = cadastroController.buscarPessoaPorCPF(cpf);
        if (usuario != null) {
            // Verifica se a senha está correta
            if (usuario.getSenha().equals(senha)) {
                mostrarExtrato(cpf); // Exibe o extrato do banco de dados
            } else {
                JOptionPane.showMessageDialog(this, "Senha incorreta.");
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
        //            java.util.logging.Logger.getLogger(Extrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //        } catch (InstantiationException ex) {
        //            java.util.logging.Logger.getLogger(Extrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //        } catch (IllegalAccessException ex) {
        //            java.util.logging.Logger.getLogger(Extrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        //            java.util.logging.Logger.getLogger(Extrato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //        }
        //        //</editor-fold>
        //
        //        /* Create and display the form */
        //        java.awt.EventQueue.invokeLater(new Runnable() {
        //            public void run() {
        //                new Extrato().setVisible(true);
        //            }
        //        });
        //    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblTabela;
    // End of variables declaration//GEN-END:variables
}
