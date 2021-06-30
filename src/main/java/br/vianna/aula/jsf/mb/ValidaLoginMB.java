/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.mb;

import br.vianna.aula.jsf.dao.InvestidorDao;
import br.vianna.aula.jsf.dao.UsuarioDao;
import br.vianna.aula.jsf.model.usuario.ETipoUsuario;
import br.vianna.aula.jsf.model.usuario.Usuario;
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
@RequestScoped
public class ValidaLoginMB {//esse trecho de codigo só será criado quando a pagina login for criada.  quando a pagina terminar de ser criada esse trecho é eliminado, nao guardando o usuario então
    
    @Autowired
    UsuarioDao userD;
    
    @Autowired
    InvestidorDao investD;
    
    @Autowired//injeção de dependenicia - essa notação faz com que seja utilizado o objeto loginMB que ja foi criado pelo controler ao invés de criar um loginMB novo
    private LoginMB loginMB;
    
//    ////////////para randomizar valor de acoes ao logar
//    @Autowired
//    private CadastroEmpresaMB cadempMB;
//    ////////////
    
    public String VerificaPassword(){
        loginMB.setUser(investD.existeInvestidor(loginMB.getNome(), loginMB.getSenha()));
        
        
        if (loginMB.getUser() != null){
            loginMB.setIsLogado(true);
            
            
//            ////////////para randomizar valor de acoes ao logar - descomente para desabilitar
//            cadempMB.randomizarPrecoAcoes();
//            ////////////
            
            
            return "index"; //informando o nome da pagina a ser chamada caso a condição seja verdadeira
        }else{
            loginMB.setUser(userD.existeUsuario(loginMB.getNome(), loginMB.getSenha()));
            
            if (loginMB.getUser() != null){
            loginMB.setIsLogado(true);
            
            
//            ////////////para randomizar valor de acoes ao logar - descomente para desabilitar
//            cadempMB.randomizarPrecoAcoes();
//            ////////////
            
            
            return "index"; //informando o nome da pagina a ser chamada caso a condição seja verdadeira
        }else{
            
            loginMB.setMsgErro("login ou senha inválida!");
            loginMB.setSenha("");//pra fazer nome e senha varzios antes de retornarem
            loginMB.setNome("");//pra fazer nome e senha varzios antes de retornarem
            return ""; //caso a condição seja falsa a pagina pagina que chamou esse MB será chamada novamente, isso foi definido ao retornar null ou ""
            }
        }
    }
    
    
    
    
    
    
    
}
