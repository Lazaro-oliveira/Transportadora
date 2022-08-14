package com.transportadora.controller;

import com.transportadora.dto.AddMovimentacaoDto;
import com.transportadora.dto.RelatorioMovimentacaoPorClientesDto;
import com.transportadora.model.Conteiner;
import com.transportadora.model.Movimentacao;
import com.transportadora.service.ConteinerService;
import com.transportadora.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @Autowired
    private ConteinerService conteinerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Movimentacao> listaMovimentacao(){
        return movimentacaoService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movimentacao buscarMovimentacaoPorId(@PathVariable("id") Long id){
        return movimentacaoService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movimentação não encontrado"));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String salvar(@RequestBody AddMovimentacaoDto addMovimentacaoDto){

        String failResponse = "{\"status\":\"invalid\"}";
        String successResponse = "{\"status\":\"success\"}";

        try{
            Movimentacao movimentacao = new Movimentacao();
            movimentacao.setTipoMovimentacao(addMovimentacaoDto.getTipoMovimentacao());
            movimentacao.setDataInicio(addMovimentacaoDto.getDataInicio());
            movimentacao.setDataFim(addMovimentacaoDto.getDataFim());
            Optional<Conteiner> conteiner = conteinerService.getById(addMovimentacaoDto.getConteinerId());
            movimentacao.setConteiner(conteiner.get());
            movimentacaoService.save(movimentacao);
            return successResponse;
        }
        catch (Exception e){
            return failResponse;
        }

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerMovimentacao(@PathVariable("id") Long id){
        movimentacaoService.getById(id)
                .map(movimentacao -> {
                    movimentacaoService.deleteById(movimentacao.getMovimentacaoId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movimentacão não encontrada"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public String atualizarMovimentacao(@PathVariable("id") Long id, @RequestBody AddMovimentacaoDto addMovimentacaoDto){

        String failResponse = "{\"status\":\"invalid\"}";
        String successResponse = "{\"status\":\"success\"}";

        try{
            Optional<Movimentacao> movimentacao = movimentacaoService.getById(id);
            movimentacao.get().setTipoMovimentacao(addMovimentacaoDto.getTipoMovimentacao());
            movimentacao.get().setDataInicio(addMovimentacaoDto.getDataInicio());
            movimentacao.get().setDataFim(addMovimentacaoDto.getDataFim());
            Optional<Conteiner> conteiner = conteinerService.getById(addMovimentacaoDto.getConteinerId());
            movimentacao.get().setConteiner(conteiner.get());
            movimentacaoService.save(movimentacao.get());
            return successResponse;
        }
        catch (Exception e){
            return failResponse;
        }

    }

    @GetMapping("/MovimentacaoPorCliente")
    @ResponseStatus(HttpStatus.OK)
    public List<RelatorioMovimentacaoPorClientesDto> MovimentacaoPorCliente(){
        return movimentacaoService.getAllMovimentacaoPorCliente();

    }

    @GetMapping("/MovimentacaoPorClienteImportacao")
    @ResponseStatus(HttpStatus.OK)
    public List<RelatorioMovimentacaoPorClientesDto> MovimentacaoPorClienteImportacao(){

        return movimentacaoService.getAllMovimentacaoPorClienteComCategoria("Importacao");

    }

    @GetMapping("/MovimentacaoPorClienteExportacao")
    @ResponseStatus(HttpStatus.OK)
    public List<RelatorioMovimentacaoPorClientesDto> MovimentacaoPorClienteExportacao(){

        return movimentacaoService.getAllMovimentacaoPorClienteComCategoria("Exportacao");

    }

}
