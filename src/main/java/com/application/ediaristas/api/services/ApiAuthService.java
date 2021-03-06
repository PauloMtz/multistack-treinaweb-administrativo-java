package com.application.ediaristas.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.application.ediaristas.api.dtos.requests.RefreshRequestDto;
import com.application.ediaristas.api.dtos.requests.TokenRequestDto;
import com.application.ediaristas.api.dtos.responses.TokenResponseDto;
import com.application.ediaristas.core.services.token.adapters.TokenServiceAdapter;

@Service
public class ApiAuthService {
    
    @Autowired
    private TokenServiceAdapter tokenAdapter;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authManager;

    public TokenResponseDto autenticar(TokenRequestDto request) {
        var email = request.getEmail();
        var senha = request.getSenha();

        var autenticacao = new UsernamePasswordAuthenticationToken(email, senha);
        authManager.authenticate(autenticacao);

        var acesso = tokenAdapter.gerarTokenAcesso(email);
        var refresh = tokenAdapter.gerarRefreshToken(email);

        return new TokenResponseDto(acesso, refresh);
    }

    public TokenResponseDto reAutenticar(RefreshRequestDto refreshRequest) {
        var email = tokenAdapter.getSubjectDoRefreshToken(refreshRequest.getRefresh());
        userDetailsService.loadUserByUsername(email);
        
        var acesso = tokenAdapter.gerarTokenAcesso(email);
        var refresh = tokenAdapter.gerarRefreshToken(email);
        
        return new TokenResponseDto(acesso, refresh);
    }
}
