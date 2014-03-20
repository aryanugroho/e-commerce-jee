package net.marcoreis.ecommerce.messaging;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.service.CategoriaService;

import org.apache.log4j.Logger;

@MessageDriven(mappedName = "jms/CategoriaQueue", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/queue/test"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class CategoriaListener implements MessageListener {
    private static Logger logger = Logger.getLogger(CategoriaListener.class);
    @Inject
    private CategoriaService categoriaService;

    public void onMessage(Message message) {
        try {
            MapMessage valores = (MapMessage) message;
            Categoria categoria = new Categoria();
            categoria.setDescricao(valores.getString("descricao"));
            categoria.setNome(valores.getString("nome"));
            categoriaService.salvar(categoria);
        } catch (Exception e) {
            logger.error(e);
        }
    }
}
