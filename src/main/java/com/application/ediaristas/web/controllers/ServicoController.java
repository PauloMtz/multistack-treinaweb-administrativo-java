package com.application.ediaristas.web.controllers;

import com.application.ediaristas.core.enums.Icone;
import com.application.ediaristas.core.models.Servico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/servicos")
public class ServicoController {
    
    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var mv = new ModelAndView("admin/servicos/form");
        mv.addObject("servico_form_controller", new Servico());
        //mv.addObject("icones_form_controller", Icone.values());
        return mv;
    }

    // aqueles ícones serão disponibilizados para quaisquer views
    @ModelAttribute("icones_form_controller")
    public Icone[] getIcones() {
        return Icone.values();
    }
}