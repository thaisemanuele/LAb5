/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Trabalho5.telas;

/**
 *
 * @author Gabriela
 */
public class TelaMenu extends javax.swing.JFrame {

    /**
     * Creates new form TelaEventos
     */
    public TelaMenu() {
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

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Inserir = new javax.swing.JMenu();
        InserirEventos = new javax.swing.JMenuItem();
        InserirEdicao = new javax.swing.JMenuItem();
        InserirPessoa = new javax.swing.JMenuItem();
        InserirInscrito = new javax.swing.JMenuItem();
        InserirArtigo = new javax.swing.JMenuItem();
        InserirEscreve = new javax.swing.JMenuItem();
        InserirOrganiza = new javax.swing.JMenuItem();
        InserirPatrocinio = new javax.swing.JMenuItem();
        InserirPatrocinador = new javax.swing.JMenuItem();
        InserirDespesa = new javax.swing.JMenuItem();
        InserirAuxilio = new javax.swing.JMenuItem();
        Deletar = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        DeletarEdicao = new javax.swing.JMenuItem();
        DeletarPessoa = new javax.swing.JMenuItem();
        DeletarInscrito = new javax.swing.JMenuItem();
        DeletarArtigo = new javax.swing.JMenuItem();
        DeletarEscreve = new javax.swing.JMenuItem();
        DeletarOrganiza = new javax.swing.JMenuItem();
        DeletarPatrocinador = new javax.swing.JMenuItem();
        DeletarPatrocinio = new javax.swing.JMenuItem();
        DeletarDespesa = new javax.swing.JMenuItem();
        DeletarAuxilio = new javax.swing.JMenuItem();
        Editar = new javax.swing.JMenu();
        EditarEvento = new javax.swing.JMenuItem();
        EditarEdicao = new javax.swing.JMenuItem();
        EditarPessoa = new javax.swing.JMenuItem();
        EditarInscrito = new javax.swing.JMenuItem();
        EditarArtigo = new javax.swing.JMenuItem();
        EditarEscreve = new javax.swing.JMenuItem();
        EditarOrganiza = new javax.swing.JMenuItem();
        EditarPatrocinador = new javax.swing.JMenuItem();
        EditarPatrocinio = new javax.swing.JMenuItem();
        EditarDespesa = new javax.swing.JMenuItem();
        EditarAuxilio = new javax.swing.JMenuItem();
        Buscar = new javax.swing.JMenu();
        BuscarEvento = new javax.swing.JMenuItem();
        BuscarEdicao = new javax.swing.JMenuItem();
        BuscarPessoa = new javax.swing.JMenuItem();
        BuscarInscrito = new javax.swing.JMenuItem();
        BuscarArtigo = new javax.swing.JMenuItem();
        BuscarEscreve = new javax.swing.JMenuItem();
        BuscarOrganiza = new javax.swing.JMenuItem();
        BuscarPatrocinador = new javax.swing.JMenuItem();
        BuscarPatrocinio = new javax.swing.JMenuItem();
        BuscarDespesa = new javax.swing.JMenuItem();
        BuscarAuxilio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );

