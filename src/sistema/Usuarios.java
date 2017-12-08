/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
create table usuarios(
id_usuario int primary key,
nome_usuario varchar(255) not null,
telefone_usuario varchar(11) not null,
email_usuario varchar(255) not null,
login_usuario varchar(50) not null,
senha_usuario varchar(50) not null,
perfil_usuario varchar(20) not null,
status_usuario varchar(20) not null
);
 */
package sistema;

import java.sql.*;
import bancodedados.Conexao;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.JSType;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Brunno Rodrigues
 */
public class Usuarios extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement entrada = null;
    ResultSet saida = null;

    /**
     * Creates new form Usuarios
     */
    public Usuarios() {
        initComponents();

        conexao = Conexao.conexao();
    }

    private void limpar() {
        resposta_id.setText(null);
        resposta_nome.setText(null);
        resposta_telefone.setText(null);
        resposta_email.setText(null);
        resposta_login.setText(null);
        resposta_senha.setText(null);

        botao_cadastrar.setEnabled(true);
    }

    private void pesquisar() {
        String sql = "select*from usuarios where nome_usuario like ?";
        try {
            entrada = conexao.prepareStatement(sql);

            entrada.setString(1, resposta_nome.getText() + "%");

            saida = entrada.executeQuery();

            tabela.setModel(DbUtils.resultSetToTableModel(saida));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void listar() {
        int listar = tabela.getSelectedRow();
        resposta_id.setText(tabela.getModel().getValueAt(listar, 0).toString());
        resposta_nome.setText(tabela.getModel().getValueAt(listar, 1).toString());
        resposta_telefone.setText(tabela.getModel().getValueAt(listar, 2).toString());
        resposta_email.setText(tabela.getModel().getValueAt(listar, 3).toString());
        resposta_login.setText(tabela.getModel().getValueAt(listar, 4).toString());
        resposta_senha.setText(tabela.getModel().getValueAt(listar, 5).toString());
        resposta_perfil.setSelectedItem(tabela.getModel().getValueAt(listar, 6).toString());
        resposta_status.setSelectedItem(tabela.getModel().getValueAt(listar, 7).toString());

        botao_cadastrar.setEnabled(false);
    }

    private void cadastrar() {
        String sql = "insert into usuarios(nome_usuario,telefone_usuario,email_usuario,login_usuario,senha_usuario,perfil_usuario,status_usuario) values(?,?,?,?,?,?,?)";
        try {
            entrada = conexao.prepareStatement(sql);
            entrada.setString(1, resposta_nome.getText());
            entrada.setString(2, resposta_telefone.getText());
            entrada.setString(3, resposta_email.getText());
            entrada.setString(4, resposta_login.getText());
            entrada.setString(5, resposta_senha.getText());
            entrada.setString(6, resposta_perfil.getSelectedItem().toString());
            entrada.setString(7, resposta_status.getSelectedItem().toString());

            if ((resposta_nome.getText().isEmpty()) || (resposta_telefone.getText().isEmpty()) || (resposta_email.getText().isEmpty()) || (resposta_login.getText().isEmpty()) || (resposta_senha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar vazio!");
            } else {
                int cadastrado = entrada.executeUpdate();

                if (cadastrado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                    resposta_nome.setText(null);
                    resposta_telefone.setText(null);
                    resposta_email.setText(null);
                    resposta_login.setText(null);
                    resposta_senha.setText(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void atualizar() {
        String sql = "update usuarios set nome_usuario=?,telefone_usuario=?,email_usuario=?,login_usuario=?,senha_usuario=?,perfil_usuario=?,status_usuario=? where id_usuario=?";
        try {
            entrada = conexao.prepareStatement(sql);
            entrada.setString(1, resposta_nome.getText());
            entrada.setString(2, resposta_telefone.getText());
            entrada.setString(3, resposta_email.getText());
            entrada.setString(4, resposta_login.getText());
            entrada.setString(5, resposta_senha.getText());
            entrada.setString(6, resposta_perfil.getSelectedItem().toString());
            entrada.setString(7, resposta_status.getSelectedItem().toString());
            int resposta = JSType.toInteger(resposta_id.getText());
            entrada.setInt(8, resposta);

            if ((resposta_nome.getText().isEmpty()) || (resposta_telefone.getText().isEmpty()) || (resposta_email.getText().isEmpty()) || (resposta_login.getText().isEmpty()) || (resposta_senha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar vazio!");
            } else {
                int atualizado = entrada.executeUpdate();

                if (atualizado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do Usuário alterados com sucesso!");
                    resposta_nome.setText(null);
                    resposta_telefone.setText(null);
                    resposta_email.setText(null);
                    resposta_login.setText(null);
                    resposta_senha.setText(null);

                    botao_cadastrar.setEnabled(true);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void excluir() {
        int excluir = JOptionPane.showConfirmDialog(null, "Você quer mesmo excluir este Usuário?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (excluir == JOptionPane.YES_OPTION) {
            String sql = "delete from usuarios where id_usuario=? and id_usuario <> 1";
            JOptionPane.showMessageDialog(null, "Usuário Administrador do sistema. Não pode ser excluído!");

            try {
                entrada = conexao.prepareStatement(sql);

                entrada.setString(1, resposta_id.getText());

                if ((resposta_nome.getText().isEmpty()) || (resposta_telefone.getText().isEmpty()) || (resposta_email.getText().isEmpty()) || (resposta_login.getText().isEmpty()) || (resposta_senha.getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar vazio!");
                } else {
                    int excluido = entrada.executeUpdate();

                    if (excluido > 0) {
                        JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
                        resposta_nome.setText(null);
                        resposta_telefone.setText(null);
                        resposta_email.setText(null);
                        resposta_login.setText(null);
                        resposta_senha.setText(null);

                        botao_cadastrar.setEnabled(true);
                    }

                    entrada.executeUpdate();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        texto_id = new javax.swing.JLabel();
        texto_nome = new javax.swing.JLabel();
        texto_telefone = new javax.swing.JLabel();
        texto_email = new javax.swing.JLabel();
        texto_login = new javax.swing.JLabel();
        texto_senha = new javax.swing.JLabel();
        texto_perfil = new javax.swing.JLabel();
        resposta_telefone = new javax.swing.JTextField();
        resposta_nome = new javax.swing.JTextField();
        resposta_id = new javax.swing.JTextField();
        resposta_email = new javax.swing.JTextField();
        resposta_login = new javax.swing.JTextField();
        resposta_senha = new javax.swing.JPasswordField();
        resposta_perfil = new javax.swing.JComboBox<>();
        botao_atualizar = new javax.swing.JButton();
        botao_cadastrar = new javax.swing.JButton();
        botao_limpar = new javax.swing.JButton();
        texto_preenchimento_obrigatorio = new javax.swing.JLabel();
        texto_somente_numeros = new javax.swing.JLabel();
        texto_status = new javax.swing.JLabel();
        resposta_status = new javax.swing.JComboBox<>();
        botao_exlcuir = new javax.swing.JButton();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema Restaurante - Usuários");
        setResizable(false);

        texto_id.setText("ID:");

        texto_nome.setText("Nome:");

        texto_telefone.setText("Telefone:");

        texto_email.setText("E-mail:");

        texto_login.setText("Login:");

        texto_senha.setText("Senha:");

        texto_perfil.setText("Perfil:");

        resposta_telefone.setToolTipText("64987654321");

        resposta_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                resposta_nomeKeyReleased(evt);
            }
        });

        resposta_id.setEditable(false);

        resposta_perfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Funcionário" }));

        botao_atualizar.setText("Atualizar");
        botao_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_atualizarActionPerformed(evt);
            }
        });

        botao_cadastrar.setText("Cadastrar");
        botao_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_cadastrarActionPerformed(evt);
            }
        });

        botao_limpar.setText("Limpar");
        botao_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_limparActionPerformed(evt);
            }
        });

        texto_preenchimento_obrigatorio.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        texto_preenchimento_obrigatorio.setText("O preenchimento de todos os campos (quando não gerado automaticamente) é obrigatório!");

        texto_somente_numeros.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        texto_somente_numeros.setText("Acima, somente números");

        texto_status.setText("Ativo:");

        resposta_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        botao_exlcuir.setText("Excluir");
        botao_exlcuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_exlcuirActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botao_limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botao_cadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botao_atualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botao_exlcuir))
                    .addComponent(texto_preenchimento_obrigatorio)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_telefone)
                            .addComponent(texto_email)
                            .addComponent(texto_perfil)
                            .addComponent(texto_login)
                            .addComponent(texto_senha)
                            .addComponent(texto_status))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(resposta_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(texto_somente_numeros)
                                .addComponent(resposta_email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(resposta_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(resposta_login, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(resposta_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(resposta_status, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_nome)
                            .addComponent(texto_id))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(resposta_id, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resposta_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                            .addComponent(tabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(texto_preenchimento_obrigatorio)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_id)
                    .addComponent(resposta_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_nome)
                    .addComponent(resposta_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_telefone)
                    .addComponent(resposta_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(texto_somente_numeros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_email)
                    .addComponent(resposta_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resposta_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_login))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resposta_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_senha))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resposta_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_perfil))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resposta_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_status))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_atualizar)
                    .addComponent(botao_exlcuir)
                    .addComponent(botao_limpar)
                    .addComponent(botao_cadastrar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botao_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_cadastrarActionPerformed
        // TODO add your handling code here:
        cadastrar();
    }//GEN-LAST:event_botao_cadastrarActionPerformed

    private void botao_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_atualizarActionPerformed
        // TODO add your handling code here:
        atualizar();
    }//GEN-LAST:event_botao_atualizarActionPerformed

    private void botao_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_limparActionPerformed
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_botao_limparActionPerformed

    private void botao_exlcuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_exlcuirActionPerformed
        // TODO add your handling code here:
        excluir();
    }//GEN-LAST:event_botao_exlcuirActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:
        listar();
    }//GEN-LAST:event_tabelaMouseClicked

    private void resposta_nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_resposta_nomeKeyReleased
        // TODO add your handling code here:
        pesquisar();
    }//GEN-LAST:event_resposta_nomeKeyReleased

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
            java.util.logging.Logger.getLogger(Usuarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_atualizar;
    private javax.swing.JButton botao_cadastrar;
    private javax.swing.JButton botao_exlcuir;
    private javax.swing.JButton botao_limpar;
    private javax.swing.JTextField resposta_email;
    private javax.swing.JTextField resposta_id;
    private javax.swing.JTextField resposta_login;
    private javax.swing.JTextField resposta_nome;
    private javax.swing.JComboBox<String> resposta_perfil;
    private javax.swing.JPasswordField resposta_senha;
    private javax.swing.JComboBox<String> resposta_status;
    private javax.swing.JTextField resposta_telefone;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel texto_email;
    private javax.swing.JLabel texto_id;
    private javax.swing.JLabel texto_login;
    private javax.swing.JLabel texto_nome;
    private javax.swing.JLabel texto_perfil;
    private javax.swing.JLabel texto_preenchimento_obrigatorio;
    private javax.swing.JLabel texto_senha;
    private javax.swing.JLabel texto_somente_numeros;
    private javax.swing.JLabel texto_status;
    private javax.swing.JLabel texto_telefone;
    // End of variables declaration//GEN-END:variables
}
