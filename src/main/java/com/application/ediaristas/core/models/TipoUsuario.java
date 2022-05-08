package com.application.ediaristas.core.models;

public enum TipoUsuario {

    ADMIN (3),
    CLIENTE (1),
    DIARISTA (2);

    private Integer id;

    /*
        enum só pode ter getter e construtor com todos os argumentos
        não pode ter setter porque não pode alterar valor
    */

    private TipoUsuario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
