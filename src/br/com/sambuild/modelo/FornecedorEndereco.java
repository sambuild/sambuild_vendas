package br.com.sambuild.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FornecedorEndereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private String logradouro;

    private String bairro;

    private String cidade;

    private String uf;

    private String numero;

    private String complemento;

    @ManyToOne
    private Fornecedor fornecedor;

    public String getLogradouro() {
	return logradouro;
    }

    public void setLogradouro(String logradouro) {
	this.logradouro = logradouro;
    }

    public String getBairro() {
	return bairro;
    }

    public void setBairro(String bairro) {
	this.bairro = bairro;
    }

    public String getCidade() {
	return cidade;
    }

    public void setCidade(String cidade) {
	this.cidade = cidade;
    }

    public String getUf() {
	return uf;
    }

    public void setUf(String uf) {
	this.uf = uf;
    }

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

    public Fornecedor getFornecedor() {
	return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
	this.fornecedor = fornecedor;
    }

    public String getNumero() {
	return numero;
    }

    public void setNumero(String numero) {
	this.numero = numero;
    }

    public String getComplemento() {
	return complemento;
    }

    public void setComplemento(String complemento) {
	this.complemento = complemento;
    }


    @Override
    public String toString() {
	return "Descição " + descricao + " Logradouro " + logradouro
		+ " Bairro " + bairro + " Cidade " + cidade + " UF " + uf
		+ " Numero " + numero + " Complemento " + complemento;
    }

}
