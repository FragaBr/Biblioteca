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
public class clnCidade {
    
    protected int CdCidade;
    protected String NmCidade;
    protected String Estado;
    
    public int getCdCidade(){
        return CdCidade;        
    }
    public void setCdCidade(int CdCidade){
        this.CdCidade = CdCidade;
    }
    public String getNmCidade(){
        return NmCidade;        
    }
    public void setNmCidade(String NmCidade){
        this.NmCidade = NmCidade;
    }
    public String getEstado(){
        return Estado;        
    }
    public void setEstado(String Estado){
        this.Estado = Estado;
    }
}
