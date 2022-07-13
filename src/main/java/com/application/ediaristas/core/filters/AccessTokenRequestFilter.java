package com.application.ediaristas.core.filters;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.application.ediaristas.api.dtos.responses.ErrorResponseDto;
import com.application.ediaristas.core.services.token.adapters.TokenServiceAdapter;
import com.application.ediaristas.core.services.token.exceptions.TokenServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AccessTokenRequestFilter extends OncePerRequestFilter {

    private final static String TOKEN_TYPE = "Bearer ";

    @Autowired
    private TokenServiceAdapter tokenService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(
        HttpServletRequest request, 
        HttpServletResponse response, 
        FilterChain filterChain
    ) throws ServletException, IOException {
        
        // seleciona o código - clica na lâmpada - extract to method
        try {
            tryDoFilterInternal(request, response, filterChain);
        } catch (TokenServiceException exception) {
            var statusHttp = HttpStatus.UNAUTHORIZED;

            var errorResponse = new ErrorResponseDto.Builder()
                    .status(statusHttp.value())
                    .timestamp(LocalDateTime.now())
                    .mensagem(exception.getLocalizedMessage())
                    .path(request.getRequestURI())
                    .build();

            var json = objectMapper.writeValueAsString(errorResponse);

            response.setStatus(statusHttp.value());
            response.setHeader("Content-Type", "application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(json);
        }
    }

    private void tryDoFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        var token = "";
        var email = "";

        var authorizationHeader = request.getHeader("Authorization");

        if (isTokenPresente(authorizationHeader)) {
            // pega o token depois de 'Bearer '
            token = authorizationHeader.substring(TOKEN_TYPE.length());
            email = tokenService.getSubjectTokenAcesso(token);
        }

        if (isEmailNotInContextSpringSecurity(email)) {
            addEmailInContext(request, email);
        }

        filterChain.doFilter(request, response);
    }
    
    private Boolean isTokenPresente(String authorizationHeader) {
        return authorizationHeader != null && authorizationHeader.startsWith(TOKEN_TYPE);
    }

    private Boolean isEmailNotInContextSpringSecurity(String email) {
        return !email.isEmpty() && SecurityContextHolder.getContext().getAuthentication() == null;
    }

    private void addEmailInContext(HttpServletRequest request, String email) {
        var usuario = userDetailsService.loadUserByUsername(email);

        var autenticacao = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        autenticacao.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(autenticacao);
    }
}
