/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
create table fornecedores(
cnpj_fornecedor varchar(14) primary key not null,
nome_fornecedor varchar(255) not null,
telefone_fornecedor varchar(11) not null,
email_fornecedor varchar(255) not null
);
 */
package sistema;

import java.sql.*;
import bancodedados.Conexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Brunno Rodrigues
 */
public class Fornecedores extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement entrada = null;
    ResultSet saida = null;
    /**
     * Creates new form Usuarios
     */
    public Fornecedores() {
        initComponents();

        conexao = Conexao.conexao();
    }

    private void limpar() {
        resposta_cnpj.setText(null);
        resposta_nome.setText(null);
        resposta_telefone.setText(null);
        resposta_email.setText(null);
        
        botao_cadastrar.setEnabled(true);
    }

    private void pesquisar() {
        String sql = "select*from fornecedores where nome_fornecedor like ?";
        try {
            entrada = conexao.prepareStatement(sql);

            entrada.setString(1, resposta_pesquisar.getText() + "%");

            saida = entrada.executeQuery();

            tabela.setModel(DbUtils.resultSetToTableModel(saida));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void listar() {
        int listar = tabela.getSelectedRow();
        resposta_cnpj.setText(tabela.getModel().getValueAt(listar, 0).toString());
        resposta_nome.setText(tabela.getModel().getValueAt(listar, 1).toString());
        resposta_telefone.setText(tabela.getModel().getValueAt(listar, 2).toString());
        resposta_email.setText(tabela.getModel().getValueAt(listar, 3).toString());
        EnderecosFornecedores cnpj = new EnderecosFornecedores();
        cnpj.CNPJ_FORNECEDOR = tabela.getModel().getValueAt(listar, 0).toString();

        botao_cadastrar.setEnabled(false);
    }

    private void cadastrar() {
        String sql = "insert into fornecedores(cpf_fornecedor,nome_fornecedor,telefone_fornecedor,email_fornecedor) values(?,?,?,?)";
        try {
            entrada = conexao.prepareStatement(sql);
            entrada.setString(1, resposta_cnpj.getText());
            entrada.setString(2, resposta_nome.getText());
            entrada.setString(3, resposta_telefone.getText());
            entrada.setString(4, resposta_email.getText());

            if ((resposta_cnpj.getText().isEmpty()) || (resposta_nome.getText().isEmpty()) || (resposta_telefone.getText().isEmpty()) || (resposta_email.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar vazio!");
            } else {
                int cadastrado = entrada.executeUpdate();

                if (cadastrado > 0) {
                    JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");
                    resposta_nome.setText(null);
                    resposta_telefone.setText(null);
                    resposta_email.setText(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void atualizar() {
        String sql = "update fornecedores set nome_fornecedor=?,telefone_fornecedor=?,email_fornecedor=? where cpf_fornecedor=?";
        try {
            entrada = conexao.prepareStatement(sql);
            entrada.setString(1, resposta_nome.getText());
            entrada.setString(2, resposta_telefone.getText());
            entrada.setString(3, resposta_email.getText());
            entrada.setString(4, resposta_cnpj.getText());

            if ((resposta_cnpj.getText().isEmpty()) || (resposta_nome.getText().isEmpty()) || (resposta_telefone.getText().isEmpty()) || (resposta_email.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar vazio!");
            } else {
                int atualizado = entrada.executeUpdate();

                if (atualizado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do Fornecedor alterados com sucesso!");
                    resposta_nome.setText(null);
                    resposta_telefone.setText(null);
                    resposta_email.setText(null);

                    botao_cadastrar.setEnabled(true);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void excluir() {
        int excluir = JOptionPane.showConfirmDialog(null, "Você quer mesmo excluir este Fornecedor?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (excluir == JOptionPane.YES_OPTION) {
            String sql = "delete from fornecedores where cpf_fornecedor=?";

            try {
                entrada = conexao.prepareStatement(sql);

                entrada.setString(1, resposta_cnpj.getText());

                if ((resposta_cnpj.getText().isEmpty()) || (resposta_nome.getText().isEmpty()) || (resposta_telefone.getText().isEmpty()) || (resposta_email.getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar vazio!");
                } else {
                    int excluido = entrada.executeUpdate();

                    if (excluido > 0) {
                        JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!");
                        resposta_nome.setText(null);
                        resposta_telefone.setText(null);
                        resposta_email.setText(null);
                        
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

        texto_status = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        resposta_pesquisar = new javax.swing.JTextField();
        tabela = new javax.swing.JTable();
        texto_cnpj = new javax.swing.JLabel();
        texto_nome = new javax.swing.JLabel();
        texto_telefone = new javax.swing.JLabel();
        texto_email = new javax.swing.JLabel();
        texto_endereco = new javax.swing.JLabel();
        resposta_telefone = new javax.swing.JTextField();
        resposta_nome = new javax.swing.JTextField();
        resposta_cnpj = new javax.swing.JTextField();
        resposta_email = new javax.swing.JTextField();
        botao_atualizar = new javax.swing.JButton();
        botao_cadastrar = new javax.swing.JButton();
        botao_limpar = new javax.swing.JButton();
        texto_preenchimento_obrigatorio = new javax.swing.JLabel();
        texto_somente_numeros = new javax.swing.JLabel();
        texto_somente_numeros1 = new javax.swing.JLabel();
        texto_atualizarcadastrarendereco = new javax.swing.JLabel();
        texto_pesquisar = new javax.swing.JLabel();
        botao_excluir = new javax.swing.JButton();

        texto_status.setText("Ativo:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema Restaurante - Fornecedores");
        setResizable(false);

        resposta_pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                resposta_pesquisarKeyReleased(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CNPJ", "Nome", "Telefone", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });

        texto_cnpj.setText("CNPJ:");

        texto_nome.setText("Nome:");

        texto_telefone.setText("Telefone:");

        texto_email.setText("E-mail:");

        texto_endereco.setText("Endereço:");

        resposta_telefone.setToolTipText("64987654321");

        resposta_cnpj.setToolTipText("12345678900");

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

        texto_somente_numeros1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        texto_somente_numeros1.setText("Acima, somente números");

        texto_atualizarcadastrarendereco.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        texto_atualizarcadastrarendereco.setText("Clique aqui para atualizar ou cadastrar");
        texto_atualizarcadastrarendereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                texto_atualizarcadastrarenderecoMouseClicked(evt);
            }
        });

        texto_pesquisar.setText("Pesquisar (por Nome):");

        botao_excluir.setText("Excluir");
        botao_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_telefone)
                            .addComponent(texto_endereco)
                            .addComponent(texto_email)
                            .addComponent(texto_nome)
                            .addComponent(texto_cnpj))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botao_limpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botao_cadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botao_atualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botao_excluir))
                            .addComponent(resposta_nome)
                            .addComponent(resposta_email)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(texto_somente_numeros)
                                    .addComponent(resposta_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(resposta_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(texto_somente_numeros1)
                                    .addComponent(texto_atualizarcadastrarendereco))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(texto_preenchimento_obrigatorio)
                        .addGap(0, 347, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(texto_pesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resposta_pesquisar)
                            .addComponent(tabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_pesquisar)
                    .addComponent(resposta_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(texto_preenchimento_obrigatorio)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resposta_cnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_cnpj))
                .addGap(1, 1, 1)
                .addComponent(texto_somente_numeros1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resposta_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_nome))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resposta_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_telefone))
                .addGap(2, 2, 2)
                .addComponent(texto_somente_numeros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_email)
                    .addComponent(resposta_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_endereco)
                    .addComponent(texto_atualizarcadastrarendereco))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_atualizar)
                    .addComponent(botao_cadastrar)
                    .addComponent(botao_limpar)
                    .addComponent(botao_excluir))
                .addContainerGap())
        );

        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setResizable(false);
            tabela.getColumnModel().getColumn(0).setHeaderValue("CNPJ");
            tabela.getColumnModel().getColumn(1).setResizable(false);
            tabela.getColumnModel().getColumn(1).setHeaderValue("Nome");
            tabela.getColumnModel().getColumn(2).setHeaderValue("Telefone");
            tabela.getColumnModel().getColumn(3).setResizable(false);
            tabela.getColumnModel().getColumn(3).setHeaderValue("E-mail");
        }

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

    private void texto_atualizarcadastrarenderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_texto_atualizarcadastrarenderecoMouseClicked
        // TODO add your handling code here:
        EnderecosFornecedores ec = new EnderecosFornecedores();
        ec.setVisible(true);
    }//GEN-LAST:event_texto_atualizarcadastrarenderecoMouseClicked

    private void botao_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_excluirActionPerformed
        // TODO add your handling code here:
        excluir();
    }//GEN-LAST:event_botao_excluirActionPerformed

    private void resposta_pesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_resposta_pesquisarKeyReleased
        // TODO add your handling code here:
        pesquisar();
    }//GEN-LAST:event_resposta_pesquisarKeyReleased

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:
        listar();
    }//GEN-LAST:event_tabelaMouseClicked

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
            java.util.logging.Logger.getLogger(Fornecedores.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fornecedores.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fornecedores.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fornecedores.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fornecedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_atualizar;
    private javax.swing.JButton botao_cadastrar;
    private javax.swing.JButton botao_excluir;
    private javax.swing.JButton botao_limpar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField resposta_cnpj;
    private javax.swing.JTextField resposta_email;
    private javax.swing.JTextField resposta_nome;
    private javax.swing.JTextField resposta_pesquisar;
    private javax.swing.JTextField resposta_telefone;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel texto_atualizarcadastrarendereco;
    private javax.swing.JLabel texto_cnpj;
    private javax.swing.JLabel texto_email;
    private javax.swing.JLabel texto_endereco;
    private javax.swing.JLabel texto_nome;
    private javax.swing.JLabel texto_pesquisar;
    private javax.swing.JLabel texto_preenchimento_obrigatorio;
    private javax.swing.JLabel texto_somente_numeros;
    private javax.swing.JLabel texto_somente_numeros1;
    private javax.swing.JLabel texto_status;
    private javax.swing.JLabel texto_telefone;
    // End of variables declaration//GEN-END:variables
}
