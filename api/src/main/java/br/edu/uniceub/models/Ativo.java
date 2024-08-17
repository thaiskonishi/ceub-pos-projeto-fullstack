package br.edu.uniceub.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ativo {

    private Integer id;
    private String nome;
    private Date dataFundacao;
    private Integer idSetor;
    private Integer IdTipoAtivo;

}
