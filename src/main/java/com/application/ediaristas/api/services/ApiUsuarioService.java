package com.application.ediaristas.api.services;

import com.application.ediaristas.api.dtos.requests.UsuarioRequestDto;
import com.application.ediaristas.api.dtos.responses.UsuarioResponseDto;
import com.application.ediaristas.api.mappers.ApiUsuarioMapper;
import com.application.ediaristas.core.exceptions.SenhasNaoConferemException;
import com.application.ediaristas.core.repositories.UsuarioRepository;
import com.application.ediaristas.core.services.email.adapters.EmailServiceAdapter;
import com.application.ediaristas.core.services.email.dtos.EmailServiceParamsDto;
import com.application.ediaristas.core.services.storage.adapters.StorageServiceAdapter;
import com.application.ediaristas.core.validators.UsuarioValidator;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

@Service
public class ApiUsuarioService {
    
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ApiUsuarioMapper mapper;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UsuarioValidator validator;

    @Autowired
    private StorageServiceAdapter adapter;

    @Autowired
    private EmailServiceAdapter emailAdapter;

    public UsuarioResponseDto cadastrar(UsuarioRequestDto request) {
        validarConfirmacaoSenha(request);
        
        var usuarioParaCadastro = mapper.usuarioToModel(request);
        validator.validarUsuario(usuarioParaCadastro);

        var encoderSenha = encoder.encode(usuarioParaCadastro.getSenha());
        usuarioParaCadastro.setSenha(encoderSenha);

        var fotoDocumento = adapter.salvar(request.getFotoDocumento());
        usuarioParaCadastro.setFotoDocumento(fotoDocumento);

        if (usuarioParaCadastro.isDiarista()) {
            var reputacaoMedia = repository.getMediaReputacaoDiarista();

            if (reputacaoMedia == null || reputacaoMedia == 0.0) {
                reputacaoMedia = 5.0;
            }
            
            usuarioParaCadastro.setReputacao(reputacaoMedia);
        }
        
        var usuarioCadastrar = repository.save(usuarioParaCadastro);

        if (usuarioCadastrar.isCliente() || usuarioCadastrar.isDiarista()) {
            var props = new HashMap<String, Object>();
            props.put("nomeUsuario", usuarioCadastrar.getNomeCompleto());
            props.put("tipoUsuario", usuarioCadastrar.getTipoUsuario().toString()); // toString ou name

            var emailParams = new EmailServiceParamsDto();
            emailParams.setDestinatario(usuarioCadastrar.getEmail());
            emailParams.setAssunto("Cadastro realizado com sucesso");
            emailParams.setTemplate("emails/boas-vindas");
            emailParams.setProps(props);

            emailAdapter.enviarEmailComTemplateHtml(emailParams);
        }

        return mapper.usuarioToResponseDto(usuarioCadastrar);
    }

    private void validarConfirmacaoSenha(UsuarioRequestDto request) {

        var senha = request.getPassword();
        var confirmacaoSenha = request.getPasswordConfirmation();

        if (!senha.equals(confirmacaoSenha)) {
            var mensagem = "Os dois campos de senha não conferem";
            var fieldError = new FieldError(request.getClass().getName(), "passwordConfirmation", 
                request.getPasswordConfirmation(), false, null, null, mensagem);

            throw new SenhasNaoConferemException(mensagem, fieldError);
        }
    }
}
