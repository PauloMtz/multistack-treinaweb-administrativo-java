package com.application.ediaristas.api.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.ediaristas.api.dtos.requests.DiariaRequestDto;
import com.application.ediaristas.api.dtos.responses.DiariaResponseDto;
import com.application.ediaristas.api.mappers.ApiDiariaMapper;
import com.application.ediaristas.core.enums.DiariaStatus;
import com.application.ediaristas.core.models.Diaria;
import com.application.ediaristas.core.repositories.DiariaRepository;
import com.application.ediaristas.core.utils.SecurityUtils;

@Service
public class ApiDiariaService {
    
    @Autowired
    private DiariaRepository repository;

    @Autowired
    private ApiDiariaMapper mapper;

    @Autowired
    private SecurityUtils securityUtils;

    public DiariaResponseDto cadastrar(DiariaRequestDto request) {
        var model = mapper.toModel(request);
        model.setValorComissao(calculaComissao(model));
        model.setCliente(securityUtils.getUsuarioLogado());
        model.setStatus(DiariaStatus.SEM_PAGAMENTO);
        var modelCadastrado = repository.save(model);

        return mapper.toResponse(modelCadastrado);
    }

    private BigDecimal calculaComissao(Diaria model) {
        var servico = model.getServico();
        var preco = model.getPreco();
        var porcentagemComissao = servico.getPorcentagemComissao();

        /*
         * o BigDecimal não aceita operações como no Integer
         * por isso, precisa declarar o valor 100 
         * e utilizar os métodos da classe - multiply, divide etc.
         */

         var bigDecimal100 = new BigDecimal(100);

         return preco.multiply(porcentagemComissao.divide(bigDecimal100)).setScale(2);
    }
}