        Inserir.setText("Inserir");
        Inserir.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                InserirMenuSelected(evt);
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
        });

        InserirEventos.setText("Evento");
        InserirEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InserirEventosMouseClicked(evt);
            }
        });
        InserirEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InserirEventosActionPerformed(evt);
            }
        });
        Inserir.add(InserirEventos);

        InserirEdicao.setText("Edição");
        Inserir.add(InserirEdicao);

        InserirPessoa.setText("Pessoa");
        InserirPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InserirPessoaActionPerformed(evt);
            }
        });
        Inserir.add(InserirPessoa);

        InserirInscrito.setText("Inscrito");
        Inserir.add(InserirInscrito);

        InserirArtigo.setText("Artigo");
        Inserir.add(InserirArtigo);

        InserirEscreve.setText("Escreve");
        Inserir.add(InserirEscreve);

        InserirOrganiza.setText("Organiza");
        Inserir.add(InserirOrganiza);

        InserirPatrocinio.setText("Patrocinador");
        InserirPatrocinio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InserirPatrocinioActionPerformed(evt);
            }
        });
        Inserir.add(InserirPatrocinio);

        InserirPatrocinador.setText("Patrocinio");
        Inserir.add(InserirPatrocinador);

        InserirDespesa.setText("Despesa");
        Inserir.add(InserirDespesa);

        InserirAuxilio.setText("Auxílio");
        Inserir.add(InserirAuxilio);

        jMenuBar1.add(Inserir);

        Deletar.setText("Deletar");

        jMenuItem1.setText("Evento");
        Deletar.add(jMenuItem1);

        DeletarEdicao.setText("Edicao");
        Deletar.add(DeletarEdicao);

        DeletarPessoa.setText("Pessoa");
        DeletarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarPessoaActionPerformed(evt);
            }
        });
        Deletar.add(DeletarPessoa);

        DeletarInscrito.setText("Inscrito");
        Deletar.add(DeletarInscrito);

        DeletarArtigo.setText("Artigo");
        Deletar.add(DeletarArtigo);

        DeletarEscreve.setText("Escreve");
        Deletar.add(DeletarEscreve);

        DeletarOrganiza.setText("Organiza");
        Deletar.add(DeletarOrganiza);

        DeletarPatrocinador.setText("Patrocinador");
        Deletar.add(DeletarPatrocinador);

        DeletarPatrocinio.setText("Patrocinio");
        Deletar.add(DeletarPatrocinio);

        DeletarDespesa.setText("Despesa");
        Deletar.add(DeletarDespesa);

        DeletarAuxilio.setText("Auxílio");
        Deletar.add(DeletarAuxilio);

        jMenuBar1.add(Deletar);

        Editar.setText("Editar");

        EditarEvento.setText("Evento");
        Editar.add(EditarEvento);

        EditarEdicao.setText("Edição");
        Editar.add(EditarEdicao);

        EditarPessoa.setText("Pessoa");
        Editar.add(EditarPessoa);

        EditarInscrito.setText("Inscrito");
        Editar.add(EditarInscrito);

        EditarArtigo.setText("Artigo");
        EditarArtigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarArtigoActionPerformed(evt);
            }
        });
        Editar.add(EditarArtigo);

        EditarEscreve.setText("Escreve");
        EditarEscreve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarEscreveActionPerformed(evt);
            }
        });
        Editar.add(EditarEscreve);

        EditarOrganiza.setText("Organiza");
        Editar.add(EditarOrganiza);

        EditarPatrocinador.setText("Patrocinador");
        Editar.add(EditarPatrocinador);

        EditarPatrocinio.setText("Patrocínio");
        Editar.add(EditarPatrocinio);

        EditarDespesa.setText("Despesa");
        Editar.add(EditarDespesa);

        EditarAuxilio.setText("Auxílio");
        Editar.add(EditarAuxilio);

        jMenuBar1.add(Editar);

        Buscar.setText("Buscar");

        BuscarEvento.setText("Evento");
        Buscar.add(BuscarEvento);

        BuscarEdicao.setText("Edição");
        Buscar.add(BuscarEdicao);

        BuscarPessoa.setText("Pessoa");
        Buscar.add(BuscarPessoa);

        BuscarInscrito.setText("Inscrito");
        Buscar.add(BuscarInscrito);

        BuscarArtigo.setText("Artigo");
        Buscar.add(BuscarArtigo);

        BuscarEscreve.setText("Escreve");
        Buscar.add(BuscarEscreve);

        BuscarOrganiza.setText("Organiza");
        Buscar.add(BuscarOrganiza);

        BuscarPatrocinador.setText("Patrocinador");
        Buscar.add(BuscarPatrocinador);

        BuscarPatrocinio.setText("Patrocínio");
        Buscar.add(BuscarPatrocinio);

        BuscarDespesa.setText("Despesa");
        Buscar.add(BuscarDespesa);

        BuscarAuxilio.setText("Auxilio");
        Buscar.add(BuscarAuxilio);

        jMenuBar1.add(Buscar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InserirMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_InserirMenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_InserirMenuSelected

    private void InserirEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InserirEventosActionPerformed
        // TODO add your handling code here:
        TelaEventos tela = new TelaEventos();
        tela.TelaEventosInserir.setSelectedIndex(1);
        tela.setVisible(true);
    }//GEN-LAST:event_InserirEventosActionPerformed

    private void InserirPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InserirPessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InserirPessoaActionPerformed

    private void InserirPatrocinioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InserirPatrocinioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InserirPatrocinioActionPerformed

    private void DeletarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarPessoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeletarPessoaActionPerformed

    private void InserirEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InserirEventosMouseClicked
        TelaMenu tela = new TelaMenu();
        tela.setVisible(true);
    }//GEN-LAST:event_InserirEventosMouseClicked

    private void EditarEscreveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarEscreveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditarEscreveActionPerformed

    private void EditarArtigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarArtigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditarArtigoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Buscar;
    private javax.swing.JMenuItem BuscarArtigo;
    private javax.swing.JMenuItem BuscarAuxilio;
    private javax.swing.JMenuItem BuscarDespesa;
    private javax.swing.JMenuItem BuscarEdicao;
    private javax.swing.JMenuItem BuscarEscreve;
    private javax.swing.JMenuItem BuscarEvento;
    private javax.swing.JMenuItem BuscarInscrito;
    private javax.swing.JMenuItem BuscarOrganiza;
    private javax.swing.JMenuItem BuscarPatrocinador;
    private javax.swing.JMenuItem BuscarPatrocinio;
    private javax.swing.JMenuItem BuscarPessoa;
    private javax.swing.JMenu Deletar;
    private javax.swing.JMenuItem DeletarArtigo;
    private javax.swing.JMenuItem DeletarAuxilio;
    private javax.swing.JMenuItem DeletarDespesa;
    private javax.swing.JMenuItem DeletarEdicao;
    private javax.swing.JMenuItem DeletarEscreve;
    private javax.swing.JMenuItem DeletarInscrito;
    private javax.swing.JMenuItem DeletarOrganiza;
    private javax.swing.JMenuItem DeletarPatrocinador;
    private javax.swing.JMenuItem DeletarPatrocinio;
    private javax.swing.JMenuItem DeletarPessoa;
    private javax.swing.JMenu Editar;
    private javax.swing.JMenuItem EditarArtigo;
    private javax.swing.JMenuItem EditarAuxilio;
    private javax.swing.JMenuItem EditarDespesa;
    private javax.swing.JMenuItem EditarEdicao;
    private javax.swing.JMenuItem EditarEscreve;
    private javax.swing.JMenuItem EditarEvento;
    private javax.swing.JMenuItem EditarInscrito;
    private javax.swing.JMenuItem EditarOrganiza;
    private javax.swing.JMenuItem EditarPatrocinador;
    private javax.swing.JMenuItem EditarPatrocinio;
    private javax.swing.JMenuItem EditarPessoa;
    private javax.swing.JMenu Inserir;
    private javax.swing.JMenuItem InserirArtigo;
    private javax.swing.JMenuItem InserirAuxilio;
    private javax.swing.JMenuItem InserirDespesa;
    private javax.swing.JMenuItem InserirEdicao;
    private javax.swing.JMenuItem InserirEscreve;
    private javax.swing.JMenuItem InserirEventos;
    private javax.swing.JMenuItem InserirInscrito;
    private javax.swing.JMenuItem InserirOrganiza;
    private javax.swing.JMenuItem InserirPatrocinador;
    private javax.swing.JMenuItem InserirPatrocinio;
    private javax.swing.JMenuItem InserirPessoa;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
