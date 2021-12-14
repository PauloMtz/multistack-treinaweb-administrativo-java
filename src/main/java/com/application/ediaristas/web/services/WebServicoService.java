package com.application.ediaristas.web.services;

import java.util.List;

import com.application.ediaristas.core.exceptions.ServicoNaoEncontradoException;
import com.application.ediaristas.core.models.Servico;
import com.application.ediaristas.core.repositories.ServicoRepository;
import com.application.ediaristas.web.dtos.ServicoForm;
import com.application.ediaristas.web.mappers.WebServicoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebServicoService {
    
    @Autowired
    private ServicoRepository repository;

    @Autowired
    private WebServicoMapper mapper;

    public List<Servico> listarTodos() {
        return repository.findAll();
    }

    public Servico cadastrar(ServicoForm servicoForm) {
        var model = mapper.toModel(servicoForm);
        return repository.save(model);
    }

    public Servico buscarPorId(Long id) {
        var servicoEncontrado = repository.findById(id);

        if (servicoEncontrado.isPresent()) {
            return servicoEncontrado.get();
        }

        var mensagem = String.format("Serviço com o ID %d não encontrado", id);
        throw new ServicoNaoEncontradoException(mensagem);
    }

    public Servico editar(ServicoForm servicoForm, Long id) {
        var servicoEncontrado = buscarPorId(id);
        var model = mapper.toModel(servicoForm);
        model.setId(servicoEncontrado.getId());
        return repository.save(model);
    }

    public void excluir(Long id) {
        var servicoEncontrado = buscarPorId(id);
        repository.delete(servicoEncontrado);
    }
}
