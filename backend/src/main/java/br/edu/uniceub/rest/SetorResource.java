package br.edu.uniceub.rest;

import br.edu.uniceub.service.SetorService;

@path("/setor")
public class SetorResource {

    @Inject
    private SetorService setorService;

    @GET
    @Path("/lista")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Recupera a lista de setores.", description = "Lista de setores no formato JSON")
    @APIResponse(responseCode = "200", description = "Recupera lista de setores", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Setor.class))
    })
    public List<Setor> getSetores() {
        List<Setor> setores = setorService.getSetoresList();
        return setores;
    }

    @GET
    @Path("/detalhes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Recupera os detalhes de um setores da base de dados.", description = "Apresenta o registro de um setores no formato JSON")
    @APIResponse(responseCode = "200", description = "Recupera o registro de um setor.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Setor.class))
    })
    public Response getSetor(@PathParam("id") Long id) {
        Optional<Setor> setor = setorService.getSetor(id);
        if (Setor.isPresent()) {
            return Response.ok().entity(setor).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Insere um setor na base de dados.", description = "Inclui um setor na base de dados.")
    @APIResponse(responseCode = "201", description = "Inserir setor", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Setor.class))
    })
    public Response insereSetor(@Valid SetorForm SetorForm) {
        Setor novoSetor = SetorForm.convertion();
        Setor setorCriado = setorService.insereSetor(novoSetor);
        if (setorCriado != null) {
            return Response.status(Response.Status.CREATED).entity(novoSetor).build();
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
            @Content(mediaType = "application/json", schema = @Schema(implementation = Setor.class))
    })
    public Response alteraSetor(@PathParam("id") Long id, @Valid SetorForm SetorForm) {
        Setor setor = setorService.alteraSetor(id, SetorForm.convertion());
        if (setor != null) {
            return Response.status(Response.Status.OK).entity(setor).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Deleta um setor da base de dados.", description = "Deleta um setor da base de dados.")
    @APIResponse(responseCode = "200", description = "Deletar setor.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Setor.class))
    })
    public Response deletaSetor(@PathParam("id") Long id) {
        Setor setor = setorService.deleteSetor(id);
        if (setor != null) {
            return Response.status(Response.Status.OK).entity(setor).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
}
