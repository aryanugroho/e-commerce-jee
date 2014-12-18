package net.marcoreis.ecommerce.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.marcoreis.ecommerce.entidades.ItemVenda;
import net.marcoreis.ecommerce.entidades.Venda;

@Stateless
public class VendaService {
    @PersistenceContext(unitName = "e-commerce-pu")
    private EntityManager em;

    public Venda salvar(Venda venda) {
        return em.merge(venda);
    }

    public void salvar(ItemVenda item) {
        em.merge(item);
    }
}
