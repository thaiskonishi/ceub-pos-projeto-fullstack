package br.edu.uniceub.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TIPO_ATIVO")
public class TipoAtivo extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOME_TIPO_ATIVO")
    private String nomeTipoAtivo;

    @Column(name = "DESCRICAO")
    private String descricao;

    public TipoAtivo(String nomeTipoAtivo, String descricao) {
        this.nomeTipoAtivo = nomeTipoAtivo;
        this.descricao = descricao;
    }

}
