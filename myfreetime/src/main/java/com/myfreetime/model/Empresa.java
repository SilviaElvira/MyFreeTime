package com.myfreetime.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "empresa", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
public class Empresa {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(name = "empresa_roles", joinColumns = { @JoinColumn(name = "empresa_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "rol_id", referencedColumnName = "id") })
    private Collection<Rol> roles;
    
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Collection<Rol> getRoles() {
        return roles;
    }
    
    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }
    
    public Empresa(Long id, String nombre, String email, String password, Collection<Rol> roles) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    
    public Empresa(String nombre, String email, String password, Collection<Rol> roles) {
        this.nombre = nombre;  
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    
    public Empresa() {
    }
}
