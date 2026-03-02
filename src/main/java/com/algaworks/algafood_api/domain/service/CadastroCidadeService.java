package com.algaworks.algafood_api.domain.service;

import com.algaworks.algafood_api.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood_api.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood_api.domain.model.Cidade;
import com.algaworks.algafood_api.domain.model.Estado;
import com.algaworks.algafood_api.domain.repository.CidadeRepository;
import com.algaworks.algafood_api.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade){
        Long estadoId = cidade.getEstado().getId();
        Estado estado = estadoRepository.buscar(estadoId);

        if (estado == null){
            throw new EntidadeNaoEncontradaException(
                    String.format("Nao existe cadastro de estado com o codigo %d", estadoId));
        }

        cidade.setEstado(estado);

        return cidadeRepository.salvar(cidade);
    }

    public void excluir(Long cidadeId){
        try {
            cidadeRepository.remover(cidadeId);
        } catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(
                    String.format("Nao existe cadastro de cidade com o codigo %d", cidadeId));
        } catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                    String.format("Cidade de codigo %d nao pode ser removida, pois esta em uso"));
        }
    }
}
