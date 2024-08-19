package br.edu.uniceub.models;

import java.util.Date;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(schema = "DB_FINANCAS",name="ATIVO")
public class Ativo extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name="NOME")
    private String nome;

    @Column(name = "DATA_FUNDACAO")
    private Date dataFundacao;

    @Column(name="ID_SETOR")
    private Integer idSetor;

    @Column(name="ID_TIPO_ATIVO")
    private Integer IdTipoAtivo;

}
