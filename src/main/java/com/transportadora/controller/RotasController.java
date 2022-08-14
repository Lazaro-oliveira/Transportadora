package com.transportadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RotasController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/conteiner/cadastrar")
    public String conteinerCadastrar() {
        return "conteinerCadastrar";
    }

    @GetMapping("/conteiner/listar")
    public String conteinerListar() {
        return "conteinerListar";
    }

    @GetMapping("/conteiner/editar/{conteinerId}")
    public String conteinerEditar(@PathVariable("conteinerId") Long userId) {
        return "conteinerEditar";
    }

    @GetMapping("/movimentacao/cadastrar")
    public String movimentacaoCadastrar() {
        return "movimentacaoCadastrar";
    }

    @GetMapping("/movimentacao/listar")
    public String movimentacaoListar() {
        return "movimentacaoListar";
    }

    @GetMapping("/movimentacao/editar/{movimentacaoId}")
    public String movimentacaoEditar(@PathVariable("movimentacaoId") Long userId) {
        return "movimentacaoEditar";
    }

    @GetMapping("/relatorio")
    public String relatorio(){return "relatorio"; }
}
