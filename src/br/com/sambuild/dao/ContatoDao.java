package br.com.sambuild.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sambuild.modelo.Contato;
import br.com.sambuild.modelo.Fornecedor;

public class ContatoDao extends Dao<Contato> {

    @Inject
    private EntityManager manager;

    public ContatoDao() {
	super(Contato.class);
    }

    @SuppressWarnings("unchecked")
    public List<Contato> getContatosByFornecedor(Fornecedor fornecedor) {
	String query = "Select c From Contato c Where c.fornecedor = :fornecedor";
	Query createQuery = manager.createQuery(query);
	createQuery.setParameter("fornecedor", fornecedor);
	List<Contato> lista = createQuery.getResultList();
	return lista;
    }
}
