package com.application.ediaristas.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.ediaristas.core.models.Diaria;

public interface DiariaRepository extends JpaRepository<Diaria, Long> {
}
