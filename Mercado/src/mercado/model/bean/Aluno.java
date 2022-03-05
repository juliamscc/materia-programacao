/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercado.model.bean;

/**
 *
 * @author julia
 */
public class Aluno {
    private int id;
    private String nome;
    private String matricula;
    private int cpf;
    
    //id
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    //nome
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    //matricula
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public String getMatricula() {
        return matricula;
    }
    
    //cpf
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    
    public int getCpf() {
        return cpf;
    }
}
