package br.edu.uniceub.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ativo {

    private Integer id;
    private String nome;
    private Date dataFundacao;
    private Integer idSetor;
    private Integer IdTipoAtivo;

}
