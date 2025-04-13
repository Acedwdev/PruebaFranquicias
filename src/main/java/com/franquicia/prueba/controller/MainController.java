package com.franquicia.prueba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franquicia.prueba.DTO.DtoMapper;
import com.franquicia.prueba.DTO.FranquiciaSimpleDTO;
import com.franquicia.prueba.DTO.ProductoDTO;
import com.franquicia.prueba.DTO.SucursalDTO;
import com.franquicia.prueba.entidad.Franquicia;
import com.franquicia.prueba.entidad.Producto;
import com.franquicia.prueba.entidad.Sucursal;
import com.franquicia.prueba.service.FranquiciaService;
import com.franquicia.prueba.service.ProductoService;
import com.franquicia.prueba.service.SucursalService;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private FranquiciaService franquiciaService;
    
    @Autowired
    private SucursalService sucursalService;
    
    @Autowired
    private ProductoService productoService;

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
    
    // Producto
    @PostMapping("/sucursales/{idSucursal}/productos")
    public ProductoDTO agregarProducto(@PathVariable Long idSucursal, @RequestBody Producto producto) {
        Sucursal sucursal = sucursalService.findById(idSucursal).orElseThrow();
        producto.setSucursal(sucursal);
        return DtoMapper.toProductoDTO(productoService.save(producto));
    }

    @PutMapping("/productos/{id}")
    public ProductoDTO actualizarProducto(@PathVariable Long id, @RequestBody Producto p) {
        return productoService.findById(id).map(prod -> {
            prod.setNombre(p.getNombre());
            prod.setStock(p.getStock());
            return DtoMapper.toProductoDTO(productoService.save(prod));
        }).orElseThrow();
    }
    
    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.deleteById(id);
    }
    
    @GetMapping("/franquicias/{franquiciaId}/productos/max-stock")
    public List<ProductoDTO> obtenerProductoConMasStockPorSucursal(@PathVariable Long franquiciaId) {
        Franquicia franquicia = franquiciaService.findById(franquiciaId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        List<ProductoDTO> resultado = new ArrayList<>();

        for (Sucursal sucursal : franquicia.getSucursales()) {
            productoService.findProductoConMasStockPorSucursal(sucursal)
                    .ifPresent(producto -> resultado.add(DtoMapper.toProductoDTO(producto)));
        }

        return resultado;
    }

    
}
