/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.empresa;

import br.vianna.aula.jsf.model.investidor.*;
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
public class Empresa{
    
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    
    @NotNull
    private String nome;
    
    @NotNull
    private Double valorAcoes;
    
    @OneToMany(mappedBy = "empresa")
    private List<Acao> listaAcoes;

    public Empresa() {
        this.listaAcoes = new ArrayList<>();//nao tenho certeza se está certo
    }

    public Empresa(int id, String nome, Double valorAcoes) {
        this.id = id;
        this.nome = nome;
        this.valorAcoes = valorAcoes;
        this.listaAcoes = new ArrayList<>();//nao tenho certeza se está certo
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

    public Double getValorAcoes() {
        return valorAcoes;
    }

    public void setValorAcoes(Double valorAcoes) {
        this.valorAcoes = valorAcoes;
    }

    public List<Acao> getListaAcoes() {
        return listaAcoes;
    }

    public void setListaAcoes(List<Acao> listaAcoes) {
        this.listaAcoes = listaAcoes;
    }
    
    public void listaAcoesAdd(Acao acao) {
        this.listaAcoes.add(acao);
    }
    
    public void listaAcoesRemove(Acao acao) {//criar um remove para remover pelo indicie tambem
        this.listaAcoes.remove(acao);
    }
}
