package br.com.sambuild.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sambuild.dao.FornecedorContatoDao;
import br.com.sambuild.dao.FornecedorDao;
import br.com.sambuild.dao.FornecedorEnderecoDao;
import br.com.sambuild.datamodel.DataModelFornecedor;
import br.com.sambuild.interceptor.Transactional;
import br.com.sambuild.modelo.Fornecedor;
import br.com.sambuild.modelo.FornecedorContato;
import br.com.sambuild.modelo.FornecedorEndereco;

@Named
@SessionScoped
public class FornecedorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private FornecedorDao fornecedorDao;

    @Inject
    private FornecedorContatoDao contatoDao;

    @Inject
    private FornecedorEnderecoDao enderecoDao;

    @Inject
    private DataModelFornecedor dataModel;

    private Fornecedor fornecedor = new Fornecedor();

    private FornecedorContato contato = new FornecedorContato();

    private FornecedorEndereco endereco = new FornecedorEndereco();

    public Fornecedor getFornecedor() {
	return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
	this.fornecedor = fornecedor;
    }

    public FornecedorContato getContato() {
	return contato;
    }

    public void setContato(FornecedorContato contato) {
	this.contato = contato;
    }

    public DataModelFornecedor getDataModel() {
	return dataModel;
    }

    public void setDataModel(DataModelFornecedor dataModel) {
	this.dataModel = dataModel;
    }

    public FornecedorEndereco getEndereco() {
	return endereco;
    }

    public void setEndereco(FornecedorEndereco endereco) {
	this.endereco = endereco;
    }

    public void adicionarEndereco() {
	fornecedor.getEnderecos().add(endereco);
	endereco = new FornecedorEndereco();
	endereco.setId(null);
    }

    public void adicionarContato() {
	fornecedor.getContatos().add(contato);
	contato = new FornecedorContato();
	contato.setId(null);
    }

    @Transactional
    public void gravar() {
	for (FornecedorContato contato : fornecedor.getContatos()) {
	    Long id = contato.getId() == null || contato.getId() == 0 ? null
		    : contato.getId();
	    contato.setId(id);
	}
	for (FornecedorEndereco endereco : fornecedor.getEnderecos()) {
	    Long id = endereco.getId() == null || endereco.getId() == 0 ? null
		    : endereco.getId();
	    endereco.setId(id);
	}
	if (fornecedor.getId() > 0) {
	    fornecedorDao.amend(fornecedor);
	} else {
	    fornecedor.setId(null);
	    fornecedorDao.saveNew(fornecedor);
	}
	for (FornecedorContato contato : fornecedor.getContatos()) {
	    contato.setFornecedor(fornecedor);
	    if (contato.getId() != null) {
		contatoDao.amend(contato);
	    } else {
		contatoDao.saveNew(contato);
	    }
	}
	for (FornecedorEndereco endereco : fornecedor.getEnderecos()) {
	    endereco.setFornecedor(fornecedor);
	    if (endereco.getId() != null) {
		enderecoDao.amend(endereco);
	    } else {
		enderecoDao.saveNew(endereco);
	    }
	}
    }

    public void cancelar() {
	fornecedor = new Fornecedor();
    }

    public void cancelarContato() {
	contato = new FornecedorContato();
    }

    @Transactional
    public void remover(FornecedorEndereco endereco) {
	fornecedor.getEnderecos().remove(endereco);
	if (endereco.getId() != null && endereco.getId() > 0) {
	    enderecoDao.remove(endereco);
	}
    }

    @Transactional
    public void remover(FornecedorContato contato) {
	fornecedor.getContatos().remove(contato);
	if (contato.getId() != null && contato.getId() > 0) {
	    contatoDao.remove(contato);
	}
    }

    @Transactional
    public String remover(Long fornecedorId) {
	String url = "fornecedor.xhtml?faces-redirect=true";
	Fornecedor fornecedor = fornecedorDao.findById(fornecedorId);
	if (fornecedor != null) {
	    for (FornecedorEndereco endereco : fornecedor.getEnderecos()) {
		enderecoDao.remove(endereco);
	    }
	    for (FornecedorContato contato : fornecedor.getContatos()) {
		contatoDao.remove(contato);
	    }
	    fornecedorDao.remove(fornecedor);
	    addMessage("Sistema",
		    "Fornecedor e apagado do sistema com sucesso!");
	}
	return url;
    }

    private void addMessage(String summary, String detail) {
	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
		summary, detail);
	FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String detalhar(Fornecedor fornecedor) {
	this.fornecedor = fornecedor;
	return "fornecedor-detalhes.xhtml?faces-redirect=true";
    }

    public String novoFornecedor() {
	this.fornecedor = new Fornecedor();
	return "fornecedor-detalhes.xhtml?faces-redirect=true";
    }
}
