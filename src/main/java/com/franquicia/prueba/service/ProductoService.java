package com.franquicia.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franquicia.prueba.entidad.Producto;
import com.franquicia.prueba.entidad.Sucursal;
import com.franquicia.prueba.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    public List<Producto> findAll() {
        return repository.findAll();
    }

    public Optional<Producto> findById(Long id) {
        return repository.findById(id);
    }

    public Producto save(Producto obj) {
        return repository.save(obj);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    public Optional<Producto> findProductoConMasStockPorSucursal(Sucursal sucursal) {
        return repository.findTopBySucursalOrderByStockDesc(sucursal);
    }

}
