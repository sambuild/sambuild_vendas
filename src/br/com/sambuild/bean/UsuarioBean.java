package br.com.sambuild.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sambuild.dao.UsuarioDao;
import br.com.sambuild.interceptor.Transactional;
import br.com.sambuild.modelo.Usuario;

@Named
@RequestScoped
public class UsuarioBean implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1755512998154079196L;

	@Inject
    private UsuarioDao userDao;

    private Usuario usuario = new Usuario();

    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public Usuario getUsuario() {
	return usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
	if (usuarios == null || usuarios.isEmpty()) {
	    usuarios = userDao.listAll();
	}
	return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
	this.usuarios = usuarios;
    }

    @Transactional
    public void gravar() {
	usuario.setDataRegistro(Calendar.getInstance());
	if (usuario.getId() != null && usuario.getId() > 0) {
	    userDao.amend(usuario);
	} else {
	    usuario.setId(null);
	    userDao.saveNew(usuario);
	}
	usuario = new Usuario();
    }

    public void cancelar() {
	usuario = new Usuario();
    }

    @Transactional
    public void remover(Usuario usuario) {
	userDao.remove(usuario);
    }
}
