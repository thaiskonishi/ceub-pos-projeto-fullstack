package br.edu.uniceub.service;

import java.util.List;
import br.edu.uniceub.models.HistoricoCotacao;
import br.edu.uniceub.repository.HistoricoCotacaoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/historico-cotacao")
public class HistoricoCotacaoService {

    @Inject
    HistoricoCotacaoRepository repository;

    public List<HistoricoCotacao> getCotacoesList(Long id) {
        return repository.listAll();
    }
    
}
