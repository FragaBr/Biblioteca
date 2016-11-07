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
import javax.swing.table.DefaultTableModel;
import dao.ModEnsinoDao;
import selimjose.clnModEnsino;
/**
 *
 * @author Bruna
 */
public class frmCadModEnsino extends javax.swing.JFrame {

    private DefaultTableModel tabelaLista = new DefaultTableModel();
     ArrayList<clnModEnsino> arraymodensino = null;
    /**
     * Creates new form frmCadModEnsino
     */
    public frmCadModEnsino() {
        initComponents();
        tabelaLista = (DefaultTableModel) TabelaModEnsino.getModel();
        buscaNome(); 
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        
    }
    private void buscaNome() {
       // int totalLinhas = TabelaAutor.getRowCount();//pega numero total de linhas
        
        TabelaModEnsino.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                return this;
            }
        });

        ModEnsinoDao aDAO = new ModEnsinoDao();
       
            arraymodensino = (ArrayList<clnModEnsino>) aDAO.listar();
            for (clnModEnsino p : arraymodensino) {
            TabelaModEnsino.setSelectionBackground(Color.LIGHT_GRAY);
            tabelaLista.addRow(new Object[]{p.getCdModEnsino(), p.getNmModEnsino()});
            }  
    }

    private void AtualizaTabela() {
    
        ModEnsinoDao aDAO = new ModEnsinoDao();
        if(!arraymodensino.isEmpty())
        {
            tabelaLista.setRowCount(0);
            tabelaLista.fireTableDataChanged();
            arraymodensino.clear();
            arraymodensino = (ArrayList<clnModEnsino>) aDAO.listar();
            for (clnModEnsino p : arraymodensino) {
            TabelaModEnsino.setSelectionBackground(Color.LIGHT_GRAY);
            tabelaLista.addRow(new Object[]{p.getCdModEnsino(), p.getNmModEnsino()});
            
            }                     
        }
        else{
            arraymodensino = (ArrayList<clnModEnsino>) aDAO.listar();
            for (clnModEnsino p : arraymodensino) {
            TabelaModEnsino.setSelectionBackground(Color.LIGHT_GRAY);
            tabelaLista.addRow(new Object[]{p.getCdModEnsino(), p.getNmModEnsino()});
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
        txtNomeModEnsino = new java.awt.TextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaModEnsino = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuRelatorios = new javax.swing.JMenu();
        jMenuCadastro1 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LogoGModens.png"))); // NOI18N

        txtNomeModEnsino.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNomeModEnsino.setForeground(new java.awt.Color(153, 153, 153));
        txtNomeModEnsino.setText("Digite o nome da modalidade");
        txtNomeModEnsino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeModEnsinoKeyPressed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel22.setText("Modalidade de Ensino*:");
        jLabel22.setToolTipText("");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(153, 102, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 1, 2, new java.awt.Color(102, 51, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        TabelaModEnsino.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        TabelaModEnsino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Modalidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaModEnsino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaModEnsinoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaModEnsino);

        jButton6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jButton6.setText("Inserir");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel29.setText("Consulta");
        jLabel29.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        jButton7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_action_goleft.png"))); // NOI18N
        jButton7.setText("Voltar");
        jButton7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_action_undo.png"))); // NOI18N
        jButton10.setText("Restaurar Tela");
        jButton10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel22)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtNomeModEnsino, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(66, 66, 66)
                                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNomeModEnsino, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jMenuCadastro.setBorder(null);
        jMenuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mmenubar.png"))); // NOI18N
        jMenuCadastro.setText("Menu");
        jMenuCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuCadastro.setFont(new java.awt.Font("Candara", 1, 20)); // NOI18N

        jMenu1.setText("Cadastros");

        jMenuItem1.setText("Aluno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem10.setText("Funcionário");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuItem11.setText("Livro");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuCadastro.add(jMenu1);

        jMenu2.setText("Movimentações");

        jMenuItem12.setText("Reserva");
        jMenu2.add(jMenuItem12);

        jMenuItem13.setText("Empréstimo");
        jMenu2.add(jMenuItem13);

        jMenuItem14.setText("Devolução");
        jMenu2.add(jMenuItem14);

        jMenuCadastro.add(jMenu2);

        jMenuItem2.setText("Consultas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItem2);

        jMenuItem5.setText("Relatórios");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItem5);

        jMenuItem6.setText("Configurações");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItem6);

        jMenuItem7.setText("Sugestão de Compras");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItem7);

        jMenuBar1.add(jMenuCadastro);

        jMenuRelatorios.setText("                                                                                                                   ");
        jMenuRelatorios.setFont(new java.awt.Font("Candara", 1, 20)); // NOI18N
        jMenuBar1.add(jMenuRelatorios);

        jMenuCadastro1.setBorder(null);
        jMenuCadastro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_action_exit.png"))); // NOI18N
        jMenuCadastro1.setText("Sair");
        jMenuCadastro1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuCadastro1.setFont(new java.awt.Font("Candara", 1, 20)); // NOI18N

        jMenuItem8.setText("Desconectar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenuCadastro1.add(jMenuItem8);

        jMenuBar1.add(jMenuCadastro1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         if ((!txtNomeModEnsino.getText().isEmpty())) {
            ModEnsinoDao aDao = new ModEnsinoDao();
            clnModEnsino a = new clnModEnsino();
            
            a.setNmModEnsino(txtNomeModEnsino.getText());
             
            if (aDao.Exists(a) != null) {
                JOptionPane.showMessageDialog(this, "Modalidade já existente!", "Cadastrando Modalidade", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    aDao.inserir(a);
                    AtualizaTabela();
                } catch (DaoException ex) {
                    Logger.getLogger(frmCadModEnsino.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "A Modalidade foi cadastrada com sucesso!!", "Cadastrando Modalidade", JOptionPane.INFORMATION_MESSAGE);
                //dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Campos em branco!", "Cadastrando Modalidade", JOptionPane.WARNING_MESSAGE);
        }
        txtNomeModEnsino.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        ModEnsinoDao aDao = new ModEnsinoDao();
        clnModEnsino obj = new clnModEnsino();

        int linha = TabelaModEnsino.getSelectedRow();
        if(linha==-1){
            JOptionPane.showMessageDialog(this, "Selecione alguma linha!", "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                obj.setNmModEnsino(txtNomeModEnsino.getText());
                obj.setCdModEnsino((int) TabelaModEnsino.getValueAt(linha,0));
                aDao.alterar(obj);
                AtualizaTabela();
            } catch (DaoException ex) {
                Logger.getLogger(frmCadModEnsino.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        ModEnsinoDao aDao = new ModEnsinoDao();
        clnModEnsino a = new clnModEnsino();

        int linha = TabelaModEnsino.getSelectedRow();
        if(linha==-1){
            JOptionPane.showMessageDialog(this, "Selecione alguma linha!", "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir ?", " - Excluir -", JOptionPane.YES_NO_OPTION);
            if(opcao == JOptionPane.YES_OPTION)
            {
                int id = (int) TabelaModEnsino.getValueAt(linha,0);
                tabelaLista.removeRow(linha);
                try {
                    aDao.excluir(id);
                } catch (DaoException ex) {
                    Logger.getLogger(frmCadModEnsino.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        txtNomeModEnsino.setText("");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //Pesquisar
        ModEnsinoDao aDao = new ModEnsinoDao();
        clnModEnsino a = new clnModEnsino();
        a.setNmModEnsino(txtNomeModEnsino.getText());
        tabelaLista.setRowCount(0);
        tabelaLista.fireTableDataChanged();
        arraymodensino.clear();
        arraymodensino = (ArrayList<clnModEnsino>) aDao.PesquisarLista(a);
        for (clnModEnsino p : arraymodensino) {
            TabelaModEnsino.setSelectionBackground(Color.LIGHT_GRAY);
            tabelaLista.addRow(new Object[]{p.getCdModEnsino(), p.getNmModEnsino()});
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        frmCriteriosSistema P = new frmCriteriosSistema();
        P.setLocationRelativeTo(null);
        P.setResizable(true);
        P.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        AtualizaTabela();
        txtNomeModEnsino.setText("");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
       
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void txtNomeModEnsinoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeModEnsinoKeyPressed
       txtNomeModEnsino.setText("");
    }//GEN-LAST:event_txtNomeModEnsinoKeyPressed

    private void TabelaModEnsinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaModEnsinoMouseClicked
        //mouse clicked
        int linha = TabelaModEnsino.getSelectedRow();
        txtNomeModEnsino.setText((String) TabelaModEnsino.getValueAt(linha,1));
    }//GEN-LAST:event_TabelaModEnsinoMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // Cadastro aluno
        this.setVisible(false);
        frmCadAluno P = new frmCadAluno(new javax.swing.JFrame(), true);
        P.setLocationRelativeTo(null);
        P.setResizable(true);
        P.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // Cadastro funcionario
        this.setVisible(false);
        frmCadFuncionario P = new frmCadFuncionario();
        P.setLocationRelativeTo(null);
        P.setResizable(true);
        P.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // Cadastro Livro
        this.setVisible(false);
        frmCadObras P = new frmCadObras(new javax.swing.JFrame(), true);
        P.setLocationRelativeTo(null);
        P.setResizable(true);
        P.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // Consultas
        this.setVisible(false);
        frmConsultas P = new frmConsultas();
        P.setLocationRelativeTo(null);
        P.setResizable(true);
        P.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        //Relatorio
        this.setVisible(false);
        frmRelatorios P = new frmRelatorios();
        P.setLocationRelativeTo(null);
        P.setResizable(true);
        P.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // Config
        this.setVisible(false);
        frmCriteriosSistema P = new frmCriteriosSistema();
        P.setLocationRelativeTo(null);
        P.setResizable(true);
        P.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // Compras
        this.setVisible(false);
        frmSugestoes P = new frmSugestoes();
        P.setLocationRelativeTo(null);
        P.setResizable(true);
        P.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // Menu Desconectar
        dispose();
        frmLogin A = new frmLogin();
        A.setLocationRelativeTo(null);
        A.setResizable(true);
        A.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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
            java.util.logging.Logger.getLogger(frmCadModEnsino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadModEnsino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadModEnsino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadModEnsino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCadModEnsino().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaModEnsino;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenu jMenuCadastro1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenu jMenuRelatorios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField txtNomeModEnsino;
    // End of variables declaration//GEN-END:variables
}
