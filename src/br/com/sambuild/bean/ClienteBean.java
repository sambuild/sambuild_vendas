package br.com.sambuild.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.sambuild.modelo.Cliente;
import br.com.sambuild.modelo.Contato;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Cliente cliente = new Cliente();
    
    private Contato contato = new Contato();
    
    private List<Cliente> clientes;

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
	
	public void gravar(){
		
	}
	
	public void cancelar(){
		
	}

	public void remover(Cliente cliente){
		
	}

	public void adicionarContato(){
		if(cliente.getContatos().isEmpty())
			contato.setPrincipal(Boolean.TRUE);
		else if(contato.getPrincipal())
			for(Contato contato : cliente.getContatos())
				contato.setPrincipal(Boolean.FALSE);

		cliente.getContatos().add(getContato());
		novoContato();
	}
	
	public Contato getContato(){
		return this.contato;
	}
	
	private void novoContato(){
		this.contato = new Contato();
	}
}
