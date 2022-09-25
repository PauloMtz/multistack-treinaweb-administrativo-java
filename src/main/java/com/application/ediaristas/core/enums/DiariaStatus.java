package com.application.ediaristas.core.enums;

public enum DiariaStatus {
    
    SEM_PAGAMENTO(1),
    PAGO(2),
    CONFIRMADO(3),
    CONCLUIDO(4),
    CANCELADO(5),
    AVALIADO(6),
    TRANSFERIDO(7);

    private Integer id;

    private DiariaStatus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
