package br.edu.uniceub.service;

import java.util.List;
import java.util.Optional;

import br.edu.uniceub.models.TipoAtivo;
import jakarta.ws.rs.Path;

@Path("/tipo-ativo")
public class TipoAtivoService {

    public List<TipoAtivo> getTiposAtivosList() {
        return null;
    }

    public Optional<TipoAtivo> getTipoAtivo(Long id) {
        return null;
    }

    public TipoAtivo insereTipoAtivo(TipoAtivo novoTipoAtivo) {
        return null;
    }

    public TipoAtivo alteraTipoAtivo(Long id, TipoAtivo tipoAtivo) {
        return null;
    }

    public TipoAtivo deleteTipoAtivo(Long id) {
        return null;
    }
    
}
