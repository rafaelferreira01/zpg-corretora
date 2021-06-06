/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.mb;

import br.vianna.aula.jsf.dao.UsuarioDao;
import br.vianna.aula.jsf.model.usuario.ETipoUsuario;
import br.vianna.aula.jsf.model.usuario.Usuario;
import br.vianna.aula.jsf.model.dto.UsuarioLogadoDTO;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author suporte
 */

@Component
@SessionScoped//manager bean escopo de sessao -salvo na sessao
public class LoginMB implements Serializable{
    
    private String nome, senha, msgErro, msgAviso; //essa msgErro é a variavel que guarda a mensagem de erro abaixo
    private boolean isLogado;
    private UsuarioLogadoDTO user;
    
//    @Autowired//injeção de dependencia - injetando usuario DAO
//    UsuarioDao userD;

    public LoginMB() {
        isLogado = false;
        msgErro = msgAviso = "";//inicializando duas variaceis de uma vez com o valor vazio
        user=null;
    }
    
    public boolean isAdmin(){
        if(user == null){//testa se usuario eh nulo
            return false;
        }
        return user.getTipo() == ETipoUsuario.ADMIN;//retorna se o usuario eh admin ou nao
    }
    
    public boolean isInvestidor(){
        if(user == null){//testa se usuario eh nulo
            return false;
        }
        return user.getTipo() == ETipoUsuario.INVESTIDOR;//retorna se o usuario eh investidor ou nao
    }
    
    public String callCadastro(){
        
        return "cadastro?faces-redirect=true";//faz com que o controller solicite a pagina cadastro usando redirect (coisa puramente estetica)
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMsgErro() {
        return msgErro;
    }

    public void setMsgErro(String msgErro) {
        this.msgErro = msgErro;
    }

    public boolean isIsLogado() {
        return isLogado;
    }

    public void setIsLogado(boolean isLogado) {
        this.isLogado = isLogado;
    }

    public String getMsgAviso() {
        return msgAviso;
    }

    public void setMsgAviso(String msgAviso) {
        this.msgAviso = msgAviso;
    }

    public UsuarioLogadoDTO getUser() {
        return user;
    }

    public void setUser(UsuarioLogadoDTO user) {
        this.user = user;
    }
}
