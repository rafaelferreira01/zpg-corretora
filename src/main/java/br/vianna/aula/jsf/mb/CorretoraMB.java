/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.mb;

import br.vianna.aula.jsf.dao.CorretoraDao;
import br.vianna.aula.jsf.model.corretora.Corretora;
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
public class CorretoraMB {
    
    private Corretora corretora;//vai reseber o resultado do select
    
    @Autowired
    private CorretoraDao corretoraDao;

    public CorretoraMB() {
    }

    public Corretora getCorretora() {
        return corretora;
    }

    public void setCorretora(Corretora corretora) {
        this.corretora = corretora;
    }

    public CorretoraDao getCorretoraDao() {
        return corretoraDao;
    }

    public void setCorretoraDao(CorretoraDao corretoraDao) {
        this.corretoraDao = corretoraDao;
    }
    
    @PostConstruct
    public void init() {

        pegarCorretoraNoBanco();//inicializa corretora
        
    }
    
    
    
    
    
    public double calcularCorretagem(double valorTransacao) {

        double corretagemPercent = 50;//porcentagem
        
        double valorFinalDaCorretagem = (corretagemPercent * valorTransacao) / 100 ;
        
        return valorFinalDaCorretagem;
    }
    
    
    
    void salvarCorretagemCompra(double valorFinalDaCorretagem) {

//        double corretagemPercent = 50;//porcentagem
//        
//        double valorFinalDaCorretagem = (corretagemPercent * valorTransacao) / 100 ;
        
        corretora.setDinheiro(corretora.getDinheiro() + valorFinalDaCorretagem);
        
        corretoraDao.save(corretora);

        System.out.println("Corretagem sobre transação foi salva no banco.");
        
//        return valorFinalDaCorretagem;
    }
    
    
    
    
    
    void salvarCorretagemVenda(double valorFinalDaCorretagem) {

//        double corretagemPercent = 50;//porcentagem
//        
//        double valorFinalDaCorretagem = (corretagemPercent * valorTransacao) / 100 ;
        
        corretora.setDinheiro(corretora.getDinheiro() + valorFinalDaCorretagem);
        
        corretoraDao.save(corretora);

        System.out.println("Corretagem sobre transação foi salva no banco.");
        
//        return valorFinalDaCorretagem;
    }
    
    
    
    

    private Corretora pegarCorretoraNoBanco() {
        corretora = corretoraDao.pegarCorretoraNoBanco();

        return corretora;
    }

}
