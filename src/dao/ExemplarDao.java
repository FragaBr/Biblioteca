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
import selimjose.clnExemplar;
/**
 *
 * @author Bruna
 */
public class ExemplarDao extends Dao implements DbDao<clnExemplar> {
     
    public static final String SQL_INSERIR =  
    "INSERT INTO `exemplar` (`CdExemplar`, `Obra_CdObra`,`Obra_Editora_CdEditora`,`Obra_Autor_CdAutor`, `Situacao_CdSituacao`) VALUES (?,?,?,?,?)";
    
    public static final String SQL_EXCLUIR =
    "UPDATE `exemplar` SET `Situacao_CdSituacao` = 5 WHERE `Obra_CdObra` = ?";
    
    public static final String SQL_ALTERAR = 
    "UPDATE `exemplar` SET `Situacao_CdSituacao` = ? WHERE `CdExemplar` = ?";
      
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `obra`,`exemplar` WHERE `Titulo` = ? and CdObra = Obra_CdObra and Situacao_CdSituacao = 1  ";
    
    public static final String SQL_PESQUISAR2 =
    "SELECT * FROM `exemplar` WHERE `Obra_CdObra` = ? ";
    
    public static final String SQL_PESQUISAR3=
    "SELECT * FROM `obra`,`exemplar` WHERE `CdExemplar` = ? and CdObra = Obra_CdObra and Situacao_CdSituacao = 3  ";
    
    public static final String SQL_EXISTS
            = " select * from exemplar "
            + " where CdExemplar = ?  ";
    
    public static final String SQL_Disponibilizar =
    "UPDATE `exemplar` SET `Situacao_CdSituacao` = 1 WHERE `CdExemplar` = ?";

