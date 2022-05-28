package com.myfreetime.dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioRegistroDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    
    public Long getId() {
        return id;
    }
    
    public void setId(final Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    public void setApellidos(final String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(final String password) {
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        this.password = bCryptPasswordEncoder.encode((CharSequence)password);
    }
    
    public UsuarioRegistroDTO(final Long id, final String nombre, final String apellidos, final String email, final String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
    }
    
    public UsuarioRegistroDTO(final String nombre, final String apellidos, final String email, final String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
    }
    
    public UsuarioRegistroDTO(final String email) {
        this.email = email;
    }
    
    public UsuarioRegistroDTO() {
    }
}