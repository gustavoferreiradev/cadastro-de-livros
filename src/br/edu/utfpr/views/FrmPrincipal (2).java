/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.views;

import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
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

        jMenuItem1 = new javax.swing.JMenuItem();
        PanelDesktop = new javax.swing.JDesktopPane();
        BarraMenu = new javax.swing.JMenuBar();
        MenuCadastrar = new javax.swing.JMenu();
        itemCadastrarLivros = new javax.swing.JMenuItem();
        MenuItemAutores = new javax.swing.JMenuItem();
        MenuItemCadastrarEditoras = new javax.swing.JMenuItem();
        MenuItemCadastrarGeneros = new javax.swing.JMenuItem();
        MenuConsultar = new javax.swing.JMenu();
        btnConsultarLivros = new javax.swing.JMenuItem();
        btnAutores = new javax.swing.JMenuItem();
        btnEditoras = new javax.swing.JMenuItem();
        MenuItemConsultarGeneros = new javax.swing.JMenuItem();
        MenuAjuda = new javax.swing.JMenu();
        ItemMenuSobre = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout PanelDesktopLayout = new javax.swing.GroupLayout(PanelDesktop);
        PanelDesktop.setLayout(PanelDesktopLayout);
        PanelDesktopLayout.setHorizontalGroup(
            PanelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 907, Short.MAX_VALUE)
        );
        PanelDesktopLayout.setVerticalGroup(
            PanelDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );

        MenuCadastrar.setText("Cadastrar");

        itemCadastrarLivros.setText("Livros");
        itemCadastrarLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadastrarLivrosActionPerformed(evt);
            }
        });
        MenuCadastrar.add(itemCadastrarLivros);

        MenuItemAutores.setText("Autores");
        MenuItemAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemAutoresActionPerformed(evt);
            }
        });
        MenuCadastrar.add(MenuItemAutores);

        MenuItemCadastrarEditoras.setText("Editoras");
        MenuItemCadastrarEditoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCadastrarEditorasActionPerformed(evt);
            }
        });
        MenuCadastrar.add(MenuItemCadastrarEditoras);

        MenuItemCadastrarGeneros.setText("Gêneros");
        MenuItemCadastrarGeneros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCadastrarGenerosActionPerformed(evt);
            }
        });
        MenuCadastrar.add(MenuItemCadastrarGeneros);

        BarraMenu.add(MenuCadastrar);

        MenuConsultar.setText("Consultar");

        btnConsultarLivros.setText("Livros");
        btnConsultarLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarLivrosActionPerformed(evt);
            }
        });
        MenuConsultar.add(btnConsultarLivros);

        btnAutores.setText("Autores");
        btnAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutoresActionPerformed(evt);
            }
        });
        MenuConsultar.add(btnAutores);

        btnEditoras.setText("Editoras");
        btnEditoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditorasActionPerformed(evt);
            }
        });
        MenuConsultar.add(btnEditoras);

        MenuItemConsultarGeneros.setText("Gêneros");
        MenuItemConsultarGeneros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemConsultarGenerosActionPerformed(evt);
            }
        });
        MenuConsultar.add(MenuItemConsultarGeneros);

        BarraMenu.add(MenuConsultar);

        MenuAjuda.setText("Ajuda");

        ItemMenuSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        ItemMenuSobre.setText("Sobre");
        ItemMenuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemMenuSobreActionPerformed(evt);
            }
        });
        MenuAjuda.add(ItemMenuSobre);

        BarraMenu.add(MenuAjuda);

        setJMenuBar(BarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelDesktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelDesktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCadastrarLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadastrarLivrosActionPerformed
        IfLivrosTable livros = new IfLivrosTable();
        PanelDesktop.add(livros);
        livros.setVisible(true);


    }//GEN-LAST:event_itemCadastrarLivrosActionPerformed

    private void btnConsultarLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarLivrosActionPerformed
        DlgListaLivros dlgllivros = new DlgListaLivros(this, rootPaneCheckingEnabled);
        dlgllivros.setVisible(true);
    }//GEN-LAST:event_btnConsultarLivrosActionPerformed

    private void MenuItemAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemAutoresActionPerformed
        IfAutoresTable autores = new IfAutoresTable();
        PanelDesktop.add(autores);
        autores.setVisible(true);

    }//GEN-LAST:event_MenuItemAutoresActionPerformed

    private void MenuItemCadastrarEditorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCadastrarEditorasActionPerformed
        IfEditorasTable editoras = new IfEditorasTable();
        PanelDesktop.add(editoras);
        editoras.setVisible(true);
    }//GEN-LAST:event_MenuItemCadastrarEditorasActionPerformed

    private void MenuItemCadastrarGenerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCadastrarGenerosActionPerformed
        IfGenerosTable generos = new IfGenerosTable();
        PanelDesktop.add(generos);
        generos.setVisible(true);

    }//GEN-LAST:event_MenuItemCadastrarGenerosActionPerformed

    private void btnAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutoresActionPerformed
        DlgListaAutores dlgautores = new DlgListaAutores(this, rootPaneCheckingEnabled);
        dlgautores.setVisible(true);
    }//GEN-LAST:event_btnAutoresActionPerformed

    private void btnEditorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditorasActionPerformed
        DlgListaEditoras dlgeditoras = new DlgListaEditoras(this, rootPaneCheckingEnabled);
        dlgeditoras.setVisible(true);
    }//GEN-LAST:event_btnEditorasActionPerformed

    private void MenuItemConsultarGenerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemConsultarGenerosActionPerformed
        DlgListaGeneros dlglgeneros = new DlgListaGeneros(this, rootPaneCheckingEnabled);
        dlglgeneros.setVisible(true);
    }//GEN-LAST:event_MenuItemConsultarGenerosActionPerformed

    private void ItemMenuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemMenuSobreActionPerformed
        JOptionPane.showMessageDialog(null, "Programa desenvolvido por Gustavo Ferreira da Silva como trabalho final da disciplina de Programação Orientada a Obejtos I");
    }//GEN-LAST:event_ItemMenuSobreActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraMenu;
    private javax.swing.JMenuItem ItemMenuSobre;
    private javax.swing.JMenu MenuAjuda;
    private javax.swing.JMenu MenuCadastrar;
    private javax.swing.JMenu MenuConsultar;
    private javax.swing.JMenuItem MenuItemAutores;
    private javax.swing.JMenuItem MenuItemCadastrarEditoras;
    private javax.swing.JMenuItem MenuItemCadastrarGeneros;
    private javax.swing.JMenuItem MenuItemConsultarGeneros;
    private javax.swing.JDesktopPane PanelDesktop;
    private javax.swing.JMenuItem btnAutores;
    private javax.swing.JMenuItem btnConsultarLivros;
    private javax.swing.JMenuItem btnEditoras;
    private javax.swing.JMenuItem itemCadastrarLivros;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}