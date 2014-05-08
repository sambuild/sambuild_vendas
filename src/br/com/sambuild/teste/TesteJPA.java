package br.com.sambuild.teste;

import javax.persistence.EntityManager;

import br.com.sambuild.modelo.Cliente;
import br.com.sambuild.util.ApplicationProperties;
import br.com.sambuild.util.JPAUtil;

public class TesteJPA {

    public static void main(String[] args) {
	
	ApplicationProperties.load();
	
	EntityManager em = new JPAUtil().getEntityManager();

	Cliente cliente = em.find(Cliente.class, 1L);

	System.out.println(cliente.getNome());

	em.close();
    }
}
