/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.acao;

import br.vianna.aula.jsf.model.conta.Conta;
import br.vianna.aula.jsf.model.empresa.Empresa;
import br.vianna.aula.jsf.model.usuario.investidor.Investidor;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Leonardo
 */
@Entity
public class Acao {
    
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    
    @NotNull
    private double valor;
    
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    @ManyToOne(optional = true, cascade=CascadeType.ALL)
    private Conta conta;
    
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade=CascadeType.ALL)
    private Empresa empresa;

    public Acao() {
    }

    public Acao(int id, double valor, Conta conta, Empresa empresa) {
        this.id = id;
        this.valor = valor;
        this.conta = conta;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    
}
