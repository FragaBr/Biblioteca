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
import selimjose.clnAutor;

/**
 *
 * @author Bruna
 */
public class AutorDao extends Dao implements DbDao<clnAutor> {
     
    public static final String SQL_INSERIR =  
    "INSERT INTO `autor` (`NmAutor`) VALUES (?)";
    
    public static final String SQL_EXCLUIR =
    "DELETE FROM `autor` WHERE `CdAutor`=? ";
    
    public static final String SQL_ALTERAR_AUTOR = 
    "UPDATE `autor` SET `NmAutor` = ? WHERE `CdAutor` = ?";
      
    public static final String SQL_PESQUISAR_AUTOR =
    "SELECT * FROM `autor` WHERE `NmAutor` = ? ";
    
    public static final String SQL_EXISTS
            = " select * from autor "
            + " where NmAutor = ?  ";

    @Override
    public int inserir(clnAutor Obj) throws DaoException {
        
        int autoNum = -1;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,Obj.getNmAutor());            
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
    public clnAutor pesquisar(String nm) throws DaoException {
        
        clnAutor cRet = null;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR_AUTOR);  
            ps.setString (1, nm);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet = new clnAutor();
                cRet.setNmAutor(rs.getString("NmAutor"));    
                cRet.setCdAutor(rs.getInt("CdAutor")); 
            }
                
        } catch (Exception e) {
            new DaoException("Autor nao inserido "+ e.getMessage()).printStackTrace();;
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
            new DaoException("Autor não removido"+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps);
        }        
        return ret;
    }

    @Override
    public boolean alterar(clnAutor Obj) throws DaoException {
        
        boolean ret = false;        
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_ALTERAR_AUTOR);  
            ps.setString(1,Obj.getNmAutor());
            ps.setInt(2, Obj.getCdAutor());
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
    
      public clnAutor Exists(clnAutor p) {
        clnAutor cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_EXISTS);
            ps.setString(1, p.getNmAutor());

            rs = ps.executeQuery();

            if (rs.next()) {
                cRet = new clnAutor();

                cRet.setNmAutor(rs.getString("NmAutor"));                
            }
        } catch (Exception e) {
            System.out.println(" Autor ainda não inserido" + e.getMessage());
        } finally {
            close(con, ps, rs);
        }

        return cRet;
    }
      
      public List<clnAutor> listar(TextAutoCompleter c) {
        ArrayList<clnAutor> a = new ArrayList<>();
        clnAutor cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("select * from autor");
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnAutor();
                cRet.setCdAutor(rs.getInt("CdAutor"));
                cRet.setNmAutor(rs.getString("NmAutor"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Autor nao inserido" + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
      
     public List<clnAutor> PesquisarLista(TextAutoCompleter c, clnAutor p) {
        ArrayList<clnAutor> a = new ArrayList<>();
        clnAutor cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR_AUTOR);
            ps.setString(1, p.getNmAutor());
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnAutor();
                cRet.setCdAutor(rs.getInt("CdAutor"));
                cRet.setNmAutor(rs.getString("NmAutor"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Autor nao inserido" + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }

}
