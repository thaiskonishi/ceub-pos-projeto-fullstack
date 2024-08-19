package br.edu.uniceub.models;

import java.time.LocalDateTime;

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
@Table(schema = "DB_FINANCAS",name="COTACAO")
public class Cotacao extends PanacheEntityBase{

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ID_ATIVO")
    private Integer idAtivo;

    @Column(name = "DATA")
    private LocalDateTime data;

    @Column(name = "COTACAO")
    private Double cotacao;
}
