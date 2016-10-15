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
import selimjose.clnSituacao;
/**
 *
 * @author Bruna
 */
public class SituacaoDao extends Dao implements DbDao<clnSituacao> {
     
    public static final String SQL_INSERIR =  
    "INSERT INTO `situacao` (`NmSituacao`) VALUES (?)";
    
    public static final String SQL_EXCLUIR =
    "DELETE FROM `situacao` WHERE `CdSituacao`=? ";
    
    public static final String SQL_ALTERAR = 
    "UPDATE `situacao` SET `NmSituacao` = ? WHERE `CdSituacao` = ?";
      
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `situacao` WHERE `NmSituacao` = ? ";
    
    public static final String SQL_EXISTS
            = " select * from situacao "
            + " where NmSituacao = ?  ";

    @Override
    public int inserir(clnSituacao Obj) throws DaoException {
        
        int autoNum = -1;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,Obj.getNmSituacao());            
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
    public clnSituacao pesquisar(String nm) throws DaoException {
        
        clnSituacao cRet = null;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);  
            ps.setString (1, nm);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet = new clnSituacao();
                cRet.setNmSituacao(rs.getString("NmSituacao"));    
                cRet.setCdSituacao(rs.getInt("CdSituacao")); 
            }
                
        } catch (Exception e) {
            new DaoException("Situacao nao inserida "+ e.getMessage()).printStackTrace();;
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
            new DaoException("Situacao não removida "+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps);
        }        
        return ret;
    }

    @Override
    public boolean alterar(clnSituacao Obj) throws DaoException {
        
        boolean ret = false;        
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_ALTERAR);  
            ps.setString(1,Obj.getNmSituacao());
            ps.setInt(2, Obj.getCdSituacao());
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
    
      public clnSituacao Exists(clnSituacao p) {
        clnSituacao cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_EXISTS);
            ps.setString(1, p.getNmSituacao());

            rs = ps.executeQuery();

            if (rs.next()) {
                cRet = new clnSituacao();

                cRet.setNmSituacao(rs.getString("NmSituacao"));                
            }
        } catch (Exception e) {
            System.out.println("Situacao ainda não inserida " + e.getMessage());
        } finally {
            close(con, ps, rs);
        }

        return cRet;
    }
      
      public List<clnSituacao> listar(TextAutoCompleter c) {
        ArrayList<clnSituacao> a = new ArrayList<>();
        clnSituacao cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("select * from situacao");
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnSituacao();
                cRet.setCdSituacao(rs.getInt("CdSituacao"));
                cRet.setNmSituacao(rs.getString("NmSituacao"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Situacao nao inserida " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }
        return a;
    }
      
      public List<clnSituacao> listarMod(TextAutoCompleter c) {
        ArrayList<clnSituacao> a = new ArrayList<>();
        clnSituacao cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("select * from situacao where CdSituacao = 1 or CdSituacao = 4 or CdSituacao = 5  ");
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnSituacao();
                cRet.setCdSituacao(rs.getInt("CdSituacao"));
                cRet.setNmSituacao(rs.getString("NmSituacao"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Situacao nao inserida " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }
        return a;
    }
      
     public List<clnSituacao> PesquisarLista(TextAutoCompleter c, clnSituacao p) {
        ArrayList<clnSituacao> a = new ArrayList<>();
        clnSituacao cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);
            ps.setString(1, p.getNmSituacao());
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnSituacao();
                cRet.setCdSituacao(rs.getInt("CdSituacao"));
                cRet.setNmSituacao(rs.getString("NmSituacao"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Situacao nao inserida " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
    
}
