package br.edu.uniceub.form;

import br.edu.uniceub.models.TipoAtivo;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TipoAtivoForm {

    @NotNull(message = "O nome não pode ser vazio!")
    private String nomeTipoAtivo;
    @NotNull(message = "O nome não pode ser vazio!")
    private String descricao;

    public TipoAtivo convertion() {
        return new TipoAtivo(0, nomeTipoAtivo, descricao);
    }
    
}
