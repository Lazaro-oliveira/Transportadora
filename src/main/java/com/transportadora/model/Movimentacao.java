package com.transportadora.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movimentacaoId;

    @Column(nullable = false)
    private String tipoMovimentacao;

    @Column(nullable = false)
    private Date dataInicio;

    @Column(nullable = false)
    private Date dataFim;

    @ManyToOne(fetch = FetchType.EAGER)
    private Conteiner conteiner;

}
