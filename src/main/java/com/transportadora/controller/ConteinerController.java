package com.transportadora.controller;

import com.transportadora.model.Conteiner;
import com.transportadora.service.ConteinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conteiner")
public class ConteinerController {

    @Autowired
    private ConteinerService conteinerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Conteiner> listaConteiner(){
        return conteinerService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Conteiner buscarConteinerPorId(@PathVariable("id") Long id){
        return conteinerService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conteiner não encontrado"));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String salvar(@RequestBody Conteiner conteiner){

        String failResponse = "{\"status\":\"invalid\"}";
        String successResponse = "{\"status\":\"success\"}";

        try{
            conteinerService.save(conteiner);
            return successResponse;
        }
        catch (Exception e){
            return failResponse;
        }

    }

    @DeleteMapping("/{id}")
    public String removerConteiner(@PathVariable("id") Long id){
        String failResponse = "{\"status\":\"invalid\"}";
        String successResponse = "{\"status\":\"success\"}";
        try {
            conteinerService.deleteById(id);
            return successResponse;

        }
        catch (Exception e){
            return failResponse;
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public String atualizarConteiner(@PathVariable("id") Long id, @RequestBody Conteiner conteiner){
        String failResponse = "{\"status\":\"invalid\"}";
        String successResponse = "{\"status\":\"success\"}";

        try{
            Optional<Conteiner> conteinerBanco = conteinerService.getById(id);
            conteinerBanco.get().setCategoria(conteiner.getCategoria());
            conteinerBanco.get().setTipo(conteiner.getTipo());
            conteinerBanco.get().setStatus(conteiner.getStatus());
            conteinerBanco.get().setCliente(conteiner.getCliente());
            conteinerService.save(conteinerBanco.get());
            return successResponse;
        }
        catch (Exception e){
            return failResponse;
        }

    }

}
