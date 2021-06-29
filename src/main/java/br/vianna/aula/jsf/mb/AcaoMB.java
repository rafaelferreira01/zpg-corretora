/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.mb;

import br.vianna.aula.jsf.dao.AcaoDao;
import br.vianna.aula.jsf.dao.EmpresaDao;
import br.vianna.aula.jsf.dao.InvestidorDao;
import br.vianna.aula.jsf.model.acao.Acao;
import br.vianna.aula.jsf.model.acao.ETipoTransacao;
import br.vianna.aula.jsf.model.conta.Conta;
import br.vianna.aula.jsf.model.dto.ListaEmpresaDTO;
import br.vianna.aula.jsf.model.dto.UsuarioLogadoDTO;
import br.vianna.aula.jsf.model.empresa.Empresa;
import br.vianna.aula.jsf.model.usuario.investidor.Investidor;
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

        
    private UsuarioLogadoDTO user;
    private Empresa empresa;
    private int quantidadeAcao;
    private double valorTransacao;
    private Acao acao;
    private Investidor investidor;
    
    @Autowired
    private AcaoDao acaoDao;
    
    @Autowired
    private LoginMB usuario;
    
    @Autowired
    private InvestidorDao investDao;
    
    @Autowired
    private EmpresaDao empresaDao;

    public AcaoMB() {
        status = EStatusCrud.VIEW;

        InicializaAcao();
    }

    private void InicializaAcao() {
        acao = new Acao();
        
    }
    
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

    public AcaoMB(EStatusCrud status, UsuarioLogadoDTO user, Empresa empresa, int quantidadeAcao, double valorTransacao, Acao acao, Investidor investidor, AcaoDao acaoDao, LoginMB usuario, InvestidorDao investDao, EmpresaDao empresaDao) {
        this.status = status;
        this.user = user;
        this.empresa = empresa;
        this.quantidadeAcao = quantidadeAcao;
        this.valorTransacao = valorTransacao;
        this.acao = acao;
        this.investidor = investidor;
        this.acaoDao = acaoDao;
        this.usuario = usuario;
        this.investDao = investDao;
        this.empresaDao = empresaDao;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    

    
    public InvestidorDao getInvestDao() {
        return investDao;
    }

    public void setInvestDao(InvestidorDao investDao) {
        this.investDao = investDao;
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

    public double getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(double valorTransacao) {
        this.valorTransacao = valorTransacao;
    }
    
    
    
    ///////////////////////////////////////////
    public String comprar(int id) {

        FacesContext ct = FacesContext.getCurrentInstance();
        empresa = empresaDao.get(id);
        valorTransacao = empresa.getValorAtualAcoes()*this.quantidadeAcao;
//        user = usuario.getUser();//usuario logado atualmente
        investidor = investDao.get(usuario.getUser().getId());
        Conta conta = investidor.getConta();
        
        if(conta.getSaldo() < valorTransacao){
            InicializaAcao();
            status = EStatusCrud.VIEW;

            ct.addMessage("", new FacesMessage("Saldo insuficiente"));

            return "";
        } else if(this.quantidadeAcao > empresa.getQuantAtualAcoes()){
            InicializaAcao();
            status = EStatusCrud.VIEW;

            ct.addMessage("", new FacesMessage("Quandtidade de Ações indisponivel"));

            return "";
        
        }else{
        
        
        //populando objeto acao
        empresa.setQuantAtualAcoes(empresa.getQuantAtualAcoes()-this.quantidadeAcao);
        
        acao.setEmpresa(empresa);
        acao.setTipoTransacao(ETipoTransacao.COMPRA);
        acao.setValorTransacao(valorTransacao);
        acao.setDataTransacao(new Date());
        acao.setConta(conta);
        acao.setQuantidadeAcoesTransacao(this.quantidadeAcao);
        
        conta.setSaldo(conta.getSaldo()-valorTransacao);
        
        //
        investDao.save(investidor);//atualizando investidor
        acaoDao.save(acao);//atualizando acao
        
        
        //atualizando o DTO que esta exibindo as informacoes no menu - só aparece depois que loga novamente
        
        InicializaAcao();
        status = EStatusCrud.VIEW;

        ct.addMessage("", new FacesMessage("Ações compradas com sucesso!"));

        return "";
        }
    }
    
    
    public String vender(int id) {

        FacesContext ct = FacesContext.getCurrentInstance();
        empresa = empresaDao.get(id);
        valorTransacao = empresa.getValorAtualAcoes()*this.quantidadeAcao;
//        user = usuario.getUser();//usuario logado atualmente
        investidor = investDao.get(usuario.getUser().getId());
        Conta conta = investidor.getConta();
        
        int quantidadeAtualEspecifica = empresaDao.getQuandtidadeAcoesAtualVender(empresa.getId(), conta.getId());//quandotidade atual das acoes da empresa que esta tentando vender
        
        if(this.quantidadeAcao > quantidadeAtualEspecifica){
            InicializaAcao();
            status = EStatusCrud.VIEW;

            ct.addMessage("", new FacesMessage("Ações insuficientes"));

            return "";
        } else {
        
        
        //populando objeto acao
        
        empresa.setQuantAtualAcoes(empresa.getQuantAtualAcoes()+this.quantidadeAcao);
        
        acao.setEmpresa(empresa);
        acao.setTipoTransacao(ETipoTransacao.VENDA);
        acao.setValorTransacao(valorTransacao);
        acao.setDataTransacao(new Date());
        acao.setConta(conta);
        acao.setQuantidadeAcoesTransacao(this.quantidadeAcao =- this.quantidadeAcao);
        
        conta.setSaldo(conta.getSaldo()+valorTransacao);
        
        //
        investDao.save(investidor);//atualizando investidor
        acaoDao.save(acao);//atualizando acao
        
        
        //atualizando o DTO que esta exibindo as informacoes no menu - só aparece depois que loga novamente
        
        InicializaAcao();
        status = EStatusCrud.VIEW;

        ct.addMessage("", new FacesMessage("Ações vendidas com com sucesso!"));

        return "";
        }
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

}

    

