/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.dao;

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
public class EmpresaDao {
    
    private String src = "br.vianna.aula.jsf.model.dto.";
    
    @Autowired
    private EntityManager conexao;
    
    
    @Transactional
    public Empresa save(Empresa e){
        if (e.getId() > 0){//se o id for maior que 0 significa que é um registro que ja existe, isso té, estão dando um update no registro
            conexao.merge(e);//atualizando uma edicao (update)
        }else{//caso contrario eh um novo registro
            e.setQuantAtualAcoes(e.getQuantTotalAcoes());
            conexao.persist(e);//inserindo...
        }
        return e;
    }
    

    public ArrayList<ListaEmpresaDTO> getAllEmpresas() {
      
          Query q = conexao.createQuery("SELECT new "+src+"ListaEmpresaDTO(e.id,e.nome,e.quantTotalAcoes,e.quantAtualAcoes,e.valorAtualAcoes)"
                    + " from Empresa e");
 
          
//          Query q = conexao.createQuery("SELECT new "+src+"ListaEmpresaDTO(e.id,e.nome,e.quantTotalAcoes,sum(a.quantidadeAcoesTransacao),e.valorAtualAcoes)"
//                    + " from Empresa e "
//                    + " right join e.listaAcoes a"
//                    + " group by a.empresa");
          
//          Query q = conexao.createQuery("SELECT new "+src+"ListaEmpresaDTO(e.id,e.nome,e.quantTotalAcoes,sum(a.quantidadeAcoesTransacao),e.valorAtualAcoes)"
//                    + " from Empresa e, Acao a"
//                  + " where a.id = e.id");
        return (ArrayList<ListaEmpresaDTO>) q.getResultList();
    }
    
    public ArrayList<ListaEmpresaDTO> getAllEmpresasByAcaoInvestidor(int id) {//
      
          Query q = conexao.createQuery("SELECT new "+src+"ListaEmpresaDTO(e.id,e.nome,e.quantTotalAcoes,sum(a.quantidadeAcoesTransacao), e.valorAtualAcoes)"
                    + " FROM Empresa e "
                    + " RIGHT JOIN e.listaAcoes a"
                    + " WHERE a.conta.id = :id "
                    + " GROUP BY a.empresa "
                    + " HAVING sum(a.quantidadeAcoesTransacao) > 0 ");
          
          q.setParameter("id", id);
        return (ArrayList<ListaEmpresaDTO>) q.getResultList();
    }
    
    public int getQuandtidadeAcoesAtualVender(int idempresa, int idconta) {//retorna a quantidade de acoes na hora de vender, pra checar se tem a quantidade disponivel
        
        Query q = conexao.createQuery("SELECT sum(a.quantidadeAcoesTransacao) "
                    + " FROM Acao a "
                    + " WHERE a.empresa.id = :idempresa and a.conta.id = :idconta "
                    + " GROUP BY a.empresa.id ");
          
          q.setParameter("idempresa", idempresa);
          q.setParameter("idconta", idconta);
        return (int)(long)q.getSingleResult();

    }
    
    
    
    public Empresa get(int id) {
        return conexao.find(Empresa.class, id);
    }

    @Transactional
    public Empresa delete(int id) {
        Empresa e = get(id);//pega o cachorro e salva ele na variavel g
        conexao.remove(e);//apaga ele do banco de dados
        return e;//retorna ele
    }

    
    
}



//Query q = conexao.createQuery("SELECT new "+src+"ListaEmpresaDTO(e.id,e.nome,e.quantTotalAcoes,e.valorAtualAcoes,e.listaAcoes.size())"
//                    + " from Empresa e "
//                    + " where e.e.listaAcoes.size() < e.quantTotalAcoes");

