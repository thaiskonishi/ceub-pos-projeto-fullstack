package br.edu.uniceub.repository;

import br.edu.uniceub.models.Ativo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AtivoRepository implements PanacheRepository<Ativo> {
    
        public List<Ativo> listAll(){
        return findAll().list();
    }
}
