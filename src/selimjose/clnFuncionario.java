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
public class clnFuncionario extends clnUsuario{
    
    protected int CdFuncionario;
    protected int CdUsuario;
    protected int CEP;
    protected int CdBairro;
    protected int CdCidade;
    protected int CdCargo;
    
    public int getCdFuncionario()
    {
        return CdFuncionario;
    }
    public void setCdFuncionario( int CdFuncionario)
    {
        this.CdFuncionario = CdFuncionario;
    }
    
    public int getCdUsuario()
    {
        return CdUsuario;
    }
    public void setCdUsuario( int CdUsuario)
    {
        this.CdUsuario = CdUsuario;
    }
    public int getCEP()
    {
        return CEP;
    }
    public void setCEP( int Cep)
    {
        this.CEP = Cep;
    }
    public int getCdBairros()
    {
        return CdBairro;
    }
    public void setCdBairros( int CdBairro)
    {
        this.CdBairro = CdBairro;
    }
    public int getCdCidade()
    {
        return CdCidade;
    }
    public void setCdCidade( int CdCidade)
    {
        this.CdCidade = CdCidade;
    }
     public int getCdCargo()
    {
        return CdCargo;
    }
    public void setCdCargo( int CdCargo)
    {
        this.CdCargo = CdCargo;
    }
}
