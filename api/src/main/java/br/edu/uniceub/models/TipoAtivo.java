package br.edu.uniceub.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "DB_FINANCAS",name="TIPO_ATIVO")
public class TipoAtivo extends PanacheEntityBase{

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name="NOME_TIPO_ATIVO")
    private String nomeTipoAtivo;

    @Column(name ="DESCRICAO" )
    private String descricao;

}
