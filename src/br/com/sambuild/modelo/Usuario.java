package br.com.sambuild.modelo;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;

import br.com.sambuild.util.JPAUtil;
=======
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
>>>>>>> 0857c067250a770e9f0d22acadde142f7b17decb

@Entity
public class Usuario {

<<<<<<< HEAD
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String login;

	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean existe() {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Query query = em.createQuery(
				"select u from Usuario u where u.login = :pLogin and u.senha = :pSenha")
			.setParameter("pLogin", getLogin())
			.setParameter("pSenha", getSenha());
	
		boolean encontrado = !query.getResultList().isEmpty();
	
		return encontrado;
    }
=======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // the login is field email
    private String email;

    private String senha;

    @Temporal(TemporalType.DATE)
    private Calendar dataRegistro;

    @Temporal(TemporalType.DATE)
    private Calendar ultimoAcesso;

    private String nomeCompleto;
    
    private boolean ativo;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Calendar dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Calendar getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(Calendar ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

>>>>>>> 0857c067250a770e9f0d22acadde142f7b17decb
}
