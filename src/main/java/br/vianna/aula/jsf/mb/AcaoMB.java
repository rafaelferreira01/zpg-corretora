/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.mb;

import br.vianna.aula.jsf.dao.AcaoDao;
import br.vianna.aula.jsf.dao.EmpresaDao;
import br.vianna.aula.jsf.model.acao.Acao;
import br.vianna.aula.jsf.model.acao.ETipoTransacao;
import br.vianna.aula.jsf.model.dto.ListaEmpresaDTO;
import br.vianna.aula.jsf.model.dto.UsuarioLogadoDTO;
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
@Component(value = "acaoMB")//colocando um alias nesse componente, agora sempre que quiser chamar o CadastroUsuarioMB podemos chamar cadMB
@ViewScoped
public class AcaoMB implements Serializable {
        private EStatusCrud status;

//    private ArrayList<ListaEmpresaDTO> listaEmpresa;
        
    private UsuarioLogadoDTO user;
//
    private Empresa empresa;
//    
    private int quantidadeAcao;
//    private String nome;
//    
//    private double valorAcoes;
    
    private Acao acao;

    @Autowired
    private AcaoDao acaoDao;
    
    @Autowired
    private LoginMB usuario;
    
    @Autowired
    private EmpresaDao empresaDao;

//    @Autowired//injetando
//    private EmpresaDao empDao; 

    public AcaoMB() {
        status = EStatusCrud.VIEW;

        System.out.println("sssssssssssssssssssss");

        InicializaAcao();
//  

//        listaEmpresa = new ArrayList<>();
////        lista.add (new ListaPetDTO("Fofinho", "Masculino","Gato","Rafael", true));
////        lista.add (new ListaPetDTO("Rufus", "Masculino","Cachorro",null, false));
////        lista.add (new ListaPetDTO("Cassandra", "Feminino","Gato","Leonardo", true));
////        lista.add (new ListaPetDTO("Tontão", "Masculino","Cachorro",null, true));
////        lista.add (new ListaPetDTO("Dragoa", "Feminino","Gato",null, true));
////        lista.add (new ListaPetDTO("Felpuda", "Feminino","Gato","Daves", true));
    }
//
    private void InicializaAcao() {
        acao = new Acao();
        //    animal.setNome("abc");
      //  empresa.setListaAcoes();
//        empresa.setValorAtualAcoes(100.00);
        
    }
//
//    public AcaoMB(EStatusCrud status, ArrayList<ListaEmpresaDTO> listaEmpresa, Empresa empresa, EmpresaDao empresaDao) {
//        this.status = status;
//        this.listaEmpresa = listaEmpresa;
//        this.empresa = empresa;
//        this.empresaDao = empresaDao;
//    }
    
    

//    @PostConstruct
//    public void init() {
//
//        listaEmpresa = getAllEmpresas();
//
//    }
//
//    public EStatusCrud getStatus() {
//        return status;
//    }
//}

//    public AcaoMB(EStatusCrud status, UsuarioLogadoDTO user, Empresa empresa, Acao acao, AcaoDao acaoDao, EmpresaDao empresaDao) {
//        this.status = status;
//        this.user = user;
//        this.empresa = empresa;
//        this.acao = acao;
//        this.acaoDao = acaoDao;
//        this.empresaDao = empresaDao;
//        
//    }
    
    
    
    public AcaoMB(EStatusCrud status, UsuarioLogadoDTO user, Empresa empresa, int quantidadeAcao, Acao acao, AcaoDao acaoDao, LoginMB usuario, EmpresaDao empresaDao) {
        this.status = status;
        this.user = user;
        this.empresa = empresa;
        this.quantidadeAcao = quantidadeAcao;
        this.acao = acao;
        this.acaoDao = acaoDao;
        this.usuario = usuario;
        this.empresaDao = empresaDao;
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

    public int getQuantidadeAcao() {
        return quantidadeAcao;
    }

    public void setQuantidadeAcao(int quantidadeAcao) {
        this.quantidadeAcao = quantidadeAcao;
    }

    public LoginMB getUsuario() {
        return usuario;
    }

    public void setUsuario(LoginMB usuario) {
        this.usuario = usuario;
    }

    
//    public ArrayList<ListaEmpresaDTO> getLista() {
//        return listaEmpresa;
//    }
//
//    public void setLista(ArrayList<ListaEmpresaDTO> lista) {
//        this.listaEmpresa = listaEmpresa;
//    }
//
//    public ArrayList<ListaEmpresaDTO> getListaEmpresa() {
//        return listaEmpresa;
//    }
//
//    public void setListaEmpresa(ArrayList<ListaEmpresaDTO> listaEmpresa) {
//        this.listaEmpresa = listaEmpresa;
//    }

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

//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }

//    public double getValorAcoes() {
//        return valorAcoes;
//    }
//
//    public void setValorAcoes(double valorAcoes) {
//        this.valorAcoes = valorAcoes;
//    }

    public UsuarioLogadoDTO getUser() {
        return user;
    }

    public void setUser(UsuarioLogadoDTO user) {
        this.user = user;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public AcaoDao getAcaoDao() {
        return acaoDao;
    }

    public void setAcaoDao(AcaoDao acaoDao) {
        this.acaoDao = acaoDao;
    }
    
    
    
    
    ///////////////////////////////////////////
    public String comprar(int id) {
//        empresa = empresaDao.get(id);
//        System.out.println(empresa.getNome()+"EEEEEEEEEEEEEEEEEEEEEEEEEEEE");
//        acao.setEmpresa(empresa);
        
        
//        acao.setConta(usuario.getUser().getConta());
//        System.out.println(usuario.getUser().getNome()+"UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
        
        

        FacesContext ct = FacesContext.getCurrentInstance();
        
        System.out.println(usuario.getUser().getConta()+"   \nAAAAAAAAAAAAAAAAAAAAAA");
   
//        acao = acaoDao.get(id);
        empresa = empresaDao.get(id);
        acao.setEmpresa(empresa);
        acao.setTipoTransacao(ETipoTransacao.COMPRA);
        acao.setValorTransacao(empresa.getValorAtualAcoes()*this.quantidadeAcao);
        acao.setQuantidadeAcoesTransacao(this.quantidadeAcao);
        acao.setDataTransacao(new Date());
        acao.setConta(usuario.getUser().getConta());
        
        
        acaoDao.save(acao);
        
        InicializaAcao();
        status = EStatusCrud.VIEW;
//        listaEmpresa = getAllEmpresas();

        ct.addMessage("", new FacesMessage("Empresa salva com sucesso!"));

        return "";
    }

    

//    public String salvar() {
//
//        FacesContext ct = FacesContext.getCurrentInstance();
//   
//        empresaDao.save(empresa);
//        
//        InicializaEmpresa();
//        status = EStatusCrud.VIEW;
//        listaEmpresa = getAllEmpresas();
//
//        ct.addMessage("", new FacesMessage("Empresa salva com sucesso!"));
//
//        return "";
//    }




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

//    public String delete(int id) {
//
//        FacesContext ct = FacesContext.getCurrentInstance();
//
//        Empresa aux = null;
//
//        aux = empresaDao.delete(id);
//      
//        ct.addMessage("", new FacesMessage(aux.getNome() + " excluído com sucesso!"));
//
//        listaEmpresa = getAllEmpresas();
//
//        return "";
//    }
}

    

