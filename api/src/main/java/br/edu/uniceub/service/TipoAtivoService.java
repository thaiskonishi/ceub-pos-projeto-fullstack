package br.edu.uniceub.service;

import java.util.List;
import java.util.Optional;

import br.edu.uniceub.models.TipoAtivo;
import br.edu.uniceub.repository.TipoAtivoRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;

@Path("/tipo-ativo")
public class TipoAtivoService {

    @Inject
    TipoAtivoRepository repository;

    public List<TipoAtivo> getTiposAtivosList() {
        return repository.listAll();
    }

    public Optional<TipoAtivo> getTipoAtivo(Long id) {
        return repository.findByIdOptional(id);
    }

    @Transactional
    public TipoAtivo insereTipoAtivo(TipoAtivo novoTipoAtivo) {
        repository.persist(novoTipoAtivo);
        return novoTipoAtivo;
    }

    @Transactional
    public TipoAtivo alteraTipoAtivo(Long id, TipoAtivo tipoAtivo) {
        TipoAtivo entity = repository.findById(id);
        if (entity != null) {
            entity.setNomeTipoAtivo(tipoAtivo.getNomeTipoAtivo());
            entity.setDescricao(tipoAtivo.getDescricao());
            tipoAtivo.setId(entity.getId());
            return tipoAtivo;
        }
        return null;
    }

    @Transactional
    public TipoAtivo deleteTipoAtivo(Long id) {
        Optional<TipoAtivo> optionalTipoAtivo = repository.findByIdOptional(id);
        if (optionalTipoAtivo.isPresent()) {
            repository.deleteById(id);
            return optionalTipoAtivo.get();
        }
        return null;
    }

}
