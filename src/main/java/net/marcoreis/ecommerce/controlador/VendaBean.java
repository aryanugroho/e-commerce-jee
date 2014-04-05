package net.marcoreis.ecommerce.controlador;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import net.marcoreis.ecommerce.entidades.ItemVenda;
import net.marcoreis.ecommerce.entidades.Produto;
import net.marcoreis.ecommerce.service.ProdutoService;

@Model
@SessionScoped
public class VendaBean extends BaseBean {
    private static final long serialVersionUID = 861905629535769221L;
    private Produto produto;
    private Collection<ItemVenda> itens;
    private Collection<Produto> produtos;
    @Inject
    private ProdutoService produtoService;

    @PostConstruct
    public void init() {
        produto = new Produto();
        itens = new ArrayList<ItemVenda>();
        carregarProdutos();
    }

    public void adicionarItem() {
        ItemVenda item = new ItemVenda();
        item.setProduto(getProduto());
        getItens().add(item);
    }

    public void carregarProdutos() {
        produtos = produtoService.consultarTodos();
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProdutos(Collection<Produto> produtos) {
        this.produtos = produtos;
    }

    public Collection<Produto> getProdutos() {
        return produtos;
    }

    public void setItens(Collection<ItemVenda> itens) {
        this.itens = itens;
    }

    public Collection<ItemVenda> getItens() {
        return itens;
    }
}
