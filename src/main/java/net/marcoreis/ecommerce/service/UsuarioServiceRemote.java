package net.marcoreis.ecommerce.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import net.marcoreis.ecommerce.entidades.Usuario;

@Stateless
public class UsuarioServiceRemote implements UsuarioRemote {
    @Inject
    private UsuarioService usuarioService;

    public String loginValido(String usuario, String senha) {
        System.out.println(usuario);
        return null;
    }

    public Usuario buscarPeloEmail(String email) {
        return usuarioService.buscarPeloEmail(email);
    }

}
