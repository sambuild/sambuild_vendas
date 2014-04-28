package br.com.sambuild.teste;

import javax.persistence.EntityManager;

import br.com.sambuild.modelo.Contato;
import br.com.sambuild.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Contato contato = em.find(Contato.class, 3L);
		
		System.out.println(contato.getDescricao());
		
		em.close();
	}
}
