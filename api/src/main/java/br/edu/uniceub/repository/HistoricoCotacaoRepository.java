package br.edu.uniceub.repository;

import br.edu.uniceub.models.HistoricoCotacao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;

public class HistoricoCotacaoRepository implements PanacheRepository<HistoricoCotacao>{
    
        public List<HistoricoCotacao> listAll(){
        return findAll().list();
    }
}
