package com.application.ediaristas.core.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.ediaristas.core.models.Foto;

public interface FotoRepository extends JpaRepository<Foto, Long> {
    
    Optional<Foto> findByFilename(String filename);
}
