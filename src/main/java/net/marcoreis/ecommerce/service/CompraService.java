package net.marcoreis.ecommerce.service;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
@Interceptors(CompraInterceptor.class)
public class CompraService implements CompraLocal {

    public void comprar() {
        // Finalizar a compra
    }
}
