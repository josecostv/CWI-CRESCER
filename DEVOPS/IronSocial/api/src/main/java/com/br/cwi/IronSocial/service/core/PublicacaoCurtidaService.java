package com.br.cwi.IronSocial.service.core;

import com.br.cwi.IronSocial.domain.PublicacaoCurtida;
import com.br.cwi.IronSocial.repository.PublicacaoCurtidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class PublicacaoCurtidaService {

    @Autowired
    private PublicacaoCurtidaRepository publicacaoCurtidaRepository;

    public PublicacaoCurtida buscarPorId(Long id) {

        existePorId(id);

        return publicacaoCurtidaRepository.findById(id).get();
    }

    public PublicacaoCurtida buscarPorPublicacaoIdEUsuarioId(Long publicacaoId, Long usuarioId) {

        existePorPublicacaoIdEUsuarioId(publicacaoId, usuarioId);

        return publicacaoCurtidaRepository.findByPublicacaoIdAndUsuarioId(publicacaoId, usuarioId).get();
    }

    private void existePorPublicacaoIdEUsuarioId(Long publicacaoId, Long usuarioId) {

        if(!publicacaoCurtidaRepository.existsByPublicacaoIdAndUsuarioId(publicacaoId, usuarioId)){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Curtida não existe");
        }
    }

    public void existePorId(Long id) {

        if(!publicacaoCurtidaRepository.existsById(id)){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Curtida não encontrada");
        }
    }

    public void validarUsuarioJaCurtiu(Long publicacaoId, Long usuarioId) {

        if(publicacaoCurtidaRepository.existsByPublicacaoIdAndUsuarioId(publicacaoId, usuarioId)){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Usuario já curtiu a publicacao");
        }
    }

    public void validarUsuarioCurtiu(Long publicacaoId, Long usuarioId) {

        if(!publicacaoCurtidaRepository.existsByPublicacaoIdAndUsuarioId(publicacaoId, usuarioId)){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Usuario nao curtiu a publicacao");
        }
    }
}
