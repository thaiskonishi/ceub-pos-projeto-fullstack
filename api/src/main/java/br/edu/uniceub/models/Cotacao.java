package br.edu.uniceub.models;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cotacao {

    private Integer id;
    private Integer idAtivo;
    private LocalDateTime data;
    private Double cotacao;
}
