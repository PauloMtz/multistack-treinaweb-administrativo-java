package com.application.ediaristas.core.repositories;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.ediaristas.core.models.TokenBlackList;

public interface TokenBlackListRepository extends JpaRepository<TokenBlackList, Long> {
    
    //Optional<TokenBlackList> findByToken(String token);

    Boolean existsByToken(String token);
}
