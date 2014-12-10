package net.marcoreis.ecommerce.messaging;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.service.CategoriaService;

@MessageDriven(mappedName = "CategoriaMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/Categoria"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class CategoriaListener implements MessageListener {
    private static Logger logger = Logger.getLogger(CategoriaListener.class
            .getCanonicalName());

    @Inject
    private CategoriaService categoriaService;

    public void onMessage(Message message) {
        try {
            MapMessage valores = (MapMessage) message;
            Categoria categoria = new Categoria();
            categoria.setDescricao(valores.getString("descricao"));
            categoria.setNome(valores.getString("nome"));
            if (valores.getString("nome").equals("Nome 2")) {
                throw new RuntimeException("Transacao desfeita");
            }
            categoriaService.salvar(categoria);
            logger.info("Dados gravados pelo MDB");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }
}
