package br.edu.uniceub.repository;

import java.util.List;

import br.edu.uniceub.models.HistoricoCotacao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HistoricoCotacaoRepository implements PanacheRepository<HistoricoCotacao> {

    public List<HistoricoCotacao> findHistoricoByTipoAtivo(Long idTipoAtivo) {
        return find("idAtivo = ?1", idTipoAtivo).list();
    }

}
