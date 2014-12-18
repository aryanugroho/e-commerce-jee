package net.marcoreis.ecommerce.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import net.marcoreis.ecommerce.entidades.ItemVenda;
import net.marcoreis.ecommerce.entidades.Venda;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteConsultaVendas {

    private EntityManager em;

    @Before
    public void inicializar() {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("e-commerce-pu");
        em = emf.createEntityManager();
    }

    @After
    public void finalizar() {
        em.close();
    }

    @Test
    public void consultarTodasVendas() {
        List<Venda> vendas = em.createQuery("from Venda").getResultList();
        for (Venda v : vendas) {
            System.out.println("===============");
            System.out.println("ID: " + v.getId() + " - " + v.getData());
            //
            String jpql = "from ItemVenda iv where iv.venda = :venda";
            Query query = em.createQuery(jpql);
            query.setParameter("venda", v);
            List<ItemVenda> itens = query.getResultList();
            for (ItemVenda iv : itens) {
                System.out.println(iv.getProduto().getNome() + "["
                        + iv.getQuantidade() + "]");
            }

        }
    }

    public void consultarItens() {
        System.out.println("++++++++++++++++++=");
        List<ItemVenda> itens = em.createQuery("from ItemVenda")
                .getResultList();
        for (ItemVenda iv : itens) {
            try {
                System.out.println("IDV: " + iv.getId());
                System.out.println(iv.getQuantidade());
                System.out.println(iv.getVenda().getId());
            } catch (Exception e) {
            }
        }
    }

}
