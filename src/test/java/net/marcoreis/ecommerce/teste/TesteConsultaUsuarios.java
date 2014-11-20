package net.marcoreis.ecommerce.teste;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import net.marcoreis.ecommerce.entidades.Usuario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteConsultaUsuarios {

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
    public void consultaTodosUsuarios() {
        String queryJPA = "from Usuario";
        Query query = em.createQuery(queryJPA);
        List<Usuario> usuarios = query.getResultList();
        System.out.println("================== JPQL ===================");
        for (Usuario usuario : usuarios) {
            System.out.println("Nome: " + usuario.getNome() + " ("
                    + usuario.getEmail() + ")");
        }
    }

    @Test
    public void consultaUsuriosAcessoDia() {
        Query query = em.createNamedQuery("usuario.consultaAcessoDia");
        query.setParameter("data", new Date());
        List<Usuario> usuarios = query.getResultList();
        System.out.println("================== NamedQuery ===================");
        for (Usuario usuario : usuarios) {
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Ultimo login: " + usuario.getUltimoLogin());
            System.out.println();
        }
        System.out.println("=====================================");
    }
}
