package com.franquicia.prueba.DTO;

import com.franquicia.prueba.entidad.Franquicia;
import com.franquicia.prueba.entidad.Sucursal;

public class DtoMapper {
	
    public static FranquiciaSimpleDTO toFranquiciaDTO(Franquicia franquicia) {
    	FranquiciaSimpleDTO dto = new FranquiciaSimpleDTO();
        dto.setId(franquicia.getId());
        dto.setNombre(franquicia.getNombre());
        return dto;
    }

    public static SucursalDTO toSucursalDTO(Sucursal sucursal) {
        SucursalDTO dto = new SucursalDTO();
        dto.setId(sucursal.getId());
        dto.setNombre(sucursal.getNombre());
        FranquiciaSimpleDTO fDto = new FranquiciaSimpleDTO();
        fDto.setId(sucursal.getFranquicia().getId());
        fDto.setNombre(sucursal.getFranquicia().getNombre());
        dto.setFranquicia(fDto);
        return dto;
    }

}
