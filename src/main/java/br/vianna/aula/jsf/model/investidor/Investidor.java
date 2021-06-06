/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.model.investidor;

import br.vianna.aula.jsf.model.usuario.*;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author suporte
 */
@Entity
public class Investidor extends Usuario{
    
    @NotNull
    private String profissao, endereco, rg, cpf;

    public Investidor() {
    }

    public Investidor(String profissao, String endereco, String rg, String cpf, int id, String nome, String email, String login, String senha, ETipoUsuario tipo) {
        super(id, nome, email, login, senha, tipo);
        this.profissao = profissao;
        this.endereco = endereco;
        this.rg = rg;
        this.cpf = cpf;
    }
}
