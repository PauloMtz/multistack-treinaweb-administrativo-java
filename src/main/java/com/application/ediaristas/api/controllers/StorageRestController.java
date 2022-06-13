package com.application.ediaristas.api.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.ediaristas.core.repositories.FotoRepository;
import com.application.ediaristas.core.services.storage.providers.LocalStorageServiceProvider;

@RestController
@RequestMapping("/uploads")
public class StorageRestController {
    
    @Autowired
    private FotoRepository repository;

    @Autowired
    private LocalStorageServiceProvider provider;

    @GetMapping
    public ResponseEntity<Object> buscarFoto(@RequestParam String filename) throws IOException {
        var foto = repository.findByFilename(filename).get();
        var file = provider.buscarFoto(filename);

        return ResponseEntity.ok()
            .header("Content-Type", foto.getContentType())
            .header("Content-Length", foto.getContentLength().toString())
            .body(file.getInputStream().readAllBytes());
    }
}
