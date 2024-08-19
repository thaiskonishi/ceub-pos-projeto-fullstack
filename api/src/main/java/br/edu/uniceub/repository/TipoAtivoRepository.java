package br.edu.uniceub.repository;

import br.edu.uniceub.models.TipoAtivo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoAtivoRepository implements PanacheRepository<TipoAtivo> {

}
