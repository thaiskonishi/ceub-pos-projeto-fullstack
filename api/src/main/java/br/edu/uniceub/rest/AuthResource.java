package br.edu.uniceub.rest;

import java.util.Optional;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.mindrot.jbcrypt.BCrypt;
import br.edu.uniceub.form.UsuarioForm;
import br.edu.uniceub.models.Usuario;
import br.edu.uniceub.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/login")
public class AuthResource {

    @Inject
    UsuarioService usuarioService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Autentica um usuário.", description = "Autentica um usuário na aplicação.")
    @APIResponse(responseCode = "200", description = "Usuário autenticado com sucesso!", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioForm.class))
    })
    public Response login(UsuarioForm credenciais) {

        // String hashedPassword = BCrypt.hashpw(credenciais.getPassword(),
        // BCrypt.gensalt());
        // System.out.println("1 - " + hashedPassword);

        Optional<Usuario> usuario = usuarioService.findByLogin(credenciais.getLogin());

        if (usuario.isPresent() && BCrypt.checkpw(credenciais.getPassword(), usuario.get().getPassword())) {
            return Response.status(Response.Status.OK).build();
        }

        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
