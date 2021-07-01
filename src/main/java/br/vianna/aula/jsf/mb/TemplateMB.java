/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.mb;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author suporte
 */
@Component
@RequestScoped//manager bean de request
public class TemplateMB {
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index";
    }
    
    public String home(){
        return "index?faces-redirect=true";
    }
    
    public String cadastrarEmpresa(){
        return "cadastroEmpresas?faces-redirect=true";
    }
    
      public String cadastrarInvestidor(){
        return "cadastroInvestidor?faces-redirect=true";
    }
      
    public String acoesTransacao(){
    return "acoesTransacao?faces-redirect=true";
    }
    
    public String historicoTransacoes(){
    return "historicoTransacoes?faces-redirect=true";
    }
    
    public String historicoTransacoesAdm(){
    return "historicoTransacoesAdm?faces-redirect=true";
    }
    
    public String operacoes(){
    return "operacoes?faces-redirect=true";
    }
    
    
}
