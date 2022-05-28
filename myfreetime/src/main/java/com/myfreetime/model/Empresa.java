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
    @Column(name = "apellidos")
    private String apellidos;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(name = "empresa_roles", joinColumns = { @JoinColumn(name = "empresa_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "rol_id", referencedColumnName = "id") })
    private Collection<Rol> roles;
    
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
    
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(final String apellidos) {
        this.apellidos = apellidos;
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
    
    public Collection<Rol> getRoles() {
        return this.roles;
    }
    
    public void setRoles(final Collection<Rol> roles) {
        this.roles = roles;
    }
    
    public Empresa(final Long id, final String nombre, final String apellidos, final String email, final String password, final Collection<Rol> roles) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    
    public Empresa(final String nombre, final String apellidos, final String email, final String password, final Collection<Rol> roles) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    
    public Empresa() {
    }
}
