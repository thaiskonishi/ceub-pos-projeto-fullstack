package br.edu.uniceub.form;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioForm {

    @NotNull(message = "O login do usuário deve ser preenchido!")
    private String login;
    @NotNull(message = "A senha do ususário não pode estar vazia!")
    private String password;

}
