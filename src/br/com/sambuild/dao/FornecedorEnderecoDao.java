package br.com.sambuild.dao;

import java.io.Serializable;

import br.com.sambuild.modelo.FornecedorEndereco;

public class FornecedorEnderecoDao extends Dao<FornecedorEndereco> implements
	Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3911173343061404965L;

	public FornecedorEnderecoDao() {
	super(FornecedorEndereco.class);
    }

}
