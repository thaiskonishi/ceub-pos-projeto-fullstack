package br.edu.uniceub.rest;

import java.util.List;
import br.edu.uniceub.models.HistoricoCotacao;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import br.edu.uniceub.service.HistoricoCotacaoService;

@Path("/historico-cotacao")
public class HistoricoCotacaoResource {

    @Inject
    private HistoricoCotacaoService historicoCotacaoService;

    @GET
    @Path("/{id_ativo}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Recupera a lista de cotacoes.", description = "Lista de cotacoes no formato JSON")
    @APIResponse(responseCode = "200", description = "Recupera lista de cotacoes", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = HistoricoCotacao.class))
    })
    public List<HistoricoCotacao> getCotacoes(@PathParam("id_ativo") Long id) {
        List<HistoricoCotacao> cotacoes = historicoCotacaoService.getCotacoesList(id);
        return cotacoes;
    }
    
}
