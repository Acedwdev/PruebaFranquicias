package com.franquicia.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franquicia.prueba.DTO.DtoMapper;
import com.franquicia.prueba.DTO.FranquiciaSimpleDTO;
import com.franquicia.prueba.DTO.SucursalDTO;
import com.franquicia.prueba.entidad.Franquicia;
import com.franquicia.prueba.entidad.Sucursal;
import com.franquicia.prueba.service.FranquiciaService;
import com.franquicia.prueba.service.SucursalService;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private FranquiciaService franquiciaService;
    
    @Autowired
    private SucursalService sucursalService;

    // Franquicia 
    @PostMapping("/franquicias")
    public FranquiciaSimpleDTO crearFranquicia(@RequestBody Franquicia franquicia) {
        return DtoMapper.toFranquiciaDTO(franquiciaService.save(franquicia));
    }

    @PutMapping("/franquicias/{id}")
    public FranquiciaSimpleDTO actualizarFranquicia(@PathVariable Long id, @RequestBody Franquicia f) {
        return franquiciaService.findById(id).map(fr -> {
            fr.setNombre(f.getNombre());
            return DtoMapper.toFranquiciaDTO(franquiciaService.save(fr));
        }).orElseThrow();
    }
    
    // Sucursal
    @PostMapping("/franquicias/{idFranquicia}/sucursales")
    public SucursalDTO agregarSucursal(@PathVariable Long idFranquicia, @RequestBody Sucursal sucursal) {
        Franquicia franquicia = franquiciaService.findById(idFranquicia).orElseThrow();
        sucursal.setFranquicia(franquicia);
        return DtoMapper.toSucursalDTO(sucursalService.save(sucursal));
    }

    @PutMapping("/sucursales/{id}")
    public SucursalDTO actualizarSucursal(@PathVariable Long id, @RequestBody Sucursal s) {
        return sucursalService.findById(id).map(suc -> {
            suc.setNombre(s.getNombre());
            return DtoMapper.toSucursalDTO(sucursalService.save(suc));
        }).orElseThrow();
    }
    
}
