/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.acao;

import br.vianna.aula.jsf.model.empresa.Empresa;
import br.vianna.aula.jsf.model.investidor.Investidor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author suporte
 */
@Entity
public class Acao {
    
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    
    @NotNull
    private double valor;
    
    @JoinColumn(name = "investidor", referencedColumnName = "id")
    @ManyToOne
    private Investidor investidor;
    
    @NotNull
    @JoinColumn(name = "empresa", referencedColumnName = "id")
    @ManyToOne
    private Empresa empresa;

    public Acao() {
    }

    public Acao(int id, double valor, Empresa empresa) {
        this.id = id;
        this.valor = valor;
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

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
