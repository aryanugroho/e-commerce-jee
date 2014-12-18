package net.marcoreis.ecommerce.service;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.entidades.Produto;

@Stateless
public class CategoriaService {
    @PersistenceContext(unitName = "e-commerce-pu")
    private EntityManager em;
    private static Logger logger = Logger.getLogger(CategoriaService.class
            .getCanonicalName());

    // @Resource(mappedName = "java:/ConnectionFactory")
    // private ConnectionFactory factory;
    // @Resource(mappedName = "java:/queue/test")
    // private Queue queue;

    public Categoria salvar(Categoria categoria) {
        return em.merge(categoria);
    }

    public Collection<Categoria> consultarTodas() {
        return em.createQuery("from Categoria").getResultList();
    }

    public void excluir(Categoria categoria) {
        categoria = em.merge(categoria);
        em.remove(categoria);
    }

    public List<Produto> carregarProdutosPorCategoria(Long idCategoria) {
        String hql = "from Produto where categoria.id = :idCategoria";
        Query query = em.createQuery(hql);
        query.setParameter("idCategoria", idCategoria);
        return query.getResultList();
    }

    public Categoria buscarPorId(Long id) {
        return em.find(Categoria.class, id);
    }

    // public void salvarJms(Categoria categoria) {
    // Session session = null;
    // try {
    // Connection connection = factory.createConnection();
    // session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
    // //
    // MessageProducer producer = session.createProducer(queue);
    // MapMessage message = session.createMapMessage();
    // message.setString("nome", categoria.getNome());
    // message.setString("descricao", categoria.getDescricao());
    // producer.send(message);
    // session.commit();
    // if (!session.getTransacted()) {
    // throw new RuntimeException("Erro jms");
    // }
    // } catch (Exception e) {
    // try {
    // session.rollback();
    // } catch (JMSException e1) {
    // e1.printStackTrace();
    // }
    // logger.error(e);
    // throw new RuntimeException(e);
    // }
    // }

}
