/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.dto;

/**
 *
 * @author Leonardo
 */
public class ListaInvestidorDTO {
    
    private int id;   
    private String nome,profissao,endereco,cpf;

    public ListaInvestidorDTO() {
    }

    public ListaInvestidorDTO(int id, String nome, String profissao, String endereco, String cpf) {
        this.id = id;
        this.nome = nome;
        this.profissao = profissao;
        this.endereco = endereco;
        this.cpf = cpf;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }




 
    
}
