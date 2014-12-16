package net.marcoreis.ecommerce.controlador;

import java.util.Collection;
import java.util.logging.Level;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.entidades.Produto;
import net.marcoreis.ecommerce.service.ProdutoService;

@ManagedBean
@ViewScoped
public class ProdutoBean extends BaseBean {
    private static final long serialVersionUID = 6953446470230636484L;
    private Produto produto;
    private Collection<Produto> produtos;
    @Inject
    private ProdutoService produtoService;

    @PostConstruct
    public void init() {
        carregarProdutos();
        produto = new Produto();
        produto.setCategoria(new Categoria());
    }

    public Collection<Produto> getProdutos() {
        return produtos;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void salvar() {
        try {
            produtoService.salvar(getProduto());
            String msg = "Dados gravados com sucesso";
            infoMsg(msg);
            logger.log(Level.INFO, msg);
        } catch (Exception e) {
            errorMsg(e);
        }
    }

    public void carregarProdutos() {
        produtos = produtoService.consultarTodos();
    }

    public String editar(Produto produto) {
        this.produto = produto;
        return "produto";
    }

}
