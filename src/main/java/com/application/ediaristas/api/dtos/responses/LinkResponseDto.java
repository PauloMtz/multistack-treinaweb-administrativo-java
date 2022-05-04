package com.application.ediaristas.api.dtos.responses;

public class LinkResponseDto {
    
    private String type;
    private String rel;
    private String uri;

    public LinkResponseDto() {
    }
    
    public LinkResponseDto(String type, String rel, String uri) {
        this.type = type;
        this.rel = rel;
        this.uri = uri;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
