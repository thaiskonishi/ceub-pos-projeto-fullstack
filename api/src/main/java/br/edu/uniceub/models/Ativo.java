package br.edu.uniceub.models;

import java.util.Date;

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
@Table(name = "ATIVO")
public class Ativo extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "TICKER")
    private String ticker;

    @Column(name = "DATA_FUNDACAO")
    private Date dataFundacao;

    @Column(name = "ID_SETOR")
    private Integer idSetor;

    @Column(name = "ID_TIPO_ATIVO")
    private Integer idTipoAtivo;

    public Ativo(String nome, String ticker, Date dataFundacao, Integer idSetor, Integer idTipoAtivo) {
        this.nome = nome;
        this.ticker = ticker;
        this.dataFundacao = dataFundacao;
        this.idSetor = idSetor;
        this.idTipoAtivo = idTipoAtivo;
    }

}
