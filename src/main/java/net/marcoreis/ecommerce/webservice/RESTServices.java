package net.marcoreis.ecommerce.webservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("servicos-rest")
public class RESTServices extends Application {
    private Set<Object> singletons = new HashSet();
    private Set<Class<?>> classes = new HashSet();

    public RESTServices() {
        // this.singletons.add(new UsuarioServiceREST());
        classes.add(UsuarioServiceREST.class);
    }

    public Set<Class<?>> getClasses() {
        return this.classes;
    }

    public Set<Object> getSingletons() {
        return this.singletons;
    }
}
