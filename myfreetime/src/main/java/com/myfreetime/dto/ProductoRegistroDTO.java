package com.myfreetime.dto;

public class ProductoRegistroDTO {
	
	private Long id;
    private String nombre;
	private String actividad;
	private String descripcion;
	private Long precio;
	private String provincia;
	private String localidad;
    private String imparticion;
    private String telefono;
    private String email;
    
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
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getImparticion() {
		return imparticion;
	}
	public void setImparticion(String imparticion) {
		this.imparticion = imparticion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ProductoRegistroDTO(Long id, String nombre, String actividad, String descripcion, Long precio,
			String provincia, String localidad, String imparticion, String telefono, String email) {
		this.id = id;
		this.nombre = nombre;
		this.actividad = actividad;
		this.descripcion = descripcion;
		this.precio = precio;
		this.provincia = provincia;
		this.localidad = localidad;
		this.imparticion = imparticion;
		this.telefono = telefono;
		this.email = email;
	}
	public ProductoRegistroDTO(String nombre) {
		this.nombre = nombre;
	}
	public ProductoRegistroDTO() {
	}
 }
