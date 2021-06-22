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
    
     private String src = "br.vianna.aula.jsf.model.dto.";

    @Autowired
    private EntityManager con;

    @Transactional
    public Usuario save(Usuario u) {
        con.persist(u);
        return u;
    }

    @Transactional
    public Investidor saveInvestidor(Investidor i) {
        con.persist(i);
        return i;
    }

    public UsuarioLogadoDTO verificaTabelaUsuario(String login, String senha) {
        Query q = con.createQuery("select new br.vianna.aula.jsf.model.dto.UsuarioLogadoDTO(u.id, u.nome, u.email, u.tipo) "
                + "from Usuario u where u.login = :log and u.senha = :sen");

        q.setParameter("log", login);
        String conv = senha;
        q.setParameter("sen", conv);

        return (UsuarioLogadoDTO) q.getSingleResult();
    }

    public UsuarioLogadoDTO verificaTabelaInvestidor(String login, String senha) {
        Query q = con.createQuery("select new br.vianna.aula.jsf.model.dto.UsuarioLogadoDTO(i.id, i.nome, i.email, i.profissao, i.endereco, i.rg, i.cpf, i.tipo) "
                + "from Investidor i where i.login = :log and i.senha = :sen");

        q.setParameter("log", login);
        String conv = senha;
        q.setParameter("sen", conv);

        return (UsuarioLogadoDTO) q.getSingleResult();
    }

    public UsuarioLogadoDTO existeUsuario(String login, String senha) {
        try {
            return verificaTabelaInvestidor(login, Utils.md5(senha));
        } catch (Exception e) {
            try {
                return verificaTabelaUsuario(login, Utils.md5(senha));
            } catch (Exception e2) {
                return null;
            }
        }

    }

    // MÉTODO NOVO - CHECAR QUERY
   
    public ArrayList<ListaInvestidorDTO> getAllInvestidores() {

        Query q = con.createQuery("SELECT new " + src + "ListInvestidorDTO(i.id,i.nome,i.profissao,i.endereco,i.cpf,i.dinheiro"
                + " from Investidor i");

        return (ArrayList<ListaInvestidorDTO>) q.getResultList();
       }
   }


