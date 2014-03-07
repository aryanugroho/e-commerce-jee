package net.marcoreis.ecommerce.controlador;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.service.CategoriaService;

@Model
public class CategoriaBean extends BaseBean {
    private static final long serialVersionUID = 861905629535769221L;
    private Categoria categoria;
    private Collection<Categoria> categorias;
    @Inject
    private CategoriaService categoriaService;

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Collection<Categoria> getCategorias() {
        return categorias;
    }

    @PostConstruct
    public void init() {
        carregarCategorias();
        categoria = new Categoria();
    }

    public void salvar() {
        try {
            categoriaService.salvar(getCategoria());
            infoMsg("Dados gravados com sucesso");
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
}
