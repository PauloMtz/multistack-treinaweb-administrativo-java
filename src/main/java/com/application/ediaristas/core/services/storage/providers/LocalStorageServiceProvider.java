package com.application.ediaristas.core.services.storage.providers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.application.ediaristas.api.controllers.StorageRestController;
import com.application.ediaristas.core.models.Foto;
import com.application.ediaristas.core.repositories.FotoRepository;
import com.application.ediaristas.core.services.storage.adapters.StorageServiceAdapter;
import com.application.ediaristas.core.services.storage.exceptions.StorageException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class LocalStorageServiceProvider implements StorageServiceAdapter {
    
    private final Path pastaUpload = Paths.get("uploads");

    @Autowired
    private FotoRepository repository;

    @Override
    public Foto salvar(MultipartFile arquivo) throws StorageException {
        
        try {
            return trySalvarArquivo(arquivo);
        } catch(IOException ex) {
            throw new StorageException(ex.getLocalizedMessage());
        }
    }

    public Resource buscarFoto(String filename) {
        var arquivo = pastaUpload.resolve(filename);
        try {
            return new UrlResource(arquivo.toUri());
        } catch (MalformedURLException e) {
            throw new StorageException(e.getLocalizedMessage());
        }
    }

    private Foto trySalvarArquivo(MultipartFile arquivo) throws IOException {
        if (!Files.exists(pastaUpload)) {
            Files.createDirectories(pastaUpload);
        }

        var foto = novaFoto(arquivo);
        Files.copy(arquivo.getInputStream(), pastaUpload.resolve(foto.getFilename()));

        return repository.save(foto);
    }

    private Foto novaFoto(MultipartFile arquivo) throws IOException {
        var foto = new Foto();
        var novoNome = gerarNovoNomeArquivo(arquivo.getOriginalFilename());
        var url = linkTo(methodOn(StorageRestController.class).buscarFoto(novoNome)).toString();
        foto.setFilename(novoNome);
        foto.setContentLength(arquivo.getSize());
        foto.setContentType(arquivo.getContentType());
        foto.setUrl(url);
        return foto;
    }

    private String gerarNovoNomeArquivo(String arquivoOriginal) {
        var extensao = arquivoOriginal.split("\\.")[1];
        var novoNome = UUID.randomUUID().toString() + "." + extensao;
        return novoNome;
    }
}
