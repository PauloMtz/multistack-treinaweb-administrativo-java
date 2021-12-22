package com.application.ediaristas.web.services;

import java.util.List;

import com.application.ediaristas.core.exceptions.UsuarioNaoEncontradoException;
import com.application.ediaristas.core.models.TipoUsuario;
import com.application.ediaristas.core.models.Usuario;
import com.application.ediaristas.core.repositories.UsuarioRepository;
import com.application.ediaristas.web.dtos.UsuarioCadastroForm;
import com.application.ediaristas.web.mappers.WebUsuarioMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebUsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private WebUsuarioMapper mapper;

    public List<Usuario> listaTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario cadastrar(UsuarioCadastroForm form) {
        var model = mapper.toModel(form);
        model.setTipoUsuario(TipoUsuario.ADMIN);
        return usuarioRepository.save(model);
    }

    public Usuario buscarPorId(Long id) {
        var mensagem = String.format("ID %d não encontrado.", id);
        return usuarioRepository
            .findById(id)
            .orElseThrow(() -> new UsuarioNaoEncontradoException(mensagem));
    }

    public void excluir(Long id) {
        var usuario = buscarPorId(id);
        usuarioRepository.delete(usuario);
    }
}
