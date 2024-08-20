package br.edu.uniceub.form;

import br.edu.uniceub.models.Setor;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SetorForm {

    @NotNull(message = "O nome não pode ser vazio!")
    private String nomeSetor;
    @NotNull(message = "O nome não pode ser vazio!")
    private String descricao;

    public Setor convertion() {
        return new Setor(nomeSetor, descricao);
    }
    
}
