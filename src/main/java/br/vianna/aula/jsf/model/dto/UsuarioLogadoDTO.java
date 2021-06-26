/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.dto;

import br.vianna.aula.jsf.model.usuario.ETipoUsuario;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 *
 * @author suporte
 */
public class UsuarioLogadoDTO {
    
    private int id;
    private String nome, email, profissao, endereco, rg, cpf, login;
    private double saldo;
    private ETipoUsuario tipo;
    
    public UsuarioLogadoDTO() {
    }

    public UsuarioLogadoDTO(int id, String nome, String email, ETipoUsuario tipo) {//construtor usuario administrador
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
    }

    public UsuarioLogadoDTO(int id, String nome, String email, String profissao, String endereco, String rg, String cpf, ETipoUsuario tipo) {//construtor do usuario investidor
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.profissao = profissao;//atributo do investidor apenas (para referencia)
        this.endereco = endereco;//atributo do investidor apenas (para referencia)
        this.rg = rg;//atributo do investidor apenas (para referencia)
        this.cpf = cpf;//atributo do investidor apenas (para referencia)
        this.tipo = tipo;
    }

    public UsuarioLogadoDTO(int id, String nome, String email, String profissao, String endereco, String rg, String cpf, String login, double saldo, ETipoUsuario tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.profissao = profissao;
        this.endereco = endereco;
        this.rg = rg;
        this.cpf = cpf;
        this.login = login;
        this.saldo = saldo;
        this.tipo = tipo;
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

    public ETipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(ETipoUsuario tipo) {
        this.tipo = tipo;
    }

    
}
