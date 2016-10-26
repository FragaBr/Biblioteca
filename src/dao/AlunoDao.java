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
import static dao.FuncionarioDao.SQL_LOGAR;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import selimjose.clnAluno;
import selimjose.clnObra;

/**
 *
 * @author Bruna
 */
public class AlunoDao extends Dao implements DbDao<clnAluno> {

    /*Inserindo Aluno*/
    
    public static final String SQL_INSERIRALUNO="SELECT MAX(CdUsuario) FROM `usuario`";
    
    /**/
    
      public static final String SQL_INSERIR =  
    "INSERT INTO `aluno` (`Matricula`, `ModEnsino_CdModEnsino`,`Turno_CdTurno`,`Usuario_CdUsuario`, `Usuario_Logradouros_Cep`"
              + ",`Usuario_Logradouros_Bairros_CdBairros` ) VALUES (?,?,?,?,?,?)";
    
    public static final String SQL_EXCLUIR =
    "DELETE FROM `obra` WHERE `CdObra`=? ";
    
    public static final String SQL_ALTERAR = 
    "UPDATE `obra` SET `Titulo` = ? WHERE `CdObra` = ?";
      
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `usuario` WHERE `Login` = ? and `Senha` = ?  ";
    
    public static final String SQL_EXISTS
            = " select * from obra "
            + " where Titulo = ?  ";
    
    public static final String SQL_LOGAR =
    "SELECT * FROM `usuario` WHERE `Login` = ? and `Senha` = ?  ";

    
    @Override
    public int inserir(clnAluno Obj) throws DaoException {
        
        int autoNum = -1;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,Obj.getMatricula());   
            ps.setInt(2,Obj.getModEnsinoFK());
            ps.setInt(3,Obj.getCdTurnoFK());
            ps.setInt(4,Obj.getCdUsuarioFK());
            ps.setInt(5,Obj.getCepFK());
            ps.setInt(6,Obj.getBairroFK());
            
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
    public boolean excluir(int id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(clnAluno Obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public clnAluno Logar(clnAluno Obj) throws DaoException {
        
        clnAluno cRet = null;		
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
                cRet = new clnAluno();    
                cRet.setCdUsuario(rs.getInt("CdUsuario"));
            }
                
        } catch (Exception e) {
            new DaoException("Funcionario não inserido "+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps, rs);
        }	
        return cRet;
    }

    @Override
    public clnAluno pesquisar(String id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
     
}
