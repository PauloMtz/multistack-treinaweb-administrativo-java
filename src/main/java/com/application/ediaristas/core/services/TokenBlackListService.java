package com.application.ediaristas.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.ediaristas.core.exceptions.TokenBlackListException;
import com.application.ediaristas.core.models.TokenBlackList;
import com.application.ediaristas.core.repositories.TokenBlackListRepository;

@Service
public class TokenBlackListService {
    
    @Autowired
    private TokenBlackListRepository repository;

    public void verificaToken(String token) {
        /*var tokenBlackListOptional = repository.findByToken(token);

        if (tokenBlackListOptional.isPresent()) {
            
        }*/

        if (repository.existsByToken(token)) {
            throw new TokenBlackListException();
        }
    }

    public void colocaTokenBlackList(String token) {
        if (!repository.existsByToken(token)) {
            var tokenBlackList = new TokenBlackList();
            tokenBlackList.setToken(token);
            repository.save(tokenBlackList);
        }
    }
}
