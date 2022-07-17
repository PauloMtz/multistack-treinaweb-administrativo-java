package com.application.ediaristas.api.dtos.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RefreshRequestDto {
    
    @NotNull
    @NotEmpty
    private String refresh;

    public RefreshRequestDto() {
    }

    public RefreshRequestDto(String refresh) {
        this.refresh = refresh;
    }
    
    public String getRefresh() {
        return refresh;
    }

    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }
}
