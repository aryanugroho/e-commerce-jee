package net.marcoreis.ecommerce.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.entidades.Produto;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteInsereProduto {

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
    public void inserirProduto() {
        Long idCategoria = 1l;
        Categoria categoria = em.find(Categoria.class, idCategoria);
        Assert.assertNotNull("Categoria não cadastrada", categoria);
        Produto produto = new Produto();
        produto.setCategoria(categoria);
        produto.setDescricao("Colcha para cama de solteiro 120cm x 210cm");
        produto.setNome("Colcha para cama de solteiro");
        produto.setPreco(150.00);
        em.persist(produto);
    }
}
