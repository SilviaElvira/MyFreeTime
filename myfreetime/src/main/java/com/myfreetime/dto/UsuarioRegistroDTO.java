package com.myfreetime.dto;

public class UsuarioRegistroDTO {
	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(final String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public UsuarioRegistroDTO(final Long id, final String nombre, final String apellido, final String email,
			final String password) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}

	public UsuarioRegistroDTO(final String nombre, final String apellido, final String email, final String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}

	public UsuarioRegistroDTO(final String email) {
		this.email = email;
	}

	public UsuarioRegistroDTO() {
	}
}