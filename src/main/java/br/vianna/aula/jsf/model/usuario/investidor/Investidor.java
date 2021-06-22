/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.usuario.investidor;

import br.vianna.aula.jsf.model.acao.Acao;
import br.vianna.aula.jsf.model.usuario.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author suporte
 */
@Entity
public class Investidor extends Usuario{
    
    @NotNull
    private String profissao, endereco, rg, cpf;

    public Investidor() {
    }

    public Investidor(String profissao, String endereco, String rg, String cpf, int id, String nome, String email, String login, String senha, ETipoUsuario tipo) {
        super(id, nome, email, login, senha, tipo);
        this.profissao = profissao;
        this.endereco = endereco;
        this.rg = rg;
        this.cpf = cpf;
    }

    public Investidor(int id, String nome, String email, String login, String senha, ETipoUsuario tipo) {
        super(id, nome, email, login, senha, tipo);
    }

    public Investidor(String profissao, String endereco, String rg, String cpf) {
        this.profissao = profissao;
        this.endereco = endereco;
        this.rg = rg;
        this.cpf = cpf;
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
    
    
}
