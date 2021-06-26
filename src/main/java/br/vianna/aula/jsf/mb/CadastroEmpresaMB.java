/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.mb;

import br.vianna.aula.jsf.dao.EmpresaDao;
import br.vianna.aula.jsf.model.dto.ListaEmpresaDTO;
import br.vianna.aula.jsf.model.empresa.Empresa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Leonardo
 */
@Component(value = "cadEmpMB")//colocando um alias nesse componente, agora sempre que quiser chamar o CadastroUsuarioMB podemos chamar cadMB
@ViewScoped
public class CadastroEmpresaMB implements Serializable {
        private EStatusCrud status;

    private ArrayList<ListaEmpresaDTO> listaEmpresa;

    private Empresa empresa;
    
    private String nome;
    
    private double valorAcoes;


    @Autowired
    private EmpresaDao empresaDao;

//    @Autowired//injetando
//    private EmpresaDao empDao; 

    public CadastroEmpresaMB() {
        status = EStatusCrud.VIEW;

        

        InicializaEmpresa();
  

        listaEmpresa = new ArrayList<>();
//        lista.add (new ListaPetDTO("Fofinho", "Masculino","Gato","Rafael", true));
//        lista.add (new ListaPetDTO("Rufus", "Masculino","Cachorro",null, false));
//        lista.add (new ListaPetDTO("Cassandra", "Feminino","Gato","Leonardo", true));
//        lista.add (new ListaPetDTO("Tontão", "Masculino","Cachorro",null, true));
//        lista.add (new ListaPetDTO("Dragoa", "Feminino","Gato",null, true));
//        lista.add (new ListaPetDTO("Felpuda", "Feminino","Gato","Daves", true));
    }

    private void InicializaEmpresa() {
        empresa = new Empresa();
        //    animal.setNome("abc");
      //  empresa.setListaAcoes();
//        empresa.setValorAtualAcoes(100.00);
        
    }

    public CadastroEmpresaMB(EStatusCrud status, ArrayList<ListaEmpresaDTO> listaEmpresa, Empresa empresa, EmpresaDao empresaDao) {
        this.status = status;
        this.listaEmpresa = listaEmpresa;
        this.empresa = empresa;
        this.empresaDao = empresaDao;
    }
    
    

    @PostConstruct
    public void init() {

        listaEmpresa = getAllEmpresas();

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

    public ArrayList<ListaEmpresaDTO> getLista() {
        return listaEmpresa;
    }

    public void setLista(ArrayList<ListaEmpresaDTO> lista) {
        this.listaEmpresa = listaEmpresa;
    }

    public ArrayList<ListaEmpresaDTO> getListaEmpresa() {
        return listaEmpresa;
    }

    public void setListaEmpresa(ArrayList<ListaEmpresaDTO> listaEmpresa) {
        this.listaEmpresa = listaEmpresa;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorAcoes() {
        return valorAcoes;
    }

    public void setValorAcoes(double valorAcoes) {
        this.valorAcoes = valorAcoes;
    }
    
    
    
    

    

    public String salvar() {

        FacesContext ct = FacesContext.getCurrentInstance();
   
        empresaDao.save(empresa);
        
        InicializaEmpresa();
        status = EStatusCrud.VIEW;
        listaEmpresa = getAllEmpresas();

        ct.addMessage("", new FacesMessage("Empresa salva com sucesso!"));

        return "";
    }




    private ArrayList<ListaEmpresaDTO> getAllEmpresas() {
        ArrayList<ListaEmpresaDTO> listaEmpresa = new ArrayList<>();

        listaEmpresa.addAll(empresaDao.getAllEmpresas());

        return listaEmpresa;
    }

    public String prepareEdit(int id) {
        status = EStatusCrud.EDIT;
        empresa = empresaDao.get(id);
        return "";
    }

    public String delete(int id) {

        FacesContext ct = FacesContext.getCurrentInstance();

        Empresa aux = null;

        aux = empresaDao.delete(id);
      
        ct.addMessage("", new FacesMessage(aux.getNome() + " excluído com sucesso!"));

        listaEmpresa = getAllEmpresas();

        return "";
    }
}

    

