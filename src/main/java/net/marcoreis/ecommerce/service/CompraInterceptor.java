package net.marcoreis.ecommerce.service;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class CompraInterceptor {
    @AroundInvoke
    public Object auditoria(InvocationContext ctx) throws Exception {
        String msg = "Fazendo auditoria da operação";
        System.out.println(msg);
        return ctx.proceed();
    }
}
