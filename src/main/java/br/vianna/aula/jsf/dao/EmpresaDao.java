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
            conexao.persist(e);//inserindo...
        }
        return e;
    }
    

    public ArrayList<ListaEmpresaDTO> getAllEmpresas() {
      
          Query q = conexao.createQuery("SELECT new "+src+"ListaEmpresaDTO(e.id,e.nome,e.quantTotalAcoes,e.valorAtualAcoes)"
                    + " from Empresa e");
 
        return (ArrayList<ListaEmpresaDTO>) q.getResultList();
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

