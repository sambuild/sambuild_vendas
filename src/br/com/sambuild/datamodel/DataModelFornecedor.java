package br.com.sambuild.datamodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.sambuild.dao.FornecedorDao;
import br.com.sambuild.modelo.Fornecedor;

public class DataModelFornecedor extends LazyDataModel<Fornecedor> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1035818260601364912L;
	@Inject
    private FornecedorDao dao;

    @PostConstruct
    private void init() {
	this.setRowCount(dao.countAll());
    }

    @Override
    public List<Fornecedor> load(int first, int pageSize, String sortField,
	    SortOrder sortOrder, Map<String, Object> filters) {

	List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

	if (filters != null && !filters.isEmpty()) {
	    fornecedores = dao.listUsingFilter(filters, first, pageSize);
	} else {
	    fornecedores = dao.listByPage(first, pageSize);
	}
	return fornecedores;
    }
}
