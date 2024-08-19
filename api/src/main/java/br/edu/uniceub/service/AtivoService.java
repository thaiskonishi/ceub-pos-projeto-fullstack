package br.edu.uniceub.service;

import java.util.List;
import java.util.Optional;

import br.edu.uniceub.models.Ativo;
import br.edu.uniceub.models.Cotacao;
import br.edu.uniceub.repository.AtivoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/ativo")
public class AtivoService {

    @Inject
    AtivoRepository repository;

    public List<Ativo> getAtivosList() {
        return repository.listAll();
    }

    public Optional<Ativo> getAtivo(Long id) {
        return repository.findByIdOptional(id);
    }

    public Ativo insereAtivo(Ativo novoAtivo) {
        repository.persist(novoAtivo);
        return novoAtivo;
    }

    public Ativo alteraAtivo(Long id, Ativo ativo) {
        Ativo entity = repository.findById(id);
        if (entity != null) {
            repository.isPersistent(ativo);
        }
        return ativo;
    }

    public Ativo deleteAtivo(Long id) {
        boolean deletado =  repository.deleteById(id);
        return (deletado) ? repository.findById(id):null;
    }
    
}
