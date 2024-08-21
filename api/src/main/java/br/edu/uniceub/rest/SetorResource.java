package br.edu.uniceub.rest;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import br.edu.uniceub.dto.SetorDto;
import br.edu.uniceub.form.SetorForm;
import br.edu.uniceub.models.Setor;
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
import br.edu.uniceub.service.SetorService;

@Path("/setor")
public class SetorResource {

    @Inject
    private SetorService setorService;

    @GET
    @Path("/lista")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Recupera a lista de setores.", description = "Lista de setores no formato JSON")
    @APIResponse(responseCode = "200", description = "Recupera lista de setores", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = SetorDto.class))
    })
    public List<SetorDto> getSetores() {
        List<Setor> setores = setorService.getSetoresList();
        return SetorDto.convertion(setores);
    }

    @GET
    @Path("/detalhes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Recupera os detalhes de um setores da base de dados.", description = "Apresenta o registro de um setores no formato JSON")
    @APIResponse(responseCode = "200", description = "Recupera o registro de um setor.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = SetorDto.class))
    })
    public Response getSetor(@PathParam("id") Long id) {
        Optional<Setor> setor = setorService.getSetor(id);
        if (setor.isPresent()) {
            return Response.ok().entity(new SetorDto(setor.get())).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Insere um setor na base de dados.", description = "Inclui um setor na base de dados.")
    @APIResponse(responseCode = "201", description = "Inserir setor", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = SetorDto.class))
    })
    public Response insereSetor(@Valid SetorForm setorForm) {
        Setor novoSetor = setorForm.convertion();
        Setor setorCriado = setorService.insereSetor(novoSetor);
        if (setorCriado != null) {
            return Response.status(Response.Status.CREATED).entity(new SetorDto(novoSetor)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Altera um setor na base de dados.", description = "Altera um setor na base de dados.")
    @APIResponse(responseCode = "200", description = "Alterar um setor.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = SetorDto.class))
    })
    public Response alteraSetor(@PathParam("id") Long id, @Valid SetorForm setorForm) {
        Setor setor = setorService.alteraSetor(id, setorForm.convertion());
        if (setor != null) {
            return Response.status(Response.Status.OK).entity(new SetorDto(setor)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Deleta um setor da base de dados.", description = "Deleta um setor da base de dados.")
    @APIResponse(responseCode = "200", description = "Deletar setor.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = SetorDto.class))
    })
    public Response deletaSetor(@PathParam("id") Long id) {
        Setor setor = setorService.deleteSetor(id);
        if (setor != null) {
            return Response.status(Response.Status.OK).entity(new SetorDto(setor)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
