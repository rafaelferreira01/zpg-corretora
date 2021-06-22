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
    private double valorAcoes;

    public ListaEmpresaDTO() {
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


    public double getValorAcoes() {
        return valorAcoes;
    }

    public void setValorAcoes(double valorAcoes) {
        this.valorAcoes = valorAcoes;
    }

 
    
}
