package br.edu.uniceub.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
@Table(schema = "DB_FINANCAS",name="SETOR")
public class Setor extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqId")
    @SequenceGenerator(name = "seqId", sequenceName = "Seq_ID", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;

    @Column(name="NOME")
    private String nome;
    @Column(name="DESCRICAO")
    private String descricao;
}
