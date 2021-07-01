/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.corretora;

import br.vianna.aula.jsf.model.conta.*;
import br.vianna.aula.jsf.model.acao.Acao;
import br.vianna.aula.jsf.model.empresa.Empresa;
import br.vianna.aula.jsf.model.usuario.investidor.Investidor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Leonardo
 */
@Entity
public class Corretora implements Serializable{
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    
    @NotNull
    private int taxaVenda;
    
    @NotNull
    private int taxaCompra;
    
    @NotNull
    private double dinheiro;

    public Corretora() {
    }

    public Corretora(int id, int taxaVenda, int taxaCompra, double dinheiro) {
        this.id = id;
        this.taxaVenda = taxaVenda;
        this.taxaCompra = taxaCompra;
        this.dinheiro = dinheiro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaxaVenda() {
        return taxaVenda;
    }

    public void setTaxaVenda(int taxaVenda) {
        this.taxaVenda = taxaVenda;
    }

    public int getTaxaCompra() {
        return taxaCompra;
    }

    public void setTaxaCompra(int taxaCompra) {
        this.taxaCompra = taxaCompra;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }
    
}
