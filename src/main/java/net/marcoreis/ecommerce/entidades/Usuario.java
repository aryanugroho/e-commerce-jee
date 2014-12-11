package net.marcoreis.ecommerce.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

@Cacheable
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "usuario.consultaAcessoDia", query = "from Usuario where cast(ultimoLogin as date) = :data")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1432553426294627255L;
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String nome;
    private Date ultimoLogin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setUltimoLogin(Date ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public Date getUltimoLogin() {
        return ultimoLogin;
    }
}
