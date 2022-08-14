package com.transportadora.service;

import com.transportadora.dto.RelatorioMovimentacaoPorClientesDto;
import com.transportadora.model.Movimentacao;
import com.transportadora.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    public Movimentacao save(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public Optional<Movimentacao> getById(Long movimentacaoId) {
        return movimentacaoRepository.findById(movimentacaoId);
    }

    public List<Movimentacao> getAll() {
        return movimentacaoRepository.findAll();
    }

    public List<RelatorioMovimentacaoPorClientesDto> getAllMovimentacaoPorCliente() {
        return movimentacaoRepository.findallMovimentacaoPorCliente();
    }

    public List<RelatorioMovimentacaoPorClientesDto> getAllMovimentacaoPorClienteComCategoria(String categoria) {
        return movimentacaoRepository.findallMovimentacaoPorClienteComCategoria(categoria);
    }

    public void deleteById(Long movimentacaoId) {
        movimentacaoRepository.deleteById(movimentacaoId);
    }

}
