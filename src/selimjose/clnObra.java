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

public class clnObra {
    
    protected int CdObra;
    protected String Titulo;
    protected int Edicao;
    protected int Ano;
    protected String Volume;
    protected String ISBN;
    protected int CdEditora;
    protected int CdAutor;
    
    public int getCdObra (){
        return CdObra;
    }
    public void setCdObra(int CdObra){
        this.CdObra = CdObra;
    }
    public String getTitulo(){
        return Titulo;
    }
    public void setTitulo(String Titulo){
        this.Titulo = Titulo;
    }
    public int getEdicao(){
        return Edicao;
    }
    public void setEdicao(int Edicao){
        this.Edicao = Edicao;
    }
    public int getAno(){
        return Ano;
    }
    public void setAno(int Ano){
        this.Ano = Ano;
    }
    public String getVolume(){
        return Volume;
    }
    public void setVolume(String Volume){
        this.Volume = Volume;
    }
    public String getISBN(){
        return ISBN;
    }
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }
    public int getCdEditora(){
        return CdEditora;
    }
    public void setCdEditora(int CdEditora){
        this.CdEditora = CdEditora;
    }
    public int getCdAutor(){
        return CdAutor;
    }
     public void setCdAutor(int CdAutor){
        this.CdAutor = CdAutor;
    }
}
