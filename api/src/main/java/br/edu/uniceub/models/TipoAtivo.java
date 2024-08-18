package br.edu.uniceub.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoAtivo {

    private Integer id;
    private String nomeTipoAtivo;
    private String descricao;

}
