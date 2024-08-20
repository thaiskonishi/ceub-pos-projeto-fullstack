package br.edu.uniceub.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.uniceub.models.TipoAtivo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoAtivoDto {

    private Integer id;
    private String nomeTipoAtivo;
    private String descricao;

    public TipoAtivoDto(TipoAtivo tipoAtivo) {
        this.id = tipoAtivo.getId();
        this.nomeTipoAtivo = tipoAtivo.getNomeTipoAtivo();
        this.descricao = tipoAtivo.getDescricao();
    }

    public static List<TipoAtivoDto> convertion(List<TipoAtivo> tiposDeAtivo) {
        return tiposDeAtivo.stream().map(TipoAtivoDto::new).collect(Collectors.toList());
    }

}
