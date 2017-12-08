/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
create table enderecos_clientes(
cpf_cliente varchar(11) not null,
foreign key(cpf_cliente) references clientes(cpf_cliente),
rua_enderecocliente varchar(255) not null,
numero_enderecocliente varchar(10) not null,
bairro_enderecocliente varchar(100) not null,
complemento_enderecocliente varchar(500),
referencia_enderecocliente varchar(500),
cep_enderecocliente varchar(8) not null,
cidade_enderecocliente varchar(255) not null,
estado_enderecocliente varchar(50) not null
);
 */

package sistema;

import java.sql.*;
import bancodedados.Conexao;
import javax.swing.JOptionPane;

/**
 *
 * @author Brunno Rodrigues
 */
public class EnderecosClientes extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement entrada = null;
    ResultSet saida = null;

    /**
     * Creates new form Usuarios
     */
    public EnderecosClientes() {
        initComponents();

        conexao = Conexao.conexao();
    }

    private void limpar() {
        resposta_rua.setText(null);
        resposta_numero.setText(null);
        resposta_bairro.setText(null);
        resposta_complemento.setText(null);
        resposta_referencia.setText(null);
        resposta_cep.setText(null);
        resposta_cidade.setText(null);
    }

    private void cadastrar() {
        String sql = "insert into enderecos_clientes(cpf_cliente,rua_enderecocliente,numero_enderecocliente,bairro_enderecocliente,complemento_enderecocliente,referencia_enderecocliente,cep_enderecocliente,cidade_enderecocliente,estado_enderecocliente,cpf_cliente) values(?,?,?,?,?,?,?,?,?)";
        try {
            entrada = conexao.prepareStatement(sql);
            entrada.setString(1, resposta_cpfcliente.getText());
            entrada.setString(2, resposta_rua.getText());
            entrada.setString(3, resposta_numero.getText());
            entrada.setString(4, resposta_bairro.getText());
            entrada.setString(5, resposta_complemento.getText());
            entrada.setString(6, resposta_referencia.getText());
            entrada.setString(7, resposta_cep.getText());
            entrada.setString(8, resposta_cidade.getText());
            entrada.setString(9, resposta_estado.getSelectedItem().toString());

            if ((resposta_rua.getText().isEmpty()) || (resposta_numero.getText().isEmpty()) || (resposta_bairro.getText().isEmpty()) || (resposta_cep.getText().isEmpty()) || (resposta_cidade.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Algum campo obrigatório está vazio!");
            } else {
                int cadastrado = entrada.executeUpdate();

                if (cadastrado > 0) {
                    JOptionPane.showMessageDialog(null, "Endereço cadastrado com sucesso!");
                    resposta_rua.setText(null);
                    resposta_numero.setText(null);
                    resposta_bairro.setText(null);
                    resposta_complemento.setText(null);
                    resposta_referencia.setText(null);
                    resposta_cep.setText(null);
                    resposta_cidade.setText(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void atualizar() {
        String sql = "update enderecos_clientes set rua_enderecocliente=?,numero_enderecocliente=?,bairro_enderecocliente=?,complemento_enderecocliente=?,referencia_enderecocliente=?,cep_enderecocliente=?,cidade_enderecocliente=?,estado_enderecocliente=? where cpf_cliente=?";
        try {
            entrada = conexao.prepareStatement(sql);
            entrada.setString(1, resposta_rua.getText());
            entrada.setString(2, resposta_numero.getText());
            entrada.setString(3, resposta_bairro.getText());
            entrada.setString(4, resposta_complemento.getText());
            entrada.setString(5, resposta_referencia.getText());
            entrada.setString(6, resposta_cep.getText());
            entrada.setString(7, resposta_cidade.getText());
            entrada.setString(8, resposta_estado.getSelectedItem().toString());

            if ((resposta_rua.getText().isEmpty()) || (resposta_numero.getText().isEmpty()) || (resposta_bairro.getText().isEmpty()) || (resposta_cep.getText().isEmpty()) || (resposta_cidade.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Algum campo obrigatório está vazio!");
            } else {
                int atualizado = entrada.executeUpdate();

                if (atualizado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do Endereço alterados com sucesso!");
                    resposta_rua.setText(null);
                    resposta_numero.setText(null);
                    resposta_bairro.setText(null);
                    resposta_complemento.setText(null);
                    resposta_referencia.setText(null);
                    resposta_cep.setText(null);
                    resposta_cidade.setText(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
        texto_rua = new javax.swing.JLabel();
        texto_numero = new javax.swing.JLabel();
        texto_bairro = new javax.swing.JLabel();
        texto_complemento = new javax.swing.JLabel();
        resposta_numero = new javax.swing.JTextField();
        resposta_rua = new javax.swing.JTextField();
        resposta_bairro = new javax.swing.JTextField();
        botao_atualizar = new javax.swing.JButton();
        botao_cadastrar = new javax.swing.JButton();
        botao_limpar = new javax.swing.JButton();
        texto_preenchimento_obrigatorio = new javax.swing.JLabel();
        texto_somente_numeros = new javax.swing.JLabel();
        resposta_complemento = new javax.swing.JTextField();
        resposta_cidade = new javax.swing.JTextField();
        resposta_cep = new javax.swing.JTextField();
        resposta_referencia = new javax.swing.JTextField();
        resposta_estado = new javax.swing.JComboBox<>();
        texto_somente_numeros1 = new javax.swing.JLabel();
        texto_referencia = new javax.swing.JLabel();
        texto_cep = new javax.swing.JLabel();
        texto_cidade = new javax.swing.JLabel();
        texto_estado = new javax.swing.JLabel();
        texto_cpfcliente = new javax.swing.JLabel();
        resposta_cpfcliente = new javax.swing.JLabel();

        texto_status.setText("Ativo:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema Restaurante - Endereços de Clientes");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        texto_rua.setText("Rua:");

        texto_numero.setText("Número:");

        texto_bairro.setText("Bairro:");

        texto_complemento.setText("Complemento:");

        resposta_numero.setToolTipText("64987654321");

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
        texto_preenchimento_obrigatorio.setText("Com exceção de Complemento e Referência, o preenchimento de todos os campos (quando não gerado automaticamente) é obrigatório!");

        texto_somente_numeros.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        texto_somente_numeros.setText("Acima, somente números");

        resposta_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)", "Bahia (BA)", "Ceará (CE)", "Distrito Federal (DF)", "Espírito Santo (ES)", "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Pará (PA)", "Paraíba (PB)", "Paraná (PR)", "Pernambuco (PE)", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)" }));

        texto_somente_numeros1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        texto_somente_numeros1.setText("Acima, somente números");

        texto_referencia.setText("Referência:");

        texto_cep.setText("CEP:");

        texto_cidade.setText("Cidade:");

        texto_estado.setText("Estado:");

        texto_cpfcliente.setText("CPF do Cliente:");

        resposta_cpfcliente.setText("CPF");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botao_limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botao_atualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botao_cadastrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_numero)
                            .addComponent(texto_bairro)
                            .addComponent(texto_rua)
                            .addComponent(texto_complemento)
                            .addComponent(texto_referencia)
                            .addComponent(texto_cep)
                            .addComponent(texto_cidade)
                            .addComponent(texto_estado))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resposta_rua)
                            .addComponent(resposta_bairro)
                            .addComponent(resposta_complemento)
                            .addComponent(resposta_referencia)
                            .addComponent(resposta_cidade)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(texto_somente_numeros)
                                    .addComponent(resposta_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(texto_somente_numeros1)
                                    .addComponent(resposta_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(resposta_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_preenchimento_obrigatorio)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(texto_cpfcliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resposta_cpfcliente)))
                        .addGap(0, 131, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_cpfcliente)
                    .addComponent(resposta_cpfcliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(texto_preenchimento_obrigatorio)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_rua)
                    .addComponent(resposta_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resposta_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_numero))
                .addGap(2, 2, 2)
                .addComponent(texto_somente_numeros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_bairro)
                    .addComponent(resposta_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_complemento)
                    .addComponent(resposta_complemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resposta_referencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_referencia))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resposta_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_cep))
                .addGap(1, 1, 1)
                .addComponent(texto_somente_numeros1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resposta_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_cidade))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resposta_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_estado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_atualizar)
                    .addComponent(botao_limpar)
                    .addComponent(botao_cadastrar))
                .addGap(18, 18, 18))
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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        Clientes c = new Clientes();

        resposta_cpfcliente.setText("teste");
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
            java.util.logging.Logger.getLogger(EnderecosClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnderecosClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnderecosClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnderecosClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnderecosClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_atualizar;
    private javax.swing.JButton botao_cadastrar;
    private javax.swing.JButton botao_limpar;
    private javax.swing.JTextField resposta_bairro;
    private javax.swing.JTextField resposta_cep;
    private javax.swing.JTextField resposta_cidade;
    private javax.swing.JTextField resposta_complemento;
    private javax.swing.JLabel resposta_cpfcliente;
    private javax.swing.JComboBox<String> resposta_estado;
    private javax.swing.JTextField resposta_numero;
    private javax.swing.JTextField resposta_referencia;
    private javax.swing.JTextField resposta_rua;
    private javax.swing.JLabel texto_bairro;
    private javax.swing.JLabel texto_cep;
    private javax.swing.JLabel texto_cidade;
    private javax.swing.JLabel texto_complemento;
    private javax.swing.JLabel texto_cpfcliente;
    private javax.swing.JLabel texto_estado;
    private javax.swing.JLabel texto_numero;
    private javax.swing.JLabel texto_preenchimento_obrigatorio;
    private javax.swing.JLabel texto_referencia;
    private javax.swing.JLabel texto_rua;
    private javax.swing.JLabel texto_somente_numeros;
    private javax.swing.JLabel texto_somente_numeros1;
    private javax.swing.JLabel texto_status;
    // End of variables declaration//GEN-END:variables
}
