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
import selimjose.clnCidade;

/**
 *
 * @author Bruna
 */
public class CidadeDao extends Dao implements DbDao<clnCidade> {
     
    public static final String SQL_INSERIR =  
    "INSERT INTO `exemplar` (`CdExemplar`, `Obra_CdObra`,`Obra_Editora_CdEditora`,`Obra_Autor_CdAutor`, `Situacao_CdSituacao`) VALUES (?,?,?,?,?)";
    
    public static final String SQL_EXCLUIR =
    "DELETE FROM `exemplar` WHERE `CdExemplar`=? ";
    
    public static final String SQL_ALTERAR = 
    "UPDATE `exemplar` SET `Situacao_CdSituacao` = ? WHERE `CdExemplar` = ?";
      
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `cidades` WHERE `CdCidades` = ? ";
    
    public static final String SQL_EXISTS
            = " select * from cidades "
            + " where CdCidades = ?  ";

    @Override
    public int inserir(clnCidade Obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public clnCidade pesquisar(String id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public clnCidade pesquisar(int id) throws DaoException {
    clnCidade cRet = null;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);  
            ps.setInt (1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet = new clnCidade();
                cRet.setCdCidade(rs.getInt("CdCidades")); 
                cRet.setNmCidade(rs.getString("NmCidade"));
                cRet.setEstado(rs.getString("Estado")); 
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
    public boolean alterar(clnCidade Obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<clnCidade> listar(TextAutoCompleter c) {
        ArrayList<clnCidade> a = new ArrayList<>();
        clnCidade cRet = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("select * from cidades");
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnCidade();            
                cRet.setCdCidade(rs.getInt("CdCidades"));
                cRet.setNmCidade(rs.getString("NmCidade"));
                cRet.setEstado(rs.getString("Estado"));                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Cidade não inserida " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
}
