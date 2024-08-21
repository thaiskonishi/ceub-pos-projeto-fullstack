package br.edu.uniceub.dto;

import java.time.LocalDateTime;

import br.edu.uniceub.models.HistoricoCotacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoCotacaoDto {

    private Integer id;
    private String ticker;
    private LocalDateTime data;
    private Double cotacao;

    public HistoricoCotacaoDto(HistoricoCotacao historicoCotacao, String ticker) {
        this.id = historicoCotacao.getId();
        this.ticker = ticker;
        this.data = historicoCotacao.getData();
        this.cotacao = historicoCotacao.getCotacao();
    }

}
