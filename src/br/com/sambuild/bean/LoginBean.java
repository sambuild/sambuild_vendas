package br.com.sambuild.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sambuild.dao.UsuarioDao;
import br.com.sambuild.modelo.Usuario;

@Named
@RequestScoped
public class LoginBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3012125520899945419L;

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
