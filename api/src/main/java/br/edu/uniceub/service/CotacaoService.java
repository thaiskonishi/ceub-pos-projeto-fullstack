package br.edu.uniceub.service;

import java.util.List;
import java.util.Optional;

import br.edu.uniceub.models.Cotacao;
import jakarta.ws.rs.Path;

@Path("/cotacao")
public class CotacaoService {

    public List<Cotacao> getCotacoesList() {
        return null;
    }

    public Optional<Cotacao> getCotacao(Long id) {
        return null;
    }

    public Cotacao insereCotacao(Cotacao novaCotacao) {
        return null;
    }

    public Cotacao alteraCotacao(Long id, Cotacao cotacao) {
        return null;
    }

    public Cotacao deleteCotacao(Long id) {
        return null;
    }
    
}
