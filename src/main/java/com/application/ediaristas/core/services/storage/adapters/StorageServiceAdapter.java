package com.application.ediaristas.core.services.storage.adapters;

import org.springframework.web.multipart.MultipartFile;

import com.application.ediaristas.core.models.Foto;
import com.application.ediaristas.core.services.storage.exceptions.StorageException;

public interface StorageServiceAdapter {
    
    Foto salvar(MultipartFile file) throws StorageException;
}
