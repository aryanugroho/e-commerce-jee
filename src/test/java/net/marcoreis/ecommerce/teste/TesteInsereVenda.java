package net.marcoreis.ecommerce.teste;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.marcoreis.ecommerce.entidades.ItemVenda;
import net.marcoreis.ecommerce.entidades.Venda;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteInsereVenda {
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
        ItemVenda arroz = new ItemVenda();
        arroz.setQuantidade(1);
        ItemVenda feijao = new ItemVenda();
        feijao.setQuantidade(2);

        Venda venda = new Venda();
        venda.setData(new Date());

        em.getTransaction().begin();
        em.persist(venda);
        arroz.setVenda(venda);
        feijao.setVenda(venda);
        em.persist(arroz);
        em.persist(feijao);
        em.getTransaction().commit();
    }
}
