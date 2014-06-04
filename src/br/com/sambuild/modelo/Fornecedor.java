package br.com.sambuild.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cnpjCpf;

    private String inscricaoEstadual;

    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.EAGER)
    private List<FornecedorContato> contatos = new ArrayList<FornecedorContato>();

    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.EAGER)
    private List<FornecedorEndereco> enderecos = new ArrayList<FornecedorEndereco>();

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getCnpjCpf() {
	return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
	this.cnpjCpf = cnpjCpf;
    }

    public String getInscricaoEstadual() {
	return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
	this.inscricaoEstadual = inscricaoEstadual;
    }

    public List<FornecedorContato> getContatos() {
	return contatos;
    }

    public void setContatos(List<FornecedorContato> contatos) {
	this.contatos = contatos;
    }

    public List<FornecedorEndereco> getEnderecos() {
	return enderecos;
    }

    public void setEnderecos(List<FornecedorEndereco> enderecos) {
	this.enderecos = enderecos;
    }
}
