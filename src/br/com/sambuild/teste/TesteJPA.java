package br.com.sambuild.teste;

import br.com.sambuild.modelo.Usuario;
import br.com.sumbuild.dao.UsuarioDao;

public class TesteJPA {

    public static void main(String[] args) {
    	Usuario usuario = new Usuario();
    	usuario.setAtivo(true);
    	usuario.setEmail("skilo@sb.com");
    	usuario.setNomeCompleto("Jose Adriano Torres Moreira");
    	usuario.setSenha("skilo");
    	
    	UsuarioDao dao = new UsuarioDao();
    	dao.saveNew(usuario);
    }
}
