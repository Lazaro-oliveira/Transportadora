package com.transportadora.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RelatorioMovimentacaoPorClientesComCategoriaDto {

    private String cliente;

    private String tipoMovimentacao;

    private Long totalImportacao;

    private Long totalExportacao;

}
