/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.historico;

import br.vianna.aula.jsf.model.acao.ETipoTransacao;
import br.vianna.aula.jsf.model.conta.Conta;
import br.vianna.aula.jsf.model.empresa.Empresa;
import br.vianna.aula.jsf.model.usuario.investidor.Investidor;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author suporte
 */
@Entity
public class Historico {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    
    @NotNull
    @Enumerated(EnumType.STRING)//pra pegar a string do ENUM ao inves do indicie
    private ETipoTransacao tipoTransacao;
    
    @NotNull
    private double valorTransacao;
       
    @JoinColumn(name = "conta", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Conta conta;
    
    @JoinColumn(name = "empresa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa empresa;

    public Historico() {
    }

    public Historico(int id, ETipoTransacao tipoTransacao, double valorTransacao, Conta conta, Empresa empresa) {
        this.id = id;
        this.tipoTransacao = tipoTransacao;
        this.valorTransacao = valorTransacao;
        this.conta = conta;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ETipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(ETipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public double getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(double valorTransacao) {
        this.valorTransacao = valorTransacao;
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
