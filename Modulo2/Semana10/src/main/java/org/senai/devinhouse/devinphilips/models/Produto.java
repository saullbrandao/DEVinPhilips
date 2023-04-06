package org.senai.devinhouse.devinphilips.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @Column(name = "data_lancamento")
    private String dataLancamento;

    private Double preco;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
