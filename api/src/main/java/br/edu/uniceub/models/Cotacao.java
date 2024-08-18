package br.edu.uniceub.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cotacao {

    private Integer id;
    private Integer idAtivo;
    private LocalDateTime data;
    private Double cotacao;
}
