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
import selimjose.clnModEnsino;
/**
 *
 * @author Bruna
 */
public class ModEnsinoDao extends Dao implements DbDao<clnModEnsino> {
     
    public static final String SQL_INSERIR =  
    "INSERT INTO `modensino` (`NmModalidade`) VALUES (?)";
    
    public static final String SQL_EXCLUIR =
    "DELETE FROM `modensino` WHERE `NmModalidade`=? ";
    
    public static final String SQL_ALTERAR = 
    "UPDATE `modensino` SET `NmModalidade` = ? WHERE `CdModEnsino` = ?";
      
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `modensino` WHERE `NmModalidade` = ? ";
    
    public static final String SQL_EXISTS
            = " select * from modensino "
            + " where NmModalidade = ?  ";

    @Override
    public int inserir(clnModEnsino Obj) throws DaoException {
        
        int autoNum = -1;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,Obj.getNmModEnsino());            
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
    public clnModEnsino pesquisar(String nm) throws DaoException {
        
        clnModEnsino cRet = null;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);  
            ps.setString (1, nm);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet = new clnModEnsino();
                cRet.setNmModEnsino(rs.getString("NmModEnsino"));    
                cRet.setCdModEnsino(rs.getInt("CdModEnsino")); 
            }
                
        } catch (Exception e) {
            new DaoException("Modalidade nao inserido "+ e.getMessage()).printStackTrace();;
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
            new DaoException("Modalidade não removido "+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps);
        }        
        return ret;
    }

    @Override
    public boolean alterar(clnModEnsino Obj) throws DaoException {
        
        boolean ret = false;        
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_ALTERAR);  
            ps.setString(1,Obj.getNmModEnsino());
            ps.setInt(2, Obj.getCdModEnsino());
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
    
      public clnModEnsino Exists(clnModEnsino p) {
        clnModEnsino cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_EXISTS);
            ps.setString(1, p.getNmModEnsino());

            rs = ps.executeQuery();

            if (rs.next()) {
                cRet = new clnModEnsino();

                cRet.setNmModEnsino(rs.getString("NmModEnsino"));                
            }
        } catch (Exception e) {
            System.out.println("Modalidade ainda não inserida " + e.getMessage());
        } finally {
            close(con, ps, rs);
        }

        return cRet;
    }
      
      public List<clnModEnsino> listar(TextAutoCompleter c) {
        ArrayList<clnModEnsino> a = new ArrayList<>();
        clnModEnsino cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("select * from modensino");
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnModEnsino();
                cRet.setCdModEnsino(rs.getInt("CdModEnsino"));
                cRet.setNmModEnsino(rs.getString("NmModalidade"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Modalidade não inserida " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
      
     public List<clnModEnsino> PesquisarLista(TextAutoCompleter c, clnModEnsino p) {
        ArrayList<clnModEnsino> a = new ArrayList<>();
        clnModEnsino cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);
            ps.setString(1, p.getNmModEnsino());
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnModEnsino();
                cRet.setCdModEnsino(rs.getInt("CdModEnsino"));
                cRet.setNmModEnsino(rs.getString("NmModEnsino"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Modalidade nao inserida " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
    
    
}
