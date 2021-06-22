/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.dao;

import br.vianna.aula.jsf.model.dto.ListaEmpresaDTO;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Leonardo
 */
@Component
public class EmpresaDao {
    
    private String src = "br.vianna.aula.jsf.model.dto.";
    
    @Autowired
    private EntityManager conexao;

    public ArrayList<ListaEmpresaDTO> getAllEmpresas() {
      
          Query q = conexao.createQuery("SELECT new "+src+"ListEmpresaDTO(e.id,e.nome,"
                    + " from Empresa e");
        
          
        return (ArrayList<ListaEmpresaDTO>) q.getResultList();
    }
}

