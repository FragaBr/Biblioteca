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
public class clnAluno extends clnUsuario {
    
    protected int cdAlunos;
    protected String Matricula;
    protected int modEnsinoFK;
    protected int cdTurnoFK;
    protected int cdUsuarioFK;
    protected int cepFK;
    protected int bairroFK;
    protected int cidadeFK;

    public clnAluno(){
        
    }
    public clnAluno(int cdAlunos, String Matricula, int modEnsinoFK, int cdTurnoFK, int cdUsuarioFK, int cepFK, int bairroFK, int cidadeFK) {
        this.cdAlunos = cdAlunos;
        this.Matricula = Matricula;
        this.modEnsinoFK = modEnsinoFK;
        this.cdTurnoFK = cdTurnoFK;
        this.cdUsuarioFK = cdUsuarioFK;
        this.cepFK = cepFK;
        this.bairroFK = bairroFK;
        this.cidadeFK = cidadeFK;
    }

    public int getCdAlunos() {
        return cdAlunos;
    }

    public void setCdAlunos(int cdAlunos) {
        this.cdAlunos = cdAlunos;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public int getModEnsinoFK() {
        return modEnsinoFK;
    }

    public void setModEnsinoFK(int modEnsinoFK) {
        this.modEnsinoFK = modEnsinoFK;
    }

    public int getCdTurnoFK() {
        return cdTurnoFK;
    }

    public void setCdTurnoFK(int cdTurnoFK) {
        this.cdTurnoFK = cdTurnoFK;
    }

    public int getCdUsuarioFK() {
        return cdUsuarioFK;
    }

    public void setCdUsuarioFK(int cdUsuarioFK) {
        this.cdUsuarioFK = cdUsuarioFK;
    }

    public int getCepFK() {
        return cepFK;
    }

    public void setCepFK(int cepFK) {
        this.cepFK = cepFK;
    }

    public int getBairroFK() {
        return bairroFK;
    }

    public void setBairroFK(int bairroFK) {
        this.bairroFK = bairroFK;
    }

    public int getCidadeFK() {
        return cidadeFK;
    }

    public void setCidadeFK(int cidadeFK) {
        this.cidadeFK = cidadeFK;
    }
    
    
    
    
    
    int a;
    
}
