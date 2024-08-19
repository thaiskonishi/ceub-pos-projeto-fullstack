package br.edu.uniceub.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.uniceub.models.Setor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SetorDto {

    private Integer id;
    private String nomeSetor;
    private String descricao;

    public SetorDto(Setor setor) {
        this.id = setor.getId();
        this.nomeSetor = setor.getNomeSetor();
        this.descricao = setor.getDescricao();
    }

    public static List<SetorDto> convertion(List<Setor> setores) {
        return setores.stream().map(SetorDto::new).collect(Collectors.toList());
    }
    
}
