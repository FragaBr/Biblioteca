/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Bruna
 */
public abstract class Dao {
    
    // nome drive JDBC  e URL de banco de dados  
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/bancobib";

    public Connection getConnection() throws DaoException {
        Connection con = null;

        try {
            // carrega classe do banco de dados
            Class.forName(JDBC_DRIVER);  //carrega classe de drive do banco de dados
            //estabelece conexao com banco de dados
            con = DriverManager.getConnection(DATABASE_URL, "", "");
        } catch ( ClassNotFoundException e){
        	throw new DaoException("Erro de driver ao acessar banco de dados: " + e.getMessage());
        } catch (Exception e) {
        	throw new DaoException("Erro - acesso ao banco de dados negado: " + e.getMessage());
        }

        return con;
    }

    protected void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                //nenhum tratamento a ser feito
            }
        }
        close(conn, ps);
    }

    protected void close(Connection conn, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                //nenhum tratamento a ser feito
            }
        }
        close(conn);
    }
    
    protected void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                //nenhum tratamento a ser feito
            }
        }
    }

}
