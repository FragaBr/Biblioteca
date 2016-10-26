/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import selimjose.clnExemplar;
import selimjose.clnEmprestimo;
import selimjose.clnExemplar;

/**
 *
 * @author Bruna
 */
public class EmprestimoDao extends Dao implements DbDao<clnEmprestimo>{

    public static final String SQL_INSERIR =  
    "INSERT INTO `emprestimo` (`DtEmprestimo`,`DtDevolucao`,`Usuario_CdUsuario`) VALUES (?,?,?)";
    
    public static final String SQL_INSERIR_EX =  
    "INSERT INTO `exemplar_has_emprestimo` (`Exemplar_CdExemplar`,`Exemplar_Obra_CdObra`,`Exemplar_Obra_Editora_CdEditora`,`Exemplar_Obra_Autor_CdAutor`,"
            + "`Exemplar_Situacao_CdSituacao`,`Emprestimo_CdEmprestimo`,`Emprestimo_Usuario_CdUsuario`) VALUES (?,?,?,?,?,?,?)";
    
    public static final String SQL_EXCLUIR =
    "DELETE FROM `reserva` WHERE `CdReserva`=? ";
    
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `reserva` WHERE `CdBairros` = ? ";
    
    
    public clnEmprestimo inserirR(clnEmprestimo Obj) throws DaoException {
        int autoNum = -1;
        clnEmprestimo cr = new clnEmprestimo();

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,Obj.getDtEmprestimo());  
            ps.setString(2,Obj.getDtDevolucao()); 
            ps.setInt(3,Obj.getCdUsuario());
            ps.execute();
            rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                autoNum = rs.getInt(1);
                cr.setCdEmprestimo(rs.getInt("CdEmprestimo"));
            }
        } catch (DaoException | SQLException e) {
        } finally {
            close(con, ps, rs);
        }
        return cr;
    }
    
    public int inserirEmprestimoEx(clnEmprestimo Obj, clnExemplar Eobj) throws DaoException { //reserva o exemplar - tabela exemplar_has_reserva
        int autoNum = -1;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_INSERIR_EX, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,Eobj.getCdExemplar());
            ps.setInt(2,Eobj.getCdObra());
            ps.setInt(3,Eobj.getCdEditora());
            ps.setInt(4,Eobj.getCdAutor());
            ps.setInt(5,Eobj.getCdSituacao());  
            ps.setInt(6,Obj.getCdEmprestimo()); 
            ps.setInt(7,Obj.getCdUsuario());
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
    public int inserir(clnEmprestimo Obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public clnEmprestimo pesquisar(String id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(clnEmprestimo Obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
