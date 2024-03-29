package com.application.ediaristas.api.services;

import com.application.ediaristas.api.dtos.requests.UsuarioRequestDto;
import com.application.ediaristas.api.dtos.responses.TokenResponseDto;
import com.application.ediaristas.api.dtos.responses.UsuarioCadastroResponseDto;
import com.application.ediaristas.api.dtos.responses.UsuarioResponseDto;
import com.application.ediaristas.api.mappers.ApiUsuarioMapper;
import com.application.ediaristas.core.exceptions.SenhasNaoConferemException;
import com.application.ediaristas.core.publishers.NovoUsuarioPublisher;
import com.application.ediaristas.core.repositories.UsuarioRepository;
import com.application.ediaristas.core.services.storage.adapters.StorageServiceAdapter;
import com.application.ediaristas.core.services.token.adapters.TokenServiceAdapter;
import com.application.ediaristas.core.validators.UsuarioValidator;

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
    private NovoUsuarioPublisher publisher;

    @Autowired
    private TokenServiceAdapter tokenService;

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

        publisher.publicarEvento(usuarioCadastrar);

        var response = mapper.usuarioToCadastroResponseDto(usuarioCadastrar);
        var tokenResponse = gerarTokenResponse(response);
        response.setToken(tokenResponse);
        return response;
    }

    private TokenResponseDto gerarTokenResponse(UsuarioCadastroResponseDto response) {
        var token = tokenService.gerarTokenAcesso(response.getEmail());
        var refresh = tokenService.gerarRefreshToken(response.getEmail());
        var tokenResponse = new TokenResponseDto(token, refresh);
        return tokenResponse;
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
