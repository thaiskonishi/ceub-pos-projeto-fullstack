package br.edu.uniceub.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome_setor")
    private String nomeSetor;
    private String descricao;

    public Setor(String nomeSetor, String descricao) {
        this.nomeSetor = nomeSetor;
        this.descricao = descricao;
    }

}
