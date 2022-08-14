package com.transportadora.dto;


import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RelatorioMovimentacaoPorClientesDto {

    private String cliente;

    private String tipoMovimentacao;

    private Long totalMovimentacao;

}

