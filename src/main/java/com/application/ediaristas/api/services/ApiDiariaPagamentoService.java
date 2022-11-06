package com.application.ediaristas.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.ediaristas.api.dtos.requests.PagamentoRequestDto;
import com.application.ediaristas.api.dtos.responses.MensagemResponseDto;
import com.application.ediaristas.core.enums.DiariaStatus;
import com.application.ediaristas.core.exceptions.DiariaNaoEncontradaException;
import com.application.ediaristas.core.models.Diaria;
import com.application.ediaristas.core.repositories.DiariaRepository;

@Service
public class ApiDiariaPagamentoService {

    @Autowired
    private DiariaRepository repository;
    
    public MensagemResponseDto pagamento(PagamentoRequestDto request, Long id) {
        var diaria = buscarDiariaPorId(id);
        diaria.setStatus(DiariaStatus.PAGO);

        repository.save(diaria);

        return new MensagemResponseDto("Pagamento da diária efetuado com sucesso!");
    }

    private Diaria buscarDiariaPorId(Long id) {
        var mensagem = String.format("Diária com ID %d não encontrada.", id);

        return repository.findById(id)
            .orElseThrow(() -> new DiariaNaoEncontradaException(mensagem));
    }
}
