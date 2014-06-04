package br.com.sambuild.dao;

import java.io.Serializable;

import br.com.sambuild.modelo.FornecedorEndereco;

/**
 * <pre>
 * @author Salariel
 * purpose: <replace>
 * 
 * Date		- User 		- Comment
 * 31/05/2014	- Salariel	- Initial version.
 * 
 * All right reserved - Sambuild - 2014
 * </pre>
 */
public class FornecedorEnderecoDao extends Dao<FornecedorEndereco> implements
	Serializable {

    private static final long serialVersionUID = 1L;

    public FornecedorEnderecoDao() {
	super(FornecedorEndereco.class);
    }

}
