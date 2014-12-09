package net.marcoreis.ecommerce.webservice;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.marcoreis.ecommerce.entidades.Usuario;
import net.marcoreis.ecommerce.service.UsuarioService;

import org.apache.log4j.Logger;
import org.json.JSONObject;

@Path("/usuario")
public class UsuarioServiceREST {
    protected static final Logger logger = Logger
            .getLogger(UsuarioServiceREST.class);

    @Inject
    private UsuarioService usuarioService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/buscar-pelo-email/{email}")
    public Usuario buscarPeloEmail(@PathParam("email") String email) {
        return usuarioService.buscarPeloEmail(email);
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/buscar-pelo-id/{id}")
    public Usuario buscarPeloId(@PathParam("id") String id) {
        return usuarioService.buscarPeloId(new Long(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consultarTodos")
    public Collection<Usuario> consultarTodos() {
        return usuarioService.consultarTodos();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/inserir")
    public String inserir(String jsonS) {
        try {
            JSONObject json = new JSONObject(jsonS);
            String nome = json.getString("nome");
            String email = json.getString("email");
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuarioService.salvar(usuario);
            logger.info("JSON -> Objeto gravado com sucesso");
            return "1";
        } catch (Exception e) {
            logger.error(e);
            return "0";
        }
    }
}
