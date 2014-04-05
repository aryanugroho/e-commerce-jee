package net.marcoreis.ecommerce.webservice;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.marcoreis.ecommerce.entidades.Categoria;
import net.marcoreis.ecommerce.service.CategoriaService;

import org.apache.log4j.Logger;

@Path("/categoria")
public class CategoriaServiceREST {
    protected static final Logger logger = Logger
            .getLogger(CategoriaServiceREST.class);

    @Inject
    private CategoriaService categoriaService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/consultarTodas")
    public Collection<Categoria> ConsultarTodas() {
        return categoriaService.consultarTodas();
    }

}
