/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
create table comandas(
codigo_comanda int primary key auto_increment,
mesa_comanda int(100) not null,
descricao_comanda varchar(500) not null,
garcom_comanda varchar(100) not null,
data_comanda varhar(10) not null,
valor_comanda decimal(10,2) not null
);
 */
package sistema;

import java.sql.*;
import bancodedados.Conexao;
import java.text.DateFormat;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.JSType;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Brunno Rodrigues
 */
public class Comandas extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement entrada = null;
    ResultSet saida = null;

    /**
     * Creates new form Usuarios
     */
    public Comandas() {
        initComponents();

        conexao = Conexao.conexao();
    }

    private void limpar() {
        resposta_codigo.setText(null);
        resposta_mesa.setText(null);
        resposta_descricao.setText(null);
        resposta_nome_garcom.setText(null);
        resposta_valor.setText(null);
        
        botao_cadastrar.setEnabled(true);
    }

    private void cadastrar() {
        String sql = "insert into comandas(mesa_comanda,descricao_comanda,garcom_comanda,data_comanda,valor_comanda) values(?,?,?,?,?)";
        try {
            entrada = conexao.prepareStatement(sql);

            entrada.setString(1, resposta_mesa.getText());
            entrada.setString(2, resposta_descricao.getText());
            entrada.setString(3, resposta_nome_garcom.getText());
            entrada.setString(4, resposta_data.getText());
            entrada.setString(5, resposta_valor.getText().replace(",", "."));

            if ((resposta_mesa.getText().isEmpty()) || (resposta_descricao.getText().isEmpty()) || (resposta_nome_garcom.getText().isEmpty()) || (resposta_valor.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar vazio!");
            } else {
                int cadastrado = entrada.executeUpdate();

                if (cadastrado > 0) {
                    JOptionPane.showMessageDialog(null, "Comanda cadastrada com sucesso!");
                    resposta_codigo.setText(null);
                    resposta_mesa.setText(null);
                    resposta_descricao.setText(null);
                    resposta_nome_garcom.setText(null);
                    resposta_valor.setText(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void pesquisar() {
        String sql = "select*from comandas where codigo_comanda like ?";
        try {
            entrada = conexao.prepareStatement(sql);

            entrada.setString(1, resposta_pesquisar.getText() + "%");

            saida = entrada.executeQuery();

            tabela.setModel(DbUtils.resultSetToTableModel(saida));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void listar() {
        int listar = tabela.getSelectedRow();
        resposta_codigo.setText(tabela.getModel().getValueAt(listar, 0).toString());
        resposta_mesa.setText(tabela.getModel().getValueAt(listar, 1).toString());
        resposta_descricao.setText(tabela.getModel().getValueAt(listar, 2).toString());
        resposta_nome_garcom.setText(tabela.getModel().getValueAt(listar, 3).toString());
        resposta_data.setText(tabela.getModel().getValueAt(listar, 4).toString());
        resposta_valor.setText(tabela.getModel().getValueAt(listar, 5).toString());

        botao_cadastrar.setEnabled(false);
    }

    private void atualizar() {
        String sql = "update comandas set mesa_comanda=?,descricao_comanda=?,garcom_comanda=?,data_comanda=?,valor_comanda=? where codigo_comanda=?";
        try {
            entrada = conexao.prepareStatement(sql);
            entrada.setString(1, resposta_mesa.getText());
            entrada.setString(2, resposta_descricao.getText());
            entrada.setString(3, resposta_nome_garcom.getText());
            entrada.setString(4, resposta_data.getText());
            entrada.setString(5, resposta_valor.getText());
            int resposta = JSType.toInteger(resposta_codigo.getText());
            entrada.setInt(6, resposta);

            if ((resposta_mesa.getText().isEmpty()) || (resposta_descricao.getText().isEmpty()) || (resposta_nome_garcom.getText().isEmpty()) || (resposta_valor.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar vazio!");
            } else {
                int atualizado = entrada.executeUpdate();

                if (atualizado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados da Comanda alterados com sucesso!");
                    resposta_codigo.setText(null);
                    resposta_mesa.setText(null);
                    resposta_descricao.setText(null);
                    resposta_nome_garcom.setText(null);
                    resposta_valor.setText(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void excluir() {
        int excluir = JOptionPane.showConfirmDialog(null, "Você quer mesmo excluir esta Comanda?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (excluir == JOptionPane.YES_OPTION) {
            String sql = "delete from comandas where id_comanda=?";

            try {
                entrada = conexao.prepareStatement(sql);

                entrada.setString(1, resposta_codigo.getText());

                if ((resposta_mesa.getText().isEmpty()) || (resposta_descricao.getText().isEmpty()) || (resposta_nome_garcom.getText().isEmpty()) || (resposta_valor.getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar vazio!");
                } else {
                    int excluido = entrada.executeUpdate();

                    if (excluido > 0) {
                        JOptionPane.showMessageDialog(null, "Comanda excluída com sucesso!");
                        resposta_codigo.setText(null);
                        resposta_mesa.setText(null);
                        resposta_descricao.setText(null);
                        resposta_nome_garcom.setText(null);
                        resposta_valor.setText(null);
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
        texto_codigo = new javax.swing.JLabel();
        texto_mesa = new javax.swing.JLabel();
        texto_descricao = new javax.swing.JLabel();
        texto_nome_garcom = new javax.swing.JLabel();
        texto_data = new javax.swing.JLabel();
        resposta_mesa = new javax.swing.JTextField();
        resposta_codigo = new javax.swing.JTextField();
        resposta_nome_garcom = new javax.swing.JTextField();
        botao_atualizar = new javax.swing.JButton();
        botao_cadastrar = new javax.swing.JButton();
        botao_limpar = new javax.swing.JButton();
        texto_preenchimento_obrigatorio = new javax.swing.JLabel();
        texto_somente_numeros1 = new javax.swing.JLabel();
        texto_valor = new javax.swing.JLabel();
        texto_pesquisar = new javax.swing.JLabel();
        botao_excluir = new javax.swing.JButton();
        resposta_data = new javax.swing.JTextField();
        resposta_valor = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        resposta_descricao = new javax.swing.JTextArea();

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
        setTitle("Sistema Restaurante - Comanda");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        resposta_pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                resposta_pesquisarKeyReleased(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CPF", "Nome", "Telefone", "E-mail", "Sexo", "Estado civil", "Receber Promoções"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        texto_codigo.setText("Código:");

        texto_mesa.setText("Mesa:");

        texto_descricao.setText("Descrição:");

        texto_nome_garcom.setText("Nome do Garçom:");

        texto_data.setText("Data:");

        resposta_codigo.setEditable(false);
        resposta_codigo.setToolTipText("12345678900");

        resposta_nome_garcom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resposta_nome_garcomActionPerformed(evt);
            }
        });

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

        texto_somente_numeros1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        texto_somente_numeros1.setText("Acima, somente números");

        texto_valor.setText("Valor:");

        texto_pesquisar.setText("Pesquisar (por Código):");

        botao_excluir.setText("Excluir");
        botao_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_excluirActionPerformed(evt);
            }
        });

        resposta_data.setEditable(false);
        resposta_data.setText("dd/mm/aaaa");

        resposta_descricao.setColumns(20);
        resposta_descricao.setRows(5);
        jScrollPane3.setViewportView(resposta_descricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(texto_preenchimento_obrigatorio)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(texto_pesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tabela, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                            .addComponent(resposta_pesquisar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_descricao)
                            .addComponent(texto_data)
                            .addComponent(texto_nome_garcom)
                            .addComponent(texto_mesa)
                            .addComponent(texto_codigo)
                            .addComponent(texto_valor))
                        .addGap(32, 32, 32)
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
                            .addComponent(resposta_nome_garcom)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(texto_somente_numeros1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(resposta_codigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(resposta_mesa, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(resposta_data, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(resposta_valor, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3))))
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
                    .addComponent(resposta_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_codigo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resposta_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_mesa))
                .addGap(1, 1, 1)
                .addComponent(texto_somente_numeros1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(texto_descricao)
                        .addGap(63, 63, 63)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_nome_garcom)
                    .addComponent(resposta_nome_garcom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_data)
                    .addComponent(resposta_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_valor)
                    .addComponent(resposta_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_atualizar)
                    .addComponent(botao_cadastrar)
                    .addComponent(botao_limpar)
                    .addComponent(botao_excluir))
                .addContainerGap())
        );

        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setHeaderValue("CPF");
            tabela.getColumnModel().getColumn(1).setHeaderValue("Nome");
            tabela.getColumnModel().getColumn(2).setHeaderValue("Telefone");
            tabela.getColumnModel().getColumn(3).setHeaderValue("E-mail");
            tabela.getColumnModel().getColumn(4).setHeaderValue("Sexo");
            tabela.getColumnModel().getColumn(5).setHeaderValue("Estado civil");
            tabela.getColumnModel().getColumn(6).setHeaderValue("Receber Promoções");
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

    private void resposta_nome_garcomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resposta_nome_garcomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resposta_nome_garcomActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        java.util.Date data = new java.util.Date();
        DateFormat hoje = DateFormat.getDateInstance(DateFormat.MEDIUM);
        resposta_data.setText(hoje.format(data));
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(Comandas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comandas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comandas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comandas.class
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
                new Comandas().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField resposta_codigo;
    private javax.swing.JTextField resposta_data;
    private javax.swing.JTextArea resposta_descricao;
    private javax.swing.JTextField resposta_mesa;
    private javax.swing.JTextField resposta_nome_garcom;
    private javax.swing.JTextField resposta_pesquisar;
    private javax.swing.JTextField resposta_valor;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel texto_codigo;
    private javax.swing.JLabel texto_data;
    private javax.swing.JLabel texto_descricao;
    private javax.swing.JLabel texto_mesa;
    private javax.swing.JLabel texto_nome_garcom;
    private javax.swing.JLabel texto_pesquisar;
    private javax.swing.JLabel texto_preenchimento_obrigatorio;
    private javax.swing.JLabel texto_somente_numeros1;
    private javax.swing.JLabel texto_status;
    private javax.swing.JLabel texto_valor;
    // End of variables declaration//GEN-END:variables
}
