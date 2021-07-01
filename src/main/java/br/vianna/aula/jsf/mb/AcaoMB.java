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
import br.vianna.aula.jsf.model.dto.ListaAcaoDTO;
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

        
    private ArrayList<ListaAcaoDTO> listaHistoricoTransacoes;
    private ArrayList<ListaAcaoDTO> listaHistoricoTransacoesTodasEmpresas;
    
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
    private CadastroEmpresaMB empMB;
    
    @Autowired
    private InvestidorDao investDao;
    
    @Autowired
    private EmpresaDao empresaDao;
    
    @Autowired
    private CorretoraMB corretoraMB;
    

    public AcaoMB() {
        status = EStatusCrud.VIEW;
       
        InicializaAcao();
        
        listaHistoricoTransacoes = new ArrayList<>();
        listaHistoricoTransacoesTodasEmpresas = new ArrayList<>();
    }

    private void InicializaAcao() {
        acao = new Acao();
        
        
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

    public ArrayList<ListaAcaoDTO> getListaHistoricoTransacoes() {
        return listaHistoricoTransacoes;
    }

    public void setListaHistoricoTransacoes(ArrayList<ListaAcaoDTO> listaHistoricoTransacoes) {
        this.listaHistoricoTransacoes = listaHistoricoTransacoes;
    }

    public CadastroEmpresaMB getEmpMB() {
        return empMB;
    }

    public void setEmpMB(CadastroEmpresaMB empMB) {
        this.empMB = empMB;
    }

    public CorretoraMB getCorretoraMB() {
        return corretoraMB;
    }

    public void setCorretoraMB(CorretoraMB corretoraMB) {
        this.corretoraMB = corretoraMB;
    }

    public ArrayList<ListaAcaoDTO> getListaHistoricoTransacoesTodasEmpresas() {
        return listaHistoricoTransacoesTodasEmpresas;
    }

    public void setListaHistoricoTransacoesTodasEmpresas(ArrayList<ListaAcaoDTO> listaHistoricoTransacoesTodasEmpresas) {
        this.listaHistoricoTransacoesTodasEmpresas = listaHistoricoTransacoesTodasEmpresas;
    }

    
    
    
    
    
    
//    @PostConstruct
//    public void init() {
//        
//        //se for inv
//        if (usuario.isInvestidor()){
//        investidor = investDao.get(usuario.getUser().getId());
//        listaHistoricoTransacoes = buscaHistoricoTransacoes(investidor.getConta().getId());
//        }
//
//    }
    
    public ArrayList<ListaAcaoDTO> buscaHistoricoTransacoes() {
        
        investidor = investDao.get(usuario.getUser().getId());
        
        
        ArrayList<ListaAcaoDTO> listaHistoricoTransacoes = new ArrayList<>();

        listaHistoricoTransacoes.addAll(acaoDao.buscaHistoricoTransacoes(investidor.getConta()));

        return listaHistoricoTransacoes;
    }
    
    public ArrayList<ListaAcaoDTO> buscaHistoricoTransacoesTodasEmpresas() {
        
        
        ArrayList<ListaAcaoDTO> listaHistoricoTransacoesTodasEmpresas = new ArrayList<>();

        listaHistoricoTransacoesTodasEmpresas.addAll(acaoDao.buscaHistoricoTransacoesTodasEmpresas());

        return listaHistoricoTransacoesTodasEmpresas;
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
            this.quantidadeAcao = 0;
            status = EStatusCrud.VIEW;

            ct.addMessage("", new FacesMessage("Saldo insuficiente"));

            return "";
        } else if(this.quantidadeAcao > empresa.getQuantAtualAcoes()){
            InicializaAcao();
            this.quantidadeAcao = 0;
            status = EStatusCrud.VIEW;

            ct.addMessage("", new FacesMessage("Quantidade de Ações indisponivel"));

            return "";
        
        }else if (this.quantidadeAcao <= 0) {
            this.quantidadeAcao = 0;
            InicializaAcao();
            status = EStatusCrud.VIEW;

            
            ct.addMessage("", new FacesMessage("Escolha a quantidade de ações que quer comprar."));

            return "";
        } else {

        //populando objeto acao
        empresa.setQuantAtualAcoes(empresa.getQuantAtualAcoes()-this.quantidadeAcao);
        
        acao.setEmpresa(empresa);
        acao.setTipoTransacao(ETipoTransacao.COMPRA);
        acao.setValorTransacao(valorTransacao);
        acao.setDataTransacao(new Date());
        acao.setConta(conta);
        acao.setQuantidadeAcoesTransacao(this.quantidadeAcao);
        
        
        //calcula valor da corretagem
        double valorCorretagem = corretoraMB.calcularCorretagem(valorTransacao);
        acao.setValorCorretagem(valorCorretagem);
        //subtrai a corretagem do valor final
        double valorFinal = valorTransacao + valorCorretagem;
        
        //salvar  na corretora
        corretoraMB.salvarCorretagemCompra(valorCorretagem);
        
        //salva na conta do investidor
        conta.setSaldo(conta.getSaldo()-valorFinal);
        
        investDao.save(investidor);//atualizando investidor
        acaoDao.save(acao);//atualizando acao
        
        
        //atualizando o DTO que esta exibindo as informacoes no menu - só aparece depois que loga novamente
        this.quantidadeAcao = 0;
        InicializaAcao();
        status = EStatusCrud.VIEW;
        
        usuario.getUser().getConta().setSaldo(conta.getSaldo());//ver como atualiza objeto na sessao
        empMB.atualizarListasMetodo();
        
        this.quantidadeAcao = 0;
        InicializaAcao();
        ct.addMessage("", new FacesMessage("Ações compradas com sucesso! $"+valorFinal));

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
            this.quantidadeAcao = 0;
            status = EStatusCrud.VIEW;

            ct.addMessage("", new FacesMessage("Ações insuficientes"));

            return "";
        } else if(this.quantidadeAcao <= 0){
            this.quantidadeAcao = 0;
            InicializaAcao();
            status = EStatusCrud.VIEW;

            ct.addMessage("", new FacesMessage("Escolha a quantidade de ações que quer vender."));

            return "";
        }else{
        
        //populando objeto acao
        
        empresa.setQuantAtualAcoes(empresa.getQuantAtualAcoes()+this.quantidadeAcao);
        
        acao.setEmpresa(empresa);
        acao.setTipoTransacao(ETipoTransacao.VENDA);
        acao.setValorTransacao(valorTransacao);
        acao.setDataTransacao(new Date());
        acao.setConta(conta);
        acao.setQuantidadeAcoesTransacao(this.quantidadeAcao =- this.quantidadeAcao);
        
        //calcula valor da corretagem
        double valorCorretagem = corretoraMB.calcularCorretagem(valorTransacao);
        acao.setValorCorretagem(valorCorretagem);
        //subtrai a corretagem do valor final
        double valorFinal = valorTransacao - valorCorretagem;
        
        //salvar  na corretora
        corretoraMB.salvarCorretagemVenda(valorCorretagem);
        
        //salva na conta do investidor
        conta.setSaldo(conta.getSaldo()+valorFinal);
        
        //
        investDao.save(investidor);//atualizando investidor
        acaoDao.save(acao);//atualizando acao
        
        
        //atualizando o DTO que esta exibindo as informacoes no menu - só aparece depois que loga novamente
        this.quantidadeAcao = 0;
        InicializaAcao();
        status = EStatusCrud.VIEW;
        
        usuario.getUser().getConta().setSaldo(conta.getSaldo());//ver como atualiza objeto na sessao
        empMB.atualizarListasMetodo();
        
        ct.addMessage("", new FacesMessage("Ações vendidas com com sucesso! $"+valorFinal));

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

    

