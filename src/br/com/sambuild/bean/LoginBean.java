package br.com.sambuild.bean;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.sambuild.modelo.Usuario;
import br.com.sumbuild.dao.UsuarioDao;

@ManagedBean
@RequestScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario = new Usuario();

    @Inject
    private UsuarioDao userDao;

    public Usuario getUsuario() {
	return usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    public String efetuaLogin() {
	String url = "login";

	if (userDao.existe(this.usuario)) {
	    url = "index?faces-redirect=true";
	}

	return url;
    }
}
