package com.franquicia.prueba.entidad;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="franquicia")
public class Franquicia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @OneToMany(mappedBy = "franquicia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sucursal> sucursales;

	public Franquicia() {

	}

	public Franquicia(Long id, String nombre, List<Sucursal> sucursales) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sucursales = sucursales;
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

	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
    
}


