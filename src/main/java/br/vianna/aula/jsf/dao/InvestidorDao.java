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
public class InvestidorDao {
    
    private String src = "br.vianna.aula.jsf.model.dto.";
    
    @Autowired
    private EntityManager con;
    
    @Transactional
    public Investidor save(Investidor i){
        if (i.getId() > 0){//se o id for maior que 0 significa que é um registro que ja existe, isso té, estão dando um update no registro
            con.merge(i);//atualizando uma edicao (update)
        }else{//caso contrario eh um novo registro
            con.persist(i);//inserindo...
        }
        return i;
    }
    
    public UsuarioLogadoDTO existeInvestidor(String login, String senha){//para logar
        try {
            Query q = con.createQuery("select new "+src+"UsuarioLogadoDTO(i.id, i.nome, i.email, i.profissao, i.endereco, i.rg, i.cpf, i.tipo) "
                + "from Investidor i where i.login = :log and i.senha = :sen");

            q.setParameter("log", login);
            String conv = Utils.md5(senha);
            q.setParameter("sen", conv);

            return (UsuarioLogadoDTO) q.getSingleResult();
            
        } catch (Exception i) {
            return null;
        }
        
    }
    
    public ArrayList<ListaInvestidorDTO> getAllInvestidores() {
      
          Query q = con.createQuery("SELECT new "+src+"ListaInvestidorDTO(i.id,i.nome,i.profissao,i.endereco,i.cpf,i.rg,i.email,i.login,i.conta.saldo)"
                    + " from Investidor i");
        
          
        return (ArrayList<ListaInvestidorDTO>) q.getResultList();
    }
    
    public Investidor get(int id) {
        return con.find(Investidor.class, id);
    }

    @Transactional
    public Investidor delete(int id) {
        Investidor i = get(id);//pega o cachorro e salva ele na variavel g
        con.remove(i);//apaga ele do banco de dados
        return i;//retorna ele
    }
    
    //METODO DE ENCRIPTAR SENHA
//    @Transactional
//    public Investidor save(Investidor i) throws NoSuchAlgorithmException{
//        i.setSenha(Utils.md5(i.getSenha()));
//        
//        if (i.getId() > 0){//se o id for maior que 0 significa que é um registro que ja existe, isso té, estão dando um update no registro
//            con.merge(i);//atualizando uma edicao (update)
//        }else{//caso contrario eh um novo registro
//            con.persist(i);//inserindo...
//        }
//        return i;
//    }
    
}


