package com.application.ediaristas.core.services.token.providers;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.application.ediaristas.core.services.token.adapters.TokenServiceAdapter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenServiceProvider implements TokenServiceAdapter {

    @Override
    public String gerarTokenAcesso(String subject) {
        var claims = new HashMap<String, Object>();
        var dataHoraAtual = Instant.now();
        var dataHoraExpiracao = dataHoraAtual.plusSeconds(30);// 30segundos

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(dataHoraAtual.toEpochMilli()))
                .setExpiration(new Date(dataHoraExpiracao.toEpochMilli()))
                .signWith(SignatureAlgorithm.HS512, "chave_secreta_token_acesso")
                .compact();
    }

    @Override
    public String getSubjectTokenAcesso(String tokenAcesso) {
        var claims = Jwts.parser()
                        .setSigningKey("chave_secreta_token_acesso")
                        .parseClaimsJws(tokenAcesso)
                        .getBody();
                        
        return claims.getSubject();
    }
    
}
