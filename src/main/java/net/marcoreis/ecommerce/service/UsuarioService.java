package net.marcoreis.ecommerce.service;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.marcoreis.ecommerce.entidades.Usuario;

@Stateless
public class UsuarioService {
    @PersistenceContext(unitName = "e-commerce-pu")
    private EntityManager em;

    public Usuario buscarPeloId(Long id) {
        return em.find(Usuario.class, id);
    }

    public Usuario buscarPeloEmail(String email) {
        String hql = "from Usuario u where u.email = :email";
        Query query = em.createQuery(hql);
        query.setParameter("email", email);
        List<Usuario> usuarios = query.getResultList();
        Usuario usuario = usuarios.get(0);
        return usuario;
    }

    public Collection<Usuario> consultarTodos() {
        return em.createQuery("from Usuario").getResultList();
    }

    public void salvar(Usuario usuario) {
        em.merge(usuario);
    }

}
