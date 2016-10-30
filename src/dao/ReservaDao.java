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
import selimjose.clnReserva;
/**
 *
 * @author Bruna
 */
public class ReservaDao extends Dao implements DbDao<clnReserva>{

    public static final String SQL_INSERIR =  
    "INSERT INTO `reserva` (`DtReserva`,`Usuario_CdUsuario`) VALUES (?,?)";
    
    public static final String SQL_INSERIR_EX =  
    "INSERT INTO `exemplar_has_reserva` (`Exemplar_CdExemplar`,`Exemplar_Obra_CdObra`,`Exemplar_Obra_Editora_CdEditora`,`Exemplar_Obra_Autor_CdAutor`,"
            + "`Exemplar_Situacao_CdSituacao`,`Reserva_CdReserva`,`Reserva_Usuario_CdUsuario`) VALUES (?,?,?,?,?,?,?)";
    
    public static final String SQL_EXCLUIR =
    "DELETE FROM `reserva` WHERE `CdReserva`=? ";
    
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `reserva` WHERE `CdBairros` = ? ";
    
    
    public int inserirR(clnReserva Obj) throws DaoException {
        int autoNum = -1;
        clnReserva cr = new clnReserva();

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,Obj.getDtReserva());  
            ps.setInt(2,Obj.getCdUsuario()); 
            ps.execute();
            rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                autoNum = rs.getInt(1);
                cr.setCdReserva(rs.getInt("CdReserva"));
            }
        } catch (DaoException | SQLException e) {
        } finally {
            close(con, ps, rs);
        }
        return autoNum;
    }
    
    public int inserirReservaEx(clnReserva Obj, clnExemplar Eobj) throws DaoException { //reserva o exemplar - tabela exemplar_has_reserva
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
            ps.setInt(6,Obj.getCdReserva()); 
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
    public clnReserva pesquisar(String id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(clnReserva Obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int inserir(clnReserva Obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
