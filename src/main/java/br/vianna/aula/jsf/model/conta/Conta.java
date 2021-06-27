/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.conta;

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
public class Conta implements Serializable{
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    
    @NotNull
    private double saldo;
    
//    @JoinColumn(name = "acao_id", referencedColumnName = "id")
    @OneToMany(mappedBy="conta")
    private List<Acao> listaAcoes;
       
//    @JoinColumn(name = "investidor_id", referencedColumnName = "id")
//    @OneToOne(optional = true, cascade=CascadeType.ALL)
//    private Investidor investidor;

    public Conta() {
    }
    
    //construtor sendo utilizado na classe Investidor
    public Conta(Investidor investidor) {
//        this.investidor = investidor;
        listaAcoes = new ArrayList<>();
    }

    public Conta(int id, double saldo) {
        this.id = id;
        this.saldo = saldo;
        listaAcoes = new ArrayList<>();
//        this.investidor = investidor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    

//    public Investidor getInvestidor() {
//        return investidor;
//    }
//
//    public void setInvestidor(Investidor investidor) {
//        this.investidor = investidor;
//    }

    public List<Acao> getListaAcoes() {
        return listaAcoes;
    }

    public void setListaAcoes(List<Acao> listaAcoes) {
        this.listaAcoes = listaAcoes;
    }
    
    
    
    
    
}
