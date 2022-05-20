package com.myfreetime.repository;

import org.springframework.stereotype.Repository;
import com.myfreetime.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}