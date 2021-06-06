/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.mb;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author suporte
 */
@Component
@RequestScoped//manager bean de request
public class IndexMB {
    
    private String nomeProjeto;
    
    @Autowired//injeção de dependenicia - essa notação faz com que seja utilizado o objeto loginMB que ja foi criado pelo controler ao invés de criar um loginMB novo
    private LoginMB loginMB;

    public IndexMB() {
        nomeProjeto = "ZPG :: Home";
    }
    
    @PostConstruct//o método abaixo será executado sempre que um objeto IndexMB for criado
    public void init(){
        if (!loginMB.isIsLogado()){
            try { 
                loginMB.setMsgErro("Acesso não autorizado!");
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            } catch (IOException ex) {
            }
        }
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }
    
    
    
}
