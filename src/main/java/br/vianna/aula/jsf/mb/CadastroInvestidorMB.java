/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.mb;

import br.vianna.aula.jsf.dao.EmpresaDao;
import br.vianna.aula.jsf.dao.UsuarioDao;
import br.vianna.aula.jsf.model.dto.ListaEmpresaDTO;
import br.vianna.aula.jsf.model.dto.ListaInvestidorDTO;
import br.vianna.aula.jsf.model.empresa.Empresa;
import br.vianna.aula.jsf.model.usuario.investidor.Investidor;
import br.vianna.aula.jsf.model.usuario.ETipoUsuario;
import br.vianna.aula.jsf.model.usuario.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author suporte
 */
@Component(value = "cadInVMB")//colocando um alias nesse componente, agora sempre que quiser chamar o CadastroUsuarioMB podemos chamar cadMB
@RequestScoped
public class CadastroInvestidorMB {
    
    private Investidor investidor;
    
    @Autowired//injeção de dependencia - injetando usuario DAO
    UsuarioDao userD;
    
   
    
    private EStatusCrud status;

    private ArrayList<ListaInvestidorDTO> listaInvestidor;

    private Empresa empresa;


  

    @Autowired
    private EmpresaDao empresaDao;


    public CadastroInvestidorMB() {
        status = EStatusCrud.VIEW;

        

        InicializaInvestidor();
  

        listaInvestidor = new ArrayList<>();

    }

    private void InicializaInvestidor() {
        empresa = new Empresa();
        //    animal.setNome("abc");
      //  empresa.setListaAcoes();
//        investidor.setDinheiro(500);
        
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

    public UsuarioDao getUserD() {
        return userD;
    }

    public void setUserD(UsuarioDao userD) {
        this.userD = userD;
    }

    public ArrayList<ListaInvestidorDTO> getListaInvestidor() {
        return listaInvestidor;
    }

    public void setListaInvestidor(ArrayList<ListaInvestidorDTO> listaInvestidor) {
        this.listaInvestidor = listaInvestidor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public EmpresaDao getEmpresaDao() {
        return empresaDao;
    }

    public void setEmpresaDao(EmpresaDao empresaDao) {
        this.empresaDao = empresaDao;
    }



    public String salvar() {

        FacesContext ct = FacesContext.getCurrentInstance();
   
        InicializaInvestidor();
        status = EStatusCrud.VIEW;
        listaInvestidor = getAllInvestidores(); 

        ct.addMessage("", new FacesMessage("Investidor salvo com sucesso!"));

        return "";
    }




    private ArrayList<ListaInvestidorDTO> getAllInvestidores() {
        ArrayList<ListaInvestidorDTO> listaInvestidor = new ArrayList<>();

        listaInvestidor.addAll(userD.getAllInvestidores());

        return listaInvestidor;
    }

    public String prepareEdit(int id) {
        status = EStatusCrud.EDIT;
        
        return "";
    }

    public String delete(int id) {

        FacesContext ct = FacesContext.getCurrentInstance();

        Empresa aux = null;

      
        ct.addMessage("", new FacesMessage(aux.getNome() + " excluído com sucesso!"));

        listaInvestidor = getAllInvestidores() ; 

        return "";
    }
}

    