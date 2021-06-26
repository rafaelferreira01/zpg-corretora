/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.usuario.investidor;

import br.vianna.aula.jsf.model.acao.Acao;
import br.vianna.aula.jsf.model.conta.Conta;
import br.vianna.aula.jsf.model.usuario.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author suporte
 */
@Entity
public class Investidor extends Usuario implements Serializable{
    
    @NotNull
    private String profissao;
    
    @NotNull
    private String endereco;
    
    @NotNull
    private String rg;
    
    @NotNull
    private String cpf;
      
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    @OneToOne(optional = true, cascade=CascadeType.ALL)
    private Conta conta;

    //construtor utilizado no inicializaInvestidor
    public Investidor() {
        this.tipo = ETipoUsuario.INVESTIDOR;
        this.conta = new Conta();
    }
    
    
    //construtor utilizado no startup
    public Investidor(String profissao, String endereco, String rg, String cpf, int id, String nome, String email, String login, String senha) {
        super(id, nome, email, login, senha, ETipoUsuario.INVESTIDOR);
        this.profissao = profissao;
        this.endereco = endereco;
        this.rg = rg;
        this.cpf = cpf;
        this.conta = new Conta();
    }
    
    
//    public Investidor(String profissao, String endereco, String rg, String cpf, int id, String nome, String email, String login, String senha, Conta conta) {
//        super(id, nome, email, login, senha, ETipoUsuario.INVESTIDOR);
//        this.profissao = profissao;
//        this.endereco = endereco;
//        this.rg = rg;
//        this.cpf = cpf;
//        this.conta = conta;
//    }

    //construtor utilizado na dao para listagem
    public Investidor(int id, String nome, String email, String login, String senha, ETipoUsuario tipo) {
        super(id, nome, email, login, senha, ETipoUsuario.INVESTIDOR);
//        this.conta = new Conta();
    }

//    public Investidor(String profissao, String endereco, String rg, String cpf) {
//        this.profissao = profissao;
//        this.endereco = endereco;
//        this.rg = rg;
//        this.cpf = cpf;
//        this.tipo = ETipoUsuario.INVESTIDOR;
////        this.conta = new Conta();
//    }
//
//    public Investidor(String profissao, String endereco, String rg, String cpf, double dinheiro) {
//        this.profissao = profissao;
//        this.endereco = endereco;
//        this.rg = rg;
//        this.cpf = cpf;
//        this.tipo = ETipoUsuario.INVESTIDOR;
////        this.conta = new Conta();
//    }


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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ETipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(ETipoUsuario tipo) {
        this.tipo = tipo;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    
    
}
