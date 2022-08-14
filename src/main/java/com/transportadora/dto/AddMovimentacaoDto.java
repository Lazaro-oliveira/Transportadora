package com.transportadora.dto;

import com.transportadora.model.Conteiner;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddMovimentacaoDto {

    private String tipoMovimentacao;

    private Date dataInicio;

    private Date dataFim;

    private Long conteinerId;
}
