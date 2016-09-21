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
import selimjose.clnAutor;

/**
 *
 * @author Bruna
 */
public class AutorDao extends Dao implements DbDao<clnAutor> {
     
    public static final String SQL_INSERIR =  
    "INSERT INTO `autor` (`NmAutor`) VALUES (?)";
    
    public static final String SQL_EXCLUIR =
    "DELETE FROM `bancobib`.`Autor` WHERE `CdAutor`=? ";
    
    public static final String SQL_ALTERAR_AUTOR = 
    "UPDATE `autor` SET `NmAutor` = ?> WHERE `CdAutor` = ?";
      
    public static final String SQL_PESQUISAR_AUTOR =
    "SELECT `CdAutor`,`NmAutor` FROM `Autor`"+
    "WHERE `CdAutor`=?";
    
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
            //ps.setInt(1, Obj.getCdAutor());
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
    public clnAutor pesquisar(int id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(clnAutor Obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
