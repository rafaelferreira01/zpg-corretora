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
public class ListaEmpresaDTO {
    
    private int id;   
    private String nome;
    private int quantTotalAcoes, quantAtualAcoes;//quantacoes qguarda o numero de acoes que a empresa tem
    private long quantAcoesCompradas;//guarda o numero de acoes daquela empresa o investidor tem
    private double valorAtualAcoes;

    public ListaEmpresaDTO() {
    }

    //esta usando esse eu acho
//    public ListaEmpresaDTO(int id, String nome, int quantTotalAcoes, double valorAtualAcoes) {
//        this.id = id;
//        this.nome = nome;
//        this.quantTotalAcoes = quantTotalAcoes;
//        this.valorAtualAcoes = valorAtualAcoes;
//    }

    public ListaEmpresaDTO(int id, String nome, int quantTotalAcoes, int quantAtualAcoes, double valorAtualAcoes) {
        this.id = id;
        this.nome = nome;
        this.quantTotalAcoes = quantTotalAcoes;
        this.quantAtualAcoes = quantAtualAcoes;
        this.valorAtualAcoes = valorAtualAcoes;
    }
    
    public ListaEmpresaDTO(int id, String nome, int quantTotalAcoes, long quantAcoesCompradas, double valorAtualAcoes) {
        this.id = id;
        this.nome = nome;
        this.quantTotalAcoes = quantTotalAcoes;
        this.quantAcoesCompradas = quantAcoesCompradas;
        this.valorAtualAcoes = valorAtualAcoes;
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

    public int getQuantTotalAcoes() {
        return quantTotalAcoes;
    }

    public void setQuantTotalAcoes(int quantTotalAcoes) {
        this.quantTotalAcoes = quantTotalAcoes;
    }

    public long getQuantAcoesCompradas() {
        return quantAcoesCompradas;
    }

    public void setQuantAcoesCompradas(long quantAcoesCompradas) {
        this.quantAcoesCompradas = quantAcoesCompradas;
    }
    
    

    public int getQuantAtualAcoes() {
        return quantAtualAcoes;
    }

    public void setQuantAtualAcoes(int quantAtualAcoes) {
        this.quantAtualAcoes = quantAtualAcoes;
    }

    public double getValorAtualAcoes() {
        return valorAtualAcoes;
    }

    public void setValorAtualAcoes(double valorAtualAcoes) {
        this.valorAtualAcoes = valorAtualAcoes;
    }

    
    
}
