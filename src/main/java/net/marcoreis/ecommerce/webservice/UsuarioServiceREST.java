package net.marcoreis.ecommerce.webservice;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import net.marcoreis.ecommerce.entidades.Usuario;
import net.marcoreis.ecommerce.service.UsuarioService;

@Path("/usuarios")
public class UsuarioServiceREST {
    protected static final Logger logger = Logger
            .getLogger(UsuarioServiceREST.class.getCanonicalName());

    @Inject
    private UsuarioService usuarioService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/email/{email}")
    public Usuario buscarPeloEmail(@PathParam("email") String email) {
        return usuarioService.buscarPeloEmail(email);
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/id/{id}")
    public Usuario buscarPeloId(@PathParam("id") String id) {
        return usuarioService.buscarPeloId(new Long(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Usuario> consultarTodos() {
        return usuarioService.consultarTodos();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(String jsonS) {
        try {
            JSONObject json = new JSONObject(jsonS);
            String nome = json.getString("nome");
            String email = json.getString("email");
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuarioService.inserir(usuario);
            logger.info("JSON -> Objeto inserido com sucesso");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void atualizar(@PathParam("id") String id, String jsonS) {
        try {
            JSONObject json = new JSONObject(jsonS);
            String nome = json.getString("nome");
            String email = json.getString("email");
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setId(Long.parseLong(id));
            usuarioService.atualizar(usuario);
            logger.info("JSON -> Objeto inserido com sucesso");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @DELETE
    @Path("/{id}")
    public void removerPeloId(@PathParam("id") String id) {
        usuarioService.removerPeloId(id);
    }

}
