package net.marcoreis.ecommerce.service;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.marcoreis.ecommerce.entidades.Categoria;

@Stateless
public class CategoriaService {
    @PersistenceContext(unitName = "e-commerce-pu")
    private EntityManager em;

    public void salvar(Categoria categoria) {
        categoria = em.merge(categoria);
    }

    public Collection<Categoria> consultarTodas() {
        return em.createQuery("from Categoria").getResultList();
    }

    public void excluir(Categoria categoria) {
        categoria = em.merge(categoria);
        em.remove(categoria);
    }

    public List<Categoria> carregarProdutosPorCategoria(Long idCategoria) {
        String hql = "from Produto where categoria.id = :idCategoria";
        Query query = em.createQuery(hql);
        query.setParameter("idCategoria", idCategoria);
        return query.getResultList();
    }

    public Categoria buscarPorId(Long id) {
        return em.find(Categoria.class, id);
    }

}
