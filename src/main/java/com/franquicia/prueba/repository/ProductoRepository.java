package com.franquicia.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franquicia.prueba.entidad.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> { }
