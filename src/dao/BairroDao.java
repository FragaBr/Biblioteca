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
import selimjose.clnBairro;
/**
 *
 * @author Bruna
 */
public class BairroDao extends Dao implements DbDao<clnBairro> {
     
    public static final String SQL_INSERIR =  
    "INSERT INTO `exemplar` (`CdExemplar`, `Obra_CdObra`,`Obra_Editora_CdEditora`,`Obra_Autor_CdAutor`, `Situacao_CdSituacao`) VALUES (?,?,?,?,?)";
    
    public static final String SQL_EXCLUIR =
    "DELETE FROM `exemplar` WHERE `CdExemplar`=? ";
    
    public static final String SQL_ALTERAR = 
    "UPDATE `exemplar` SET `Situacao_CdSituacao` = ? WHERE `CdExemplar` = ?";
      
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `bairros` WHERE `CdBairros` = ? ";
    
    public static final String SQL_EXISTS
            = " select * from bairros "
            + " where CdBairros = ?  ";
    
    public static final String SQL_EXISTS2
            = " select * from bairros "
            + " where NmBairro=? and Cidades_CdCidades = ?  ";


    @Override
    public int inserir(clnBairro Obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public clnBairro pesquisar(String id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public clnBairro pesquisar(int id) throws DaoException {
    clnBairro cRet = null;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);  
            ps.setInt (1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet = new clnBairro();
                cRet.setCdBairro(rs.getInt("CdBairros")); 
                cRet.setCdCidade(rs.getInt("Cidades_CdCidades"));
                cRet.setNmBairro(rs.getString("NmBairro")); 
            }
                
        } catch (Exception e) {
            new DaoException("Bairro não inserido "+ e.getMessage()).printStackTrace();;
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
    public boolean alterar(clnBairro Obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<clnBairro> listar(TextAutoCompleter c) {
        ArrayList<clnBairro> a = new ArrayList<>();
        clnBairro cRet = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("select * from bairros");
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnBairro();            
                cRet.setCdBairro(rs.getInt("CdBairros")); 
                cRet.setCdCidade(rs.getInt("Cidades_CdCidades"));
                cRet.setNmBairro(rs.getString("NmBairro"));                 
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Bairro não inserido " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }
        return a;
    }
    
    public clnBairro Exists(int Cidades_cdCidades, String nmBairro) {
        
        clnBairro cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_EXISTS);
            ps.setString(1, nmBairro);
            ps.setInt(2,Cidades_cdCidades);
            
            rs = ps.executeQuery();

            if (rs.next()) {
                cRet = new clnBairro();

                cRet.setCdBairro(rs.getInt("CdBairros"));
                cRet.setCdCidade(Cidades_cdCidades);
                cRet.setNmBairro(nmBairro);
            }
        } catch (Exception e) {
            System.out.println(" Exemplar ainda nÃ£o inserido " + e.getMessage());
        } finally {
            close(con, ps, rs);
        }
        return cRet;
    }
       
    public clnBairro Exists2(int Cidades_cdCidades, String nmBairro) {
        
        clnBairro cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_EXISTS2);
            ps.setString(1, nmBairro);
            ps.setInt(2,Cidades_cdCidades);
            
            rs = ps.executeQuery();

            if (rs.next()) {
                cRet = new clnBairro();

                cRet.setCdBairro(rs.getInt("CdBairros"));
                cRet.setCdCidade(Cidades_cdCidades);
                cRet.setNmBairro(nmBairro);
            }
        } catch (Exception e) {
            System.out.println(" Exemplar ainda nÃ£o inserido " + e.getMessage());
        } finally {
            close(con, ps, rs);
        }

        return cRet;
    }

    
    
}
