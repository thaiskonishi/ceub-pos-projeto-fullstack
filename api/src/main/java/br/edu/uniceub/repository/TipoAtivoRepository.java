package br.edu.uniceub.repository;

import java.util.List;

import br.edu.uniceub.models.TipoAtivo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoAtivoRepository implements PanacheRepository<TipoAtivo> {

    public List<TipoAtivo> getTiposAtivos() {
        return findAll().list();
    }

}
