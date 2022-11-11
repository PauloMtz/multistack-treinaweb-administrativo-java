package com.application.ediaristas.core.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import com.application.ediaristas.core.exceptions.ValidacaoException;
import com.application.ediaristas.core.models.Diaria;

@Component
public class PagamentoDiariaValidator {
    
    public void validarDiaria(Diaria diaria) {
        validaStatus(diaria);
    }

    private void validaStatus(Diaria diaria) {
        if (!diaria.isSemPagamento()) {
            var mensagem = "a diária deve estar sem pagamento";
            var fieldError = new FieldError(diaria.getClass().getName(), "status",
                diaria.getStatus(), false, null, null, mensagem);
            
            throw new ValidacaoException(mensagem, fieldError);
        }
    }
}
