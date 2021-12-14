package com.application.ediaristas.web.controllers;

import javax.validation.Valid;

import com.application.ediaristas.core.enums.Icone;
import com.application.ediaristas.web.dtos.FlashMessage;
import com.application.ediaristas.web.dtos.ServicoForm;
import com.application.ediaristas.web.services.WebServicoService;

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
@RequestMapping("/admin/servicos")
public class ServicoController {

    @Autowired
    private WebServicoService service;

    @GetMapping
    public ModelAndView listar() {
        var mv = new ModelAndView("admin/servicos/lista");
        mv.addObject("servicos", service.listarTodos());
        return mv;
    }
    
    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var mv = new ModelAndView("admin/servicos/form");
        mv.addObject("servicoForm", new ServicoForm());
        return mv;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid @ModelAttribute("servicoForm") ServicoForm servicoForm, 
        BindingResult result, RedirectAttributes attrs) {
        if (result.hasErrors()) {
            return "admin/servicos/form";
        }
        service.cadastrar(servicoForm);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Serviço cadastrado com sucesso!"));
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        var mv = new ModelAndView("admin/servicos/form");
        mv.addObject("servicoForm", service.buscarPorId(id));
        return mv;
    }
    
    @PostMapping("/{id}/editar")
    public String editar(@PathVariable Long id, @Valid @ModelAttribute("servicoForm") ServicoForm servicoForm, 
        BindingResult result, RedirectAttributes attrs) {
        if (result.hasErrors()) {
            return "admin/servicos/form";
        }

        service.editar(servicoForm, id);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Serviço atualizado com sucesso!"));
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id, RedirectAttributes attrs) {
        service.excluir(id);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Serviço excluído com sucesso!"));
        return "redirect:/admin/servicos";
    }

    @ModelAttribute("icones")
    public Icone[] getIcones() {
        return Icone.values();
    }
}