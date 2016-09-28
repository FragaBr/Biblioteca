/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selimjose;

/**
 *
 * @author Bruna
 */
public abstract class clnUsuario {
    
    protected int CdUsuario;
    protected String NmUsuario;
    protected String DtNasc;
    protected String Sexo;
    protected int Tel; 
    protected String Email;
    protected String Login;
    protected String Senha;
    protected boolean Status;
    protected int CEP;
    protected int CdBairros;
    protected int CdCidades;    
    protected int numeroLogradouro;  //numero da casa onde mora.
    
    
    public int getCdUsuario(){
        return CdUsuario;        
    }
    public void setCdUsuario(int CdUsuario){
        this.CdUsuario = CdUsuario;
    }
    
    public String getNmUsuario(){
        return NmUsuario;        
    }
    public void setNmUsuario(String NmUsuario){
        this.NmUsuario = NmUsuario;
    }    
}
