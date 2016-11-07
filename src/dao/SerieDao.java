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
import selimjose.clnSerie;
/**
 *
 * @author Bruna
 */
public class SerieDao extends Dao implements DbDao<clnSerie> {
     
    public static final String SQL_INSERIR =  
    "INSERT INTO `serie` (`NmSerie`) VALUES (?)";
    
    public static final String SQL_EXCLUIR =
    "DELETE FROM `serie` WHERE `CdSerie`=? ";
    
    public static final String SQL_ALTERAR = 
    "UPDATE `serie` SET `NmSerie` = ? WHERE `CdSerie` = ?";
      
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `serie` WHERE `NmSerie` = ? ";
    
    public static final String SQL_EXISTS
            = " select * from serie "
            + " where NmSerie = ?  ";

    @Override
    public int inserir(clnSerie Obj) throws DaoException {
        
        int autoNum = -1;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,Obj.getNmSerie());            
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
    public clnSerie pesquisar(String nm) throws DaoException {
        
        clnSerie cRet = null;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);  
            ps.setString (1, nm);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet = new clnSerie();
                cRet.setNmSerie(rs.getString("NmSerie"));    
                cRet.setCdSerie(rs.getInt("CdSerie")); 
            }
                
        } catch (Exception e) {
            new DaoException("Serie nao inserida "+ e.getMessage()).printStackTrace();;
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
            new DaoException("Serie não removida "+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps);
        }        
        return ret;
    }

    @Override
    public boolean alterar(clnSerie Obj) throws DaoException {
        
        boolean ret = false;        
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_ALTERAR);  
            ps.setString(1,Obj.getNmSerie());
            ps.setInt(2, Obj.getCdSerie());
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
    
      public clnSerie Exists(clnSerie p) {
        clnSerie cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_EXISTS);
            ps.setString(1, p.getNmSerie());

            rs = ps.executeQuery();

            if (rs.next()) {
                cRet = new clnSerie();

                cRet.setNmSerie(rs.getString("NmSerie"));                
            }
        } catch (Exception e) {
            System.out.println(" Serie ainda não inserida " + e.getMessage());
        } finally {
            close(con, ps, rs);
        }

        return cRet;
    }
      
      public List<clnSerie> listar() {
        ArrayList<clnSerie> a = new ArrayList<>();
        clnSerie cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("select * from serie");
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnSerie();
                cRet.setCdSerie(rs.getInt("CdSerie"));
                cRet.setNmSerie(rs.getString("NmSerie"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Serie nao inserida " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
      
     public List<clnSerie> PesquisarLista( clnSerie p) {
        ArrayList<clnSerie> a = new ArrayList<>();
        clnSerie cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);
            ps.setString(1, p.getNmSerie());
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnSerie();
                cRet.setCdSerie(rs.getInt("CdSerie"));
                cRet.setNmSerie(rs.getString("NmSerie"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Serie nao inserida" + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
    
}
