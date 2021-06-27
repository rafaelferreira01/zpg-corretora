/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.acao;

import br.vianna.aula.jsf.model.conta.Conta;
import br.vianna.aula.jsf.model.empresa.Empresa;
import br.vianna.aula.jsf.model.usuario.investidor.Investidor;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    @ManyToOne(optional = true, cascade=CascadeType.MERGE)
    private Conta conta;
    
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade=CascadeType.MERGE)
    private Empresa empresa;
    
    @NotNull
    private double valorTransacao;
    
    @NotNull
    private int quantidadeAcoesTransacao;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataTransacao;
    
    @NotNull
    @Enumerated(EnumType.STRING)//pra pegar a string do ENUM ao inves do indicie
    private ETipoTransacao tipoTransacao;

    public Acao() {
    }

    public Acao(int id, Conta conta, Empresa empresa, double valorTransacao, int quantidadeAcoesTransacao, Date dataTransacao, ETipoTransacao tipoTransacao) {
        this.id = id;
        this.conta = conta;
        this.empresa = empresa;
        this.valorTransacao = valorTransacao;
        this.quantidadeAcoesTransacao = quantidadeAcoesTransacao;
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
    }

    public int getQuantidadeAcoesTransacao() {
        return quantidadeAcoesTransacao;
    }

    public void setQuantidadeAcoesTransacao(int quantidadeAcoesTransacao) {
        this.quantidadeAcoesTransacao = quantidadeAcoesTransacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(double valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public ETipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(ETipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    
    
    
}