    @Override
    public int inserir(clnExemplar Obj) throws DaoException {
        
        int autoNum = -1;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,Obj.getCdExemplar());   
            ps.setInt(2,Obj.getCdObra());
            ps.setInt(3,Obj.getCdEditora());
            ps.setInt(4,Obj.getCdAutor());
            ps.setInt(5,Obj.getCdSituacao());
            
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

    
    public clnExemplar pesquisar(int nm) throws DaoException {
        
        clnExemplar cRet = null;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);  
            ps.setInt (1, nm);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet = new clnExemplar();
                cRet.setCdExemplar(rs.getInt("CdExemplar"));    
                cRet.setCdObra(rs.getInt("Obra_CdObra")); 
            }
                
        } catch (Exception e) {
            new DaoException("Exemplar não inserido "+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps, rs);
        }        
	
        return cRet;
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
            new DaoException("Exemplar não removido "+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps);
        }        
        return ret;
    }

    @Override
    public boolean alterar(clnExemplar Obj) throws DaoException {
        
        boolean ret = false;        
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_ALTERAR);  
            ps.setInt(1,Obj.getCdSituacao());
            ps.setInt(2, Obj.getCdExemplar());
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
    
      public clnExemplar Exists(clnExemplar p) {
        clnExemplar cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_EXISTS);
            ps.setInt(1, p.getCdExemplar());

            rs = ps.executeQuery();

            if (rs.next()) {
                cRet = new clnExemplar();

                cRet.setCdExemplar(rs.getInt("CdExemplar"));                
            }
        } catch (Exception e) {
            System.out.println(" Exemplar ainda não inserido " + e.getMessage());
        } finally {
            close(con, ps, rs);
        }

        return cRet;
    }
      
     public List<clnExemplar> listar() {
        ArrayList<clnExemplar> a = new ArrayList<>();
        clnExemplar cRet = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = getConnection();
            ps = con.prepareStatement("select `CdExemplar`,`Obra_CdObra`,`Titulo`,`Edicao`,`Ano`,`Volume`,`ISBN`,`Situacao_CdSituacao`,`Editora_CdEditora`,`Autor_CdAutor` from `exemplar`,`obra` WHERE CdObra = Obra_CdObra");
            rs = ps.executeQuery();
            while (rs.next()) {
                cRet = new clnExemplar();            
                cRet.setCdExemplar(rs.getInt("CdExemplar"));
                cRet.setCdObra(rs.getInt("Obra_CdObra"));
                cRet.setCdEditora(rs.getInt("Editora_CdEditora"));
                cRet.setCdAutor(rs.getInt("Autor_CdAutor"));
                cRet.setTitulo(rs.getString("Titulo"));
                cRet.setEdicao(rs.getInt("Edicao"));
                cRet.setAno(rs.getInt("Ano"));
                cRet.setVolume(rs.getString("Volume"));
                cRet.setISBN(rs.getString("ISBN"));
                cRet.setCdSituacao(rs.getInt("Situacao_CdSituacao"));
                
                //cRet.setCdEditora(rs.getInt("Obra_Editora_CdEditora"));
                //cRet.setCdAutor(rs.getInt("Obra_Autor_CdAutor"));
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Exemplar nao inserido" + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }
        return a;
    }
     public List<clnExemplar> listarDisponiveis() {
        ArrayList<clnExemplar> a = new ArrayList<>();
        clnExemplar cRet = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = getConnection();
            ps = con.prepareStatement("select `CdExemplar`,`Obra_CdObra`,`Titulo`,`Edicao`,`Ano`,`Volume`,`ISBN`,`Situacao_CdSituacao`,`Editora_CdEditora`,`Autor_CdAutor` from `exemplar`,`obra` WHERE CdObra = Obra_CdObra and `Situacao_CdSituacao` = 1 ");
            rs = ps.executeQuery();
            while (rs.next()) {
                cRet = new clnExemplar();            
                cRet.setCdExemplar(rs.getInt("CdExemplar"));
                cRet.setCdObra(rs.getInt("Obra_CdObra"));
                cRet.setCdEditora(rs.getInt("Editora_CdEditora"));
                cRet.setCdAutor(rs.getInt("Autor_CdAutor"));
                cRet.setTitulo(rs.getString("Titulo"));
                cRet.setEdicao(rs.getInt("Edicao"));
                cRet.setAno(rs.getInt("Ano"));
                cRet.setVolume(rs.getString("Volume"));
                cRet.setISBN(rs.getString("ISBN"));
                cRet.setCdSituacao(rs.getInt("Situacao_CdSituacao"));
                
                //cRet.setCdEditora(rs.getInt("Obra_Editora_CdEditora"));
                //cRet.setCdAutor(rs.getInt("Obra_Autor_CdAutor"));
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Exemplar nao inserido" + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }
        return a;
    } 
     
     public List<clnExemplar> listarEmprestados() {
        ArrayList<clnExemplar> a = new ArrayList<>();
        clnExemplar cRet = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = getConnection();
            ps = con.prepareStatement("select `CdExemplar`,`Obra_CdObra`,`Titulo`,`Edicao`,`Ano`,`Volume`,`ISBN`,`Situacao_CdSituacao`,`Editora_CdEditora`,`Autor_CdAutor` from `exemplar`,`obra` WHERE CdObra = Obra_CdObra and `Situacao_CdSituacao` = 3 ");
            rs = ps.executeQuery();
            while (rs.next()) {
                cRet = new clnExemplar();            
                cRet.setCdExemplar(rs.getInt("CdExemplar"));
                cRet.setCdObra(rs.getInt("Obra_CdObra"));
                cRet.setCdEditora(rs.getInt("Editora_CdEditora"));
                cRet.setCdAutor(rs.getInt("Autor_CdAutor"));
                cRet.setTitulo(rs.getString("Titulo"));
                cRet.setEdicao(rs.getInt("Edicao"));
                cRet.setAno(rs.getInt("Ano"));
                cRet.setVolume(rs.getString("Volume"));
                cRet.setISBN(rs.getString("ISBN"));
                cRet.setCdSituacao(rs.getInt("Situacao_CdSituacao"));
                
                //cRet.setCdEditora(rs.getInt("Obra_Editora_CdEditora"));
                //cRet.setCdAutor(rs.getInt("Obra_Autor_CdAutor"));
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Exemplar nao inserido" + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }
        return a;
    } 
    public List<clnExemplar> PesquisarLista(clnExemplar p) {
        ArrayList<clnExemplar> a = new ArrayList<>();
        clnExemplar cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);
            ps.setString(1, p.getTitulo());
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnExemplar();            
                cRet.setCdExemplar(rs.getInt("CdExemplar"));
                cRet.setCdObra(rs.getInt("Obra_CdObra"));
                cRet.setTitulo(rs.getString("Titulo"));
                cRet.setEdicao(rs.getInt("Edicao"));
                cRet.setAno(rs.getInt("Ano"));
                cRet.setVolume(rs.getString("Volume"));
                cRet.setISBN(rs.getString("ISBN"));
                cRet.setCdEditora(rs.getInt("Obra_Editora_CdEditora"));
                cRet.setCdAutor(rs.getInt("Obra_Autor_CdAutor"));
                cRet.setCdSituacao(rs.getInt("Situacao_CdSituacao"));                
                a.add(cRet);
            }
        } catch (Exception e) {
        new DaoException("Exemplar não inserido " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }
        return a;
    }
     
     public List<clnExemplar> PesquisarLista2(clnExemplar p) {
        ArrayList<clnExemplar> a = new ArrayList<>();
        clnExemplar cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR2);
            ps.setString(1, p.getTitulo());
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnExemplar();            
                cRet.setCdExemplar(rs.getInt("CdExemplar"));
                cRet.setCdObra(rs.getInt("Obra_CdObra"));
                cRet.setCdEditora(rs.getInt("Obra_Editora_CdEditora"));
                cRet.setCdAutor(rs.getInt("Obra_Autor_CdAutor"));
                cRet.setCdSituacao(rs.getInt("Situacao_CdSituacao"));                
                a.add(cRet);
            }
        } catch (Exception e) {
        new DaoException("Exemplar não inserido " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }
        return a;
    }
    
      public List<clnExemplar> PesquisarLista3(clnExemplar p) {
        ArrayList<clnExemplar> a = new ArrayList<>();
        clnExemplar cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR3);
            ps.setInt(1, p.getCdExemplar());
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnExemplar();            
                cRet.setCdExemplar(rs.getInt("CdExemplar"));
                cRet.setCdObra(rs.getInt("Obra_CdObra"));
                cRet.setTitulo(rs.getString("Titulo"));
                cRet.setEdicao(rs.getInt("Edicao"));
                cRet.setAno(rs.getInt("Ano"));
                cRet.setVolume(rs.getString("Volume"));
                cRet.setISBN(rs.getString("ISBN"));
                cRet.setCdEditora(rs.getInt("Obra_Editora_CdEditora"));
                cRet.setCdAutor(rs.getInt("Obra_Autor_CdAutor"));
                cRet.setCdSituacao(rs.getInt("Situacao_CdSituacao"));                
                a.add(cRet);
            }
        } catch (Exception e) {
        new DaoException("Exemplar não inserido " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }
        return a;
    }
    @Override
    public clnExemplar pesquisar(String id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean disponibiliza(clnExemplar Obj) throws DaoException {
        
        boolean ret = false;        
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_Disponibilizar); 
            ps.setInt(1, Obj.getCdExemplar());
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
}
