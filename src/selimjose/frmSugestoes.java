/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selimjose;

import java.util.List;
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
import selimjose.clnObra;
import dao.ObraDao;
import dao.AutorDao;
import dao.EditoraDao;
/**
 *
 * @author Bruna
 */
public class frmSugestoes extends javax.swing.JFrame {

    private DefaultTableModel tabelaLista = new DefaultTableModel();
    private List<clnAutor> AutorList;
    private List<clnEditora> EditoraList;
    ArrayList<clnObra> ObraList = null;
    
    /**
     * Creates new form frmSugestoes
     */
    public frmSugestoes() {
        initComponents();
        tabelaLista = (DefaultTableModel) tabelaObra.getModel();
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
        
        buscaNome();
    }
    private String[] initAutores() {
        String[] autorS;
        AutorDao cDAO = new AutorDao();
        AutorList = cDAO.listar(new TextAutoCompleter(new JTextField()));
        autorS = new String[AutorList.size()];
        for (int i = 0; i < AutorList.size(); i++) {
            autorS[i] = AutorList.get(i).getNmAutor();            
        }
        return autorS;
    }
    private String[] initEditora() {
        String[] editoraS;
        EditoraDao cDAO = new EditoraDao();
        EditoraList = cDAO.listar(new TextAutoCompleter(new JTextField()));
        editoraS = new String[EditoraList.size()];
        for (int i = 0; i < EditoraList.size(); i++) {
            editoraS[i] = EditoraList.get(i).getNmEditora();
        }
        return editoraS;
    }
    private void AtualizaTabela() {
    
        ObraDao aDAO = new ObraDao();
        if(!ObraList.isEmpty())
        {
            tabelaLista.setRowCount(0);
            tabelaLista.fireTableDataChanged();
            ObraList.clear();
            ObraList = (ArrayList<clnObra>) aDAO.listar(new TextAutoCompleter(new JTextField()));
            for (clnObra p : ObraList) {
            tabelaObra.setSelectionBackground(Color.LIGHT_GRAY);
            tabelaLista.addRow(new Object[]{p.getCdObra(), p.getTitulo(),p.getEdicao(),p.getAno(),p.getVolume(),p.getISBN(),p.getCdEditora(),p.getCdAutor()});
            
            }                     
        }
        else{
            ObraList = (ArrayList<clnObra>) aDAO.listar(new TextAutoCompleter(new JTextField()));
            for (clnObra p : ObraList) {
            tabelaObra.setSelectionBackground(Color.LIGHT_GRAY);
            tabelaLista.addRow(new Object[]{p.getCdObra(), p.getTitulo(),p.getEdicao(),p.getAno(),p.getVolume(),p.getISBN(),p.getCdEditora(),p.getCdAutor()});
            }             
        }
    }
    
