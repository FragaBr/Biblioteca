/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selimjose;


import dao.AutorDao;
import dao.DaoException;
import dao.DiasDao;
import dao.EditoraDao;
import dao.EmprestimoDao;
import dao.ExemplarDao;
import dao.ObraDao;
import dao.ReservaDao;
import dao.UsuarioDao;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import static java.sql.JDBCType.NULL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bruna
 */
public class frmMovimentacaoFinal extends javax.swing.JFrame {

    private DefaultTableModel tabelaLista = new DefaultTableModel();
    private DefaultTableModel tabelaLista2 = new DefaultTableModel();
    private List<clnAutor> AutorList;
    private List<clnEditora> EditoraList;
    ArrayList<clnObra> ObraList = null;
    ArrayList<clnExemplar> ExList = null;
    ArrayList<clnExemplar> ExList2 = null;
    private final int i;
    private final clnAluno aluno;
    /**
     * Creates new form frmMovimentacaoFinal
     */
    public frmMovimentacaoFinal(clnAluno aluno, int i) throws DaoException, ParseException {
        
        initComponents();
        ExList = new ArrayList<>();
        ExList2 = new ArrayList<>();
        tabelaLista = (DefaultTableModel) tabelaObra.getModel();
        tabelaLista2 = (DefaultTableModel) tabelaObra2.getModel();
        buscaNome();
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);  
        this.i = i;
        this.aluno=aluno;    
        if(i == 1){
            rbAnual.setEnabled(false);
            rbRegular.setEnabled(false);
        }
        if( verificaPendencia(aluno) == true){
            jButton5.setEnabled(false);
            jButton7.setEnabled(false);
            jButton9.setEnabled(false);            
        }
        
    }
    static Date revDia(String StringData) throws ParseException{
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = (Date)formatter.parse(StringData);
        return date;
    }
    
    private boolean verificaPendencia(clnAluno aluno) throws DaoException, ParseException{
        
        UsuarioDao aDao = new UsuarioDao();
        aluno = aDao.pesquisarPendente(aluno);
        Date diaHoje = new Date();
        Date diaBloqueio = new Date();
        diaBloqueio = revDia(aluno.getFimBloqueio());    
        
        if(diaHoje.before(diaBloqueio)){  //Usuario ainda esta bloqueado.
            if(aluno.Status == 2){
            JOptionPane.showMessageDialog(this, " O Usuário se encontra bloqueado! ", " Bloqueio ", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }else{
                return false;
            }
        }else{  // Usuario já está liberado.
                //Alterar status do Usuario e tirar a data de bloqueio.
                aluno.setStatus(1); //Ativa o Usuario Novamente.
                aluno.setFimBloqueio(null);
                aDao.alteraStatus(aluno);                
                return false;
        }       
    }            
    
    private String[] initAutores() {
        String[] autorS;
        AutorDao cDAO = new AutorDao();
        AutorList = cDAO.listar();
        autorS = new String[AutorList.size()];
        for (int i = 0; i < AutorList.size(); i++) {
            autorS[i] = AutorList.get(i).getNmAutor();            
        }
        return autorS;
    }
    private String[] initEditora() {
        String[] editoraS;
        EditoraDao cDAO = new EditoraDao();
        EditoraList = cDAO.listar();
        editoraS = new String[EditoraList.size()];
        for (int i = 0; i < EditoraList.size(); i++) {
            editoraS[i] = EditoraList.get(i).getNmEditora();
        }
        return editoraS;
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

         ExemplarDao aDao = new ExemplarDao();       
            ExList = (ArrayList<clnExemplar>) aDao.listarDisponiveis();
            for (clnExemplar p : ExList) {
                tabelaObra.setSelectionBackground(Color.LIGHT_GRAY);
                tabelaLista.addRow(new Object[]{p.getCdExemplar(), p.getTitulo(),p.getEdicao(),p.getAno(),p.getVolume(),p.getISBN(),p.getCdEditora(),p.getCdAutor()});
            } 
    }
    private void AtualizaTabela() {
        
        ExemplarDao aDao = new ExemplarDao();
        clnExemplar a = new clnExemplar();
        tabelaLista.setRowCount(0);
        tabelaLista.fireTableDataChanged();
        
        if(!ExList.isEmpty())
        {
            tabelaLista.setRowCount(0);
            tabelaLista.fireTableDataChanged();
            ExList.clear();
            ExList = (ArrayList<clnExemplar>) aDao.PesquisarLista(a);
            for (clnExemplar p : ExList) {
                tabelaObra.setSelectionBackground(Color.LIGHT_GRAY);
                tabelaLista.addRow(new Object[]{p.getCdExemplar(), p.getTitulo(),p.getEdicao(),p.getAno(),p.getVolume(),p.getISBN(),p.getCdEditora(),p.getCdAutor()});
            }
            
        }
        else{
            ExList = (ArrayList<clnExemplar>) aDao.PesquisarLista(a);
            for (clnExemplar p : ExList) {
                tabelaObra.setSelectionBackground(Color.LIGHT_GRAY);
                tabelaLista.addRow(new Object[]{p.getCdExemplar(), p.getTitulo(),p.getEdicao(),p.getAno(),p.getVolume(),p.getISBN(),p.getCdEditora(),p.getCdAutor()});
            }
        }
    }
    
 private static final Date date = new Date();

    static String dia() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }
    
    static String diaformatado(Date a) {
        String formato = "dd/MM/yyyy";
        SimpleDateFormat DataFormatada = new SimpleDateFormat(formato);       
        return DataFormatada.format(a);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TIpoEmp = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtTitulo = new java.awt.TextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtCodigo = new java.awt.TextField();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        comboeditora = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaObra = new javax.swing.JTable();
        comboautor = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaObra2 = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        rbAnual = new javax.swing.JRadioButton();
        rbRegular = new javax.swing.JRadioButton();
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
        jMenuRelatorios = new javax.swing.JMenu();
        jMenuCadastro1 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel21.setText("Título*:");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtTitulo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(153, 153, 153));
        txtTitulo.setText("Digite o Titulo");
        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });
        txtTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTituloKeyPressed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel22.setText("Autor*:");
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

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel23.setText("Editora*:");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel25.setText("Código : ");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtCodigo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(153, 153, 153));
        txtCodigo.setText("Digite o Codigo");
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N
        jButton5.setText("Consultar Obra");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jButton7.setText("Adicionar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_action_undo.png"))); // NOI18N
        jButton10.setText("Restaurar Tela");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        comboeditora.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        comboeditora.setForeground(new java.awt.Color(153, 153, 153));
        comboeditora.setModel(new javax.swing.DefaultComboBoxModel(initEditora()));
        comboeditora.setPreferredSize(new java.awt.Dimension(100, 18));

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

        comboautor.setMaximumRowCount(10);
        comboautor.setModel(new javax.swing.DefaultComboBoxModel<>(initAutores()));
        comboautor.setToolTipText("");

        tabelaObra2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tabelaObra2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelaObra2);

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel24.setText("Cesta ");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_action_goleft.png"))); // NOI18N
        jButton8.setText("Voltar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/darkersave.png"))); // NOI18N
        jButton9.setText("Finalizar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel26.setText("Tipo de Empréstimo:");
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TIpoEmp.add(rbAnual);
        rbAnual.setText("Empréstimo Anual");

        TIpoEmp.add(rbRegular);
        rbRegular.setText("Empréstimo Regular");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Movimentacao.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel21)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboautor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23)
                                .addComponent(comboeditora, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(46, 46, 46))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbAnual)
                                .addGap(18, 18, 18)
                                .addComponent(rbRegular))
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton10)
                                        .addGap(177, 177, 177)
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(86, 86, 86)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel24))
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel9)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboautor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addComponent(comboeditora, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(54, 54, 54))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbRegular)
                            .addComponent(rbAnual))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jMenuRelatorios.setText("                                                                                                                                           ");
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
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void txtTituloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTituloKeyPressed
        // key pessed
        txtTitulo.setText("");
        txtTitulo.setBackground(Color.white);
    }//GEN-LAST:event_txtTituloKeyPressed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //Pesquisar
        ExemplarDao aDao = new ExemplarDao();
        clnExemplar a = new clnExemplar();
        a.setTitulo(txtTitulo.getText());
        tabelaLista.setRowCount(0);
        tabelaLista.fireTableDataChanged();

        ExList = (ArrayList<clnExemplar>) aDao.PesquisarLista(a);
        for (clnExemplar p : ExList) {
            tabelaObra.setSelectionBackground(Color.LIGHT_GRAY);
            tabelaLista.addRow(new Object[]{p.getCdExemplar(), p.getTitulo(),p.getEdicao(),p.getAno(),p.getVolume(),p.getISBN(),p.getCdEditora(),p.getCdAutor()});
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int b = tabelaObra.getSelectedRow();
        
        if (b >= 0) {
            tabelaLista.removeRow(b);

            tabelaLista2.addRow(new Object[]{ExList.get(b).getCdExemplar(), ExList.get(b).getTitulo(),ExList.get(b).getEdicao(),ExList.get(b).getAno(),ExList.get(b).getVolume(),ExList.get(b).getISBN(),ExList.get(b).getCdEditora(),ExList.get(b).getCdAutor()});
            ExList2.add(ExList.get(b));
            ExList.remove(b);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione alguma linha!", "Erro ao Adionar o Exemplar ", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        //AtualizaTabela();
        txtTitulo.setText("");
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        txtCodigo.setText("");
        txtTitulo.setText("");
        tabelaLista.setRowCount(0);
        tabelaLista2.setRowCount(0);
        ExList.clear();
        ExList2.clear();
        buscaNome();        
        //AtualizaTabela();        
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

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        //Botao voltar
        this.setVisible(false);
        frmMovimentacaoLocatario A = new frmMovimentacaoLocatario(i);
        A.setLocationRelativeTo(null);
        A.setResizable(true);
        A.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        //Finalizar
        
        if( this.i == 1){
            //Reserva
            ReservaDao rDao = new ReservaDao();
            ExemplarDao exDao = new ExemplarDao();
            clnReserva r = new clnReserva();
            clnReserva r2 = new clnReserva();
            r.setCdUsuario(aluno.getCdUsuario());
            r.setDtReserva(dia());
            
            if(ExList2 != null){
            try {
            int cdReserva = rDao.inserirR(r);
            r.setCdReserva(cdReserva);
            } catch (DaoException ex1) {
                Logger.getLogger(frmMovimentacaoFinal.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
            for (clnExemplar p : ExList2) {
                    p.getCdExemplar();
                    p.getCdEditora();
                    p.getCdAutor();
                    p.getCdObra();
                    p.setCdSituacao(2);
                    try {
                        exDao.alterar(p);
                    } catch (DaoException ex) {
                       Logger.getLogger(frmMovimentacaoFinal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                    System.out.println(p.getCdExemplar());
                    System.out.println(p.getCdObra());
                    System.out.println(p.getCdEditora());
                    System.out.println(p.getCdAutor());
                    //System.out.println(p.getCdSituacao());
                    System.out.println(r.getCdReserva());
                    System.out.println(r.getCdUsuario());
                    
                    //System.out.println(d);
                    rDao.inserirReservaEx(r, p);
                } catch (DaoException ex1) {
                    Logger.getLogger(frmMovimentacaoFinal.class.getName()).log(Level.SEVERE, null, ex1);
                }
                }
            
                JOptionPane.showMessageDialog(this, " Reserva feita com Sucesso!!", "Reserva", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        }else if(this.i == 2){
            //Faz emprestimo
            DiasDao dia = new DiasDao();
            clnDia d = new clnDia();
            Date a = new Date(); 
            ExemplarDao exDao = new ExemplarDao();
            EmprestimoDao eDao = new EmprestimoDao();
            clnEmprestimo e = new clnEmprestimo();
            clnEmprestimo e2 = new clnEmprestimo();
            
            try {
                d = dia.pesquisar2();
            } catch (DaoException ex) {
                Logger.getLogger(frmMovimentacaoFinal.class.getName()).log(Level.SEVERE, null, ex);
            }
            e.setCdUsuario(aluno.getCdUsuario());
            e.setDtEmprestimo(dia());
            if(rbAnual.isSelected()){
                a.setDate(a.getDate()+ d.getDiaA());
            }else if(rbRegular.isSelected()){
                a.setDate(a.getDate()+ d.getDiaR());
            }else{
                JOptionPane.showMessageDialog(this, "Selecione uma opcao de Emprestimo!", "Emprestimo", JOptionPane.WARNING_MESSAGE);
            }
            e.setDtDevolucao(diaformatado(a));
            System.out.println(d);
            System.out.println(e.getDtDevolucao());
            
            if((ExList2 != null) && (rbAnual.isSelected() || rbRegular.isSelected())){
                
                try {
                int cdEmprestimo = eDao.inserirR(e);
                e.setCdEmprestimo(cdEmprestimo);
                } catch (DaoException ex) {
                    Logger.getLogger(frmMovimentacaoFinal.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (clnExemplar p : ExList2) {
                p.getCdExemplar();
                p.getCdEditora();
                p.getCdAutor();
                p.getCdObra();
                p.setCdSituacao(3);
                try {
                    exDao.alterar(p);
                } catch (DaoException ex) {
                    Logger.getLogger(frmMovimentacaoFinal.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                eDao.inserirEmprestimoEx(e, p);
                } catch (DaoException ex1) {
                Logger.getLogger(frmMovimentacaoFinal.class.getName()).log(Level.SEVERE, null, ex1);
                }
                }
                JOptionPane.showMessageDialog(this, " Empréstimo feito com Sucesso!!", "Emprestimo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(frmMovimentacaoFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMovimentacaoFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMovimentacaoFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMovimentacaoFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                clnAluno aluno = new clnAluno();
                try {
                    try {
                        new frmMovimentacaoFinal(aluno,1).setVisible(true);
                    } catch (ParseException ex) {
                        Logger.getLogger(frmMovimentacaoFinal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (DaoException ex) {
                    Logger.getLogger(frmMovimentacaoFinal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup TIpoEmp;
    private javax.swing.JComboBox<String> comboautor;
    private javax.swing.JComboBox comboeditora;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbAnual;
    private javax.swing.JRadioButton rbRegular;
    private javax.swing.JTable tabelaObra;
    private javax.swing.JTable tabelaObra2;
    private java.awt.TextField txtCodigo;
    private java.awt.TextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
