package br.edu.uniceub.form;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import br.edu.uniceub.models.Cotacao;

@Getter
@Setter
@NoArgsConstructor
public class CotacaoForm {

    @NotNull(message = "O nome não pode ser vazio!")
    private Integer idAtivo;

    @NotNull(message = "O nome não pode ser vazio!")
    private LocalDateTime data;

    @NotNull(message = "O nome não pode ser vazio!")
    private Double cotacao;

    public Cotacao convertion() {
        return new Cotacao(idAtivo, data, cotacao);
    }

}
