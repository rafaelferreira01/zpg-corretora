package br.vianna.aula.jsf;

import br.vianna.aula.jsf.dao.UsuarioDao;
import br.vianna.aula.jsf.model.ETipoUsuario;
import br.vianna.aula.jsf.model.Usuario;
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
        
    @Override
    public void run(String... args) throws Exception {//vai ser executado sempre que o servidor subir
        System.out.println("Server ON!");
        System.out.println("a::"+Utils.md5("a"));
        
        Usuario u = new Usuario(0, "Zezin", "ze@ze","ze", Utils.md5("123"), ETipoUsuario.ADMIN);
        Usuario u1 = new Usuario(0, "Pedrin", "pe@p  e", "ped", Utils.md5("123"), ETipoUsuario.NORMAL);
        
        userD.save(u);
        userD.save(u1);
    
    }
        
        

}
