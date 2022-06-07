package com.application.ediaristas.web.services;

import java.util.List;

import com.application.ediaristas.core.exceptions.EmailJaCadastradoException;
import com.application.ediaristas.core.exceptions.SenhaIncorretaException;
import com.application.ediaristas.core.exceptions.SenhasNaoConferemException;
import com.application.ediaristas.core.exceptions.UsuarioNaoEncontradoException;
import com.application.ediaristas.core.models.TipoUsuario;
import com.application.ediaristas.core.models.Usuario;
import com.application.ediaristas.core.repositories.UsuarioRepository;
import com.application.ediaristas.web.dtos.AlteraSenhaForm;
import com.application.ediaristas.web.dtos.UsuarioCadastroForm;
import com.application.ediaristas.web.dtos.UsuarioEdicaoForm;
import com.application.ediaristas.web.interfaces.IConfirmacaoSenha;
import com.application.ediaristas.web.mappers.WebUsuarioMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

@Service
public class WebUsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private WebUsuarioMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> listaTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario cadastrar(UsuarioCadastroForm form) {
        validarConfirmacaoSenha(form);

        var model = mapper.toModel(form);
        var senhaHash = passwordEncoder.encode(model.getSenha());

        model.setSenha(senhaHash);
        model.setTipoUsuario(TipoUsuario.ADMIN);
        validarEmailUnico(model);
        
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

    public Usuario buscarPorEmail(String email) {
        var mensagem = String.format("Usuário com email %s não encontrado", email);

        return usuarioRepository.findByEmail(email)
            .orElseThrow(() -> new UsuarioNaoEncontradoException(mensagem));
    }

    public Usuario editar(UsuarioEdicaoForm form, Long id) {
        var usuario = buscarPorId(id);
        var model = mapper.toModel(form);
        model.setId(usuario.getId());
        model.setSenha(usuario.getSenha());
        model.setTipoUsuario(usuario.getTipoUsuario());
        validarEmailUnico(model);
        return usuarioRepository.save(model);
    }

    public void excluir(Long id) {
        var usuario = buscarPorId(id);
        usuarioRepository.delete(usuario);
    }

    public void alterarSenha(AlteraSenhaForm form, String email) {
        var usuario = buscarPorEmail(email);

        validarConfirmacaoSenha(form);

        var senhaAtual = usuario.getSenha();
        var senhaAntiga = form.getSenhaAntiga();
        var senha = form.getSenha();

        if (!passwordEncoder.matches(senhaAntiga, senhaAtual)) {
            var mensagem = "A senha antiga está incorreta";
            var fieldError = new FieldError(form.getClass().getName(), "senhaAntiga", 
                senhaAntiga, false, null, null, mensagem);

            throw new SenhaIncorretaException(mensagem, fieldError);
        }

        var novaSenhaHash = passwordEncoder.encode(senha);
        usuario.setSenha(novaSenhaHash);
        usuarioRepository.save(usuario);
    }

    /*private void validaEmailUnico(Usuario usuario) {

        usuarioRepository.findByEmail(usuario.getEmail()).ifPresent((usuarioEncontrado) -> {
            if (!usuarioEncontrado.equals(usuario)) {
                var mensagem = "Este e-mail já está cadastrado na base de dados.";
                var fieldError = new FieldError(usuario.getClass().getName(),
                    "email", usuario.getEmail(), false, null, null, mensagem);
                throw new EmailJaCadastradoException(mensagem, fieldError);
            }
        });
    }*/

    private void validarConfirmacaoSenha(IConfirmacaoSenha obj) {

        var senha = obj.getSenha();
        var confirmacaoSenha = obj.getConfirmacaoSenha();

        if (!senha.equals(confirmacaoSenha)) {
            var mensagem = "Os dois campos de senha não conferem";
            var fieldError = new FieldError(obj.getClass().getName(), "confirmacaoSenha", 
                obj.getConfirmacaoSenha(), false, null, null, mensagem);

            throw new SenhasNaoConferemException(mensagem, fieldError);
        }
    }

    private void validarEmailUnico(Usuario usuario) {

        if (usuarioRepository.isEmailJaCadastrado(usuario)) {
            var mensagem = "Este e-mail já está cadastrado na base de dados.";
            var fieldError = new FieldError(usuario.getClass().getName(),
                "email", usuario.getEmail(), false, null, null, mensagem);
            throw new EmailJaCadastradoException(mensagem, fieldError);
        }
    }
}
