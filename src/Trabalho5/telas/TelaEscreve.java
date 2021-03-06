/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Trabalho5.telas;

import Trabalho5.bd.ArtigoBD;
import Trabalho5.bd.EscreveBD;
import Trabalho5.bd.PessoaBD;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriela
 */
public class TelaEscreve extends javax.swing.JFrame {

    /**
     * Creates new form TelaEscreve
     */
    public TelaEscreve() {
        initComponents();
        loadComboBox();
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        escreveTPane = new javax.swing.JTabbedPane();
        escreveInserir = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        insertEscreveButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        selectEscreveAutor = new javax.swing.JComboBox();
        selectEscreveArtigo = new javax.swing.JComboBox();
        insertAuthorName = new javax.swing.JTextField();
        insertArtTitle = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        escreveBuscar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        buscarNomeAutor = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        buscarEscreveArtigo = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        buscarEscreveAutor = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        buscarNomeArtigo = new javax.swing.JTextArea();
        escreveDeletar = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        deleteNomeAutor = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        deleteEscreveButton = new javax.swing.JButton();
        deleteEscreveArtigo = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        deleteEscreveAutor = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        deleteNomeArtigo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Selecione as informações desejadas nos campos abaixo e clique em inserir");

        jLabel2.setText("Autor:");

        jLabel3.setText("Artigo:");

        insertEscreveButton.setText("Inserir");
        insertEscreveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertEscreveButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        selectEscreveAutor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectEscreveAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectEscreveAutorActionPerformed(evt);
            }
        });

        selectEscreveArtigo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectEscreveArtigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectEscreveArtigoActionPerformed(evt);
            }
        });

        insertArtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertArtTitleActionPerformed(evt);
            }
        });

        jLabel7.setText("Nome do Autor:");

        jLabel9.setText("Titulo do Artigo:");

        javax.swing.GroupLayout escreveInserirLayout = new javax.swing.GroupLayout(escreveInserir);
        escreveInserir.setLayout(escreveInserirLayout);
        escreveInserirLayout.setHorizontalGroup(
            escreveInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escreveInserirLayout.createSequentialGroup()
                .addGroup(escreveInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escreveInserirLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(escreveInserirLayout.createSequentialGroup()
                        .addGroup(escreveInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(escreveInserirLayout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(insertEscreveButton)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addGroup(escreveInserirLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(escreveInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(escreveInserirLayout.createSequentialGroup()
                                        .addGroup(escreveInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18)
                                        .addGroup(escreveInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(selectEscreveAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(selectEscreveArtigo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(insertArtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(insertAuthorName, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(17, 17, 17)))
                .addGap(0, 0, 0))
        );
        escreveInserirLayout.setVerticalGroup(
            escreveInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escreveInserirLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGroup(escreveInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escreveInserirLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escreveInserirLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectEscreveAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(escreveInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(selectEscreveArtigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(2, 2, 2)
                .addComponent(insertAuthorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(8, 8, 8)
                .addComponent(insertArtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(escreveInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertEscreveButton)
                    .addComponent(jButton2))
                .addGap(48, 48, 48))
        );

        escreveTPane.addTab("Inserir", escreveInserir);

        jLabel8.setText("Autor:");

        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        buscarEscreveArtigo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        buscarEscreveArtigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarEscreveArtigoActionPerformed(evt);
            }
        });

        jLabel21.setText("Escolha o artigo:");

        buscarEscreveAutor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        buscarEscreveAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarEscreveAutorActionPerformed(evt);
            }
        });

        jLabel22.setText("Artigo:");

        jLabel23.setText("Listar autores:");

        buscarNomeArtigo.setColumns(20);
        buscarNomeArtigo.setRows(5);
        jScrollPane1.setViewportView(buscarNomeArtigo);

        javax.swing.GroupLayout escreveBuscarLayout = new javax.swing.GroupLayout(escreveBuscar);
        escreveBuscar.setLayout(escreveBuscarLayout);
        escreveBuscarLayout.setHorizontalGroup(
            escreveBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escreveBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escreveBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escreveBuscarLayout.createSequentialGroup()
                        .addGroup(escreveBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarNomeAutor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(escreveBuscarLayout.createSequentialGroup()
                        .addGroup(escreveBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarEscreveArtigo, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarEscreveAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escreveBuscarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(198, 198, 198))
        );
        escreveBuscarLayout.setVerticalGroup(
            escreveBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escreveBuscarLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarEscreveArtigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarEscreveAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarNomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        escreveTPane.addTab("Buscar", escreveBuscar);

        jLabel13.setText("Escolha o Artigo:");

        jLabel14.setText("Autor:");

        jLabel15.setText("Artigo:");

        jButton6.setText("Voltar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        deleteEscreveButton.setText("Deletar");
        deleteEscreveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEscreveButtonActionPerformed(evt);
            }
        });

        deleteEscreveArtigo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        deleteEscreveArtigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEscreveArtigoActionPerformed(evt);
            }
        });

        jLabel17.setText("Listar Autores");

        deleteEscreveAutor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        deleteEscreveAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEscreveAutorActionPerformed(evt);
            }
        });

        deleteNomeArtigo.setColumns(20);
        deleteNomeArtigo.setRows(5);
        jScrollPane2.setViewportView(deleteNomeArtigo);

        javax.swing.GroupLayout escreveDeletarLayout = new javax.swing.GroupLayout(escreveDeletar);
        escreveDeletar.setLayout(escreveDeletarLayout);
        escreveDeletarLayout.setHorizontalGroup(
            escreveDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escreveDeletarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escreveDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addGroup(escreveDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                        .addComponent(deleteNomeAutor, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(deleteEscreveArtigo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(deleteEscreveAutor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(escreveDeletarLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(deleteEscreveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        escreveDeletarLayout.setVerticalGroup(
            escreveDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escreveDeletarLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteEscreveArtigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteEscreveAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteNomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(escreveDeletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(deleteEscreveButton))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        escreveTPane.addTab("Deletar", escreveDeletar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escreveTPane)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escreveTPane)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void insertArtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertArtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_insertArtTitleActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void insertEscreveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertEscreveButtonActionPerformed
        if(selectEscreveAutor.getSelectedIndex()==0||selectEscreveArtigo.getSelectedIndex()==0) return;
        try {
            Integer idAut = PessoaBD.getIdByEmail(selectEscreveAutor.getSelectedItem().toString());
            Integer idArt = Integer.parseInt(selectEscreveArtigo.getSelectedItem().toString());
            EscreveBD.inserir(idAut, idArt);
            JOptionPane.showMessageDialog(null, "Escritor cadastrado " , "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            selectEscreveAutor.setSelectedIndex(0);
            selectEscreveArtigo.setSelectedIndex(0);
            insertAuthorName.setText("");
            insertArtTitle.setText("");
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TelaEscreve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_insertEscreveButtonActionPerformed

    private void selectEscreveAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectEscreveAutorActionPerformed
        if(selectEscreveAutor.getSelectedIndex()==0) return;
        ArrayList<String> details;
        ArrayList<String> artDetails;
        try {
            details = PessoaBD.searchByEmail(selectEscreveAutor.getSelectedItem().toString());
            if(selectEscreveAutor.getSelectedIndex()!=0){
               insertAuthorName.setText(details.get(1));
            }
            details.clear();
           
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TelaEscreve.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }//GEN-LAST:event_selectEscreveAutorActionPerformed

    private void selectEscreveArtigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectEscreveArtigoActionPerformed
        if(selectEscreveArtigo.getSelectedIndex()==0) return;
        ArrayList<String> artDetails;
        try {
            if(selectEscreveArtigo.getSelectedIndex()!=0){
                artDetails = ArtigoBD.buscar(
                        Integer.parseInt(selectEscreveArtigo.getSelectedItem().toString()));
                insertArtTitle.setText(artDetails.get(0));
            }
           
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TelaEscreve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_selectEscreveArtigoActionPerformed

    private void buscarEscreveAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarEscreveAutorActionPerformed
        if(buscarEscreveArtigo.getSelectedIndex()==0||buscarEscreveAutor.getSelectedIndex()==0) return;
        ArrayList autDetails = null;
        try {
            Integer idAut = PessoaBD.getIdByEmail(buscarEscreveAutor.getSelectedItem().toString());
            autDetails = PessoaBD.buscar(idAut);
            buscarNomeAutor.setText(autDetails.get(1).toString());
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TelaEscreve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarEscreveAutorActionPerformed

    private void buscarEscreveArtigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarEscreveArtigoActionPerformed
        if(buscarEscreveArtigo.getSelectedIndex()==0) return;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList artDetails = null;
        buscarNomeAutor.setText("");
        try {
            Integer idArt = Integer.parseInt(buscarEscreveArtigo.getSelectedItem().toString());
            artDetails = ArtigoBD.buscar(idArt);
            model = EscreveBD.getAuthors(idArt);
            buscarEscreveAutor.setModel(model);
            buscarNomeArtigo.setText(artDetails.get(0).toString());
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TelaEscreve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarEscreveArtigoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void deleteEscreveArtigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEscreveArtigoActionPerformed
        if(deleteEscreveArtigo.getSelectedIndex()==0) return;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList artDetails = null;
        deleteNomeAutor.setText("");
        try {
            Integer idArt = Integer.parseInt(deleteEscreveArtigo.getSelectedItem().toString());
            artDetails = ArtigoBD.buscar(idArt);
            model = EscreveBD.getAuthors(idArt);
            deleteEscreveAutor.setModel(model);
            deleteNomeArtigo.setText(artDetails.get(0).toString());
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TelaEscreve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteEscreveArtigoActionPerformed

    private void deleteEscreveAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEscreveAutorActionPerformed
        if(deleteEscreveArtigo.getSelectedIndex()==0||deleteEscreveAutor.getSelectedIndex()==0) return;
        ArrayList autDetails = null;
        try {
            Integer idAut = PessoaBD.getIdByEmail(deleteEscreveAutor.getSelectedItem().toString());
            autDetails = PessoaBD.buscar(idAut);
            deleteNomeAutor.setText(autDetails.get(1).toString());
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TelaEscreve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteEscreveAutorActionPerformed

    private void deleteEscreveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEscreveButtonActionPerformed
        if(deleteEscreveArtigo.getSelectedIndex()==0||deleteEscreveAutor.getSelectedIndex()==0) return;
        try {
            Integer idArt = Integer.parseInt(deleteEscreveArtigo.getSelectedItem().toString());
            Integer idAut = PessoaBD.getIdByEmail(deleteEscreveAutor.getSelectedItem().toString());
            EscreveBD.excluir(idAut, idArt);
            JOptionPane.showMessageDialog(null, "Escritor removido" , "Excluir", JOptionPane.INFORMATION_MESSAGE);
            deleteNomeAutor.setText("");
            deleteNomeArtigo.setText("");
            deleteEscreveArtigo.setSelectedIndex(0);
            deleteEscreveAutor.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(TelaEscreve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteEscreveButtonActionPerformed

    private void loadComboBox(){
        DefaultComboBoxModel autModel = new DefaultComboBoxModel();
        DefaultComboBoxModel artModel = new DefaultComboBoxModel();
        DefaultComboBoxModel emptyModel = new DefaultComboBoxModel();
        DefaultComboBoxModel emptyModel2 = new DefaultComboBoxModel();
        
        try {
            autModel = PessoaBD.getAuthors();
            artModel = ArtigoBD.getAllArtigos();
            emptyModel.addElement(" --- ");
            emptyModel2.addElement(" --- ");
            emptyModel2.addElement("Selecione o Artigo");
            selectEscreveAutor.setModel(autModel);
            selectEscreveArtigo.setModel(artModel);
            buscarEscreveArtigo.setModel(artModel);
            buscarEscreveArtigo.setModel(artModel);
            buscarEscreveAutor.setModel(emptyModel2);
            deleteEscreveArtigo.setModel(artModel);
            deleteEscreveAutor.setModel(emptyModel2);
        } catch (SQLException ex) {
            Logger.getLogger(TelaEventos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(TelaEscreve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
            java.util.logging.Logger.getLogger(TelaEscreve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEscreve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEscreve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEscreve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEscreve().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox buscarEscreveArtigo;
    private javax.swing.JComboBox buscarEscreveAutor;
    private javax.swing.JTextArea buscarNomeArtigo;
    private javax.swing.JTextField buscarNomeAutor;
    private javax.swing.JComboBox deleteEscreveArtigo;
    private javax.swing.JComboBox deleteEscreveAutor;
    private javax.swing.JButton deleteEscreveButton;
    private javax.swing.JTextArea deleteNomeArtigo;
    private javax.swing.JTextField deleteNomeAutor;
    private javax.swing.JPanel escreveBuscar;
    private javax.swing.JPanel escreveDeletar;
    private javax.swing.JPanel escreveInserir;
    protected javax.swing.JTabbedPane escreveTPane;
    private javax.swing.JTextField insertArtTitle;
    private javax.swing.JTextField insertAuthorName;
    private javax.swing.JButton insertEscreveButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox selectEscreveArtigo;
    private javax.swing.JComboBox selectEscreveAutor;
    // End of variables declaration//GEN-END:variables
}
