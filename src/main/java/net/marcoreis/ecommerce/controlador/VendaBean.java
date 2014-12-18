package net.marcoreis.ecommerce.controlador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import net.marcoreis.ecommerce.entidades.ItemVenda;
import net.marcoreis.ecommerce.entidades.Produto;
import net.marcoreis.ecommerce.entidades.Venda;
import net.marcoreis.ecommerce.service.ProdutoService;
import net.marcoreis.ecommerce.service.VendaService;

@ManagedBean
@ViewScoped
public class VendaBean extends BaseBean {
    private static final long serialVersionUID = 861905629535769221L;
    private Produto produto;
    private Collection<ItemVenda> itens;
    private Collection<Produto> produtos;
    private Integer quantidade;
    private Double valorUnitario;
    private Double valorTotal;

    @Inject
    private ProdutoService produtoService;
    @Inject
    private VendaService vendaService;

    @PostConstruct
    public void init() {
        logger.info("init");
        produto = new Produto();
        carregarProdutos();
    }

    public void adicionarItem() {
        ItemVenda item = new ItemVenda();
        item.setProduto(getProduto());
        item.setValorUnitario(getValorUnitario());
        item.setValorTotal(getValorTotal());
        getItens().add(item);
        infoMsg("Item adicionado");
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
        if (itens == null) {
            itens = new ArrayList<ItemVenda>();
        }
        return itens;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void salvar() {
        try {
            Venda venda = new Venda();
            venda.setItens(getItens());
            venda.setData(new Date());
            vendaService.salvar(venda);
            infoMsg("Venda gravada com sucesso");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.toString(), e);
            errorMsg(e);
        }
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }
}
