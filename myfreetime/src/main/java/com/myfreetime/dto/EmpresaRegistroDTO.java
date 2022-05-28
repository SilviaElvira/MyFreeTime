package com.myfreetime.dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EmpresaRegistroDTO {

	private Long id;
    private String nombre;
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        this.password = bCryptPasswordEncoder.encode((CharSequence)password);
    }
    
    public EmpresaRegistroDTO(Long id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }
    
    public EmpresaRegistroDTO(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }
    
    public EmpresaRegistroDTO(String email) {
        this.email = email;
    }
    
    public EmpresaRegistroDTO() {
    }
}
