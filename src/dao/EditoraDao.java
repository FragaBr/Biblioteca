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
import selimjose.clnEditora;

/**
 *
 * @author Bruna
 */
public class EditoraDao extends Dao implements DbDao<clnEditora> {
     
    public static final String SQL_INSERIR =  
    "INSERT INTO `editora` (`NmEditora`) VALUES (?)";
    
    public static final String SQL_EXCLUIR =
    "DELETE FROM `editora` WHERE `CdEditora`=? ";
    
    public static final String SQL_ALTERAR = 
    "UPDATE `editora` SET `NmEditora` = ? WHERE `CdEditora` = ?";
      
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `editora` WHERE `NmEditora` = ? ";
    
    public static final String SQL_EXISTS
            = " select * from editora "
            + " where NmEditora = ?  ";

    @Override
    public int inserir(clnEditora Obj) throws DaoException {
        int autoNum = -1;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,Obj.getNmEditora());            
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
    public clnEditora pesquisar(String nm) throws DaoException {

        clnEditora cRet = null;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);  
            ps.setString (1, nm);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet = new clnEditora();
                cRet.setNmEditora(rs.getString("NmEditora"));    
                cRet.setCdEditora(rs.getInt("CdEditora")); 
            }
                
        } catch (Exception e) {
            new DaoException("Editora nao inserida "+ e.getMessage()).printStackTrace();;
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
            new DaoException("Ediora não removida "+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps);
        }        
        return ret;
    }

    @Override
    public boolean alterar(clnEditora Obj) throws DaoException {
        
        boolean ret = false;        
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_ALTERAR);  
            ps.setString(1,Obj.getNmEditora());
            ps.setInt(2, Obj.getCdEditora());
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
    
     public clnEditora Exists(clnEditora p) {
        clnEditora cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_EXISTS);
            ps.setString(1, p.getNmEditora());

            rs = ps.executeQuery();

            if (rs.next()) {
                cRet = new clnEditora();

                cRet.setNmEditora(rs.getString("NmEditora"));                
            }
        } catch (Exception e) {
            System.out.println(" Editora ainda não inserida" + e.getMessage());
        } finally {
            close(con, ps, rs);
        }

        return cRet;
    }
      
      public List<clnEditora> listar() {
        ArrayList<clnEditora> a = new ArrayList<>();
        clnEditora cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("select * from editora");
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnEditora();
                cRet.setCdEditora(rs.getInt("CdEditora"));
                cRet.setNmEditora(rs.getString("NmEditora"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Editora nao inserida" + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
      public List<clnEditora> PesquisarLista(clnEditora p) {
        ArrayList<clnEditora> a = new ArrayList<>();
        clnEditora cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);
            ps.setString(1, p.getNmEditora());
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnEditora();
                cRet.setCdEditora(rs.getInt("CdEditora"));
                cRet.setNmEditora(rs.getString("NmEditora"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
        new DaoException(" Editora não inserida " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
}
