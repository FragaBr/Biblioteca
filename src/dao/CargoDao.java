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
import selimjose.clnCargo;
/**
 *
 * @author Bruna
 */
public class CargoDao extends Dao implements DbDao<clnCargo> {
     
    public static final String SQL_INSERIR =  
    "INSERT INTO `cargo` (`NmCargo`) VALUES (?)";
    
    public static final String SQL_EXCLUIR =
    "DELETE FROM `cargo` WHERE `CdCargo`=? ";
    
    public static final String SQL_ALTERAR = 
    "UPDATE `cargo` SET `NmCargo` = ? WHERE `CdCargo` = ?";
      
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `cargo` WHERE `NmCargo` = ? ";
    
    public static final String SQL_EXISTS
            = " select * from cargo "
            + " where NmCargo = ?  ";

    @Override
    public int inserir(clnCargo Obj) throws DaoException {
        
        int autoNum = -1;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,Obj.getNmCargo());            
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
    public clnCargo pesquisar(String nm) throws DaoException {
        
        clnCargo cRet = null;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);  
            ps.setString (1, nm);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet = new clnCargo();
                cRet.setNmCargo(rs.getString("NmCargo"));    
                cRet.setCdCargo(rs.getInt("CdCargo")); 
            }
                
        } catch (Exception e) {
            new DaoException(" Cargo nao inserido "+ e.getMessage()).printStackTrace();;
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
            new DaoException("Cargo não removido "+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps);
        }        
        return ret;
    }

    @Override
    public boolean alterar(clnCargo Obj) throws DaoException {
        
        boolean ret = false;        
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_ALTERAR);  
            ps.setString(1,Obj.getNmCargo());
            ps.setInt(2, Obj.getCdCargo());
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
    
      public clnCargo Exists(clnCargo p) {
        clnCargo cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_EXISTS);
            ps.setString(1, p.getNmCargo());

            rs = ps.executeQuery();

            if (rs.next()) {
                cRet = new clnCargo();

                cRet.setNmCargo(rs.getString("NmCargo"));                
            }
        } catch (Exception e) {
            System.out.println("Cargo ainda não inserido " + e.getMessage());
        } finally {
            close(con, ps, rs);
        }

        return cRet;
    }
      
      public List<clnCargo> listar(TextAutoCompleter c) {
        ArrayList<clnCargo> a = new ArrayList<>();
        clnCargo cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("select * from cargo");
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnCargo();
                cRet.setCdCargo(rs.getInt("CdCargo"));
                cRet.setNmCargo(rs.getString("NmCargo"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Cargo nao inserido " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
      
     public List<clnCargo> PesquisarLista(TextAutoCompleter c, clnCargo p) {
        ArrayList<clnCargo> a = new ArrayList<>();
        clnCargo cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);
            ps.setString(1, p.getNmCargo());
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnCargo();
                cRet.setCdCargo(rs.getInt("CdCargo"));
                cRet.setNmCargo(rs.getString("NmCargo"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Cargo nao inserido " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
    
}
