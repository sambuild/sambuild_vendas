package br.com.sumbuild.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sambuild.modelo.Usuario;
import br.com.sambuild.util.JPAUtil;

public class UsuarioDao extends Dao<Usuario> implements Serializable {

    private static final long serialVersionUID = 1L;

    public UsuarioDao() {
	super(Usuario.class);
    }

    private EntityManager manager = JPAUtil.getEntityManager();

    public boolean existe(Usuario usuario) {

	Query query = manager
		.createQuery(
			"select u from Usuario u where u.email = :pLogin and u.senha = :pSenha")
		.setParameter("pLogin", usuario.getEmail())
		.setParameter("pSenha", usuario.getSenha());

	boolean encontrado = !query.getResultList().isEmpty();

	return encontrado;
    }
}