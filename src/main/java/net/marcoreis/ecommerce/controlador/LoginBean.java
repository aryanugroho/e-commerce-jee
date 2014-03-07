package net.marcoreis.ecommerce.controlador;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import net.marcoreis.ecommerce.entidades.Usuario;
import net.marcoreis.ecommerce.service.UsuarioService;

import org.apache.log4j.Logger;

@Named
@SessionScoped
public class LoginBean extends BaseBean {
    private static final long serialVersionUID = 4169068378414919948L;
    protected static final Logger logger = Logger.getLogger(LoginBean.class);
    @Inject
    private UsuarioService usuarioService;

    public String login() {
        try {
            Usuario usuario = usuarioService.buscarPeloEmail(getUsuario()
                    .getEmail());
            if (usuario != null) {
                setUsuario(usuario);
                return "inicio";
            } else {
                errorMsg("Usuário inválido");
                return null;
            }
        } catch (Exception e) {
            errorMsg("Usuário inválido");
            logger.error(e);
            return null;
        }
    }

    @PostConstruct
    public void init() {
        setUsuario(new Usuario());
    }

}
