/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mxrck.autocompleter.TextAutoCompleter;
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
    "INSERT INTO `obra` (`Titulo`, `Edicao`,`Ano`,`Volume`, `ISBN`,`Editora_CdEditora`, `Autor_CdAutor` ) VALUES (?,?,?,?,?,?,?)";
    
    public static final String SQL_EXCLUIR =
    "DELETE FROM `obra` WHERE `CdObra`=? ";
    
    public static final String SQL_ALTERAR = 
    "UPDATE `obra` SET `Titulo` = ? WHERE `CdObra` = ?";
      
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `obra` WHERE `Titulo` = ? ";
    
    public static final String SQL_EXISTS
            = " select * from obra "
            + " where Titulo = ?  ";

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
            ps.setInt(2, Obj.getCdObra());
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
      
      public List<clnObra> listar(TextAutoCompleter c) {
        ArrayList<clnObra> a = new ArrayList<>();
        clnObra cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("select * from obra");
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
      
     public List<clnObra> PesquisarLista(TextAutoCompleter c, clnObra p) {
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
    
}
