package br.com.sambuild.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.sambuild.modelo.Usuario;

@ManagedBean
@RequestScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario = new Usuario();

    public Usuario getUsuario() {
	return usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    public String efetuaLogin() {
	String url = "login";

	if (usuario.existe()) {
	    url = "index?faces-redirect=true";
	}

	return url;
    }
}