    private void buscaNome() {
       // int totalLinhas = TabelaAutor.getRowCount();//pega numero total de linhas
        
        tabelaObra.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                return this;
            }
        });

         ObraDao aDAO = new ObraDao();
       
            ObraList = (ArrayList<clnObra>) aDAO.listar(new TextAutoCompleter(new JTextField()));
            for (clnObra p : ObraList) {
            tabelaObra.setSelectionBackground(Color.LIGHT_GRAY);
            tabelaLista.addRow(new Object[]{p.getCdObra(), p.getTitulo(),p.getEdicao(),p.getAno(),p.getVolume(),p.getISBN(),p.getCdEditora(),p.getCdAutor()});
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
        label1 = new javax.swing.JLabel();
        txtTitulo = new java.awt.TextField();
        jLabel22 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        comboeditora = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        comboautor = new javax.swing.JComboBox<>();
        txtEdicao = new java.awt.TextField();
        jLabel25 = new javax.swing.JLabel();
        txtAno = new java.awt.TextField();
        txtVolume = new java.awt.TextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtIsbn = new java.awt.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaObra = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/InserirObra.png"))); // NOI18N

        label1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        label1.setText("Título*:");
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtTitulo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(153, 153, 153));
        txtTitulo.setText("Digite o Titulo");
        txtTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTituloKeyPressed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel22.setText("Autor*:");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(49, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel23.setText("Editora*:");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel24.setText("Edição:");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        comboeditora.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        comboeditora.setForeground(new java.awt.Color(153, 153, 153));
        comboeditora.setModel(new javax.swing.DefaultComboBoxModel(initEditora()));
        comboeditora.setPreferredSize(new java.awt.Dimension(100, 18));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(49, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        comboautor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        comboautor.setForeground(new java.awt.Color(153, 153, 153));
        comboautor.setModel(new javax.swing.DefaultComboBoxModel<>(initAutores()));
        comboautor.setNextFocusableComponent(comboeditora);
        comboautor.setPreferredSize(new java.awt.Dimension(100, 18));
        comboautor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboautorMouseClicked(evt);
            }
        });
        comboautor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboautorActionPerformed(evt);
            }
        });

        txtEdicao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtEdicao.setForeground(new java.awt.Color(153, 153, 153));
        txtEdicao.setText("Digite a Edição");
        txtEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdicaoActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel25.setText("Ano:");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtAno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtAno.setForeground(new java.awt.Color(153, 153, 153));
        txtAno.setText("Digite o Ano");
        txtAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnoActionPerformed(evt);
            }
        });

        txtVolume.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtVolume.setForeground(new java.awt.Color(153, 153, 153));
        txtVolume.setText("Digite o Volume");
        txtVolume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVolumeActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel26.setText("Volume:");
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel27.setText("ISBN/ISSN:");
        jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtIsbn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtIsbn.setForeground(new java.awt.Color(153, 153, 153));
        txtIsbn.setText("Digite o ISBN/ISSN");
        txtIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIsbnActionPerformed(evt);
            }
        });

        tabelaObra.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tabelaObra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Título", "Edicao", "Ano", "Volume", "ISBN", "Editora", "Autor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaObra);

        jButton7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_action_goleft.png"))); // NOI18N
        jButton7.setText("Voltar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_action_undo.png"))); // NOI18N
        jButton10.setText("Restaurar Tela");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jButton8.setText("Inserir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))))
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtVolume, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addGap(184, 184, 184))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtEdicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(139, 139, 139))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel26)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(comboautor, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label1)
                                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboeditora, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel25))
                .addGap(116, 116, 116))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(comboeditora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboautor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        comboautor.getAccessibleContext().setAccessibleDescription(",");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdicaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdicaoActionPerformed

    private void txtAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnoActionPerformed

    private void txtVolumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVolumeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVolumeActionPerformed

    private void txtIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIsbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIsbnActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.setVisible(false);
        frmPrincipal A = new frmPrincipal(new javax.swing.JFrame(), true);
        A.setLocationRelativeTo(null);
        A.setResizable(true);
        A.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        AtualizaTabela();
        txtTitulo.setText("");
        txtAno.setText("");
        txtEdicao.setText("");
        txtVolume.setText("");
        txtIsbn.setText("");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Adicionar autores
        this.setVisible(false);
        frmCadAutores A = new frmCadAutores(2);
        A.setLocationRelativeTo(null);
        A.setResizable(true);
        A.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       //Adicionar Editoras
        this.setVisible(false);
        frmCadEditoras E = new frmCadEditoras(2);
        E.setLocationRelativeTo(null);
        E.setResizable(true);
        E.setVisible(true);
        comboautor.setEditable(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtTituloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTituloKeyPressed
        // key pessed
        txtTitulo.setText("");
        txtTitulo.setBackground(Color.white);
        txtAno.setText("");
        txtEdicao.setText("");
        txtVolume.setText("");
        txtIsbn.setText("");
        
    }//GEN-LAST:event_txtTituloKeyPressed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // Inserir
        
       if ((!txtTitulo.getText().isEmpty()) && (comboautor.getItemCount() != 0) && (comboeditora.getItemCount() != 0)  ) {
           
            ObraDao aDao = new ObraDao();
            AutorDao autDao = new AutorDao();
            EditoraDao edDao = new EditoraDao();
            clnObra a = new clnObra();

            a.setTitulo(txtTitulo.getText());
            if(txtEdicao.getText().isEmpty())
            {a.setEdicao(0);                   
            }
            else{
                int ed = Integer.parseInt(txtEdicao.getText());
                a.setEdicao(ed);               
            }
            if(txtAno.getText().isEmpty())
            {a.setAno(0);
                
            }else{
                a.setAno(Integer.parseInt(txtAno.getText()));                
            }           
            a.setVolume(txtVolume.getText());
            a.setISBN(txtIsbn.getText());
            
            try {
                a.setCdAutor(autDao.pesquisar(comboautor.getSelectedItem().toString()).getCdAutor());
            } catch (DaoException ex) {
                Logger.getLogger(frmSugestoes.class.getName()).log(Level.SEVERE, null, ex);
            }            
            
           try {
               a.setCdEditora(edDao.pesquisar(comboeditora.getSelectedItem().toString()).getCdEditora());
           } catch (DaoException ex) {
               Logger.getLogger(frmSugestoes.class.getName()).log(Level.SEVERE, null, ex);
           }
                      
           if(aDao.Exists(a) != null){
               JOptionPane.showMessageDialog(this, " Obra já existente!", "Cadastrando Obras", JOptionPane.WARNING_MESSAGE);               
           }else{
                try {
                    aDao.inserir(a);
                    AtualizaTabela();
                } catch (DaoException ex) {
                    Logger.getLogger(frmSugestoes.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, " Obra Cadastrada com Sucesso!!", "Cadastrando Obras", JOptionPane.INFORMATION_MESSAGE);
           }
        }else if ((txtTitulo.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, " Informe o Titulo!", "Cadastrando Obras", JOptionPane.WARNING_MESSAGE);            
            txtTitulo.setBackground(Color.lightGray);
        } else if ((comboautor.getItemCount() != 0)) {
            //labelCampo.setVisible(true);
            JOptionPane.showMessageDialog(this, "Insira o Autor!", "Cadastrando Obras", JOptionPane.WARNING_MESSAGE);
        } else if ((comboeditora.getItemCount() != 0)) {
            //labelCampo.setVisible(true);
            JOptionPane.showMessageDialog(this, "Insira a Editora!", "Cadastrando Obras", JOptionPane.WARNING_MESSAGE);
        }
        else {
                JOptionPane.showMessageDialog(this, "Campos em branco!", "Cadastrando Obras", JOptionPane.WARNING_MESSAGE);
            //labelCampo.setVisible(true);
            //labelCampo1.setVisible(true);
        }
       
       txtTitulo.setText("");
       txtAno.setText("");
       txtEdicao.setText("");
       txtVolume.setText("");
       txtIsbn.setText("");
       
    }//GEN-LAST:event_jButton8ActionPerformed

    private void comboautorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboautorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comboautorMouseClicked

    private void comboautorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboautorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboautorActionPerformed

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
            java.util.logging.Logger.getLogger(frmSugestoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSugestoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSugestoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSugestoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSugestoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboautor;
    private javax.swing.JComboBox comboeditora;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JTable tabelaObra;
    private java.awt.TextField txtAno;
    private java.awt.TextField txtEdicao;
    private java.awt.TextField txtIsbn;
    private java.awt.TextField txtTitulo;
    private java.awt.TextField txtVolume;
    // End of variables declaration//GEN-END:variables
}
