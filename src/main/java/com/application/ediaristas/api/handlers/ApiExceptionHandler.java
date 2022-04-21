package com.application.ediaristas.api.handlers;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import com.application.ediaristas.api.dtos.responses.ErrorResponseDto;
import com.application.ediaristas.core.services.consultaendereco.exceptions.EnderecoServiceException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(annotations = RestController.class)
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(EnderecoServiceException.class)
    public static ResponseEntity<Object> handleEnderecoServiceException(EnderecoServiceException exception,
        HttpServletRequest request) {

            var errorResponse = new ErrorResponseDto.Builder()
                .status(400)
                .timestamp(LocalDateTime.now())
                .mensagem(exception.getLocalizedMessage())
                .path(request.getRequestURI())
                .build();

            return ResponseEntity.badRequest().body(errorResponse);
        }
}
