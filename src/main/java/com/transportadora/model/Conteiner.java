package com.transportadora.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Conteiner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conteinerId;

    @Column(nullable = false, unique = true)
    private String numeroConteiner;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String cliente;

}
