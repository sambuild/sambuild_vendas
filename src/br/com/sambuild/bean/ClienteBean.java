package br.com.sambuild.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.sambuild.modelo.Cliente;

@ManagedBean
@RequestScoped
public class ClienteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Cliente cliente = new Cliente();
    
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
		cliente.getContatos().add(cliente.getContatoPrincipal());
	}
}
