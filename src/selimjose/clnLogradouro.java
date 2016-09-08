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
public class clnLogradouro {
    
    protected int Cep;
    protected String NmLogradouro;
    protected String Tipo;
    protected int CdBairro;
    protected int CdCidade;
    
    public int getCep (){
        return Cep;
    }
    public void setCep( int Cep){
        this.Cep = Cep;
    }
    public String getNmLogradouro(){
        return NmLogradouro;
    }
    public void setNmLogradouro(String NmLogradouro){
        this.NmLogradouro = NmLogradouro;
    }
     public String getTipo(){
        return Tipo;
    }
    public void setTipo(String Tipo){
        this.Tipo = Tipo;
    }
    public int getCdBairro (){
        return CdBairro;
    }
    public void setCdBairro( int CdBairro){
        this.CdBairro = CdBairro;
    }        
    public int getCdCidade(){
        return CdCidade;
    }
    public void setCdCidade( int CdCidade){
        this.CdCidade = CdCidade;
    }         
    
}
