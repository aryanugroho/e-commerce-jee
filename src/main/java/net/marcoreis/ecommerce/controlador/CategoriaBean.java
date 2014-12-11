package net.marcoreis.ecommerce.controlador;

import java.util.Collection;
import java.util.logging.Level;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.service.CategoriaService;

@Model
public class CategoriaBean extends BaseBean {
    private static final long serialVersionUID = 861905629535769221L;
    private Categoria categoria;
    private Collection<Categoria> categorias;
    @Inject
    private CategoriaService categoriaService;

    @PostConstruct
    public void init() {
        carregarCategorias();
        categoria = new Categoria();
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Collection<Categoria> getCategorias() {
        return categorias;
    }

    public void salvar() {
        try {
            categoriaService.salvar(getCategoria());
            String msg = "Dados gravados com sucesso";
            infoMsg(msg);
            logger.log(Level.INFO, msg);
        } catch (Exception e) {
            errorMsg(e);
        }
    }

    public void carregarCategorias() {
        categorias = categoriaService.consultarTodas();
    }

    public String editar(Categoria categoria) {
        this.categoria = categoria;
        return "categoria";
    }

    public void excluir(Categoria categoria) {
        try {
            categoriaService.excluir(categoria);
            carregarCategorias();
            infoMsg("Categoria excluída: " + categoria.getDescricao());
        } catch (Exception e) {
            errorMsg(e);
        }
    }

    // public void salvarJms() {
    // try {
    // categoriaService.salvarJms(getCategoria());
    // infoMsg("Dados gravados com JMS");
    // } catch (Exception e) {
    // errorMsg(e);
    // }
    // }
}
