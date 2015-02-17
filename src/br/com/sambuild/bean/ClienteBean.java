package br.com.sambuild.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.sambuild.dao.BairroDao;
import br.com.sambuild.dao.CidadeDao;
import br.com.sambuild.dao.UFDao;
import br.com.sambuild.modelo.Bairro;
import br.com.sambuild.modelo.Cidade;
import br.com.sambuild.modelo.Cliente;
import br.com.sambuild.modelo.Contato;
import br.com.sambuild.modelo.UF;

@Named
@ViewScoped
public class ClienteBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3585519059309412106L;

	private Cliente cliente = new Cliente();

    private Contato contato = new Contato();

    private List<Cliente> clientes;

    private List<UF> ufs = new UFDao().listAll();

    private List<Cidade> cidades = new ArrayList<Cidade>();

    private List<Bairro> bairros = new BairroDao().listAll();

    public List<Cliente> getClientes() {
	return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
	this.clientes = clientes;
    }

    public Cliente getCliente() {
	return cliente;
    }

    public void setCliente(Cliente cliente) {
	this.cliente = cliente;
    }

    public void gravar() {

    }

    public void cancelar() {

    }

    public void remover(Cliente cliente) {

    }

    public void adicionarContato() {
	if (cliente.getContatos().isEmpty())
	    contato.setPrincipal(Boolean.TRUE);
	else if (contato.getPrincipal())
	    for (Contato contato : cliente.getContatos())
		contato.setPrincipal(Boolean.FALSE);

	cliente.getContatos().add(getContato());
	novoContato();
    }

    public Contato getContato() {
	return this.contato;
    }

    private void novoContato() {
	this.contato = new Contato();
    }

    public Map<String, String> getUfs() {
	Map<String, String> valores = new HashMap<String, String>();

	for (UF uf : ufs) {
	    valores.put(uf.getDescricao(), uf.getDescricao());
	}

	return valores;
    }

    public Map<String, String> getCidades() {
	Map<String, String> valores = new HashMap<String, String>();

	for (Cidade cidade : cidades) {
	    valores.put(cidade.getDescricao(), cidade.getDescricao());
	}

	return valores;
    }

    public Map<String, String> getBairros() {
	Map<String, String> valores = new HashMap<String, String>();

	for (Bairro bairro : bairros) {
	    valores.put(bairro.getDescricao(), bairro.getDescricao());
	}

	return valores;
    }

    public void carregaCidades() {
	new CidadeDao().listAll();
    }
}
