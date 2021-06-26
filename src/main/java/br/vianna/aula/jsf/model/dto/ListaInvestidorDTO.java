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
    private String nome,profissao,endereco,cpf,rg,email,login;
    private double saldo;

    public ListaInvestidorDTO() {
    }

    public ListaInvestidorDTO(int id, String nome, String profissao, String endereco, String cpf, String rg, String email, String login, double saldo) {
        this.id = id;
        this.nome = nome;
        this.profissao = profissao;
        this.endereco = endereco;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.login = login;
        this.saldo = saldo;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    



 
    
}
