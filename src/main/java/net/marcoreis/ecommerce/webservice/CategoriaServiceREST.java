package net.marcoreis.ecommerce.webservice;

import java.util.Collection;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.service.CategoriaService;

@Path("/categoria")
public class CategoriaServiceREST {
    protected static final Logger logger = Logger
            .getLogger(CategoriaServiceREST.class.getCanonicalName());

    @Inject
    private CategoriaService categoriaService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/consultarTodas")
    public Collection<Categoria> ConsultarTodas() {
        return categoriaService.consultarTodas();
    }

}
