package br.edu.uniceub.rest;

import java.util.List;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import br.edu.uniceub.dto.AtivoDto;
import br.edu.uniceub.form.AtivoForm;
import br.edu.uniceub.models.Ativo;
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

import br.edu.uniceub.service.AtivoService;

@Path("/ativo")
public class AtivoResource {

    @Inject
    private AtivoService ativoService;

    @GET
    @Path("/lista")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Recupera a lista de ativos.", description = "Lista de ativos no formato JSON")
    @APIResponse(responseCode = "200", description = "Recupera lista de ativos", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = AtivoDto.class))
    })
    public List<AtivoDto> getAtivos() {
        return ativoService.getAtivosList();
    }

    @GET
    @Path("/detalhes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Recupera os detalhes de um ativo da base de dados.", description = "Apresenta o registro de um ativo no formato JSON")
    @APIResponse(responseCode = "200", description = "Recupera o registro de um ativo.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = AtivoDto.class))
    })
    public Response getAtivo(@PathParam("id") Long id) {
        AtivoDto ativo = ativoService.getAtivo(id);
        if (ativo != null) {
            return Response.ok().entity(ativo).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Insere um ativo na base de dados.", description = "Inclui um ativo na base de dados.")
    @APIResponse(responseCode = "201", description = "Inserir ativo", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = AtivoDto.class))
    })
    public Response insereAtivo(@Valid AtivoForm ativoForm) {
        Ativo novoAtivo = ativoForm.convertion();
        AtivoDto ativoCriado = ativoService.insereAtivo(novoAtivo);
        if (ativoCriado != null) {
            return Response.status(Response.Status.CREATED).entity(ativoCriado).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Altera um ativo na base de dados.", description = "Altera um ativo na base de dados.")
    @APIResponse(responseCode = "200", description = "Alterar um ativo.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = AtivoDto.class))
    })
    public Response alteraAtivo(@PathParam("id") Long id, @Valid AtivoForm ativoForm) {
        AtivoDto ativo = ativoService.alteraAtivo(id, ativoForm.convertion());
        if (ativo != null) {
            return Response.status(Response.Status.OK).entity(ativo).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Deleta um ativo da base de dados.", description = "Deleta um ativo da base de dados.")
    @APIResponse(responseCode = "200", description = "Deletar ativo.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = AtivoDto.class))
    })
    public Response deletaSetor(@PathParam("id") Long id) {
        AtivoDto ativo = ativoService.deleteAtivo(id);
        if (ativo != null) {
            return Response.status(Response.Status.OK).entity(ativo).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
}
