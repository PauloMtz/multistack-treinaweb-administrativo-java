package com.application.ediaristas.web.controllers;

import com.application.ediaristas.web.dtos.UsuarioCadastroForm;
import com.application.ediaristas.web.services.WebUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/usuarios")
public class UsuarioController {

    @Autowired
    private WebUsuarioService service;
    
    @GetMapping
    public ModelAndView listarTodos() {
        var mv = new ModelAndView("admin/usuarios/lista");
        mv.addObject("usuarios", service.listaTodos());
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var mv = new ModelAndView("admin/usuarios/form");
        mv.addObject("usuarioForm", new UsuarioCadastroForm());
        return mv;
    }
}