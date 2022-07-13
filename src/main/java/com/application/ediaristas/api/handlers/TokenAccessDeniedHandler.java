package com.application.ediaristas.api.handlers;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.application.ediaristas.api.dtos.responses.ErrorResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TokenAccessDeniedHandler implements AccessDeniedHandler {

    @Autowired
    private ObjectMapper objectMapper; // fasterxml.jackson.databind.ObjectMapper

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
        AccessDeniedException accessDeniedException) 
        throws IOException, ServletException {
    
            var statusHttp = HttpStatus.FORBIDDEN;

            var errorResponse = new ErrorResponseDto.Builder()
                    .status(statusHttp.value())
                    .timestamp(LocalDateTime.now())
                    .mensagem(accessDeniedException.getLocalizedMessage())
                    .path(request.getRequestURI())
                    .build();
    
            var json = objectMapper.writeValueAsString(errorResponse);
    
            response.setStatus(statusHttp.value());
            response.setHeader("Content-Type", "application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(json);
    } 
}
