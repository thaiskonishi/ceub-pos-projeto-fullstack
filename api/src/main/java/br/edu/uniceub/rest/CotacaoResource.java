package br.edu.uniceub.rest;

import java.util.List;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import br.edu.uniceub.dto.CotacaoDto;
import br.edu.uniceub.form.CotacaoForm;
import br.edu.uniceub.models.Cotacao;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import br.edu.uniceub.service.CotacaoService;

@Path("/cotacao")
public class CotacaoResource {

    @Inject
    private CotacaoService cotacaoService;

    @GET
    @Path("/lista")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Recupera a lista de cotacoes.", description = "Lista de cotacoes no formato JSON")
    @APIResponse(responseCode = "200", description = "Recupera lista de cotacoes", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = CotacaoDto.class))
    })
    public List<CotacaoDto> getCotacoes() {
        return cotacaoService.getCotacoesList();
    }

    @GET
    @Path("/detalhes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Recupera os detalhes de um cotacoes da base de dados.", description = "Apresenta o registro de um cotacoes no formato JSON")
    @APIResponse(responseCode = "200", description = "Recupera o registro de uma cotacao.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = CotacaoDto.class))
    })
    public Response getCotacao(@PathParam("id") Long id) {
        CotacaoDto cotacao = cotacaoService.getCotacao(id);
        if (cotacao != null) {
            return Response.ok().entity(cotacao).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Insere um cotacao na base de dados.", description = "Inclui um cotacao na base de dados.")
    @APIResponse(responseCode = "201", description = "Inserir cotacao", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = CotacaoDto.class))
    })
    public Response insereCotacao(@Valid CotacaoForm cotacaoForm) {
        Cotacao novaCotacao = cotacaoForm.convertion();
        CotacaoDto cotacaoCriada = cotacaoService.insereCotacao(novaCotacao);
        if (cotacaoCriada != null) {
            return Response.status(Response.Status.CREATED).entity(cotacaoCriada).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Altera um cotacao na base de dados.", description = "Altera um cotacao na base de dados.")
    @APIResponse(responseCode = "200", description = "Alterar um cotacao.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = CotacaoDto.class))
    })
    public Response alteraCotacao(@PathParam("id") Long id, @Valid CotacaoForm cotacaoForm) {
        CotacaoDto cotacao = cotacaoService.alteraCotacao(id, cotacaoForm.convertion());
        if (cotacao != null) {
            return Response.status(Response.Status.OK).entity(cotacao).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Deleta um cotacao da base de dados.", description = "Deleta um cotacao da base de dados.")
    @APIResponse(responseCode = "200", description = "Deletar cotacao.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = CotacaoDto.class))
    })
    public Response deletaCotacao(@PathParam("id") Long id) {
        CotacaoDto cotacao = cotacaoService.deleteCotacao(id);
        if (cotacao != null) {
            return Response.status(Response.Status.OK).entity(cotacao).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
