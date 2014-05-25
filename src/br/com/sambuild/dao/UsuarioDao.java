package br.com.sambuild.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sambuild.modelo.Usuario;

public class UsuarioDao extends Dao<Usuario> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;
    
    public UsuarioDao() {
	super(Usuario.class);
    }

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