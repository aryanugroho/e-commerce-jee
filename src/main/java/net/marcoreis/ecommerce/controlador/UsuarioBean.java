package net.marcoreis.ecommerce.controlador;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import net.marcoreis.ecommerce.entidades.Usuario;
import net.marcoreis.ecommerce.service.UsuarioService;

@Model
public class UsuarioBean extends BaseBean {
    private static final long serialVersionUID = -2658024901938874346L;
    private Usuario usuario;
    private Collection<Usuario> usuarios;
    @Inject
    private UsuarioService usuarioService;

    @PostConstruct
    public void init() {
        carregarUsuarios();
        usuario = new Usuario();
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void salvar() {
        try {
            infoMsg("Dados gravados com sucesso");
        } catch (Exception e) {
            errorMsg(e);
        }
    }

    public void carregarUsuarios() {
        usuarios = usuarioService.consultarTodos();
    }

    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
