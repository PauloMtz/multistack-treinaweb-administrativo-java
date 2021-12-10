package com.application.ediaristas.web.controllers;

import com.application.ediaristas.core.enums.Icone;
import com.application.ediaristas.core.models.Servico;
import com.application.ediaristas.core.repositories.ServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/servicos")
public class ServicoController {

    @Autowired
    private ServicoRepository repository;

    @GetMapping
    public ModelAndView listar() {
        var mv = new ModelAndView("admin/servicos/lista");
        mv.addObject("servicos", repository.findAll());
        return mv;
    }
    
    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var mv = new ModelAndView("admin/servicos/form");
        mv.addObject("servico", new Servico());
        return mv;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Servico servico) {
        repository.save(servico);
        return "redirect:/admin/servicos";
    }

    @ModelAttribute("icones")
    public Icone[] getIcones() {
        return Icone.values();
    }
}