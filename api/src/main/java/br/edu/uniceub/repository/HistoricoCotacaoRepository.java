package br.edu.uniceub.repository;

import br.edu.uniceub.models.HistoricoCotacao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HistoricoCotacaoRepository implements PanacheRepository<HistoricoCotacao>{
    
}
