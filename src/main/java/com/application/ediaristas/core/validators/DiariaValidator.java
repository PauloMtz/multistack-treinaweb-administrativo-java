package com.application.ediaristas.core.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import com.application.ediaristas.core.exceptions.ValidacaoException;
import com.application.ediaristas.core.models.Diaria;

@Component
public class DiariaValidator {
    
    public void validar(Diaria diaria) {
        validaHoraTermino(diaria);
    }

    private void validaHoraTermino(Diaria diaria) {
        var dataAtendimento = diaria.getDataAtendimento();
        var tempoAtendimento = diaria.getTempoAtendimento();
        var dataTermino = dataAtendimento.plusHours(tempoAtendimento);
        var dataLimite = dataAtendimento.withHour(22).withMinute(0).withSecond(0);

        if (dataTermino.isAfter(dataLimite)) {
            var mensagem = "não pode ser depois das 22 horas";
            var fieldError = new FieldError(diaria.getClass().getName(), "dataAtendimento",
                diaria.getDataAtendimento(), false, null, null, mensagem);
            
            throw new ValidacaoException(mensagem, fieldError);
        }
    }
}
