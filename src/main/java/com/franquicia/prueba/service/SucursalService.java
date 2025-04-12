package com.franquicia.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franquicia.prueba.entidad.Sucursal;
import com.franquicia.prueba.repository.SucursalRepository;

@Service
public class SucursalService {
    @Autowired
    private SucursalRepository repository;

    public List<Sucursal> findAll() {
        return repository.findAll();
    }

    public Optional<Sucursal> findById(Long id) {
        return repository.findById(id);
    }

    public Sucursal save(Sucursal obj) {
        return repository.save(obj);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
