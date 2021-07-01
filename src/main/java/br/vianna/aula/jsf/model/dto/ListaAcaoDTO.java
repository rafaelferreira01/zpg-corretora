/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.dto;

import br.vianna.aula.jsf.model.acao.ETipoTransacao;
import br.vianna.aula.jsf.model.conta.Conta;
import br.vianna.aula.jsf.model.empresa.Empresa;
import java.util.Date;

/**
 *
 * @author Leonardo
 */
public class ListaAcaoDTO {
    
    private int id;
    private Conta conta;
    private Empresa empresa;
    private double valorTransacao;
    private int quantidadeAcoesTransacao;
    private Date dataTransacao;
    private ETipoTransacao tipoTransacao;
    private double valorCorretagem;

    public ListaAcaoDTO() {
    }

    public ListaAcaoDTO(int id, Conta conta, Empresa empresa, double valorTransacao, int quantidadeAcoesTransacao, Date dataTransacao, ETipoTransacao tipoTransacao) {
        this.id = id;
        this.conta = conta;
        this.empresa = empresa;
        this.valorTransacao = valorTransacao;
        this.quantidadeAcoesTransacao = quantidadeAcoesTransacao;
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
    }
    
    public ListaAcaoDTO(int id, Conta conta, Empresa empresa, double valorTransacao, int quantidadeAcoesTransacao, Date dataTransacao, ETipoTransacao tipoTransacao, double valorCorretagem) {
        this.id = id;
        this.conta = conta;
        this.empresa = empresa;
        this.valorTransacao = valorTransacao;
        this.quantidadeAcoesTransacao = quantidadeAcoesTransacao;
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
        this.valorCorretagem = valorCorretagem;
    }

    public double getValorCorretagem() {
        return valorCorretagem;
    }

    public void setValorCorretagem(double valorCorretagem) {
        this.valorCorretagem = valorCorretagem;
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

    public int getQuantidadeAcoesTransacao() {
        return quantidadeAcoesTransacao;
    }

    public void setQuantidadeAcoesTransacao(int quantidadeAcoesTransacao) {
        this.quantidadeAcoesTransacao = quantidadeAcoesTransacao;
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
