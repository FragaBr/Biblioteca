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
import java.util.Date;
import java.util.List;
import selimjose.clnAluno;
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
    "UPDATE `usuario` SET `Senha` = ? WHERE `CdUsuario` = ?"; 
    
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `usuario` WHERE (`NmUsuario`, `DtNasc`) = (?,?)";
    
    public static final String SQL_CONSULTA =
    "SELECT * FROM `usuario` WHERE `NmUsuario` = ? ";
    
    public static final String SQL_RECUPERA =
    "SELECT * FROM `usuario` WHERE (`Login`, `DtNasc`) = (?,?)";
    
    public static final String SQL_EXISTS
            = " select * from usuario WHERE `CdUsuario` = ? ";
    
    public static final String SQL_STATUS =
    "SELECT * FROM `usuario` WHERE `Status` = ? ";
    
  
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
    
    public clnFuncionario recupera(clnUsuario p) throws DaoException {
        clnFuncionario cRet = null;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_RECUPERA);  
            ps.setString(1, p.getLogin());
            ps.setString(2, p.getDtNasc());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet = new clnFuncionario();
                cRet.setCdUsuario(rs.getInt("CdUsuario"));
                cRet.setNmUsuario(rs.getString("NmUsuario"));                
            }
                
        } catch (Exception e) {
            new DaoException("Usuario não inserido "+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps, rs);
        }	
        return cRet;
    }
    
    public clnAluno recuperaAluno(clnUsuario p) throws DaoException {
        clnAluno cRet = null;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_RECUPERA);  
            ps.setString(1, p.getLogin());
            ps.setString(2, p.getDtNasc());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet = new clnAluno();
                cRet.setCdUsuario(rs.getInt("CdUsuario"));
                cRet.setNmUsuario(rs.getString("NmUsuario"));                
            }
                
        } catch (Exception e) {
            new DaoException("Usuario não inserido "+ e.getMessage()).printStackTrace();;
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
        boolean ret = false;        
        PreparedStatement ps = null;
        Connection con = null;        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_ALTERAR);  
            ps.setString(1,Obj.getSenha());
            ps.setInt(2, Obj.getCdUsuario());
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
    
    public List<clnFuncionario> PesquisarLista(TextAutoCompleter c, clnFuncionario p) {
        ArrayList<clnFuncionario> a = new ArrayList<>();
        clnFuncionario cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_CONSULTA);
            ps.setString(1, p.getNmUsuario());
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnFuncionario();
                cRet.setCdUsuario(rs.getInt("CdUsuario"));
                cRet.setNmUsuario(rs.getString("NmUsuario"));
                cRet.setEmail(rs.getString("Email"));
                cRet.setTel(rs.getString("Tel"));
                cRet.setStatus(rs.getInt("Status"));
                a.add(cRet);
            }
        } catch (Exception e) {
        new DaoException("Funcionario não inserido " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }
        return a;
    }
    
    public List<clnFuncionario> listar(TextAutoCompleter c) {
        ArrayList<clnFuncionario> a = new ArrayList<>();
        clnFuncionario cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("select * from usuario");
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnFuncionario();
                cRet.setCdUsuario(rs.getInt("CdUsuario"));
                cRet.setNmUsuario(rs.getString("NmUsuario"));
                cRet.setEmail(rs.getString("Email"));
                cRet.setTel(rs.getString("Tel"));
                cRet.setStatus(rs.getInt("Status"));
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Autor nao inserido" + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
    
     public List<clnFuncionario> PesquisaStatus(TextAutoCompleter c, clnFuncionario p) {
        ArrayList<clnFuncionario> a = new ArrayList<>();
        clnFuncionario cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_STATUS);
            ps.setInt(1, p.isStatus());
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnFuncionario();
                cRet.setCdUsuario(rs.getInt("CdUsuario"));
                cRet.setNmUsuario(rs.getString("NmUsuario"));
                cRet.setEmail(rs.getString("Email"));
                cRet.setTel(rs.getString("Tel"));
                cRet.setStatus(rs.getInt("Status"));
                a.add(cRet);
            }
        } catch (Exception e) {
        new DaoException("Funcionario não inserido " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }
        return a;
    }
     
     public int pesquisar2(clnUsuario p) throws DaoException {
        
        int cRet=0;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);  
            ps.setString(1, p.getNmUsuario());
            ps.setString(2,p.getDtNasc());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet =(rs.getInt("CdUsuario"));
            }
                
        } catch (Exception e) {
            new DaoException("Funcionario nÃ£o inserido "+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps, rs);
        }	
        return cRet;
    }

}
