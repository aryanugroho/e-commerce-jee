package net.marcoreis.ecommerce.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.marcoreis.ecommerce.entidades.Categoria;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteInsereCategoria {

    private EntityManager em;

    @Before
    public void inicializar() {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("e-commerce-pu");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @After
    public void finalizar() {
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void consultarTodasCategorias() {
        Categoria c = new Categoria();
        c.setDescricao("Utensílios domésticos para cama, mesa e banho");
        c.setNome("Cama, mesa e banho");
        em.persist(c);
    }
}
