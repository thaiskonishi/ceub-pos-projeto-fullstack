package br.edu.uniceub.models;

import java.time.LocalDateTime;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class HistoricoCotacao extends PanacheEntityBase {

    @Column(name = "ID")
    private Integer id;

    @Column(name = "ID_ATIVO")
    private Integer idAtivo;

    @Column(name = "DATA")
    private LocalDateTime data;

    @Column(name = "COTACAO")
    private Double cotacao;
}
