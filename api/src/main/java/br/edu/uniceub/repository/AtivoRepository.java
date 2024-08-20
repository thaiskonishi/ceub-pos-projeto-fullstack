package br.edu.uniceub.repository;

import br.edu.uniceub.models.Ativo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AtivoRepository implements PanacheRepository<Ativo> {

}
