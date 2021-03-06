/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.sql.*;
import bancodedados.Conexao;
import javax.swing.JOptionPane;

/**
 *
 * @author Brunno Rodrigues
 */
public class Login extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement entrada = null;
    ResultSet saida = null;

    public void logar() {
        String sql = "select*from usuarios where login_usuario=? and senha_usuario=?";
        try {
            entrada = conexao.prepareStatement(sql);
            entrada.setString(1, resposta_usuario.getText());
            entrada.setString(2, resposta_senha.getText());

            saida = entrada.executeQuery();

            if (saida.next()) {
                String perfil = saida.getString(7);
                if (perfil.equals("Administrador")) {
                    Inicio inicio = new Inicio();
                    inicio.setVisible(true);
                    Inicio.menu_usuarios.setEnabled(true);
                    this.dispose();
                } else {
                    Inicio inicio = new Inicio();
                    inicio.setVisible(true);
                    this.dispose();
                }
                String status = saida.getString(8);
                if (status.equals("Não")) {
                    JOptionPane.showMessageDialog(null, "Usuário sem permissões para acessar o sistema!");
                    System.exit(0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido(s)!");
                resposta_usuario.setText(null);
                resposta_senha.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();

        conexao = Conexao.conexao();
        System.out.println(conexao);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        texto_usuario = new javax.swing.JLabel();
        texto_senha = new javax.swing.JLabel();
        botao_login = new javax.swing.JButton();
        resposta_usuario = new javax.swing.JTextField();
        resposta_senha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Restaurante - Login");
        setMaximumSize(new java.awt.Dimension(0, 0));
        setResizable(false);

        texto_usuario.setText("Usuário");

        texto_senha.setText("Senha");

        botao_login.setText("Login");
        botao_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 223, Short.MAX_VALUE)
                        .addComponent(botao_login))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_usuario)
                            .addComponent(texto_senha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resposta_senha)
                            .addComponent(resposta_usuario))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_usuario)
                    .addComponent(resposta_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(texto_senha)
                    .addComponent(resposta_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botao_login)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("login");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botao_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_loginActionPerformed
        // TODO add your handling code here:
        logar();
    }//GEN-LAST:event_botao_loginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_login;
    private javax.swing.JPasswordField resposta_senha;
    private javax.swing.JTextField resposta_usuario;
    private javax.swing.JLabel texto_senha;
    private javax.swing.JLabel texto_usuario;
    // End of variables declaration//GEN-END:variables
}
