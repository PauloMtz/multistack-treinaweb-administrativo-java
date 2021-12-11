package com.application.ediaristas.web.controllers;

import javax.validation.Valid;

import com.application.ediaristas.core.enums.Icone;
import com.application.ediaristas.core.models.Servico;
import com.application.ediaristas.core.repositories.ServicoRepository;
import com.application.ediaristas.web.dtos.ServicoForm;
import com.application.ediaristas.web.mappers.WebServicoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/servicos")
public class ServicoController {

    @Autowired
    private ServicoRepository repository;

    @Autowired
    private WebServicoMapper mapper;

    @GetMapping
    public ModelAndView listar() {
        var mv = new ModelAndView("admin/servicos/lista");
        mv.addObject("servicos", repository.findAll());
        return mv;
    }
    
    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var mv = new ModelAndView("admin/servicos/form");
        mv.addObject("servicoForm", new ServicoForm());
        return mv;
    }

    // o BIndingResult deve vir imediatemente após o dado validado
    @PostMapping("/cadastrar")
    public String cadastrar(@Valid ServicoForm servicoForm, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/servicos/form";
        }
        var servico = mapper.toModel(servicoForm);
        repository.save(servico);
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        var mv = new ModelAndView("admin/servicos/form");
        var servico = repository.getById(id);
        var servicoForm = mapper.toForm(servico);
        mv.addObject("servicoForm", servicoForm);
        return mv;
    }
    
    @PostMapping("/{id}/editar")
    public String editar(@PathVariable Long id, @Valid ServicoForm servicoForm, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/servicos/form";
        }
        var servico = mapper.toModel(servicoForm);
        servico.setId(id);
        repository.save(servico);
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/admin/servicos";
    }

    @ModelAttribute("icones")
    public Icone[] getIcones() {
        return Icone.values();
    }
}