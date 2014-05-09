package br.com.sambuild.teste;

import br.com.sambuild.modelo.Cliente;
import br.com.sambuild.util.ApplicationProperties;
import br.com.sumbuild.dao.ClienteDao;

public class TesteJPA {

    public static void main(String[] args) {

	ApplicationProperties.load();
	ClienteDao dao = new ClienteDao();
	Cliente c = new Cliente();

	c.setNome("Cebeça");

	dao.adiciona(c);
	c = dao.buscaPorId(1L);
	System.out.println(c.getNome());

    }
}
