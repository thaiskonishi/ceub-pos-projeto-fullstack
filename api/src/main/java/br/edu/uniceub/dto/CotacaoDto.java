package br.edu.uniceub.dto;

import java.time.LocalDateTime;

import br.edu.uniceub.models.Cotacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CotacaoDto {

    private Integer id;
    private String ticker;
    private LocalDateTime data;
    private Double cotacao;

    public CotacaoDto(Cotacao cotacao, String ticker) {
        this.id = cotacao.getId();
        this.ticker = ticker;
        this.data = cotacao.getData();
        this.cotacao = cotacao.getCotacao();
    }

}
