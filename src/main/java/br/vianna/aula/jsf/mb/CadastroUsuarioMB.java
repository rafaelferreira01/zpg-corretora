/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.mb;

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
@Component(value = "cadMB")//colocando um alias nesse componente, agora sempre que quiser chamar o CadastroUsuarioMB podemos chamar cadMB
@RequestScoped
public class CadastroUsuarioMB {
    
    private Usuario user;
    
    @Autowired//injeção de dependencia - injetando usuario DAO
    UsuarioDao userD;
    
    @Autowired//injeção de dependencia
    LoginMB login;
    
    public CadastroUsuarioMB() {
        user = new Usuario();
    }
    
    public String saveUser(){
        
        user.setTipo(ETipoUsuario.NORMAL);
        user.setSenha(user.getSenha());//chama o método que passa a senha pra MD5
        
        
        userD.save(user);//salva o usuario
        
        user = new Usuario();//coloca um novo usuario dentro de user pra apagar
        
        login.setMsgAviso("Usuario criado com sucesso");
        
        return "login?faces-redirect=true";
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
