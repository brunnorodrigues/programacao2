/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import javax.swing.JOptionPane;

/**
 *
 * @author Brunno Rodrigues
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Usuarios
     */
    public Inicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JMenuBar();
        menu_clientes = new javax.swing.JMenu();
        clientes_cadastrar = new javax.swing.JMenuItem();
        clientes_listar = new javax.swing.JMenuItem();
        clientes_atualizar = new javax.swing.JMenuItem();
        clientes_excluir = new javax.swing.JMenuItem();
        menu_comanda = new javax.swing.JMenu();
        comanda_cadastrar = new javax.swing.JMenuItem();
        comanda_listar = new javax.swing.JMenuItem();
        comanda_atualizar = new javax.swing.JMenuItem();
        comanda_excluir = new javax.swing.JMenuItem();
        menu_estoque = new javax.swing.JMenu();
        estoque_cadastrar = new javax.swing.JMenuItem();
        estoque_listar = new javax.swing.JMenuItem();
        estoque_atualizar = new javax.swing.JMenuItem();
        estoque_excluir = new javax.swing.JMenuItem();
        menu_fornecedores = new javax.swing.JMenu();
        fornecedores_cadastrar = new javax.swing.JMenuItem();
        fornecedores_listar = new javax.swing.JMenuItem();
        fornecedores_atualizar = new javax.swing.JMenuItem();
        fornecedores_excluir = new javax.swing.JMenuItem();
        menu_usuarios = new javax.swing.JMenu();
        usuarios_cadastrar = new javax.swing.JMenuItem();
        usuarios_listar = new javax.swing.JMenuItem();
        usuarios_atualizar = new javax.swing.JMenuItem();
        usuarios_excluir = new javax.swing.JMenuItem();
        menu_opcoes = new javax.swing.JMenu();
        opcoes_sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema Restaurante - Início");
        setResizable(false);

        menu_clientes.setText("Clientes");

        clientes_cadastrar.setText("Cadastrar");
        clientes_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientes_cadastrarActionPerformed(evt);
            }
        });
        menu_clientes.add(clientes_cadastrar);

        clientes_listar.setText("Listar");
        clientes_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientes_listarActionPerformed(evt);
            }
        });
        menu_clientes.add(clientes_listar);

        clientes_atualizar.setText("Atualizar");
        clientes_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientes_atualizarActionPerformed(evt);
            }
        });
        menu_clientes.add(clientes_atualizar);

        clientes_excluir.setText("Excluir");
        clientes_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientes_excluirActionPerformed(evt);
            }
        });
        menu_clientes.add(clientes_excluir);

        Menu.add(menu_clientes);

        menu_comanda.setText("Comanda");

        comanda_cadastrar.setText("Cadastrar");
        comanda_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comanda_cadastrarActionPerformed(evt);
            }
        });
        menu_comanda.add(comanda_cadastrar);

        comanda_listar.setText("Listar");
        comanda_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comanda_listarActionPerformed(evt);
            }
        });
        menu_comanda.add(comanda_listar);

        comanda_atualizar.setText("Atualizar");
        comanda_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comanda_atualizarActionPerformed(evt);
            }
        });
        menu_comanda.add(comanda_atualizar);

        comanda_excluir.setText("Excluir");
        comanda_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comanda_excluirActionPerformed(evt);
            }
        });
        menu_comanda.add(comanda_excluir);

        Menu.add(menu_comanda);

        menu_estoque.setText("Estoque");

        estoque_cadastrar.setText("Cadastrar");
        estoque_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estoque_cadastrarActionPerformed(evt);
            }
        });
        menu_estoque.add(estoque_cadastrar);

        estoque_listar.setText("Listar");
        estoque_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estoque_listarActionPerformed(evt);
            }
        });
        menu_estoque.add(estoque_listar);

        estoque_atualizar.setText("Atualizar");
        estoque_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estoque_atualizarActionPerformed(evt);
            }
        });
        menu_estoque.add(estoque_atualizar);

        estoque_excluir.setText("Excluir");
        estoque_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estoque_excluirActionPerformed(evt);
            }
        });
        menu_estoque.add(estoque_excluir);

        Menu.add(menu_estoque);

        menu_fornecedores.setText("Fornecedores");

        fornecedores_cadastrar.setText("Cadastrar");
        fornecedores_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fornecedores_cadastrarActionPerformed(evt);
            }
        });
        menu_fornecedores.add(fornecedores_cadastrar);

        fornecedores_listar.setText("Listar");
        fornecedores_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fornecedores_listarActionPerformed(evt);
            }
        });
        menu_fornecedores.add(fornecedores_listar);

        fornecedores_atualizar.setText("Atualizar");
        fornecedores_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fornecedores_atualizarActionPerformed(evt);
            }
        });
        menu_fornecedores.add(fornecedores_atualizar);

        fornecedores_excluir.setText("Excluir");
        fornecedores_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fornecedores_excluirActionPerformed(evt);
            }
        });
        menu_fornecedores.add(fornecedores_excluir);

        Menu.add(menu_fornecedores);

        menu_usuarios.setText("Usuários");
        menu_usuarios.setEnabled(false);

        usuarios_cadastrar.setText("Cadastrar");
        usuarios_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarios_cadastrarActionPerformed(evt);
            }
        });
        menu_usuarios.add(usuarios_cadastrar);

        usuarios_listar.setText("Listar");
        usuarios_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarios_listarActionPerformed(evt);
            }
        });
        menu_usuarios.add(usuarios_listar);

        usuarios_atualizar.setText("Atualizar");
        usuarios_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarios_atualizarActionPerformed(evt);
            }
        });
        menu_usuarios.add(usuarios_atualizar);

        usuarios_excluir.setText("Excluir");
        usuarios_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarios_excluirActionPerformed(evt);
            }
        });
        menu_usuarios.add(usuarios_excluir);

        Menu.add(menu_usuarios);

        menu_opcoes.setText("Opções");

        opcoes_sair.setText("Sair");
        opcoes_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcoes_sairActionPerformed(evt);
            }
        });
        menu_opcoes.add(opcoes_sair);

        Menu.add(menu_opcoes);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void opcoes_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcoes_sairActionPerformed
        // TODO add your handling code here:
        int sair = JOptionPane.showConfirmDialog(null, "Você quer mesmo sair?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_opcoes_sairActionPerformed

    private void usuarios_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarios_cadastrarActionPerformed
        // TODO add your handling code here:
        Usuarios cadastrar = new Usuarios();
        cadastrar.setVisible(true);
    }//GEN-LAST:event_usuarios_cadastrarActionPerformed

    private void usuarios_listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarios_listarActionPerformed
        // TODO add your handling code here:
        Usuarios listar = new Usuarios();
        listar.setVisible(true);
    }//GEN-LAST:event_usuarios_listarActionPerformed

    private void usuarios_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarios_atualizarActionPerformed
        // TODO add your handling code here:
        Usuarios editar = new Usuarios();
        editar.setVisible(true);
    }//GEN-LAST:event_usuarios_atualizarActionPerformed

    private void usuarios_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarios_excluirActionPerformed
        // TODO add your handling code here:
        Usuarios excluir = new Usuarios();
        excluir.setVisible(true);
    }//GEN-LAST:event_usuarios_excluirActionPerformed

    private void clientes_listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientes_listarActionPerformed
        // TODO add your handling code here:
        Clientes listar = new Clientes();
        listar.setVisible(true);
    }//GEN-LAST:event_clientes_listarActionPerformed

    private void clientes_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientes_cadastrarActionPerformed
        // TODO add your handling code here:
        Clientes cadastrar = new Clientes();
        cadastrar.setVisible(true);
    }//GEN-LAST:event_clientes_cadastrarActionPerformed

    private void clientes_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientes_atualizarActionPerformed
        // TODO add your handling code here:
        Clientes atualizar = new Clientes();
        atualizar.setVisible(true);
    }//GEN-LAST:event_clientes_atualizarActionPerformed

    private void clientes_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientes_excluirActionPerformed
        // TODO add your handling code here:
        Clientes excluir = new Clientes();
        excluir.setVisible(true);
    }//GEN-LAST:event_clientes_excluirActionPerformed

    private void estoque_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estoque_cadastrarActionPerformed
        // TODO add your handling code here:
        Estoque cadastrar = new Estoque();
        cadastrar.setVisible(true);
    }//GEN-LAST:event_estoque_cadastrarActionPerformed

    private void estoque_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estoque_atualizarActionPerformed
        // TODO add your handling code here:
        Estoque atualizar = new Estoque();
        atualizar.setVisible(true);
    }//GEN-LAST:event_estoque_atualizarActionPerformed

    private void estoque_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estoque_excluirActionPerformed
        // TODO add your handling code here:
        Estoque excluir = new Estoque();
        excluir.setVisible(true);
    }//GEN-LAST:event_estoque_excluirActionPerformed

    private void comanda_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comanda_cadastrarActionPerformed
        // TODO add your handling code here:
        Comandas cadastrar = new Comandas();
        cadastrar.setVisible(true);
    }//GEN-LAST:event_comanda_cadastrarActionPerformed

    private void comanda_listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comanda_listarActionPerformed
        // TODO add your handling code here:
        Comandas listar = new Comandas();
        listar.setVisible(true);
    }//GEN-LAST:event_comanda_listarActionPerformed

    private void comanda_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comanda_atualizarActionPerformed
        // TODO add your handling code here:
        Comandas atualizar = new Comandas();
        atualizar.setVisible(true);
    }//GEN-LAST:event_comanda_atualizarActionPerformed

    private void comanda_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comanda_excluirActionPerformed
        // TODO add your handling code here:
        Comandas excluir = new Comandas();
        excluir.setVisible(true);
    }//GEN-LAST:event_comanda_excluirActionPerformed

    private void estoque_listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estoque_listarActionPerformed
        // TODO add your handling code here:
        Estoque listar = new Estoque();
        listar.setVisible(true);
    }//GEN-LAST:event_estoque_listarActionPerformed

    private void fornecedores_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fornecedores_cadastrarActionPerformed
        // TODO add your handling code here
        Fornecedores cadastrar = new Fornecedores();
        cadastrar.setVisible(true);
    }//GEN-LAST:event_fornecedores_cadastrarActionPerformed

    private void fornecedores_listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fornecedores_listarActionPerformed
        // TODO add your handling code here:
        Fornecedores listar = new Fornecedores();
        listar.setVisible(true);
    }//GEN-LAST:event_fornecedores_listarActionPerformed

    private void fornecedores_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fornecedores_atualizarActionPerformed
        // TODO add your handling code here:
        Fornecedores atualizar = new Fornecedores();
        atualizar.setVisible(true);
    }//GEN-LAST:event_fornecedores_atualizarActionPerformed

    private void fornecedores_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fornecedores_excluirActionPerformed
        // TODO add your handling code here:
        Fornecedores excluir = new Fornecedores();
        excluir.setVisible(true);
    }//GEN-LAST:event_fornecedores_excluirActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenuItem clientes_atualizar;
    private javax.swing.JMenuItem clientes_cadastrar;
    private javax.swing.JMenuItem clientes_excluir;
    private javax.swing.JMenuItem clientes_listar;
    private javax.swing.JMenuItem comanda_atualizar;
    private javax.swing.JMenuItem comanda_cadastrar;
    private javax.swing.JMenuItem comanda_excluir;
    private javax.swing.JMenuItem comanda_listar;
    private javax.swing.JMenuItem estoque_atualizar;
    private javax.swing.JMenuItem estoque_cadastrar;
    private javax.swing.JMenuItem estoque_excluir;
    private javax.swing.JMenuItem estoque_listar;
    private javax.swing.JMenuItem fornecedores_atualizar;
    private javax.swing.JMenuItem fornecedores_cadastrar;
    private javax.swing.JMenuItem fornecedores_excluir;
    private javax.swing.JMenuItem fornecedores_listar;
    private javax.swing.JMenu menu_clientes;
    private javax.swing.JMenu menu_comanda;
    private javax.swing.JMenu menu_estoque;
    private javax.swing.JMenu menu_fornecedores;
    private javax.swing.JMenu menu_opcoes;
    public static javax.swing.JMenu menu_usuarios;
    private javax.swing.JMenuItem opcoes_sair;
    public static javax.swing.JMenuItem usuarios_atualizar;
    public static javax.swing.JMenuItem usuarios_cadastrar;
    public static javax.swing.JMenuItem usuarios_excluir;
    private javax.swing.JMenuItem usuarios_listar;
    // End of variables declaration//GEN-END:variables
}