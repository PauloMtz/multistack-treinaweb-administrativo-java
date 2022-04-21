package com.application.ediaristas.api.dtos.responses;

import java.time.LocalDateTime;

public class ErrorResponseDto {
    
    private final Integer status;
    private final LocalDateTime timestamp;
    private final String mensagem;
    private final String path;

    private ErrorResponseDto(Builder builder) {
        this.status = builder.status;
        this.timestamp = builder.timestamp;
        this.mensagem = builder.mensagem;
        this.path = builder.path;
    }

    public static class Builder {
        private Integer status;
        private LocalDateTime timestamp;
        private String mensagem;
        private String path;

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder mensagem(String mensagem) {
            this.mensagem = mensagem;
            return this;
        }

        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public ErrorResponseDto build() {
            return new ErrorResponseDto(this);
        }
    }

    public Integer getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getPath() {
        return path;
    }
}
