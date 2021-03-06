/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selimjose;

import dao.AlunoDao;
import dao.AutorDao;
import dao.DaoException;
import dao.EditoraDao;
import dao.EmprestimoDao;
import dao.ExemplarDao;
import dao.ObraDao;
import dao.ReservaDao;
import dao.SituacaoDao;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bruna
 */
public class frmConsultaObras extends javax.swing.JFrame {

    private int mod;
    private List<clnSituacao> SituacaoList;
    
    private DefaultTableModel tabelaLista = new DefaultTableModel();
    private DefaultTableModel tabelaListaEx = new DefaultTableModel();
    private DefaultTableModel tabelaListaSituacao = new DefaultTableModel();
    private DefaultTableModel tabelaListaEmprestimo = new DefaultTableModel();
    private List<clnAutor> AutorList;
    private List<clnEditora> EditoraList;
    private List<clnExemplar> ExemplarList;
    private List<clnEmprestimo> EmprestimoList;
    private List<clnReserva> ReservaList;
    ArrayList<clnObra> ObraList = null;
    
    /**
     * Creates new form frmConsultaObras
     */
    public frmConsultaObras() throws DaoException {
        initComponents();
        tabelaExemplar.setEnabled(false);
        
        tabelaLista = (DefaultTableModel) tabelaObra.getModel();
        tabelaListaEx = (DefaultTableModel) tabelaExemplar.getModel();
        tabelaListaSituacao = (DefaultTableModel) tabelaSituacao.getModel();
        tabelaListaEmprestimo = (DefaultTableModel) tabelaEmprestimo.getModel();
        
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);   
        buscaNome();
        checkNao.setSelected(true);
        comboSituacao.setEnabled(false);
        txtDataI.setEnabled(false);
        txtDataF.setEnabled(false);
    }
    
    private String[] initSituacao() {
        String[] situacaoS;
        SituacaoDao cDAO = new SituacaoDao();
        SituacaoList = cDAO.listar();
        situacaoS = new String[SituacaoList.size()+1];
        situacaoS[0] = " ";
        for (int i = 0; i < SituacaoList.size(); i++) {
                situacaoS[i+1] = SituacaoList.get(i).getNmSituacao();
        }
        return situacaoS;
    }
    private void buscaNome() throws DaoException {
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
         EditoraDao eDAO = new EditoraDao();
         AutorDao autDAO = new AutorDao();
         clnEditora e = new clnEditora();
         clnAutor a = new clnAutor();
            
            ObraList = (ArrayList<clnObra>) aDAO.listar();
            for (clnObra p : ObraList) {
            a = autDAO.pesquisarNome(p.getCdAutor());
            e = eDAO.pesquisarNome(p.getCdEditora()); 
            tabelaObra.setSelectionBackground(Color.LIGHT_GRAY);
            tabelaLista.addRow(new Object[]{p.getCdObra(), p.getTitulo(),p.getEdicao(),p.getAno(),p.getVolume(),p.getISBN(),e.getNmEditora(),a.getNmAutor()});
            }  
    }
    private void AtualizaTabela() {
    
        ObraDao aDAO = new ObraDao();
        if(!ObraList.isEmpty())
        {
            tabelaLista.setRowCount(0);
            tabelaLista.fireTableDataChanged();
            ObraList.clear();
            ObraList = (ArrayList<clnObra>) aDAO.listar();
            for (clnObra p : ObraList) {
            tabelaObra.setSelectionBackground(Color.LIGHT_GRAY);
            tabelaLista.addRow(new Object[]{p.getCdObra(), p.getTitulo(),p.getEdicao(),p.getAno(),p.getVolume(),p.getISBN(),p.getCdEditora(),p.getCdAutor()});
            
            }                     
        }
        else{
            ObraList = (ArrayList<clnObra>) aDAO.listar();
            for (clnObra p : ObraList) {
            tabelaObra.setSelectionBackground(Color.LIGHT_GRAY);
            tabelaLista.addRow(new Object[]{p.getCdObra(), p.getTitulo(),p.getEdicao(),p.getAno(),p.getVolume(),p.getISBN(),p.getCdEditora(),p.getCdAutor()});
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

        ExExemplares = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        comboSituacao = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        checkSim = new javax.swing.JCheckBox();
        jLabel24 = new javax.swing.JLabel();
        checkNao = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtDataF = new javax.swing.JFormattedTextField();
        txtDataI = new javax.swing.JFormattedTextField();
        jtObra = new javax.swing.JTabbedPane();
        panelObra = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaObra = new javax.swing.JTable();
        panelExemplar = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaExemplar = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaSituacao = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaEmprestimo = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
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
        jMenuRelatorios4 = new javax.swing.JMenu();
        jMenuRelatorios3 = new javax.swing.JMenu();
        jMenuRelatorios6 = new javax.swing.JMenu();
        jMenuRelatorios = new javax.swing.JMenu();
        jMenuRelatorios2 = new javax.swing.JMenu();
        jMenuCadastro1 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
            .addGap(0, 11, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(153, 102, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 1, 1, 2, new java.awt.Color(102, 51, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel21.setText("Título da Obra :");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_action_goleft.png"))); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        comboSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(initSituacao()));
        comboSituacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboSituacaoFocusLost(evt);
            }
        });
        comboSituacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboSituacaoMouseClicked(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel22.setText("Situação:");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N
        jButton5.setText("Pesquisar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_action_undo.png"))); // NOI18N
        jButton10.setText("Limpar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNome.setForeground(new java.awt.Color(153, 153, 153));
        txtNome.setText("Digite o Nome da Obra");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LogoRelUsuarios.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        ExExemplares.add(checkSim);
        checkSim.setText("Sim");
        checkSim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkSimMouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel24.setText("Exibir os exemplares:");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        ExExemplares.add(checkNao);
        checkNao.setText("Não");
        checkNao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkNaoMouseClicked(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel23.setText("Data Início:");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel25.setText("Data Fim:");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        try {
            txtDataF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDataFFocusLost(evt);
            }
        });

        try {
            txtDataI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataI.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDataIFocusLost(evt);
            }
        });

        tabelaObra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Título", "Edição", "Ano", "Volume", "ISBN", "Editora", "Autor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaObra.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tabelaObra);
        tabelaObra.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tabelaObra.getColumnModel().getColumnCount() > 0) {
            tabelaObra.getColumnModel().getColumn(1).setHeaderValue("Título");
            tabelaObra.getColumnModel().getColumn(2).setHeaderValue("Edição");
            tabelaObra.getColumnModel().getColumn(3).setHeaderValue("Ano");
            tabelaObra.getColumnModel().getColumn(4).setHeaderValue("Volume");
            tabelaObra.getColumnModel().getColumn(5).setHeaderValue("ISBN");
        }

        javax.swing.GroupLayout panelObraLayout = new javax.swing.GroupLayout(panelObra);
        panelObra.setLayout(panelObraLayout);
        panelObraLayout.setHorizontalGroup(
            panelObraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1166, Short.MAX_VALUE)
        );
        panelObraLayout.setVerticalGroup(
            panelObraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelObraLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jtObra.addTab("Obra", panelObra);

        tabelaExemplar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo Obra", "Codigo Exemplar", "Título", "Edição", "Ano", "Volume", "ISBN", "Editora", "Autor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabelaExemplar);
        tabelaExemplar.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tabelaExemplar.getColumnModel().getColumnCount() > 0) {
            tabelaExemplar.getColumnModel().getColumn(2).setHeaderValue("Título");
            tabelaExemplar.getColumnModel().getColumn(3).setHeaderValue("Edição");
            tabelaExemplar.getColumnModel().getColumn(4).setHeaderValue("Ano");
            tabelaExemplar.getColumnModel().getColumn(5).setHeaderValue("Volume");
            tabelaExemplar.getColumnModel().getColumn(6).setHeaderValue("ISBN");
        }

        javax.swing.GroupLayout panelExemplarLayout = new javax.swing.GroupLayout(panelExemplar);
        panelExemplar.setLayout(panelExemplarLayout);
        panelExemplarLayout.setHorizontalGroup(
            panelExemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelExemplarLayout.setVerticalGroup(
            panelExemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelExemplarLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jtObra.addTab("Exemplar", panelExemplar);

        tabelaSituacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo Obra", "Codigo Exemplar", "Título", "Editora", "Autor", "Situacao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tabelaSituacao);
        tabelaSituacao.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tabelaSituacao.getColumnModel().getColumnCount() > 0) {
            tabelaSituacao.getColumnModel().getColumn(2).setHeaderValue("Título");
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jtObra.addTab("Situação", jPanel5);

        tabelaEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo Movimentação", "Codigo Usuário", "Usuário", "Título", "Data Requisição", "Data Devolução", "Data Devolução Efetiva"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tabelaEmprestimo);
        tabelaEmprestimo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1166, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        jtObra.addTab("Movimentação", jPanel3);

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel26.setText("Categoria:");
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  ", "Existente", "Sugerida","Inexistente"}));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton10)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(checkSim)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(checkNao)))
                                        .addGap(92, 92, 92)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22))
                                        .addGap(64, 64, 64)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDataI, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addGap(87, 87, 87)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel25)
                                                    .addComponent(txtDataF, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21)
                                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(44, 44, 44)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel26)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtObra)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboCategoria)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboSituacao)
                            .addComponent(txtDataI)
                            .addComponent(txtDataF)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(jLabel24)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(checkSim)
                                .addComponent(checkNao)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton5)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jMenuCadastro.setBorder(null);
        jMenuCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mmenubar.png"))); // NOI18N
        jMenuCadastro.setText("Menu  ");
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
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        jMenuItem13.setText("Empréstimo");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem13);

        jMenuItem14.setText("Devolução");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
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

        jMenuRelatorios4.setText("         ");
        jMenuRelatorios4.setFont(new java.awt.Font("Candara", 1, 20)); // NOI18N
        jMenuBar1.add(jMenuRelatorios4);

        jMenuRelatorios3.setText("Usuários  ");
        jMenuRelatorios3.setFont(new java.awt.Font("Candara", 1, 20)); // NOI18N
        jMenuRelatorios3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuRelatorios3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuRelatorios3);

        jMenuRelatorios6.setText("      ");
        jMenuRelatorios6.setFont(new java.awt.Font("Candara", 1, 20)); // NOI18N
        jMenuBar1.add(jMenuRelatorios6);

        jMenuRelatorios.setText("Obras e Exemplares    ");
        jMenuRelatorios.setFont(new java.awt.Font("Candara", 1, 20)); // NOI18N
        jMenuRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuRelatoriosMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuRelatorios);

        jMenuRelatorios2.setText("                                                                                                                                                                 ");
        jMenuRelatorios2.setFont(new java.awt.Font("Candara", 1, 20)); // NOI18N
        jMenuBar1.add(jMenuRelatorios2);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.setVisible(false);
        frmRelatorios A = new frmRelatorios();
        A.setLocationRelativeTo(null);
        A.setResizable(true);
        A.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // Pesquisa
        ObraDao aDao = new ObraDao();
        ExemplarDao eDao = new ExemplarDao();
        EditoraDao editoraDao = new EditoraDao();
        AutorDao autorDao = new AutorDao();
        SituacaoDao sDao = new SituacaoDao();
        EmprestimoDao empDao = new EmprestimoDao();
        ReservaDao   rDao = new ReservaDao();
        AlunoDao alDao = new AlunoDao();
        ObraDao obraDao = new ObraDao();
        
        clnObra a = new clnObra();
        clnExemplar e = new clnExemplar();
        clnEditora editora = new clnEditora();
        clnSituacao s = new clnSituacao();
        clnAutor autor = new clnAutor();
        clnAluno aluno = new clnAluno();
         
        a.setTitulo(txtNome.getText());
        
        //Consulta de Obras.......
        if(comboCategoria.getSelectedItem().toString().equals("Existente")){
                a.setSugestao(0);
            }else if(comboCategoria.getSelectedItem().toString().equals("Sugerida")){
                a.setSugestao(1);
            }else if(comboCategoria.getSelectedItem().toString().equals("Inexistente")){
                a.setSugestao(-1);
            }else{
                a.setSugestao(2);
            }
            
            if(a.getTitulo().equals("Digite o Nome da Obra") || a.getTitulo().equals("")){  //Buscar todas as obras
                System.out.println(a.getSugestao());
                
                if(a.getSugestao() == 2){
                    AtualizaTabela();
                }else{ //Pesquisa as Obras de acordo com a categoria escolhida pelo funcionario...                        
                        tabelaLista.setRowCount(0);
                        tabelaLista.fireTableDataChanged();
                        ObraList = (ArrayList<clnObra>) aDao.PesquisarListaSugestao(a);
                        for (clnObra p : ObraList) {
                            try {
                                    autor = autorDao.pesquisarNome(p.getCdAutor());
                            } catch (DaoException ex) {
                                    Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try { 
                                    editora = editoraDao.pesquisarNome(p.getCdEditora());
                            } catch (DaoException ex) {
                                    Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            tabelaObra.setSelectionBackground(Color.LIGHT_GRAY);
                            tabelaLista.addRow(new Object[]{p.getCdObra(), p.getTitulo(),p.getEdicao(),p.getAno(),p.getVolume(),p.getISBN(),editora.getNmEditora(),autor.getNmAutor()});
                        }
                }
            }else{                                  //Buscar uma obra especifica
                    if(a.getSugestao() == 2){
                        
                    tabelaLista.setRowCount(0);
                    tabelaLista.fireTableDataChanged();
                    ObraList = (ArrayList<clnObra>) aDao.PesquisarLista(a);
                    for (clnObra p : ObraList) {
                        try {
                                    autor = autorDao.pesquisarNome(p.getCdAutor());
                            } catch (DaoException ex) {
                                    Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try { 
                                    editora = editoraDao.pesquisarNome(p.getCdEditora());
                            } catch (DaoException ex) {
                                    Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        tabelaObra.setSelectionBackground(Color.LIGHT_GRAY);
                        tabelaLista.addRow(new Object[]{p.getCdObra(), p.getTitulo(),p.getEdicao(),p.getAno(),p.getVolume(),p.getISBN(),editora.getNmEditora(),autor.getNmAutor()});
                    }                    
                    }else{   //Buscar uma obra especifica de certa categoria
                            tabelaLista.setRowCount(0);
                            tabelaLista.fireTableDataChanged();
                            ObraList = (ArrayList<clnObra>) aDao.PesquisarListaNomeSugestao(a);
                            for (clnObra p : ObraList) {
                                try {
                                        autor = autorDao.pesquisarNome(p.getCdAutor());
                                } catch (DaoException ex) {
                                        Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                try { 
                                        editora = editoraDao.pesquisarNome(p.getCdEditora());
                                } catch (DaoException ex) {
                                        Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            tabelaObra.setSelectionBackground(Color.LIGHT_GRAY);
                            tabelaLista.addRow(new Object[]{p.getCdObra(), p.getTitulo(),p.getEdicao(),p.getAno(),p.getVolume(),p.getISBN(),editora.getNmEditora(),autor.getNmAutor()});
                            }
                    }
            }
            //.......................................................................................
            
        if(checkSim.isSelected()){  //Se o Usuario quiser ver os exemplares...
            
            if(comboSituacao.getSelectedItem().toString().equals("Disponível")){
                e.setCdSituacao(1);
            }else if(comboSituacao.getSelectedItem().toString().equals("Reservado")){
                e.setCdSituacao(2);
            }else if(comboSituacao.getSelectedItem().toString().equals("Emprestado")){
                e.setCdSituacao(3);
            }else if(comboSituacao.getSelectedItem().toString().equals("Bloqueado")){
                e.setCdSituacao(4);
            }else if(comboSituacao.getSelectedItem().toString().equals("Indisponível")){
                e.setCdSituacao(5);
            }else if(comboSituacao.getSelectedItem().toString().equals("Necessita Reparo")){
                e.setCdSituacao(6);
            }else if(comboSituacao.getSelectedItem().toString().equals("Em Bom Estado")){
                e.setCdSituacao(7);
            }else{
                    e.setCdSituacao(0);
            }
            
            if(a.getTitulo().equals("Digite o Nome da Obra") || a.getTitulo().equals("")){
                
                if(e.getCdSituacao() == 7){ //Exemplares em bom estado
                    tabelaListaEx.setRowCount(0);
                    tabelaListaEx.fireTableDataChanged();
                    tabelaListaSituacao.setRowCount(0);
                    tabelaListaSituacao.fireTableDataChanged();
                    
                    ExemplarList = (ArrayList<clnExemplar>) eDao.PesquisarBomEstado();
                    for (clnExemplar p : ExemplarList) {
                        try {
                            autor = autorDao.pesquisarNome(p.getCdAutor());
                        } catch (DaoException ex) {
                            Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try { 
                            editora = editoraDao.pesquisarNome(p.getCdEditora());
                        } catch (DaoException ex) {
                            Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            s= sDao.pesquisarNome(p.getCdSituacao());
                        } catch (DaoException ex) {
                            Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        tabelaExemplar.setSelectionBackground(Color.LIGHT_GRAY);
                        tabelaListaEx.addRow(new Object[]{p.getCdObra(),p.getCdExemplar(), p.getTitulo(),p.getEdicao(),p.getAno(),p.getVolume(),p.getISBN(),editora.getNmEditora(),autor.getNmAutor()});
                        tabelaListaSituacao.addRow(new Object[]{p.getCdObra(),p.getCdExemplar(), p.getTitulo(),editora.getNmEditora(),autor.getNmAutor(),s.getNmSituacao()});
                    }
                    
                }else{
                        
                        if(e.getCdSituacao() == 2 ){ //Reservado
                        tabelaListaEmprestimo.setRowCount(0);
                        tabelaListaEmprestimo.fireTableDataChanged();   
                        tabelaListaEx.setRowCount(0);
                        tabelaListaEx.fireTableDataChanged();
                        tabelaListaSituacao.setRowCount(0);
                        tabelaListaSituacao.fireTableDataChanged();
                        ExemplarList = (ArrayList<clnExemplar>) eDao.PesquisarListaSituacao(e);
                        for (clnExemplar p : ExemplarList) {
                            try {
                                autor = autorDao.pesquisarNome(p.getCdAutor());
                            } catch (DaoException ex) {
                                Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try { 
                                editora = editoraDao.pesquisarNome(p.getCdEditora());
                            } catch (DaoException ex) {
                                Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                s= sDao.pesquisarNome(p.getCdSituacao());
                            } catch (DaoException ex) {
                                Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            tabelaExemplar.setSelectionBackground(Color.LIGHT_GRAY);
                            tabelaListaEx.addRow(new Object[]{p.getCdObra(),p.getCdExemplar(), p.getTitulo(),p.getEdicao(),p.getAno(),p.getVolume(),p.getISBN(),editora.getNmEditora(),autor.getNmAutor()});
                            tabelaListaSituacao.addRow(new Object[]{p.getCdObra(),p.getCdExemplar(), p.getTitulo(),editora.getNmEditora(),autor.getNmAutor(),s.getNmSituacao()});                             
                        }
                        
                            ReservaList = (ArrayList<clnReserva>) rDao.PesquisarLista(); ////--------------------------
                            try {
                                ObraList = (ArrayList<clnObra>) obraDao.pesquisarTituloReserva();
                            } catch (DaoException ex) {
                                Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        int i=0;
                        clnObra obra = new clnObra();
                        for (clnReserva emprestimo : ReservaList) {
                            obra = ObraList.get(i);
                            
                            try {
                                    aluno = alDao.pesquisarNome(emprestimo.getCdUsuario());
                                } catch (DaoException ex) {
                                    Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                tabelaEmprestimo.setSelectionBackground(Color.LIGHT_GRAY);
                                tabelaListaEmprestimo.addRow(new Object[]{emprestimo.getCdReserva(),emprestimo.getCdUsuario(),aluno.getNmUsuario(),obra.getTitulo(),emprestimo.getDtReserva()}); 
                            i++;
                        }
                            
                        }else if(e.getCdSituacao() == 3){ //Emprestado
                            
                            tabelaListaEmprestimo.setRowCount(0);
                            tabelaListaEmprestimo.fireTableDataChanged();   
                            tabelaListaEx.setRowCount(0);
                            tabelaListaEx.fireTableDataChanged();
                            tabelaListaSituacao.setRowCount(0);
                            tabelaListaSituacao.fireTableDataChanged();
                            ExemplarList = (ArrayList<clnExemplar>) eDao.PesquisarListaSituacao(e);
                            for (clnExemplar p : ExemplarList) {
                                try {
                                    autor = autorDao.pesquisarNome(p.getCdAutor());
                                } catch (DaoException ex) {
                                    Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                try { 
                                    editora = editoraDao.pesquisarNome(p.getCdEditora());
                                } catch (DaoException ex) {
                                    Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                try {
                                    s= sDao.pesquisarNome(p.getCdSituacao());
                                } catch (DaoException ex) {
                                    Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                tabelaExemplar.setSelectionBackground(Color.LIGHT_GRAY);
                                tabelaListaEx.addRow(new Object[]{p.getCdObra(),p.getCdExemplar(), p.getTitulo(),p.getEdicao(),p.getAno(),p.getVolume(),p.getISBN(),editora.getNmEditora(),autor.getNmAutor()});
                                tabelaListaSituacao.addRow(new Object[]{p.getCdObra(),p.getCdExemplar(), p.getTitulo(),editora.getNmEditora(),autor.getNmAutor(),s.getNmSituacao()});                             
                            }
                        
                                EmprestimoList = (ArrayList<clnEmprestimo>) empDao.PesquisarLista();
                            try {
                                ObraList = (ArrayList<clnObra>) obraDao.pesquisarTitulo();
                            } catch (DaoException ex) {
                                Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            int i=0;
                                for (clnEmprestimo emprestimo : EmprestimoList) {
                                    clnObra obra = new clnObra();
                                    obra = ObraList.get(i);
                                    
                                    
                                try {
                                    aluno = alDao.pesquisarNome(emprestimo.getCdUsuario());
                                } catch (DaoException ex) {
                                    Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                tabelaEmprestimo.setSelectionBackground(Color.LIGHT_GRAY);
                                tabelaListaEmprestimo.addRow(new Object[]{emprestimo.getCdEmprestimo(),emprestimo.getCdUsuario(),aluno.getNmUsuario(),obra.getTitulo(),emprestimo.getDtEmprestimo(),emprestimo.getDtDevolucao(),
                                emprestimo.getDtDevolucaoEfetiva()});
                                        i++;
                                /*try {
                                    ObraList = (ArrayList<clnObra>) obraDao.pesquisarTitulo(emprestimo.getCdEmprestimo());
                                } catch (DaoException ex) {
                                    Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                    for(clnObra obra : ObraList){
                                        
                                        
                                    }*/
                                }
                        
                            
                        }else{
                                tabelaListaEx.setRowCount(0);
                                tabelaListaEx.fireTableDataChanged();
                                tabelaListaSituacao.setRowCount(0);
                                tabelaListaSituacao.fireTableDataChanged();
                                ExemplarList = (ArrayList<clnExemplar>) eDao.PesquisarListaSituacao(e);
                                for (clnExemplar p : ExemplarList) {
                                try {
                                autor = autorDao.pesquisarNome(p.getCdAutor());
                                } catch (DaoException ex) {
                                    Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                try { 
                                editora = editoraDao.pesquisarNome(p.getCdEditora());
                                } catch (DaoException ex) {
                                    Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                                }      
                                try {
                                    s= sDao.pesquisarNome(p.getCdSituacao());
                                } catch (DaoException ex) {
                                    Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                tabelaExemplar.setSelectionBackground(Color.LIGHT_GRAY);
                                tabelaListaEx.addRow(new Object[]{p.getCdObra(),p.getCdExemplar(), p.getTitulo(),p.getEdicao(),p.getAno(),p.getVolume(),p.getISBN(),editora.getNmEditora(),autor.getNmAutor()});
                                tabelaListaSituacao.addRow(new Object[]{p.getCdObra(),p.getCdExemplar(), p.getTitulo(),editora.getNmEditora(),autor.getNmAutor(),s.getNmSituacao()}); 
                    }
                            
                            
                            
                        }
                }
                
                
                
                
            }else{ // Caso tenha selecionado uma obra em específico                
                
            }
        }else if(checkNao.isSelected()){ //Se o Usuario nao quiser ver os exemplares...   
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        txtNome.setText("");
        AtualizaTabela();
    }//GEN-LAST:event_jButton10ActionPerformed

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

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // Reserva
        mod=1;
        this.setVisible(false);
        frmMovimentacaoLocatario P = new frmMovimentacaoLocatario(mod);
        P.setLocationRelativeTo(null);
        P.setResizable(true);
        P.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // Empréstimo
        mod=2;
        this.setVisible(false);
        frmMovimentacaoLocatario P = new frmMovimentacaoLocatario(mod);
        P.setLocationRelativeTo(null);
        P.setResizable(true);
        P.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // Devolucao
        dispose();
        frmMovimetacaoDevolucao A = new frmMovimetacaoDevolucao();
        A.setLocationRelativeTo(null);
        A.setResizable(true);
        A.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

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

    private void jMenuRelatorios3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuRelatorios3MouseClicked
        //Menu Usuarios
        this.setVisible(false);
        frmConsultas P = new frmConsultas();
        P.setLocationRelativeTo(null);
        P.setResizable(true);
        P.setVisible(true);
    }//GEN-LAST:event_jMenuRelatorios3MouseClicked

    private void jMenuRelatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuRelatoriosMouseClicked
        //Menu Obras
        this.setVisible(false);
        frmConsultaObras P;
        try {
            P = new frmConsultaObras();
            P.setLocationRelativeTo(null);
            P.setResizable(true);
            P.setVisible(true);
        } catch (DaoException ex) {
            Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuRelatoriosMouseClicked

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // Menu Desconectar
        dispose();
        frmLogin A = new frmLogin();
        A.setLocationRelativeTo(null);
        A.setResizable(true);
        A.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void txtDataFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataFFocusLost
        //Verifica data
        Date data = null;
        String dataTexto = new String(txtDataF.getText());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            data = format.parse(dataTexto);
        } catch (ParseException ex) {
            Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtDataFFocusLost

    private void txtDataIFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataIFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataIFocusLost

    private void checkSimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkSimMouseClicked
        //Se os exemplares forem ativados
        comboSituacao.setEnabled(true);
        txtDataI.setEnabled(true);
        txtDataF.setEnabled(true);
    }//GEN-LAST:event_checkSimMouseClicked

    private void checkNaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkNaoMouseClicked
        //Se os exemplares forem desativados
        comboSituacao.setEnabled(false);
        txtDataI.setEnabled(false);
        txtDataF.setEnabled(false);
    }//GEN-LAST:event_checkNaoMouseClicked

    private void comboSituacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboSituacaoFocusLost
        // Combo focus lost
        
    }//GEN-LAST:event_comboSituacaoFocusLost

    private void comboSituacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboSituacaoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSituacaoMouseClicked

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
            java.util.logging.Logger.getLogger(frmConsultaObras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsultaObras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsultaObras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsultaObras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmConsultaObras().setVisible(true);
                } catch (DaoException ex) {
                    Logger.getLogger(frmConsultaObras.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ExExemplares;
    private javax.swing.JCheckBox checkNao;
    private javax.swing.JCheckBox checkSim;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboSituacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
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
    private javax.swing.JMenu jMenuRelatorios2;
    private javax.swing.JMenu jMenuRelatorios3;
    private javax.swing.JMenu jMenuRelatorios4;
    private javax.swing.JMenu jMenuRelatorios6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jtObra;
    private javax.swing.JPanel panelExemplar;
    private javax.swing.JPanel panelObra;
    private javax.swing.JTable tabelaEmprestimo;
    private javax.swing.JTable tabelaExemplar;
    private javax.swing.JTable tabelaObra;
    private javax.swing.JTable tabelaSituacao;
    private javax.swing.JFormattedTextField txtDataF;
    private javax.swing.JFormattedTextField txtDataI;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
