package com.franquicia.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franquicia.prueba.entidad.Franquicia;
import com.franquicia.prueba.repository.FranquiciaRepository;

@Service
public class FranquiciaService {
    @Autowired
    private FranquiciaRepository repository;

    public List<Franquicia> findAll() {
        return repository.findAll();
    }

    public Optional<Franquicia> findById(Long id) {
        return repository.findById(id);
    }

    public Franquicia save(Franquicia obj) {
        return repository.save(obj);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
