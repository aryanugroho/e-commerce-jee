package net.marcoreis.ecommerce.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.marcoreis.ecommerce.entidades.Usuario;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteRemoveUsuario {

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
    public void removerUsuario() {
        Long id = 5l;
        Usuario usuario = em.find(Usuario.class, id);
        Assert.assertNotNull("Usuario não cadastrado", usuario);
        em.remove(usuario);
    }
}
