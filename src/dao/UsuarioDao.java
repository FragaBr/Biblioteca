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
import selimjose.clnUsuario;
import selimjose.clnFuncionario;

/***
 * @author Bruna
 */
public class UsuarioDao extends Dao implements DbDao<clnUsuario> {

    public static final String SQL_INSERIR =  
    "INSERT INTO `usuario` (`NmUsuario`,`Sexo`,`DtNasc`,`Email`,`Tel`,`Login`,`Senha`,`Status`,`LogradouroNum`,`Logradouros_Cep`,`Logradouros_Bairros_CdBairros` ) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    
    public static final String SQL_EXCLUIR =
    "DELETE FROM `usuario` WHERE `CdUsuario`=? ";
    
    public static final String SQL_ALTERAR = 
    "UPDATE `usuario` SET `NmUsuario` = ? WHERE `CdUsuario` = ?"; 
    
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `usuario` WHERE (`NmUsuario`, `DtNasc`) = (?,?)";
    public static final String SQL_EXISTS
            = " select * from usuario WHERE `CdUsuario` = ? ";   
    
  
    public clnUsuario Exists(clnUsuario p) {
          
        clnUsuario cRet = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null; 

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);
            ps.setString(1, p.getNmUsuario());
            ps.setString(2, p.getDtNasc());

            rs = ps.executeQuery();

        } catch (Exception e) {
            System.out.println(" Usuario ainda não inserido " + e.getMessage());
        } finally {
            close(con, ps, rs);
        }

        return cRet;
    }

    
    public clnUsuario pesquisar(clnUsuario p) throws DaoException {
        clnFuncionario cRet = null;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);  
            ps.setString(1, p.getNmUsuario());
            ps.setString(2, p.getDtNasc());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet = new clnFuncionario();
                cRet.setCdUsuario(rs.getInt("CdUsuario"));
                cRet.setNmUsuario(rs.getString("NmUsuario"));                
            }
                
        } catch (Exception e) {
            new DaoException("Funcionario não inserido "+ e.getMessage()).printStackTrace();;
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
    public boolean alterar(clnUsuario Obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    public int inserir(clnUsuario Obj) throws DaoException {
        int autoNum = -1;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,Obj.getNmUsuario());   
            ps.setString(2,Obj.getSexo());
            ps.setString(3,Obj.getDtNasc());
            ps.setString(4,Obj.getEmail());
            ps.setString(5,Obj.getTel());
            ps.setString(6,Obj.getLogin());
            ps.setString(7,Obj.getSenha());
            ps.setInt(8,Obj.isStatus());
            ps.setInt(9,Obj.getNumeroLogradouro());
            ps.setInt(10,Obj.getCEP());
            ps.setInt(11,Obj.getCdBairros());
            
                System.out.println(Obj.getNmUsuario());
                System.out.println(Obj.getSexo());
                System.out.println(Obj.getDtNasc());
                //System.out.println(Obj.getCdCargo());
                System.out.println(Obj.getCEP());
                System.out.println(Obj.getCdBairros());
                System.out.println(Obj.getNumeroLogradouro());
                System.out.println(Obj.getEmail());
                System.out.println(Obj.getLogin());
            
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
    public clnUsuario pesquisar(String id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
