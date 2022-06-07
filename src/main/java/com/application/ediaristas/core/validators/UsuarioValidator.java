package com.application.ediaristas.core.validators;

import com.application.ediaristas.core.exceptions.EmailJaCadastradoException;
import com.application.ediaristas.core.exceptions.UsuarioJaCadastradoException;
import com.application.ediaristas.core.models.Usuario;
import com.application.ediaristas.core.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

@Component
public class UsuarioValidator {
    
    @Autowired
    private UsuarioRepository repository;

    public void validarUsuario(Usuario usuario) {
        validarEmail(usuario);
    }

    private void validarEmail(Usuario usuario) {

        if (repository.isEmailJaCadastrado(usuario)) {
            var mensagem = "Este e-mail já está cadastrado na base de dados.";
            var fieldError = new FieldError(usuario.getClass().getName(),
                "email", usuario.getEmail(), false, null, null, mensagem);
            throw new EmailJaCadastradoException(mensagem, fieldError);
        }

        validarCpf(usuario);
    }

    private void validarCpf(Usuario usuario) {

        if (repository.isCpfJaCadastrado(usuario)) {
            var mensagem = "Este CPF já está cadastrado na base de dados.";
            var fieldError = new FieldError(usuario.getClass().getName(),
                "cpf", usuario.getCpf(), false, null, null, mensagem);
            throw new UsuarioJaCadastradoException(mensagem, fieldError);
        }

        validarChavePix(usuario);
    }

    private void validarChavePix(Usuario usuario) {

        if (repository.isChavePixJaCadastrada(usuario)) {
            var mensagem = "Esta chave PIX já está cadastrada na base de dados.";
            var fieldError = new FieldError(usuario.getClass().getName(),
                "chavePix", usuario.getChavePix(), false, null, null, mensagem);
            throw new UsuarioJaCadastradoException(mensagem, fieldError);
        }

        if (usuario.isDiarista() && usuario.getChavePix() == null) {
            var mensagem = "Diarista precisa ter uma chave Pix.";
            var fieldError = new FieldError(usuario.getClass().getName(),
                "chavePix", usuario.getChavePix(), false, null, null, mensagem);
            throw new UsuarioJaCadastradoException(mensagem, fieldError);
        }
    }
}
