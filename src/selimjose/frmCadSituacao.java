/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selimjose;

import dao.DaoException;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import com.mxrck.autocompleter.TextAutoCompleter;
import javax.swing.table.DefaultTableModel;
import dao.SituacaoDao;
import selimjose.clnSituacao;
/**
 *
 * @author Bruna
 */
public class frmCadSituacao extends javax.swing.JFrame {

    private DefaultTableModel tabelaLista = new DefaultTableModel();
     ArrayList<clnSituacao> arraysit = null;
    /**
     * Creates new form frmCadSituacao
     */
    public frmCadSituacao() {
        initComponents();
        tabelaLista = (DefaultTableModel) TabelaSituacao.getModel();
        buscaNome();       
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
    }
    
      private void buscaNome() {
       // int totalLinhas = TabelaAutor.getRowCount();//pega numero total de linhas
        
        TabelaSituacao.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                return this;
            }
        });

        SituacaoDao aDAO = new SituacaoDao();
       
            arraysit = (ArrayList<clnSituacao>) aDAO.listar(new TextAutoCompleter(new JTextField()));
            for (clnSituacao p : arraysit) {
            TabelaSituacao.setSelectionBackground(Color.LIGHT_GRAY);
            tabelaLista.addRow(new Object[]{p.getCdSituacao(), p.getNmSituacao()});
            }  
    }

    private void AtualizaTabela() {
    
        SituacaoDao aDAO = new SituacaoDao();
        if(!arraysit.isEmpty())
        {
            tabelaLista.setRowCount(0);
            tabelaLista.fireTableDataChanged();
            arraysit.clear();
            arraysit = (ArrayList<clnSituacao>) aDAO.listar(new TextAutoCompleter(new JTextField()));
            for (clnSituacao p : arraysit) {
            TabelaSituacao.setSelectionBackground(Color.LIGHT_GRAY);
            tabelaLista.addRow(new Object[]{p.getCdSituacao(), p.getNmSituacao()});
            
            }                     
        }
        else{
            arraysit = (ArrayList<clnSituacao>) aDAO.listar(new TextAutoCompleter(new JTextField()));
            for (clnSituacao p : arraysit) {
            TabelaSituacao.setSelectionBackground(Color.LIGHT_GRAY);
            tabelaLista.addRow(new Object[]{p.getCdSituacao(), p.getNmSituacao()});
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeSituacao = new java.awt.TextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaSituacao = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/EditarObra.png"))); // NOI18N

        txtNomeSituacao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNomeSituacao.setForeground(new java.awt.Color(153, 153, 153));
        txtNomeSituacao.setText("Digite o nome da situação");
        txtNomeSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeSituacaoActionPerformed(evt);
            }
        });
        txtNomeSituacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeSituacaoKeyPressed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel22.setText("Situação*:");
        jLabel22.setToolTipText("");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(153, 102, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 1, 2, new java.awt.Color(102, 51, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        TabelaSituacao.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        TabelaSituacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaSituacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaSituacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaSituacao);

        jButton6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jButton6.setText("Inserir");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_action_goleft.png"))); // NOI18N
        jButton7.setText("Voltar");
        jButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel29.setText("Consulta");
        jLabel29.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_action_undo.png"))); // NOI18N
        jButton10.setText("Restaurar Tela");
        jButton10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_action_edit.png"))); // NOI18N
        jButton8.setText("Alterar");
        jButton8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_action_cancel.png"))); // NOI18N
        jButton9.setText("Excluir");
        jButton9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N
        jButton5.setText("Pesquisar");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel29)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel22)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtNomeSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(66, 66, 66)
                                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNomeSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeSituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeSituacaoActionPerformed

    private void txtNomeSituacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeSituacaoKeyPressed
        txtNomeSituacao.setText("");
    }//GEN-LAST:event_txtNomeSituacaoKeyPressed

    private void TabelaSituacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaSituacaoMouseClicked
        //mouse clicked
        int linha = TabelaSituacao.getSelectedRow();
        txtNomeSituacao.setText((String) TabelaSituacao.getValueAt(linha,1));
    }//GEN-LAST:event_TabelaSituacaoMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if ((!txtNomeSituacao.getText().isEmpty())) {
            SituacaoDao aDao = new SituacaoDao();
            clnSituacao a = new clnSituacao();

            a.setNmSituacao(txtNomeSituacao.getText());

            if (aDao.Exists(a) != null) {
                JOptionPane.showMessageDialog(this, "Serie já existente!", "Cadastrando Series", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    aDao.inserir(a);
                    AtualizaTabela();
                } catch (DaoException ex) {
                    Logger.getLogger(frmCadAutores.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "A serie foi cadastrada com sucesso!!", "Cadastrando Series", JOptionPane.INFORMATION_MESSAGE);
                //dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Campos em branco!", "Cadastrando Series", JOptionPane.WARNING_MESSAGE);
        }
        txtNomeSituacao.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        frmCriteriosSistema P = new frmCriteriosSistema();
        P.setLocationRelativeTo(null);
        P.setResizable(true);
        P.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        AtualizaTabela();
        txtNomeSituacao.setText("");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        SituacaoDao aDao = new SituacaoDao();
        clnSituacao obj = new clnSituacao();

        int linha = TabelaSituacao.getSelectedRow();
        if(linha==-1){
            JOptionPane.showMessageDialog(this, "Selecione alguma linha!", "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                obj.setNmSituacao(txtNomeSituacao.getText());
                obj.setCdSituacao((int) TabelaSituacao.getValueAt(linha,0));
                aDao.alterar(obj);
                AtualizaTabela();
            } catch (DaoException ex) {
                Logger.getLogger(frmCadAutores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        SituacaoDao aDao = new SituacaoDao();
        clnSituacao a = new clnSituacao();

        int linha = TabelaSituacao.getSelectedRow();
        if(linha==-1){
            JOptionPane.showMessageDialog(this, "Selecione alguma linha!", "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir ?", " - Excluir -", JOptionPane.YES_NO_OPTION);
            if(opcao == JOptionPane.YES_OPTION)
            {
                int id = (int) TabelaSituacao.getValueAt(linha,0);
                tabelaLista.removeRow(linha);
                try {
                    aDao.excluir(id);
                } catch (DaoException ex) {
                    Logger.getLogger(frmCadAutores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        txtNomeSituacao.setText("");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //Pesquisar
        SituacaoDao aDao = new SituacaoDao();
        clnSituacao a = new clnSituacao();
        a.setNmSituacao(txtNomeSituacao.getText());
        tabelaLista.setRowCount(0);
        tabelaLista.fireTableDataChanged();
        arraysit.clear();
        arraysit = (ArrayList<clnSituacao>) aDao.PesquisarLista(new TextAutoCompleter(new JTextField()),a);
        for (clnSituacao p : arraysit) {
            TabelaSituacao.setSelectionBackground(Color.LIGHT_GRAY);
            tabelaLista.addRow(new Object[]{p.getCdSituacao(), p.getNmSituacao()});
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(frmCadSituacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadSituacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadSituacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadSituacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCadSituacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaSituacao;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField txtNomeSituacao;
    // End of variables declaration//GEN-END:variables
}