package net.marcoreis.ecommerce.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.marcoreis.ecommerce.entidades.Cliente;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteInsereCliente {
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
    public void inserirCliente() {
        Cliente cliente = new Cliente();
        cliente.setEmail("jose@oracle.com");
        cliente.setNome("Jose Carlos");
        cliente.setCpfCnpj("1234568");
        em.persist(cliente);
        Assert.assertTrue("Cliente gravado com sucesso", cliente.getId() > 0);
    }

}
