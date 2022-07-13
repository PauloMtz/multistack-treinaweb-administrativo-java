package com.application.ediaristas.core.services.token.providers;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.application.ediaristas.core.services.token.adapters.TokenServiceAdapter;
import com.application.ediaristas.core.services.token.exceptions.TokenServiceException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenServiceProvider implements TokenServiceAdapter {

    @Override
    public String gerarTokenAcesso(String subject) {
        var claims = new HashMap<String, Object>();
        var dataHoraAtual = Instant.now();
        var dataHoraExpiracao = dataHoraAtual.plusSeconds(60);// segundos

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
        /*var claims = Jwts.parser()
                        .setSigningKey("chave_secreta_token_acesso")
                        .parseClaimsJws(tokenAcesso)
                        .getBody();*/
        
        var claims = getClaims(tokenAcesso, "chave_secreta_token_acesso");
        return claims.getSubject();
    }
    
    private Claims getClaims(String token, String signKey) {
        try {
            return tryGetClaims(token, signKey);
        } catch (JwtException exception) {
            throw new TokenServiceException(exception.getLocalizedMessage());
        }
    }

    private Claims tryGetClaims(String token, String signKey) {
        return Jwts.parser()
            .setSigningKey(signKey)
            .parseClaimsJws(token)
            .getBody();
    }
}
