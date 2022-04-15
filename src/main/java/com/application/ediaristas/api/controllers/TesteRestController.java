package com.application.ediaristas.api.controllers;

import java.util.HashMap;
import java.util.Map;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController // substitui as duas
@RequestMapping("/api/teste")
public class TesteRestController {
    
    @GetMapping
    public Map<String, String> teste() {
        var json = new HashMap<String, String>();
        json.put("nome", "Pedro Teste");
        json.put("email", "pedro@email.teste");
        return json;
    }
}
