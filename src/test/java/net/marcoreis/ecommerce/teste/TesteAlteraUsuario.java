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

public class TesteAlteraUsuario {

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
    public void alterarUsuario() {
        Long id = 2l;
        System.out.println("Alterando o usuario com ID = " + id);
        Usuario usuario = em.find(Usuario.class, id);
        Assert.assertNotNull("Usuario não cadastrado", usuario);
        usuario.setEmail("diego@lucas.net");
        usuario.setNome("Diego Lucas");
        Date data = new Date();
        usuario.setUltimoLogin(data);
        em.persist(usuario);
    }
}
