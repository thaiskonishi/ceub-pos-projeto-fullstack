package br.edu.uniceub.rest;

import java.util.List;

import br.edu.uniceub.models.TipoAtivo;
import br.edu.uniceub.service.TipoAtivoService;

@path("/tipo-ativo")
public class TipoAtivoResource {

    @Inject
    private TipoAtivoService tipoAtivoService;

    @GET
    @Path("/lista")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Recupera a lista de tipos de ativo.", description = "Lista de tipos de ativo no formato JSON")
    @APIResponse(responseCode = "200", description = "Recupera lista de tipos de ativos", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = TipoAtivo.class))
    })
    public List<TipoAtivo> getTiposAtivos() {
        List<TipoAtivo> tiposAtivos = tipoAtivoService.getTiposAtivosList();
        return tiposAtivos;
    }

    @GET
    @Path("/detalhes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Recupera os detalhes de um tipos de ativo da base de dados.", description = "Apresenta o registro de um tipos de ativo no formato JSON")
    @APIResponse(responseCode = "200", description = "Recupera o registro de um tipos de ativo", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = TipoAtivo.class))
    })
    public Response getTipoAtivo(@PathParam("id") Long id) {
        Optional<TipoAtivo> tipoAtivo = tipoAtivoService.getTipoAtivo(id);
        if (tipoAtivo.isPresent()) {
            return Response.ok().entity(tipoAtivo).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Insere um tipo de ativo na base de dados.", description = "Inclui um tipo de ativo na base de dados.")
    @APIResponse(responseCode = "201", description = "Inserir tipo de ativo", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = TipoAtivo.class))
    })
    public Response insereTipoAtivo(@Valid TipoAtivoForm tipoAtivoForm) {
        TipoAtivo novoTipoAtivo = tipoAtivoForm.convertion();
        TipoAtivo tipoAtivoCriado = tipoAtivoService.insereTipoAtivo(novoTipoAtivo);
        if (tipoAtivoCriado != null) {
            return Response.status(Response.Status.CREATED).entity(novoTipoAtivo).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Altera um tipo de ativo na base de dados.", description = "Altera um tipo de ativo na base de dados.")
    @APIResponse(responseCode = "200", description = "Alterar um tipo de ativo.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = TipoAtivo.class))
    })
    public Response alteraTipoAtivo(@PathParam("id") Long id, @Valid TipoAtivoForm tipoAtivoForm) {
        TipoAtivo tipoAtivo = tipoAtivoService.alteraTipoAtivo(id, tipoAtivoForm.convertion());
        if (tipoAtivo != null) {
            return Response.status(Response.Status.OK).entity(tipoAtivo).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Deleta um tipo de ativo da base de dados.", description = "Deleta um tipo de ativo da base de dados.")
    @APIResponse(responseCode = "200", description = "Deletar tipo de ativo.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = TipoAtivo.class))
    })
    public Response deletaTipoAtivo(@PathParam("id") Long id) {
        TipoAtivo tipoAtivo = tipoAtivoService.deleteTipoAtivo(id);
        if (tipoAtivo != null) {
            return Response.status(Response.Status.OK).entity(tipoAtivo).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
