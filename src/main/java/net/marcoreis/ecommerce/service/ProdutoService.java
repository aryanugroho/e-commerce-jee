package net.marcoreis.ecommerce.service;

import java.util.Collection;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.marcoreis.ecommerce.entidades.Produto;

@Stateless
public class ProdutoService {
    @PersistenceContext(unitName = "e-commerce-pu")
    private EntityManager em;
    private static Logger logger = Logger.getLogger(CategoriaService.class
            .getCanonicalName());

    public Collection<Produto> consultarTodos() {
        return em.createQuery("from Produto").getResultList();
    }

    public Produto consultarPeloId(Long id) {
        return em.find(Produto.class, id);
    }

}
