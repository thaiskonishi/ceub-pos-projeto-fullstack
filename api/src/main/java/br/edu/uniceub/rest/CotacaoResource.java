package br.edu.uniceub.rest;

import java.util.List;

import br.edu.uniceub.service.CotacaoService;

@path("/cotacao")
public class CotacaoResource {

    @Inject
    private CotacaoService cotacaoService;

    @GET
    @Path("/lista")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Recupera a lista de cotacoes.", description = "Lista de cotacoes no formato JSON")
    @APIResponse(responseCode = "200", description = "Recupera lista de cotacoes", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Cotacao.class))
    })
    public List<Cotacao> getCotacoes() {
        List<Cotacao> cotacoes = cotacaoService.getCotacoesList();
        return cotacoes;
    }

    @GET
    @Path("/detalhes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Recupera os detalhes de um cotacoes da base de dados.", description = "Apresenta o registro de um cotacoes no formato JSON")
    @APIResponse(responseCode = "200", description = "Recupera o registro de uma cotacao.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Cotacao.class))
    })
    public Response getCotacao(@PathParam("id") Long id) {
        Optional<Cotacao> cotacao = cotacaoService.getCotacao(id);
        if (cotacao.isPresent()) {
            return Response.ok().entity(cotacao).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Insere um cotacao na base de dados.", description = "Inclui um cotacao na base de dados.")
    @APIResponse(responseCode = "201", description = "Inserir cotacao", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Cotacao.class))
    })
    public Response insereCotacao(@Valid CotacaoForm cotacaoForm) {
        Cotacao novaCotacao = cotacaoForm.convertion();
        Cotacao cotacaoCriada = cotacaoService.insereCotacao(novaCotacao);
        if (cotacaoCriada != null) {
            return Response.status(Response.Status.CREATED).entity(novaCotacao).build();
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
            @Content(mediaType = "application/json", schema = @Schema(implementation = Cotacao.class))
    })
    public Response alteraSetor(@PathParam("id") Long id, @Valid CotacaoForm cotacaoForm) {
        Cotacao cotacao = cotacaoService.alteraSetor(id, cotacaoForm.convertion());
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
            @Content(mediaType = "application/json", schema = @Schema(implementation = Cotacao.class))
    })
    public Response deletaSetor(@PathParam("id") Long id) {
        Cotacao cotacao = cotacaoService.deleteCotacao(id);
        if (cotacao != null) {
            return Response.status(Response.Status.OK).entity(cotacao).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
}
