package br.edu.uniceub.service;

import java.util.Optional;

import br.edu.uniceub.models.Usuario;
import br.edu.uniceub.repository.UsuarioRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/login")
public class UsuarioService {

    @Inject
    UsuarioRepository repository;

    public Optional<Usuario> findByLogin(String login) {
        return repository.findByLoginOptional(login);
    }

}
