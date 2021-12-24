package com.application.ediaristas.web.controllers;

import javax.validation.Valid;

import com.application.ediaristas.web.dtos.FlashMessage;
import com.application.ediaristas.web.dtos.UsuarioCadastroForm;
import com.application.ediaristas.web.dtos.UsuarioEdicaoForm;
import com.application.ediaristas.web.services.WebUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid @ModelAttribute("usuarioForm") UsuarioCadastroForm usuarioForm,
        BindingResult result, RedirectAttributes attrs) {
        if (result.hasErrors()) {
            return "admin/usuarios/form";
        }

        service.cadastrar(usuarioForm);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", 
            "Usuário cadastrado com sucesso!"));
        return "redirect:/admin/usuarios";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        var mv = new ModelAndView("admin/usuarios/edit-form");
        mv.addObject("editForm", service.buscarFormPorId(id));
        return mv;
    }

    @PostMapping("/{id}/editar")
    public String editar(@PathVariable Long id, 
        @Valid @ModelAttribute("editForm") UsuarioEdicaoForm editForm,
        BindingResult result, RedirectAttributes attrs) {
        if (result.hasErrors()) {
            return "admin/usuarios/edit-form";
        }

        service.editar(editForm, id);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", 
            "Usuário atualizado com sucesso!"));
        return "redirect:/admin/usuarios";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id, RedirectAttributes attrs) {
        service.excluir(id);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Usuário excluído com sucesso!"));
        return "redirect:/admin/usuarios";
    }
}