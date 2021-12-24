package com.application.ediaristas.core.repositories;

import java.util.Optional;

import com.application.ediaristas.core.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findByEmail(String email);

    @Query("SELECT COUNT(*) > 0 FROM Usuario u WHERE u.email = :email AND (:id IS NULL OR u.id != :id)")
    Boolean isEmailJaCadastrado(String email, Long id);
}
