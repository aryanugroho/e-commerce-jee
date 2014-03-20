package net.marcoreis.ecommerce.service;

import javax.ejb.Remote;

import net.marcoreis.ecommerce.entidades.Usuario;

@Remote
public interface UsuarioRemote {
    public String loginValido(String usuario, String senha);

    public Usuario buscarPeloEmail(String email);
}
