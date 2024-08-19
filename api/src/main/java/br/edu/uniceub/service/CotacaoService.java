package br.edu.uniceub.service;

import java.util.List;
import java.util.Optional;

import br.edu.uniceub.models.Cotacao;
import br.edu.uniceub.repository.CotacaoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/cotacao")
public class CotacaoService {

    @Inject
    CotacaoRepository repository;

    public List<Cotacao> getCotacoesList() {
        return repository.listAll();
    }

    public Optional<Cotacao> getCotacao(Long id) {
        return repository.findByIdOptional(id);
    }

    public Cotacao insereCotacao(Cotacao novaCotacao) {
        repository.persist(novaCotacao);
        return novaCotacao;
    }

    public Cotacao alteraCotacao(Long id, Cotacao cotacao) {
        Cotacao entity = repository.findById(id);
        if (entity != null) {
            repository.isPersistent(cotacao);
        }
        return cotacao;
    }

    public Cotacao deleteCotacao(Long id) {
        boolean deletado =  repository.deleteById(id);
        return (deletado) ? repository.findById(id):null;
    }
    
}
