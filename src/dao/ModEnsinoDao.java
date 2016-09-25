/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Bruna
 */
public class ModEnsinoDao extends Dao implements DbDao<clnTurno> {
     
    public static final String SQL_INSERIR =  
    "INSERT INTO `turno` (`NmTurno`) VALUES (?)";
    
    public static final String SQL_EXCLUIR =
    "DELETE FROM `turno` WHERE `CdTurno`=? ";
    
    public static final String SQL_ALTERAR = 
    "UPDATE `autor` SET `NmTurno` = ? WHERE `CdTurno` = ?";
      
    public static final String SQL_PESQUISAR =
    "SELECT * FROM `turno` WHERE `CdTurno` = ? ";
    
    public static final String SQL_EXISTS
            = " select * from turno "
            + " where NmTurno = ?  ";

    @Override
    public int inserir(clnTurno Obj) throws DaoException {
        
        int autoNum = -1;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,Obj.getNmTurno());            
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
    public clnTurno pesquisar(String nm) throws DaoException {
        
        clnTurno cRet = null;		
	PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);  
            ps.setString (1, nm);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cRet = new clnTurno();
                cRet.setNmTurno(rs.getString("NmTurno"));    
                cRet.setCdTurno(rs.getInt("CdTurno")); 
            }
                
        } catch (Exception e) {
            new DaoException("Turno nao inserido "+ e.getMessage()).printStackTrace();;
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
            new DaoException("Turno não removido "+ e.getMessage()).printStackTrace();;
        }finally{
            close(con, ps);
        }        
        return ret;
    }

    @Override
    public boolean alterar(clnTurno Obj) throws DaoException {
        
        boolean ret = false;        
        PreparedStatement ps = null;
        Connection con = null;
        
        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_ALTERAR);  
            ps.setString(1,Obj.getNmTurno());
            ps.setInt(2, Obj.getCdTurno());
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
    
      public clnTurno Exists(clnTurno p) {
        clnTurno cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_EXISTS);
            ps.setString(1, p.getNmTurno());

            rs = ps.executeQuery();

            if (rs.next()) {
                cRet = new clnTurno();

                cRet.setNmTurno(rs.getString("NmTurno"));                
            }
        } catch (Exception e) {
            System.out.println("Turno ainda não inserido " + e.getMessage());
        } finally {
            close(con, ps, rs);
        }

        return cRet;
    }
      
      public List<clnTurno> listar(TextAutoCompleter c) {
        ArrayList<clnTurno> a = new ArrayList<>();
        clnTurno cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("select * from turno");
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnTurno();
                cRet.setCdTurno(rs.getInt("CdTurno"));
                cRet.setNmTurno(rs.getString("NmTurno"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Turno nao inserido " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
      
     public List<clnTurno> PesquisarLista(TextAutoCompleter c, clnTurno p) {
        ArrayList<clnTurno> a = new ArrayList<>();
        clnTurno cRet = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = getConnection();
            ps = con.prepareStatement(SQL_PESQUISAR);
            ps.setString(1, p.getNmTurno());
            rs = ps.executeQuery();

            while (rs.next()) {
                cRet = new clnTurno();
                cRet.setCdTurno(rs.getInt("CdTurno"));
                cRet.setNmTurno(rs.getString("NmTurno"));
                
                a.add(cRet);
            }
        } catch (Exception e) {
            new DaoException("Turno nao inserido " + e.getMessage()).printStackTrace();;
        } finally {
            close(con, ps, rs);
        }

        return a;
    }
    
    
}
