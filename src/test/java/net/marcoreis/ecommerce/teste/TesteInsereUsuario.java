package net.marcoreis.ecommerce.teste;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.marcoreis.ecommerce.entidades.Usuario;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteInsereUsuario {

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
    public void inserirUsuario() {
        Usuario usuario = new Usuario();
        usuario.setEmail("ma@marcoreis.net");
        usuario.setNome("Marco Reis");
        Date data = new Date();
        usuario.setUltimoLogin(data);
        em.persist(usuario);
        Assert.assertTrue("Usuário gravado com sucesso", usuario.getId() > 0);
    }
}
