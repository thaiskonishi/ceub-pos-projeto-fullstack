package br.edu.uniceub.form;

import org.hibernate.validator.constraints.Length;

import br.edu.uniceub.models.Ativo;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AtivoForm {

    @NotNull(message = "O nome não pode ser vazio!")
    @Length(min = 5, max = 45, message = "Observar o tamanho mínimo e máximo para o nome.")
    private String nome;

    @NotNull(message = "O ticker não pode ser vazio!")
    @Length(min = 5, max = 6, message = "Observar o tamanho mínimo e máximo para o ticker.")
    private String ticker;

    @NotNull(message = "A Data de Fundação não pode ser vazia!")
    private Date dataFundacao;

    @NotNull(message = "O Setor não pode ser vazio!")
    private Integer idSetor;

    @NotNull(message = "O Tipo de Ativo não pode ser vazio!")
    private Integer IdTipoAtivo;

    public Ativo convertion() {
        return new Ativo(nome, ticker, dataFundacao, idSetor, IdTipoAtivo);
    }

}
