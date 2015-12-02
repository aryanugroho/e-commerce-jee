package net.marcoreis.ecommerce.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class CarrinhoDeCompraService {

    @EJB
    private ProdutoService produtoService;

    public void adicionarProduto() {
        //
    }
}
