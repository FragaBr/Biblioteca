/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import selimjose.clnObra;

/**
 *
 * @author Bruna
 */
public class ObraDao extends Dao implements DbDao<clnObra> {
     
    public static final String SQL_INSERIR =  
    "INSERT INTO `obra` (`Titulo`, `Edicao`,`Ano`,`Volume`, `ISBN`,`Editora_CdEditora`, `Autor_CdAutor`,`Sugestao` ) VALUES (?,?,?,?,?,?,?,?)";
    
    public static final String SQL_EXCLUIR =
    "UPDATE `obra` SET `Sugestao` = -1 WHERE `CdObra` = ?";
    
    public static final String SQL_ALTERAR = 
    "UPDATE `obra` SET `Titulo` = ?, `Edicao` = ? ,`Ano` = ?,`Volume` = ?, `ISBN` = ? WHERE `CdObra` = ?";
      
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `obra` WHERE `Titulo` = ? ";
    
    public static final String SQL_PESQUISAR2 =
    "SELECT * FROM `obra` WHERE `Titulo` = ? and `Sugestao` = ? ";
    
    public static final String SQL_PESQUISAR3 =
    "SELECT * FROM `obra` WHERE `Sugestao` = ? ";
    
    public static final String SQL_EXISTS
            = " select * from obra "
            + " where Titulo = ?  ";
    
    public static final String SQL_SUG =
    "SELECT * FROM `obra` WHERE `Sugestao` = 1 ";

    public static final String SQL_LISTANOME =
    "select a.CdObra,a.Titulo,a.Edicao,a.Ano,a.Volume,a.ISBN,a.Editora_CdEditora,a.Autor_CdAutor,a.Sugestao,b.NmAutor,c.NmEditora from obra a "
            + "inner join autor b on a.Autor_CdAutor = b.CdAutor inner join editora c on a.Editora_CdEditora = c.CdEditora";
    
    public static final String SQL_EMPRESTADOS= "select a.Emprestimo_CdEmprestimo,b.Usuario_CdUsuario,c.NmUsuario,d.Titulo,b.DtEmprestimo, b.DtDevolucao,a.DtDevolucaoEfetiva\n" +
"from exemplar_has_emprestimo a\n" +
"inner join emprestimo b on a.Emprestimo_CdEmprestimo = b.CdEmprestimo\n" +
"inner join usuario c on b.Usuario_CdUsuario = c.CdUsuario\n" +
"inner join obra d on a.Exemplar_Obra_CdObra = d.CdObra";
    public static final String SQL_RESERVADOS =
    "select a.Reserva_CdReserva,b.Usuario_CdUsuario,c.NmUsuario,d.Titulo,b.DtReserva\n" +
    "from exemplar_has_reserva a\n" +
    "inner join reserva b on a.Reserva_CdReserva = b.CdReserva\n" +
    "inner join usuario c on b.Usuario_CdUsuario = c.CdUsuario\n" +
    "inner join obra d on a.Exemplar_Obra_CdObra = d.CdObra";
    @Override
    public int inserir(clnObra Obj) throws DaoException {
        
        int autoNum = -1;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,Obj.getTitulo());   
            ps.setInt(2,Obj.getEdicao());
            ps.setInt(3,Obj.getAno());
            ps.setString(4,Obj.getVolume());
            ps.setString(5,Obj.getISBN());
            ps.setInt(6,Obj.getCdEditora());
            ps.setInt(7,Obj.getCdAutor());
            ps.setInt(8,Obj.getSugestao());
            
