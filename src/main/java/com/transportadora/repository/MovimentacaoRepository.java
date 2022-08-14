package com.transportadora.repository;

import com.transportadora.dto.RelatorioMovimentacaoPorClientesDto;
import com.transportadora.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    @Query("SELECT new com.transportadora.dto.RelatorioMovimentacaoPorClientesDto(m.conteiner.cliente AS cliente, m.tipoMovimentacao AS tipoMovimentacao, COUNT(m.movimentacaoId) AS totalMovimentacao) FROM Movimentacao m GROUP BY m.conteiner.cliente, m.tipoMovimentacao")
    List<RelatorioMovimentacaoPorClientesDto> findallMovimentacaoPorCliente();

    @Query("SELECT new com.transportadora.dto.RelatorioMovimentacaoPorClientesDto(m.conteiner.cliente AS cliente, m.tipoMovimentacao AS tipoMovimentacao, COUNT(m.movimentacaoId) AS totalMovimentacao) FROM Movimentacao m WHERE m.conteiner.categoria = ?1 GROUP BY m.conteiner.cliente, m.tipoMovimentacao")
    List<RelatorioMovimentacaoPorClientesDto> findallMovimentacaoPorClienteComCategoria(String categoria);


}
