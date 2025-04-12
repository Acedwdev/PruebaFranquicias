package com.franquicia.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franquicia.prueba.entidad.Franquicia;
import com.franquicia.prueba.service.FranquiciaService;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private FranquiciaService franquiciaService;

    // Franquicia 
    @PostMapping("/franquicias")
    public Franquicia crearFranquicia(@RequestBody Franquicia franquicia) {
        return franquiciaService.save(franquicia);
    }

    @PutMapping("/franquicias/{id}")
    public Franquicia actualizarFranquicia(@PathVariable Long id, @RequestBody Franquicia f) {
        return franquiciaService.findById(id).map(fr -> {
            fr.setNombre(f.getNombre());
            return franquiciaService.save(fr);
        }).orElseThrow();
    }

}
