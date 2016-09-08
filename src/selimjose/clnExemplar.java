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
public class clnExemplar extends clnObra {
    
    protected int CdExemplar;
    protected int CdSituacao;
    
    public int getCdExemplar(){
        return CdExemplar;
    }
    public void setCdExemplar(int CdExemplar){
        this.CdExemplar = CdExemplar;
    }
    public int getCdSituacao(){
        return CdSituacao;
    }
    public void setCdSituacao(int CdSituacao){
        this.CdSituacao = CdSituacao;
    }
}
