package com.franquicia.prueba.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franquicia.prueba.entidad.Producto;
import com.franquicia.prueba.entidad.Sucursal;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Optional<Producto> findTopBySucursalOrderByStockDesc(Sucursal sucursal);
}

