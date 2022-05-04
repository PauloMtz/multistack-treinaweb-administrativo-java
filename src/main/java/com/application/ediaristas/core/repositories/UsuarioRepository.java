package com.application.ediaristas.core.repositories;

//import java.util.List;
import java.util.Optional;

import com.application.ediaristas.core.models.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findByEmail(String email);

    //List<Usuario> findByCidadesAtendidasCodigoIbge(String codigoIbge);

    Boolean existsByCidadesAtendidasCodigoIbge(String codigoIbge);

    Page<Usuario> findByCidadesAtendidasCodigoIbge(String codigoIbge, Pageable pageable); // ...domain.Pageable

    @Query("SELECT COUNT(*) > 0 FROM Usuario u WHERE u.email = :email AND (:id IS NULL OR u.id != :id)")
    Boolean isEmailJaCadastrado(String email, Long id);
}
