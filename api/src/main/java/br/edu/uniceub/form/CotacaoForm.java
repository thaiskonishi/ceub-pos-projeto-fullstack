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

    @NotNull(message = "Nenhum ID repassado!")
    private Integer idAtivo;

    @NotNull(message = "A data não pode ser vazia e tem de estar no formato 2022-03-10T12:15:50!")
    private LocalDateTime data;

    @NotNull(message = "A cotação não pode ser vazia!")
    private Double cotacao;

    public Cotacao convertion() {
        return new Cotacao(idAtivo, data, cotacao);
    }

}
