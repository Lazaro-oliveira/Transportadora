package com.transportadora.service;

import com.transportadora.model.Conteiner;
import com.transportadora.repository.ConteinerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConteinerService {

    @Autowired
    ConteinerRepository conteinerRepository;

    public Conteiner save(Conteiner conteiner) {
        return conteinerRepository.save(conteiner);
    }

    public Optional<Conteiner> getById(Long conteinerId) {
        return conteinerRepository.findById(conteinerId);
    }

    public List<Conteiner> getAll() {
        return conteinerRepository.findAll();
    }

    public void deleteById(Long conteinerId) {
        conteinerRepository.deleteById(conteinerId);
    }

}
