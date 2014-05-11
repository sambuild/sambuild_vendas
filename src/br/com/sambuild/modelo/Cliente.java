package br.com.sambuild.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private Calendar nascimento;

	private String cpf;
	
	private boolean spc;
	
	private boolean serasa;
	
	private Double limiteDebito;

	@OneToMany(mappedBy="cliente")
	private List<Contato> contatos;
	
	private Contato contatoPrincipal;
	
	public Cliente(){
		contatos = new ArrayList<Contato>();
		contatoPrincipal = new Contato();
	}
	
	public Contato getContatoPrincipal() {
		return contatoPrincipal;
	}

	public void setContatoPrincipal(Contato contatoPrincipal) {
		this.contatoPrincipal = contatoPrincipal;
	}

	public boolean isSpc() {
		return spc;
	}

	public void setSpc(boolean spc) {
		this.spc = spc;
	}

	public boolean isSerasa() {
		return serasa;
	}

	public void setSerasa(boolean serasa) {
		this.serasa = serasa;
	}

	public Double getLimiteDebito() {
		return limiteDebito;
	}

	public void setLimiteDebito(Double limiteDebito) {
		this.limiteDebito = limiteDebito;
	}
	
	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		for (Contato contato : contatos){
			if(contato.getPrincipal())
				contatoPrincipal=contato;
		}
		
		this.contatos = contatos;
	}

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

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
