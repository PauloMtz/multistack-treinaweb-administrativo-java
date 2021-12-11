package com.application.ediaristas.web.mappers;

import com.application.ediaristas.core.models.Servico;
import com.application.ediaristas.web.dtos.ServicoForm;

import org.springframework.stereotype.Component;

/*
    essa classe é um bean spring, e como tal, deve ter um nome único no projeto
    se houver necessidade de ter uma classe ServicoMapper lá na Api, 
    ela deverá se chamar ApiServicoMapper
    as classes bean spring são gerenciadas pelo spring para injeção de dependências
    e as anotações são: @Controller, @Repository, @Service, @Componente e @Bean
    o @Bean não é utilizado em classes, e sim em métodos
    e, como essa classe não é repositório, serviço nem controller,
    ela representará um componente
*/

@Component
public class WebServicoMapper {
    
    /*
        essa classe terá dois métodos
        - um que recebe um modelo e transforma em dto
        - outro que recebe um dto e transforma em modelo
    */

    public Servico toModel(ServicoForm form) {
        // verifica antes se o serviço não é nulo
        if (form == null) {
            throw new IllegalArgumentException();
        }

        var model = new Servico();
        model.setNome(form.getNome());
        model.setValorMinimo(form.getValorMinimo());
        model.setQtdeHoras(form.getQtdeHoras());
        model.setComissao(form.getComissao());
        model.setHorasQuarto(form.getHorasQuarto());
        model.setValorQuarto(form.getValorQuarto());
        model.setHorasSala(form.getHorasSala());
        model.setValorSala(form.getValorSala());
        model.setHorasBanheiro(form.getHorasBanheiro());
        model.setValorBanheiro(form.getValorBanheiro());
        model.setHorasCozinha(form.getHorasCozinha());
        model.setValorCozinha(form.getValorCozinha());
        model.setHorasQuintal(form.getHorasQuintal());
        model.setValorQuintal(form.getValorQuintal());
        model.setHorasOutros(form.getHorasOutros());
        model.setValorOutros(form.getValorOutros());
        model.setIcone(form.getIcone());
        model.setPosicao(form.getPosicao());

        return model;
    }

    public ServicoForm toForm(Servico model) {
        // verifica antes se o serviço não é nulo
        if (model == null) {
            throw new IllegalArgumentException();
        }

        var form = new ServicoForm();
        form.setNome(model.getNome());
        form.setValorMinimo(model.getValorMinimo());
        form.setQtdeHoras(model.getQtdeHoras());
        form.setComissao(model.getComissao());
        form.setHorasQuarto(model.getHorasQuarto());
        form.setValorQuarto(model.getValorQuarto());
        form.setHorasSala(model.getHorasSala());
        form.setValorSala(model.getValorSala());
        form.setHorasBanheiro(model.getHorasBanheiro());
        form.setValorBanheiro(model.getValorBanheiro());
        form.setHorasCozinha(model.getHorasCozinha());
        form.setValorCozinha(model.getValorCozinha());
        form.setHorasQuintal(model.getHorasQuintal());
        form.setValorQuintal(model.getValorQuintal());
        form.setHorasOutros(model.getHorasOutros());
        form.setValorOutros(model.getValorOutros());
        form.setIcone(model.getIcone());
        form.setPosicao(model.getPosicao());

        return form;
    }
}
