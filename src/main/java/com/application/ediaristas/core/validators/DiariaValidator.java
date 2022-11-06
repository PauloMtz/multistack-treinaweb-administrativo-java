package com.application.ediaristas.core.validators;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import com.application.ediaristas.core.exceptions.ValidacaoException;
import com.application.ediaristas.core.models.Diaria;
import com.application.ediaristas.core.repositories.UsuarioRepository;
import com.application.ediaristas.core.services.consultaendereco.adapters.EnderecoServiceAdapter;
import com.application.ediaristas.core.services.consultaendereco.exceptions.EnderecoServiceException;

@Component
public class DiariaValidator {

    @Autowired
    private EnderecoServiceAdapter enderecoServiceAdapter;

    @Autowired
    private UsuarioRepository usuarioRepository;
    
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

        validaTempoAtendimento(diaria);
    }

    private void validaTempoAtendimento(Diaria diaria) {
        var tempoAtendimento = diaria.getTempoAtendimento();
        var tempoTotal = calculaTempoTotal(diaria);

        if (tempoAtendimento != tempoTotal) {
            var mensagem = "valores de tempo de atendimento e tempo total não conferem";
            var fieldError = new FieldError(diaria.getClass().getName(), "tempoAtendimento",
                diaria.getTempoAtendimento(), false, null, null, mensagem);
            
            throw new ValidacaoException(mensagem, fieldError);
        }

        validarPreco(diaria);
    }

    private Integer calculaTempoTotal(Diaria diaria) {
        var servico = diaria.getServico();

        Integer tempoTotal = 0;

        tempoTotal += diaria.getQuantidadeQuartos() * servico.getHorasQuarto();
        tempoTotal += diaria.getQuantidadeSalas() * servico.getHorasSala();
        tempoTotal += diaria.getQuantidadeCozinhas() * servico.getHorasCozinha();
        tempoTotal += diaria.getQuantidadeBanheiros() * servico.getHorasBanheiro();
        tempoTotal += diaria.getQuantidadeQuintais() * servico.getHorasQuintal();
        tempoTotal += diaria.getQuantidadeOutros() * servico.getHorasOutros();

        return tempoTotal;
    }

    private void validarPreco(Diaria diaria) {
        var preco = diaria.getPreco();
        var valorTotal = calculaValorTotal(diaria);

        if (preco.compareTo(valorTotal) != 0) {
            var mensagem = "valores não correspondem";
            var fieldError = new FieldError(diaria.getClass().getName(), "preco",
                diaria.getPreco(), false, null, null, mensagem);
            
            throw new ValidacaoException(mensagem, fieldError);
        }

        validaCep(diaria);
    }

    private BigDecimal calculaValorTotal(Diaria diaria) {
        var servico = diaria.getServico();
        var valorMinimo = servico.getValorMinimo();

        var valorQuarto = calculaValorComodo(servico.getValorQuarto(), diaria.getQuantidadeQuartos());
        var valorSala = calculaValorComodo(servico.getValorSala(), diaria.getQuantidadeSalas());
        var valorCozinha = calculaValorComodo(servico.getValorCozinha(), diaria.getQuantidadeCozinhas());
        var valorBanheiro = calculaValorComodo(servico.getValorBanheiro(), diaria.getQuantidadeBanheiros());
        var valorQuintal = calculaValorComodo(servico.getValorQuintal(), diaria.getQuantidadeQuintais());
        var valorOutros = calculaValorComodo(servico.getValorOutros(), diaria.getQuantidadeOutros());

        var valorTotal = valorQuarto.add(valorSala)
            .add(valorCozinha).add(valorBanheiro)
            .add(valorQuintal).add(valorOutros);

        /*
         * o método compareTo() pega o primeiro valor e subtrai o segndo
         * se o primeiro valor for menor, retorna -1
         * se for maior, retorna 1
         * se for igual, retorna 0
         */

        if (valorTotal.compareTo(valorMinimo) < 0) {
            return valorMinimo;
        }

        return valorTotal;
    }

    /*
     * BigDecimal tem uma precisão maior que Double
     * por isso, as boas práticas recomendam BigDecimal para valores monetários
     * tem que utilizar os métodos da classe para fazer operações
     */
    
    private BigDecimal calculaValorComodo(BigDecimal valorComodo, Integer qtdeComodos) {
        return valorComodo.multiply(new BigDecimal(qtdeComodos));
    }

    private void validaCep(Diaria diaria) {
        var cep = diaria.getCep();

        try {
            enderecoServiceAdapter.buscarEnderecoPorCep(cep);
        } catch (EnderecoServiceException e) {
            var mensagem = e.getLocalizedMessage();
            var fieldError = new FieldError(diaria.getClass().getName(), "cep",
                diaria.getCep(), false, null, null, mensagem);
            
            throw new ValidacaoException(mensagem, fieldError);
        }

        validaCodigoIbge(diaria);
    }

    private void validaCodigoIbge(Diaria diaria) {
        var cep = diaria.getCep();
        var codigoIbge = diaria.getCodigoIbge();
        var codigoIbgeValido = enderecoServiceAdapter.buscarEnderecoPorCep(cep).getIbge();

        if (!codigoIbge.equals(codigoIbgeValido)) {
            var mensagem = "código IBGE inválido";
            var fieldError = new FieldError(diaria.getClass().getName(), "codigoIbge",
                diaria.getCodigoIbge(), false, null, null, mensagem);
            
            throw new ValidacaoException(mensagem, fieldError);
        }

        validaDisponibilidadeDiarista(diaria);
    }

    private void validaDisponibilidadeDiarista(Diaria diaria) {
        var codigoIbge = diaria.getCodigoIbge();
        var disponibilidade = usuarioRepository.existsByCidadesAtendidasCodigoIbge(codigoIbge);

        if (!disponibilidade) {
            var mensagem = "não há diarista disponível para o CEP informado";
            var fieldError = new FieldError(diaria.getClass().getName(), "cep",
                diaria.getCep(), false, null, null, mensagem);
            
            throw new ValidacaoException(mensagem, fieldError);
        }
    }
}
