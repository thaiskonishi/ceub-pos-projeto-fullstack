package br.edu.uniceub.dto;

import java.util.Date;
import br.edu.uniceub.models.Ativo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtivoDto {

    private Integer id;
    private String nome;
    private String ticker;
    private Date dataFundacao;
    private String setor;
    private String tipoAtivo;

    public AtivoDto(Ativo ativo, String setor, String tipoAtivo) {
        this.id = ativo.getId();
        this.nome = ativo.getNome();
        this.ticker = ativo.getTicker();
        this.dataFundacao = ativo.getDataFundacao();
        this.setor = setor;
        this.tipoAtivo = tipoAtivo;
    }

}
