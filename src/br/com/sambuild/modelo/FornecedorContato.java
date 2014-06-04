package br.com.sambuild.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FornecedorContato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private String telefone;

    private String email;

    @ManyToOne
    private Fornecedor fornecedor;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public String getTelefone() {
	return telefone;
    }

    public void setTelefone(String telefone) {
	this.telefone = telefone;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Fornecedor getFornecedor() {
	return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
	this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
	return "Descricao " + descricao + " Telefone " + telefone + " Email "
		+ email;
    }
}
