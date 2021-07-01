/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.dao;

import br.vianna.aula.jsf.model.acao.Acao;
import br.vianna.aula.jsf.model.conta.Conta;
import br.vianna.aula.jsf.model.dto.ListaAcaoDTO;
import br.vianna.aula.jsf.model.dto.ListaEmpresaDTO;
import br.vianna.aula.jsf.model.empresa.Empresa;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Leonardo
 */
@Component
public class AcaoDao {
    
    private String src = "br.vianna.aula.jsf.model.dto.";
    
    @Autowired
    private EntityManager conexao;
    
    
    @Transactional
    public Acao save(Acao a){
        if (a.getId() > 0){//se o id for maior que 0 significa que é um registro que ja existe, isso té, estão dando um update no registro
            conexao.merge(a);//atualizando uma edicao (update)
        }else{//caso contrario eh um novo registro
            conexao.persist(a);//inserindo...
        }
        return a;
    }
    
    @Transactional
    public Acao comprar(Acao a){
        if (a.getId() > 0){//se o id for maior que 0 significa que é um registro que ja existe, isso té, estão dando um update no registro
            conexao.merge(a);//atualizando uma edicao (update)
        }else{//caso contrario eh um novo registro
            conexao.persist(a);//inserindo...
        }
        return a;
    }
    

    public ArrayList<ListaEmpresaDTO> getAllEmpresas() {
      
          Query q = conexao.createQuery("SELECT new "+src+"ListaEmpresaDTO(e.id,e.nome,e.quantTotalAcoes,e.valorAtualAcoes)"
                    + " from Empresa e");
 
        return (ArrayList<ListaEmpresaDTO>) q.getResultList();
    }
    
    
    public ArrayList<ListaAcaoDTO> buscaHistoricoTransacoes(Conta conta) {//
      
          Query q = conexao.createQuery("SELECT new "+src+"ListaAcaoDTO(a.id,a.conta,a.empresa,a.valorTransacao,a.quantidadeAcoesTransacao,a.dataTransacao,a.tipoTransacao)"
                    + " FROM Acao a "
                     + " WHERE a.conta = :conta"
                     + " ORDER BY a.id DESC");
          q.setParameter("conta", conta);
        return (ArrayList<ListaAcaoDTO>) q.getResultList();
    }
    
    public ArrayList<ListaAcaoDTO> buscaHistoricoTransacoesTodasEmpresas() {//
      
          Query q = conexao.createQuery("SELECT new "+src+"ListaAcaoDTO(a.id,a.conta,a.empresa,a.valorTransacao,a.quantidadeAcoesTransacao,a.dataTransacao,a.tipoTransacao,a.valorCorretagem) "
                    + " FROM Acao a"
                    + " ORDER BY a.id DESC");
        return (ArrayList<ListaAcaoDTO>) q.getResultList();
    }
    
    
    
    public Acao get(int id) {
        return conexao.find(Acao.class, id);
    }

    @Transactional
    public Acao delete(int id) {
        Acao a = get(id);//pega o cachorro e salva ele na variavel g
        conexao.remove(a);//apaga ele do banco de dados
        return a;//retorna ele
    }
    
}

