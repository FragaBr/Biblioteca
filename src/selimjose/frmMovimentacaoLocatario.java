/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selimjose;

//import com.mxrck.autocompleter.TextAutoCompleter;
import dao.DaoException;
import dao.UsuarioDao;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bruna
 */
public class frmMovimentacaoLocatario extends javax.swing.JFrame {

    private DefaultTableModel tabelaLista = new DefaultTableModel();
    ArrayList<clnFuncionario> FunList = null;
    ArrayList<clnAluno> AlunoList = null;
    private final int mod;
    /**
     * Creates new form frmMovimentacaoLocatario
     */
    public frmMovimentacaoLocatario(int mod) {
        initComponents();
        tabelaLista = (DefaultTableModel) tabelaLoc.getModel();
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
        this.mod = mod;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Locatario = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtLocatario = new java.awt.TextField();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLoc = new javax.swing.JTable();
        txtLogin = new java.awt.TextField();
        jLabel22 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        rbAl = new javax.swing.JRadioButton();
        rbFun = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
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
        jMenu3 = new javax.swing.JMenu();
        jMenuCadastro1 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel21.setText("Nome do locatário : ");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtLocatario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtLocatario.setForeground(new java.awt.Color(153, 153, 153));
        txtLocatario.setText("Digite o Nome");
        txtLocatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocatarioActionPerformed(evt);
            }
        });
        txtLocatario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLocatarioKeyPressed(evt);
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

        jButton5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N
        jButton5.setText("Consultar Locatário");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_action_goright.png"))); // NOI18N
        jButton7.setText("Avançar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        tabelaLoc.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tabelaLoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Login", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaLoc);

        txtLogin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtLogin.setForeground(new java.awt.Color(153, 153, 153));
        txtLogin.setText("Digite o Login");
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginKeyPressed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel22.setText("Login :");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_action_undo.png"))); // NOI18N
        jButton11.setText("Restaurar Tela");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_action_goleft.png"))); // NOI18N
        jButton8.setText("Voltar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel23.setText("Locatário : ");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Locatario.add(rbAl);
        rbAl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbAl.setText("Aluno");

        Locatario.add(rbFun);
        rbFun.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbFun.setText("Funcionário");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Movimentacao.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(txtLocatario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(118, 118, 118)
                                .addComponent(jButton5)
                                .addGap(59, 59, 59))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton11)
                                .addGap(393, 393, 393)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbAl)
                                .addGap(18, 18, 18)
                                .addComponent(rbFun))
                            .addComponent(jLabel23))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(11, 11, 11)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAl)
                    .addComponent(rbFun))
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addGap(12, 12, 12)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(txtLocatario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
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

        jMenu3.setText("                                                                                                                                                                              ");
        jMenuBar1.add(jMenu3);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLocatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocatarioActionPerformed

    private void txtLocatarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocatarioKeyPressed
        // key pessed
        txtLocatario.setText("");
        txtLocatario.setBackground(Color.white);
    }//GEN-LAST:event_txtLocatarioKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //Pesquisar Locatario
        UsuarioDao aDao = new UsuarioDao();
        clnFuncionario f =new clnFuncionario();
        clnAluno a = new clnAluno();
        
        f.setLogin(txtLogin.getText());
        a.setLogin(txtLogin.getText());
        f.setNmUsuario(txtLocatario.getText());
        a.setNmUsuario(txtLocatario.getText());
        tabelaLista.setRowCount(0);
        tabelaLista.fireTableDataChanged();
        //FunList.clear();
        //AlunoList.clear();
        
        if(rbAl.isSelected()){
            //Aluno esta selecionado.
            AlunoList = (ArrayList<clnAluno>) aDao.PesquisarLista2(a);
        for (clnAluno p : AlunoList) {
            tabelaLoc.setSelectionBackground(Color.LIGHT_GRAY);
            tabelaLista.addRow(new Object[]{p.getLogin(),p.getNmUsuario()});
        }
        }else if(rbFun.isSelected()){
            //Funcionario esta selecionado.
              FunList = (ArrayList<clnFuncionario>) aDao.PesquisarLista(f);
        for (clnFuncionario p : FunList) {
            tabelaLoc.setSelectionBackground(Color.LIGHT_GRAY);
            tabelaLista.addRow(new Object[]{p.getLogin(),p.getNmUsuario()});
        }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       //Avancar
       clnAluno obj = new clnAluno();
       int linha = tabelaLoc.getSelectedRow();
        if(linha==-1){
            JOptionPane.showMessageDialog(this, "Selecione alguma linha!", "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
                obj.setLogin((String) tabelaLoc.getValueAt(linha,0));
                this.setVisible(false);        
                frmCadLoginAluno A = new frmCadLoginAluno(obj,mod);
                A.setLocationRelativeTo(null);
                A.setResizable(true);
                A.setVisible(true);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

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

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginActionPerformed

    private void txtLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginKeyPressed

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        //
        this.setVisible(false);
        frmMovimentacaoGeral P = new frmMovimentacaoGeral();
        P.setLocationRelativeTo(null);
        P.setResizable(true);
        P.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(frmMovimentacaoLocatario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMovimentacaoLocatario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMovimentacaoLocatario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMovimentacaoLocatario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMovimentacaoLocatario(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Locatario;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbAl;
    private javax.swing.JRadioButton rbFun;
    private javax.swing.JTable tabelaLoc;
    private java.awt.TextField txtLocatario;
    private java.awt.TextField txtLogin;
    // End of variables declaration//GEN-END:variables
}
