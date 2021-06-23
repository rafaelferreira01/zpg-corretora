/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.mb;

import br.vianna.aula.jsf.dao.EmpresaDao;
import br.vianna.aula.jsf.dao.InvestidorDao;
import br.vianna.aula.jsf.dao.UsuarioDao;
import br.vianna.aula.jsf.model.dto.ListaEmpresaDTO;
import br.vianna.aula.jsf.model.dto.ListaInvestidorDTO;
import br.vianna.aula.jsf.model.empresa.Empresa;
import br.vianna.aula.jsf.model.usuario.investidor.Investidor;
import br.vianna.aula.jsf.model.usuario.ETipoUsuario;
import br.vianna.aula.jsf.model.usuario.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author suporte
 */
@Component(value = "cadInvMB")//colocando um alias nesse componente, agora sempre que quiser chamar o CadastroUsuarioMB podemos chamar cadMB
@ViewScoped
public class CadastroInvestidorMB  implements Serializable{
    
    private Investidor investidor;
    
    
//    @Autowired//injeção de dependencia - injetando usuario DAO
//    UsuarioDao userD;//acho que pode apagr isso
    
   
    
    private EStatusCrud status;

    private ArrayList<ListaInvestidorDTO> listaInvestidor;

    
    private String nome,profissao,endereco,cpf;
    private double dinheiro;


  

    @Autowired
    private InvestidorDao investidorDao;


    public CadastroInvestidorMB() {
        status = EStatusCrud.VIEW;

        

        InicializaInvestidor();
  

        listaInvestidor = new ArrayList<>();

    }

    private void InicializaInvestidor() {
        investidor = new Investidor();
        //    animal.setNome("abc");
      //  empresa.setListaAcoes();
//        investidor.setDinheiro(500);
        
    }

    public CadastroInvestidorMB(Investidor investidor, EStatusCrud status, ArrayList<ListaInvestidorDTO> listaInvestidor, String nome, String profissao, String endereco, String cpf, double dinheiro, InvestidorDao investidorDao) {
        this.investidor = investidor;
        this.status = status;
        this.listaInvestidor = listaInvestidor;
        this.nome = nome;
        this.profissao = profissao;
        this.endereco = endereco;
        this.cpf = cpf;
        this.dinheiro = dinheiro;
        this.investidorDao = investidorDao;
    }

   

    @PostConstruct
    public void init() {

        listaInvestidor = getAllInvestidores();

    }

    public EStatusCrud getStatus() {
        return status;
    }

    public void setStatus(EStatusCrud status) {
        this.status = status;
    }

    public String trocar() {
        status = EStatusCrud.INSERT;

        return "";
    }

    public String voltar() {
        status = EStatusCrud.VIEW;

        return "";
    }

    public boolean estaNaView() {
        return status == EStatusCrud.VIEW;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

//    public UsuarioDao getUserD() {
//        return userD;
//    }
//
//    public void setUserD(UsuarioDao userD) {
//        this.userD = userD;
//    }

    
    public ArrayList<ListaInvestidorDTO> getListaInvestidor() {
        return listaInvestidor;
    }

    public void setListaInvestidor(ArrayList<ListaInvestidorDTO> listaInvestidor) {
        this.listaInvestidor = listaInvestidor;
    }

//    public Empresa getEmpresa() {
//        return empresa;
//    }
//
//    public void setEmpresa(Empresa empresa) {
//        this.empresa = empresa;
//    }

    public InvestidorDao getInvestidorDao() {
        return investidorDao;
    }

    public void setInvestidorDao(InvestidorDao investidorDao) {
        this.investidorDao = investidorDao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }
    
    



    public String salvar() {
        
        FacesContext ct = FacesContext.getCurrentInstance();
   
        investidorDao.save(investidor);
        
        InicializaInvestidor();
        status = EStatusCrud.VIEW;
        listaInvestidor = getAllInvestidores(); 

        ct.addMessage("", new FacesMessage("Investidor salvo com sucesso!"));

        return "";
    }




    private ArrayList<ListaInvestidorDTO> getAllInvestidores() {
        ArrayList<ListaInvestidorDTO> listaInvestidor = new ArrayList<>();

        listaInvestidor.addAll(investidorDao.getAllInvestidores());

        return listaInvestidor;
    }

    public String prepareEdit(int id) {
        status = EStatusCrud.EDIT;
        investidor = investidorDao.get(id);
        return "";
    }

    public String delete(int id) {

        FacesContext ct = FacesContext.getCurrentInstance();

        Investidor aux = null;

        aux = investidorDao.delete(id);
      
        ct.addMessage("", new FacesMessage(aux.getNome()+ " excluído com sucesso!"));

        listaInvestidor = getAllInvestidores() ; 

        return "";
    }
}

    