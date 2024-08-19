package br.edu.uniceub.service;

import java.util.List;
import java.util.Optional;

import br.edu.uniceub.models.Cotacao;
import br.edu.uniceub.models.TipoAtivo;
import br.edu.uniceub.repository.TipoAtivoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/tipo-ativo")
public class TipoAtivoService {

    @Inject
    TipoAtivoRepository repository;

    public List<TipoAtivo> getTiposAtivosList() {
        return repository.getTiposAtivos();
    }

    public Optional<TipoAtivo> getTipoAtivo(Long id) {
        return repository.findByIdOptional(id);
    }

    public TipoAtivo insereTipoAtivo(TipoAtivo novoTipoAtivo) {
        repository.persist(novoTipoAtivo);
        return novoTipoAtivo;
    }

    public TipoAtivo alteraTipoAtivo(Long id, TipoAtivo tipoAtivo) {
         TipoAtivo entity = repository.findById(id);
        if (entity != null) {
            repository.isPersistent(tipoAtivo);
        }
        return tipoAtivo;
    }

    public TipoAtivo deleteTipoAtivo(Long id) {
        boolean deletado =  repository.deleteById(id);
        return (deletado) ? repository.findById(id):null;
    }
    
}
