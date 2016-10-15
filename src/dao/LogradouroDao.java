/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import selimjose.clnLogradouro;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Bruna
 */
public class LogradouroDao extends Dao implements DbDao<clnLogradouro> {
     
    public static final String SQL_INSERIR =  
    "INSERT INTO `logradouros` (`Cep`, `Bairros_CdBairros`,`NmLogradouro`,`Tipo`) VALUES (?,?,?,?)";
    
    public static final String SQL_EXCLUIR =
    "DELETE FROM `logradouros` WHERE `Cep`=? ";
    
    public static final String SQL_ALTERAR = 
    "UPDATE `logradouros` SET `NmLogradouro` = ? WHERE `Cep` = ?";
      
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `logradouros` WHERE `Cep` = ? ";
    
    public static final String SQL_EXISTS
            = " select * from logradouros "
            + " where Cep = ?  ";

    @Override
    public int inserir(clnLogradouro Obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public clnLogradouro pesquisar(String id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public clnLogradouro pesquisar(int id) throws DaoException {
    clnLogradouro cRet = null;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);  
            ps.setInt (1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet = new clnLogradouro();
                cRet.setCep(rs.getInt("Cep")); 
                cRet.setCdBairro(rs.getInt("Bairros_CdBairros"));
                cRet.setNmLogradouro(rs.getString("NmLogradouro")); 
                cRet.setTipo(rs.getString("Tipo"));
            }
                
        } catch (Exception e) {
            new DaoException("Logradouro não inserido "+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps, rs);
        }
        return cRet;
    }

    @Override
    public boolean excluir(int id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(clnLogradouro Obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<clnLogradouro> listar(TextAutoCompleter c) {
        ArrayList<clnLogradouro> a = new ArrayList<>();
        clnLogradouro cRet = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("select * from logradouros");
            //ps.setInt (1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnLogradouro();            
                cRet.setCep(rs.getInt("Cep")); 
                cRet.setCdBairro(rs.getInt("Bairros_CdBairros"));
                cRet.setNmLogradouro(rs.getString("NmLogradouro")); 
                cRet.setTipo(rs.getString("Tipo"));                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Logradouro não inserido " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }
        return a;
    }
    
    
     public ArrayList<clnLogradouro> pegarLista(int CEP) {
        ArrayList<clnLogradouro> a = new ArrayList<>();
        clnLogradouro cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnLogradouro();
                cRet.setCep(rs.getInt("Cep")); 
                cRet.setCdBairro(rs.getInt("Bairros_CdBairros"));
                cRet.setNmLogradouro(rs.getString("NmLogradouro")); 
                cRet.setTipo(rs.getString("Tipo"));
                
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
