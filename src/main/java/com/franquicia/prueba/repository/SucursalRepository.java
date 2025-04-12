package com.franquicia.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franquicia.prueba.entidad.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> { }
