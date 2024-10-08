package br.edu.uniceub.models;

import java.time.LocalDateTime;

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
@Table(name="COTACAO")
public class Cotacao extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ID_ATIVO")
    private Integer idAtivo;

    @Column(name = "DATA")
    private LocalDateTime data;

    @Column(name = "COTACAO")
    private Double cotacao;

    public Cotacao(Integer idAtivo, LocalDateTime data, Double cotacao) {
        this.idAtivo = idAtivo;
        this.data = data;
        this.cotacao = cotacao;
    }

}
