package br.com.sambuid.teste;

import javax.persistence.EntityManager;

import br.com.sambuild.modelo.Contato;
import br.com.sambuild.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Contato contato = em.find(Contato.class, 2L);
		
		em.getTransaction().begin();
		em.remove(contato);
		em.getTransaction().commit();
		
		em.close();
	}
}
