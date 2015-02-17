package br.com.sambuild.dao;

import java.io.Serializable;

import br.com.sambuild.modelo.Fornecedor;

public class FornecedorDao extends Dao<Fornecedor> implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 950550226873809779L;

	public FornecedorDao() {
	super(Fornecedor.class);
    }

}