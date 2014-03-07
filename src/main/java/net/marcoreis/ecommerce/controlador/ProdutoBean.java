package net.marcoreis.ecommerce.controlador;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.entidades.Produto;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.primefaces.model.UploadedFile;

@Model
public class ProdutoBean extends BaseBean {
    private static final long serialVersionUID = -6475971812078805662L;
    private static Logger logger = Logger.getLogger(ProdutoBean.class);
    private Produto produto;
    private Collection<Produto> produtos;
    private UploadedFile especificacaoFabricante;

    @PostConstruct
    public void init() {
        produto = new Produto();
        produto.setCategoria(new Categoria());
        carregarProdutos();
    }

    public void carregarProdutos() {
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public Collection<Produto> getProdutos() {
        return produtos;
    }

    public void salvar() {
        try {
            if (getEspecificacaoFabricante() != null) {
                byte[] dados = IOUtils.toByteArray(getEspecificacaoFabricante()
                        .getInputstream());
                getProduto().setEspecificacaoFabricante(dados);
            }
            //
            infoMsg("Dados gravados com sucesso");
        } catch (Exception e) {
            errorMsg(e);
        }
    }

    public void setEspecificacaoFabricante(UploadedFile especificacaoFabricante) {
        this.especificacaoFabricante = especificacaoFabricante;
    }

    public UploadedFile getEspecificacaoFabricante() {
        return especificacaoFabricante;
    }

    public String editar(Produto produto) {
        this.produto = produto;
        return "produto?faces-redirect=true&includeViewParams=true";
    }

    public void excluir(Produto produto) {
        try {
            infoMsg("Produdo excluído: " + produto.getNome());
        } catch (Exception e) {
            errorMsg(e);
        }
    }


}
