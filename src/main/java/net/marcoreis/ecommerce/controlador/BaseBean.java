package net.marcoreis.ecommerce.controlador;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import net.marcoreis.ecommerce.entidades.Usuario;

public class BaseBean implements Serializable {
    private static final long serialVersionUID = -5895396595360064610L;
    protected static Logger logger = Logger.getLogger(BaseBean.class
            .getCanonicalName());
    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    protected void infoMsg(String message) {
        FacesMessage msg = new FacesMessage(message);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    protected void errorMsg(Throwable t) {
        logger.log(Level.SEVERE, t.getMessage());
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                t.getMessage(), "Erro");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    protected void errorMsg(String message) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                message, "Erro");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String getParametro(String parametro) {
        return FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get(parametro);
    }

}
