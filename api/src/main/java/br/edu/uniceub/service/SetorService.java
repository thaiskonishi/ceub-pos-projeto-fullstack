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
    SetorRepository setorRepository;

    public List<Setor> getSetoresList() {
        return setorRepository.listAll();
    }

    public Optional<Setor> getSetor(Long id) {
        return null;
    }

    @Transactional
    public Setor insereSetor(Setor setor) {
        try {
            setorRepository.persist(setor);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao persistir o setor: " + setor.toString(), e);
        }
        return setor;
    }

    public Setor alteraSetor(Long id, Setor setor) {
        return null;
    }

    public Setor deleteSetor(Long id) {
        return null;
    }
    
}
