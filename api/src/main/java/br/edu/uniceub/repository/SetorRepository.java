package br.edu.uniceub.repository;

import java.util.List;
import br.edu.uniceub.models.Setor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SetorRepository implements PanacheRepository<Setor> {

    public List<Setor> listAll(){
        return findAll().list();
    }
    
}
