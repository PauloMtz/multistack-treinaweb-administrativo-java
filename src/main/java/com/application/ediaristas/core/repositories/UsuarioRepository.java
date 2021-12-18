package com.application.ediaristas.core.repositories;

import com.application.ediaristas.core.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
