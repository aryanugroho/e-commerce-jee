package net.marcoreis.ecommerce.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ContaCorrenteService {

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void gravar() {
        //
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void excluir() {
        //
    }
}
