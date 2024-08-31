package br.edu.uniceub.repository;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

import br.edu.uniceub.models.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

    public Optional<Usuario> findByLoginOptional(String login) {
        return find("login", login).firstResultOptional();
    }

}
