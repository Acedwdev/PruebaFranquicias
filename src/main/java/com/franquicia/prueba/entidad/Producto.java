package com.franquicia.prueba.entidad;

import jakarta.persistence.*;

@Entity
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;

	public Producto() {

	}

	public Producto(Long id, String nombre, Integer stock, Sucursal sucursal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.stock = stock;
		this.sucursal = sucursal;
	}

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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
    
}
