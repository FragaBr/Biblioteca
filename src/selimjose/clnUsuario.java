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
    protected String Tel; 
    protected String Email;
    protected String Login;
    protected String Senha;
    protected int Status;
    protected String FimBloqueio;

    public String getFimBloqueio() {
        return FimBloqueio;
    }

    public void setFimBloqueio(String fimBloqueio) {
        this.FimBloqueio = fimBloqueio;
    }
    protected int CEP;
    protected int CdBairros;
    protected int CdCidades;    
    protected int numeroLogradouro;  //numero da casa onde mora.

    public int getCdUsuario() {
        return CdUsuario;
    }

    public void setCdUsuario(int CdUsuario) {
        this.CdUsuario = CdUsuario;
    }

    public String getNmUsuario() {
        return NmUsuario;
    }

    public void setNmUsuario(String NmUsuario) {
        this.NmUsuario = NmUsuario;
    }

    public String getDtNasc() {
        return DtNasc;
    }

    public void setDtNasc(String DtNasc) {
        this.DtNasc = DtNasc;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public int isStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    public int getCdBairros() {
        return CdBairros;
    }

    public void setCdBairros(int CdBairros) {
        this.CdBairros = CdBairros;
    }

    public int getCdCidades() {
        return CdCidades;
    }

    public void setCdCidades(int CdCidades) {
        this.CdCidades = CdCidades;
    }

    public int getNumeroLogradouro() {
        return numeroLogradouro;
    }

    public void setNumeroLogradouro(int numeroLogradouro) {
        this.numeroLogradouro = numeroLogradouro;
    }
    
    
       
}
