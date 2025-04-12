package com.franquicia.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franquicia.prueba.entidad.Franquicia;

@Repository
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> { }
