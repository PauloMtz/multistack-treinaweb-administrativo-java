package com.application.ediaristas.web.services;

import java.util.List;

import com.application.ediaristas.core.exceptions.EmailJaCadastradoException;
import com.application.ediaristas.core.exceptions.SenhasNaoConferemException;
import com.application.ediaristas.core.exceptions.UsuarioNaoEncontradoException;
import com.application.ediaristas.core.models.TipoUsuario;
import com.application.ediaristas.core.models.Usuario;
import com.application.ediaristas.core.repositories.UsuarioRepository;
import com.application.ediaristas.web.dtos.UsuarioCadastroForm;
import com.application.ediaristas.web.dtos.UsuarioEdicaoForm;
import com.application.ediaristas.web.mappers.WebUsuarioMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

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
        var senha = form.getSenha();
        var confirmacaoSenha = form.getConfirmacaoSenha();

        if (!senha.equals(confirmacaoSenha)) {
            var mensagem = "As senhas não conferem";
            var fieldError = new FieldError(form.getClass().getName(),
                "confirmacaoSenha", form.getConfirmacaoSenha(), false, null, null, mensagem);
            throw new SenhasNaoConferemException(mensagem, fieldError);
        }

        var model = mapper.toModel(form);
        model.setTipoUsuario(TipoUsuario.ADMIN);
        validaEmailUnico(model);
        return usuarioRepository.save(model);
    }

    public Usuario buscarPorId(Long id) {
        var mensagem = String.format("ID %d não encontrado.", id);
        return usuarioRepository
            .findById(id)
            .orElseThrow(() -> new UsuarioNaoEncontradoException(mensagem));
    }

    public UsuarioEdicaoForm buscarFormPorId(Long id) {
        var usuario = buscarPorId(id);
        return mapper.toForm(usuario);
    }

    public Usuario editar(UsuarioEdicaoForm form, Long id) {
        var usuario = buscarPorId(id);
        var model = mapper.toModel(form);
        model.setId(usuario.getId());
        model.setSenha(usuario.getSenha());
        model.setTipoUsuario(usuario.getTipoUsuario());
        validaEmailUnico(model);
        return usuarioRepository.save(model);
    }

    public void excluir(Long id) {
        var usuario = buscarPorId(id);
        usuarioRepository.delete(usuario);
    }

    private void validaEmailUnico(Usuario usuario) {

        usuarioRepository.findByEmail(usuario.getEmail()).ifPresent((usuarioEncontrado) -> {
            if (!usuarioEncontrado.equals(usuario)) {
                var mensagem = "Este e-mail já está cadastrado na base de dados.";
                var fieldError = new FieldError(usuario.getClass().getName(),
                    "email", usuario.getEmail(), false, null, null, mensagem);
                throw new EmailJaCadastradoException(mensagem, fieldError);
            }
        });
    }
}
