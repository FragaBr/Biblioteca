/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mxrck.autocompleter.TextAutoCompleter;
import dao.Dao;
import dao.DaoException;
import dao.DbDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import selimjose.clnDia;

/**
 *
 * @author Bruna
 */
public class DiasDao extends Dao implements DbDao{

    public static final String SQL_ALTERAR = 
    "UPDATE `dias` SET `periodoAnual` = ?, `periodoRegular` = ? WHERE `CdDia` = 1";
    
    public static final String SQL_INSERIR =  
    "INSERT INTO `dias` (`periodoAnual`, `periodoRegular`) VALUES (?,?)";
    
     public boolean alterar(clnDia Obj) throws DaoException {
       boolean ret = false;        
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_ALTERAR); 
            ps.setInt(1,Obj.getDiaA());   
            ps.setInt(2,Obj.getDiaR());
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
    
    public List<clnDia> listar(TextAutoCompleter c) {
        ArrayList<clnDia> a = new ArrayList<>();
        clnDia cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("select * from dias");
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnDia();
                cRet.setDiaA(rs.getInt("CdDia"));
                cRet.setDiaA(rs.getInt("periodoAnual"));
                cRet.setDiaR(rs.getInt("periodoRegular"));                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Periodo não inserido" + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }

    @Override
    public Object pesquisar(String id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public int inserir(Object Obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(Object Obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
