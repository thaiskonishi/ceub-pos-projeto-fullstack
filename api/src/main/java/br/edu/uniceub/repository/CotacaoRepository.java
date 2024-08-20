package br.edu.uniceub.repository;

import br.edu.uniceub.models.Cotacao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CotacaoRepository implements PanacheRepository<Cotacao> {

}
