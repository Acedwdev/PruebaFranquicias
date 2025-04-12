package com.franquicia.prueba.DTO;

public class SucursalDTO {
    private Long id;
    private String nombre;
    private FranquiciaSimpleDTO franquicia;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public FranquiciaSimpleDTO getFranquicia() {
		return franquicia;
	}
	public void setFranquicia(FranquiciaSimpleDTO franquicia) {
		this.franquicia = franquicia;
	}
    
    

}
