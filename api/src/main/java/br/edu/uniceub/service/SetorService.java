package br.edu.uniceub.service;

import java.util.List;
import java.util.Optional;

import br.edu.uniceub.models.Setor;
import br.edu.uniceub.repository.SetorRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;

@Path("/setor")
public class SetorService {

    @Inject
    SetorRepository repository;

    public List<Setor> getSetoresList() {
        return repository.listAll();
    }

    public Optional<Setor> getSetor(Long id) {
        return repository.findByIdOptional(id);
    }

    @Transactional
    public Setor insereSetor(Setor novoSetor) {
        repository.persist(novoSetor);
        return novoSetor;
    }

    @Transactional
    public Setor alteraSetor(Long id, Setor setor) {
        Setor entity = repository.findById(id);
        if (entity != null) {
            entity.setNomeSetor(setor.getNomeSetor());
            entity.setDescricao(setor.getDescricao());
            setor.setId(entity.getId());
            return setor;
        }
        return null;
    }

    @Transactional
    public Setor deleteSetor(Long id) {
        Optional<Setor> optionalSetor = repository.findByIdOptional(id);
        if (optionalSetor.isPresent()) {
            repository.deleteById(id);
            return optionalSetor.get();
        }
        return null;
    }
    
}
