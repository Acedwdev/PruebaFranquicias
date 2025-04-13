package com.franquicia.prueba.DTO;

public class ProductoDTO {
    private Long id;
    private String nombre;
    private int stock;
    private SucursalSimpleDTO sucursal;
    
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public SucursalSimpleDTO getSucursal() {
		return sucursal;
	}
	public void setSucursal(SucursalSimpleDTO sucursal) {
		this.sucursal = sucursal;
	}
    
}
