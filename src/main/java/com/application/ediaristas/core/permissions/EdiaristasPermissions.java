package com.application.ediaristas.core.permissions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

public @interface EdiaristasPermissions {
    
    @PreAuthorize("hasAnyAuthority('CLIENTE', 'DIARISTA')")
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface isDiaristaOrCliente {}

    @PreAuthorize("hasAuthority('CLIENTE')")
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface isCliente {}

    @PreAuthorize("isAthenticated and @securityUtils.isClienteDaDiaria(#id)")
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface isClienteDaDiaria {}
}
