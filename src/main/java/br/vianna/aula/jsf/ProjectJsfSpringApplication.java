package br.vianna.aula.jsf;

import br.vianna.aula.jsf.dao.InvestidorDao;
import br.vianna.aula.jsf.dao.UsuarioDao;
import br.vianna.aula.jsf.model.conta.Conta;
import br.vianna.aula.jsf.model.usuario.investidor.Investidor;
import br.vianna.aula.jsf.model.usuario.ETipoUsuario;
import br.vianna.aula.jsf.model.usuario.Usuario;
import br.vianna.aula.jsf.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectJsfSpringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjectJsfSpringApplication.class, args);
	}

    @Autowired//injeção de dependencia
    UsuarioDao userD;
    
    @Autowired//injeção de dependencia
    InvestidorDao InvestD;
        
    @Override
    public void run(String... args) throws Exception {//vai ser executado sempre que o servidor subir
        System.out.println("Server ON!");
////        System.out.println("a::"+Utils.md5("a"));
//        
//        Usuario u = new Usuario(0, "Zezin", "ze@ze","ze", Utils.md5("123"), ETipoUsuario.ADMIN);
//        userD.save(u);
//        
//        
////        Conta c = new Conta();//cria a conta
//        Investidor i = new Investidor("vagabundo", "rua das couves", "1212121212", "77777777",
//                0, "PedrinIvstidor", "pedrin@pedr", "ped", Utils.md5("123"));///cria o investidor passando a conta
////        c.setInvestidor(i);//passa o investidor pra dentro da conta
//        InvestD.save(i);//salva o investidor
    
    }

}
