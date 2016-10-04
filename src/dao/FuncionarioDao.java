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
import selimjose.clnFuncionario;

/**
 *
 * @author Bruna
 */
public class FuncionarioDao  extends Dao implements DbDao<clnFuncionario> {
     
    public static final String SQL_INSERIR =  
    " INSERT INTO funcionario (`Usuario_CdUsuario`,`Usuario_Logradouros_Cep`,`Usuario_Logradouros_Bairros_CdBairros`,`Cargo_CdCargo`) VALUES (?,?,?,?)";
    
    public static final String SQL_EXCLUIR =
    "DELETE FROM `funcionario` WHERE `Usuario_CdUsuario`=? ";
    
    //public static final String SQL_ALTERAR = 
    //"UPDATE `funcionario` SET `NmTurno` = ? WHERE `Usuario_CdUsuario` = ?";
      
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `funcionario` WHERE `NmFuncionario` = ? ";
    
    public static final String SQL_EXISTS
            = " select * from `funcionario` WHERE `Usuario_CdUsuario` = ? ";
    
    public static final String SQL_LOGAR =
    "SELECT * FROM `usuario`, `funcionario` WHERE `CdUsuario` = `Usuario_CdUsuario` and `Cargo_CdCargo` = 9 and `Login` = ? and `Senha` = ?  ";

    @Override
    public int inserir(clnFuncionario Obj) throws DaoException {
        
        int autoNum = -1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,Obj.getCdUsuario());  
            ps.setInt(2,Obj.getCEP());
            ps.setInt(3,Obj.getCdBairros());
            ps.setInt(4,Obj.getCdCargo());
            
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
    public clnFuncionario pesquisar(String nm) throws DaoException {
        
        clnFuncionario cRet = null;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);  
            ps.setString (1, nm);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet = new clnFuncionario();
                cRet.setCdFuncionario(rs.getInt("CdFuncionario"));    
                cRet.setCdUsuario(rs.getInt("Usuario_CdUsuario"));
                cRet.setCEP(rs.getInt("Usuario_Logradouros_Cep"));    
                cRet.setCdBairros(rs.getInt("Usuario_Logradouros_Bairros_CdBairros"));
                cRet.setCdCargo(rs.getInt("Cargo_CdCargo")); 
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
            new DaoException(" Funcionario não removido "+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps);
        }        
        return ret;
    }

    
    public clnFuncionario Exists(clnFuncionario p) {
          
        clnFuncionario cRet = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null; 

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_EXISTS);
            ps.setInt(1, p.getCdUsuario());

            rs = ps.executeQuery();

            if (rs.next()) {
                cRet = new clnFuncionario();
                cRet.setLogin(rs.getString("Login")); 
                cRet.setSenha(rs.getString("Senha")); 
            }
        } catch (Exception e) {
            System.out.println(" Funcionario ainda não inserido " + e.getMessage());
        } finally {
            close(con, ps, rs);
        }

        return cRet;
    }

    @Override
    public boolean alterar(clnFuncionario Obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public clnFuncionario Logar(clnFuncionario Obj) throws DaoException {
        
        clnFuncionario cRet = null;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_LOGAR);  
            ps.setString(1,Obj.getLogin());  
            ps.setString(2,Obj.getSenha());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet = new clnFuncionario();
                cRet.setCdFuncionario(rs.getInt("CdFuncionario"));    
                cRet.setCdUsuario(rs.getInt("Usuario_CdUsuario"));
                cRet.setCdCargo(rs.getInt("Cargo_CdCargo")); 
            }
                
        } catch (Exception e) {
            new DaoException("Funcionario não inserido "+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps, rs);
        }	
        return cRet;
    }
        
}
