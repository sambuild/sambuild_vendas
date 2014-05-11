package br.com.sambuild.modelo;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;

import br.com.sambuild.util.JPAUtil;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String login;

	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean existe() {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Query query = em.createQuery(
				"select u from Usuario u where u.login = :pLogin and u.senha = :pSenha")
			.setParameter("pLogin", getLogin())
			.setParameter("pSenha", getSenha());
	
		boolean encontrado = !query.getResultList().isEmpty();
	
		return encontrado;
    }
}
