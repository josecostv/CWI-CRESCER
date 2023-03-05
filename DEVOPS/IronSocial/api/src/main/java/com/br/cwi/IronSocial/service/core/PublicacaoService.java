package com.br.cwi.IronSocial.service.core;

import com.br.cwi.IronSocial.domain.Publicacao;
import com.br.cwi.IronSocial.repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
public class PublicacaoService {

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    public Publicacao buscarPorId(Long id) {

        existePorId(id);

        return publicacaoRepository.findById(id).get();
    }

    public void existePorId(Long id) {

        if(!publicacaoRepository.existsById(id)){
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Publicacao não encontrada");
        }
    }
}