            ps.execute();
            rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                autoNum = rs.getInt(1);
            }
        } catch (DaoException | SQLException e) {
        } finally {
            close(con, ps, rs);
        }
        return autoNum;
    }

    @Override
    public clnObra pesquisar(String nm) throws DaoException {
        
        clnObra cRet = null;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);  
            ps.setString (1, nm);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet = new clnObra();
                cRet.setTitulo(rs.getString("Titulo"));    
                cRet.setCdObra(rs.getInt("CdObra")); 
            }
                
        } catch (Exception e) {
            new DaoException("Obra nao inserida "+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps, rs);
        }        
	
        return cRet;
    }
     public List pesquisarTitulo() throws DaoException {
        
       ArrayList<clnObra> a = new ArrayList<>();
        clnObra cRet = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_EMPRESTADOS);
            //ps.setInt(1,i);
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnObra();
                //cRet.setCdObra(rs.getInt("CdObra"));
                cRet.setTitulo(rs.getString("Titulo"));
               // cRet.setEdicao(rs.getInt("Edicao"));
               // cRet.setAno(rs.getInt("Ano"));
                //cRet.setVolume(rs.getString("Volume"));
               // cRet.setISBN(rs.getString("ISBN"));
                //cRet.setCdEditora(rs.getInt("Editora_CdEditora"));
               // cRet.setCdAutor(rs.getInt("Autor_CdAutor"));                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Obra nao inserida" + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }
        return a;
    }
     public List pesquisarTituloReserva() throws DaoException {
        
       ArrayList<clnObra> a = new ArrayList<>();
        clnObra cRet = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_RESERVADOS);
            //ps.setInt(1,i);
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnObra();
                cRet.setTitulo(rs.getString("Titulo"));                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Obra nao inserida" + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }
        return a;
    }
    
    
    
    @Override
    public boolean excluir(int id) throws DaoException {
        boolean ret = false;        
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_EXCLUIR);  
            ps.setInt (1, id);
            int qtd = ps.executeUpdate();
            
            if (qtd>0)
                ret = true;
            
        } catch (Exception e) {
            new DaoException("Obra não removida "+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps);
        }        
        return ret;
    }

    @Override
    public boolean alterar(clnObra Obj) throws DaoException {
        
        boolean ret = false;        
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_ALTERAR); 
            ps.setString(1,Obj.getTitulo());   
            ps.setInt(2,Obj.getEdicao());
            ps.setInt(3,Obj.getAno());
            ps.setString(4,Obj.getVolume());
            ps.setString(5,Obj.getISBN());
            
            ps.setInt(6, Obj.getCdObra());
            int qtd = ps.executeUpdate();            
            if (qtd>0)
                ret = true;
            
        } catch (Exception e) {
        	 new DaoException(" Alteração não efetuada."+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps);
        }        
        return ret;
    }
    
      public clnObra Exists(clnObra p) {
        clnObra cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_EXISTS);
            ps.setString(1, p.getTitulo());

            rs = ps.executeQuery();

            if (rs.next()) {
                cRet = new clnObra();

                cRet.setTitulo(rs.getString("Titulo"));                
            }
        } catch (Exception e) {
            System.out.println(" Obra ainda não inserida " + e.getMessage());
        } finally {
            close(con, ps, rs);
        }

        return cRet;
    }
      
      public List<clnObra> listar() {
        ArrayList<clnObra> a = new ArrayList<>();
        clnObra cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("select * from obra where `Sugestao` = 0 ");
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnObra();
                cRet.setCdObra(rs.getInt("CdObra"));
                cRet.setTitulo(rs.getString("Titulo"));
                cRet.setEdicao(rs.getInt("Edicao"));
                cRet.setAno(rs.getInt("Ano"));
                cRet.setVolume(rs.getString("Volume"));
                cRet.setISBN(rs.getString("ISBN"));
                cRet.setCdEditora(rs.getInt("Editora_CdEditora"));
                cRet.setCdAutor(rs.getInt("Autor_CdAutor"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Obra nao inserida" + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
      
     public List<clnObra> PesquisarLista( clnObra p) {
        ArrayList<clnObra> a = new ArrayList<>();
        clnObra cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);
            ps.setString(1, p.getTitulo());
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnObra();
                cRet.setCdObra(rs.getInt("CdObra"));
                cRet.setTitulo(rs.getString("Titulo"));
                cRet.setEdicao(rs.getInt("Edicao"));
                cRet.setAno(rs.getInt("Ano"));
                cRet.setVolume(rs.getString("Volume"));
                cRet.setISBN(rs.getString("ISBN"));
                cRet.setCdEditora(rs.getInt("Editora_CdEditora"));
                cRet.setCdAutor(rs.getInt("Autor_CdAutor"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
        new DaoException("Obra não inserida " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
     
     public List<clnObra> sug() {
        ArrayList<clnObra> a = new ArrayList<>();
        clnObra cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_SUG);
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnObra();
                cRet.setCdObra(rs.getInt("CdObra"));
                cRet.setTitulo(rs.getString("Titulo"));
                cRet.setEdicao(rs.getInt("Edicao"));
                cRet.setAno(rs.getInt("Ano"));
                cRet.setVolume(rs.getString("Volume"));
                cRet.setISBN(rs.getString("ISBN"));
                cRet.setCdEditora(rs.getInt("Editora_CdEditora"));
                cRet.setCdAutor(rs.getInt("Autor_CdAutor"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Obra nao inserida" + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
    
     public List<clnObra> listarNomeAE() {
        ArrayList<clnObra> a = new ArrayList<>();
        clnObra cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_LISTANOME);
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnObra();
                cRet.setCdObra(rs.getInt("CdObra"));
                cRet.setTitulo(rs.getString("Titulo"));
                cRet.setEdicao(rs.getInt("Edicao"));
                cRet.setAno(rs.getInt("Ano"));
                cRet.setVolume(rs.getString("Volume"));
                cRet.setISBN(rs.getString("ISBN"));
                cRet.setCdEditora(rs.getInt("NmEditora"));
                cRet.setCdAutor(rs.getInt("NmAutor"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Obra nao inserida" + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
     
     public List<clnObra> PesquisarListaSugestao( clnObra p) {
        ArrayList<clnObra> a = new ArrayList<>();
        clnObra cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR3);
            ps.setInt(1,p.getSugestao());
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnObra();
                cRet.setCdObra(rs.getInt("CdObra"));
                cRet.setTitulo(rs.getString("Titulo"));
                cRet.setEdicao(rs.getInt("Edicao"));
                cRet.setAno(rs.getInt("Ano"));
                cRet.setVolume(rs.getString("Volume"));
                cRet.setISBN(rs.getString("ISBN"));
                cRet.setCdEditora(rs.getInt("Editora_CdEditora"));
                cRet.setCdAutor(rs.getInt("Autor_CdAutor"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
        new DaoException("Obra não inserida " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
    public List<clnObra> PesquisarListaNomeSugestao( clnObra p) {
        ArrayList<clnObra> a = new ArrayList<>();
        clnObra cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR2);
            ps.setString(1, p.getTitulo());
            ps.setInt(2, p.getSugestao());
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnObra();
                cRet.setCdObra(rs.getInt("CdObra"));
                cRet.setTitulo(rs.getString("Titulo"));
                cRet.setEdicao(rs.getInt("Edicao"));
                cRet.setAno(rs.getInt("Ano"));
                cRet.setVolume(rs.getString("Volume"));
                cRet.setISBN(rs.getString("ISBN"));
                cRet.setCdEditora(rs.getInt("Editora_CdEditora"));
                cRet.setCdAutor(rs.getInt("Autor_CdAutor"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
        new DaoException("Obra não inserida " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
    
}
