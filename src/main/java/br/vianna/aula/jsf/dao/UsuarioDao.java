/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.dao;

import br.vianna.aula.jsf.model.dto.ListaEmpresaDTO;
import br.vianna.aula.jsf.model.dto.ListaInvestidorDTO;
import br.vianna.aula.jsf.model.usuario.Usuario;
import br.vianna.aula.jsf.model.dto.UsuarioLogadoDTO;
import br.vianna.aula.jsf.model.usuario.investidor.Investidor;
import br.vianna.aula.jsf.utils.Utils;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author suporte
 */
@Component
public class UsuarioDao {
    
    @Autowired
    private EntityManager con;
    
    @Transactional
    public Usuario save(Usuario u){
        con.persist(u);
        return u;
    }
    
    public UsuarioLogadoDTO existeUsuario(String login, String senha){
        try {
            Query q = con.createQuery("select new br.vianna.aula.jsf.model.dto.UsuarioLogadoDTO(u.id, u.nome, u.email, u.tipo) "
                    + "from Usuario u where u.login = :log and u.senha = :sen");

            q.setParameter("log", login);
            String conv = Utils.md5(senha);
            q.setParameter("sen", conv);

            return (UsuarioLogadoDTO) q.getSingleResult();
            
        } catch (Exception e) {
            return null;
        }
        
    }
    
}


